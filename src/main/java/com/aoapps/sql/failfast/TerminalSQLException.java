/*
 * ao-sql-failfast - Fail-fast JDBC wrapper.
 * Copyright (C) 2020, 2021, 2022  AO Industries, Inc.
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

/**
 * An exception that puts a connection into a terminal state.  Once in a terminal state, the state cannot be
 * {@linkplain FailFastConnection#addFailFastCause(java.lang.Throwable) replaced} or
 * {@linkplain FailFastConnection#clearFailFast() cleared}.
 *
 * @author  AO Industries, Inc.
 */
public abstract class TerminalSQLException extends FailFastSQLException {

  private static final long serialVersionUID = 1L;

  ///**
  // * Creates a new exception that puts a connection into a terminal state.
  // */
  //public TerminalSQLException(String reason, String sqlState, int vendorCode) {
  //  super(reason, sqlState, vendorCode);
  //}

  /**
   * Creates a new exception that puts a connection into a terminal state.
   */
  protected TerminalSQLException(String reason, String sqlState) {
    super(reason, sqlState);
  }

  /**
   * Creates a new exception that puts a connection into a terminal state.
   *
   * @deprecated  Please provide SQLSTATE to {@link #TerminalSQLException(java.lang.String, java.lang.String)}
   */
  @Deprecated(forRemoval = false)
  protected TerminalSQLException(String reason) {
    super(reason);
  }

  ///**
  // * Creates a new exception that puts a connection into a terminal state.
  // */
  //protected TerminalSQLException() {
  //  super();
  //}

  ///**
  // * Creates a new exception that puts a connection into a terminal state.
  // */
  //protected TerminalSQLException(Throwable cause) {
  //  super(cause);
  //}

  ///**
  // * Creates a new exception that puts a connection into a terminal state.
  // */
  //protected TerminalSQLException(String reason, Throwable cause) {
  //  super(reason, cause);
  //}

  ///**
  // * Creates a new exception that puts a connection into a terminal state.
  // */
  //protected TerminalSQLException(String reason, String sqlState, Throwable cause) {
  //  super(reason, sqlState, cause);
  //}

  /**
   * Creates a new exception that puts a connection into a terminal state.
   */
  protected TerminalSQLException(String reason, String sqlState, int vendorCode, Throwable cause) {
    super(reason, sqlState, vendorCode, cause);
  }
}
