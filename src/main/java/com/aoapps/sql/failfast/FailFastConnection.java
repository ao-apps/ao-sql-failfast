/*
 * ao-sql-failfast - Fail-fast JDBC wrapper.
 * Copyright (C) 2020, 2021, 2022, 2024  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of ao-sql-failfast.
 *
 * ao-sql-failfast is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ao-sql-failfast is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ao-sql-failfast.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.aoapps.sql.failfast;

import com.aoapps.lang.Throwables;
import com.aoapps.sql.wrapper.Wrapper;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.concurrent.Executor;

/**
 * Makes a {@link Connection} perform in a fail-fast manner.  All access to the connection will fail once a
 * {@link Throwable} has been thrown by the underlying driver, with this state only being cleared by rollback.
 *
 * @author  AO Industries, Inc.
 */
// Note: Comment matches FailFastConnectionImpl
public interface FailFastConnection extends Wrapper, Connection {

  /**
   * Gets the connection that is wrapped.
   */
  @Override
  Connection getWrapped();

  /**
   * The set of possible fail-fast states.
   *
   * @see  #getFailFastState()
   */
  // TODO: Add more states based on the type of SQLException and/or its SQLState.  Particularly to distinguish exceptions that will not require connection validation.
  enum State {
    /**
     * Normal operation.
     */
    OK,

    /**
     * All {@link Throwable} except {@link TerminalSQLException}.  These might be recoverable through
     * {@link FailFastConnection#rollback()} or {@link FailFastConnection#rollback(java.sql.Savepoint)}.
     */
    EXCEPTION,

    /**
     * Non-recoverable {@link TerminalSQLException}.
     */
    TERMINAL;

    /**
     * Gets the precedence state for the given throwable.
     *
     * @return  The precedence state or {@code null} when given {@code null} argument
     */
    public static State getState(Throwable cause) {
      if (cause == null) {
        return OK;
      } else if (cause instanceof TerminalSQLException) {
        return TERMINAL;
      } else {
        return EXCEPTION;
      }
    }
  }

  /**
   * Registers a cause for the current failure.  Multiple causes are merged in the following order:
   * <ol>
   * <li>{@link TerminalSQLException} take highest precedence, since these are non-recoverable.</li>
   * <li>
   *   All other {@link Throwable} are next precedence.  These might be recoverable through
   *   {@link FailFastConnection#rollback()} or {@link FailFastConnection#rollback(java.sql.Savepoint)}.
   * </li>
   * </ol>
   *
   * <p>Higher precedence causes will suppress any existing cause of a lower precedence (new adds the current as
   * suppressed).</p>
   *
   * <p>Lower precedence causes will be suppressed by any existing cause of higher precedence (current adds the new as
   * suppressed).</p>
   *
   * <p>Causes within the same precedence are merged via
   * {@link Throwables#addSuppressed(java.lang.Throwable, java.lang.Throwable)}.</p>
   *
   * @param  cause  The additional cause, ignored when {@code null}
   */
  void addFailFastCause(Throwable cause);

  /**
   * Gets the cause of the current fail-fast state.
   *
   * <p>This might involve creating a new exception, so {@link #getFailFastState()} may be faster when the exact cause
   * is not required.</p>
   *
   * @return  The cause or {@code null} when not in failure state (operating normally).
   *
   * @see  #getFailFastState()
   */
  Throwable getFailFastCause();

  /**
   * Gets the current fail-fail state.
   *
   * @return  The state or {@link State#OK} when not in failure state (operating normally).
   *
   * @see  #getFailFastCause()
   */
  State getFailFastState();

  /**
   * Clears the cause of the current fail-fast state.
   * This will typically be invoked automatically during one of the following successful operations:
   * <ol>
   * <li>{@link Connection#rollback()}</li>
   * <li>{@link Connection#rollback(java.sql.Savepoint)}</li>
   * </ol>
   *
   * @return  The cause or {@code null} when was not in failure state (operating normally).
   *
   * @throws  TerminalSQLException if the connection is in a terminal fail-fast state, such as closed or aborted.
   *
   * @see  #getFailFastCause()
   */
  // TODO: Should this still be part of the interface and have a public implementation method?
  Throwable clearFailFast() throws TerminalSQLException;

  /**
   * When not in a {@linkplain TerminalSQLException terminal fail-fast state}, will
   * {@link #clearFailFast() clear the fail-fast state} upon a successful call to
   * {@code super.rollback()}.
   *
   * @throws  TerminalSQLException if already in a terminal fail-fast state
   * @throws  SQLException if any other failure occurs during rollback
   */
  @Override
  void rollback() throws TerminalSQLException, SQLException;

  /**
   * Puts the connection into a terminal {@link ClosedSQLException} fail-fast state then calls
   * {@link FailFastConnectionImpl#doClose(java.lang.Throwable)}.
   *
   * <p>When already in a terminal state (closed or aborted), is a no-op and does not call
   * {@link FailFastConnectionImpl#doClose(java.lang.Throwable)}.</p>
   *
   * @see  #addFailFastCause(java.lang.Throwable)
   * @see  ClosedSQLException
   * @see  FailFastConnectionImpl#doClose(java.lang.Throwable)
   */
  @Override
  void close() throws SQLException;

  /**
   * When not in a {@linkplain TerminalSQLException terminal fail-fast state}, will
   * {@link #clearFailFast() clear the fail-fast state} upon a successful call to
   * {@code super.rollback(savepoint)}.
   *
   * @throws  FailFastSQLException if already in a terminal fail-fast state
   * @throws  SQLException if any other failure occurs during rollback
   */
  @Override
  void rollback(Savepoint savepoint) throws TerminalSQLException, SQLException;

  /**
   * Puts the connection into a terminal {@link AbortedSQLException} fail-fast state then calls
   * {@link FailFastConnectionImpl#doAbort(java.lang.Throwable, java.util.concurrent.Executor)}.
   *
   * <p>When already in a terminal state (closed or aborted), is a no-op and does not call
   * {@link FailFastConnectionImpl#doAbort(java.lang.Throwable, java.util.concurrent.Executor)}</p>
   *
   * @see  #addFailFastCause(java.lang.Throwable)
   * @see  AbortedSQLException
   * @see  FailFastConnectionImpl#doAbort(java.lang.Throwable, java.util.concurrent.Executor)
   */
  @Override
  void abort(Executor executor) throws SQLException;
}
