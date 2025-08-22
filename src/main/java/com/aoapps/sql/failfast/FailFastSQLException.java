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

import com.aoapps.lang.Throwables;
import java.sql.SQLException;

/**
 * An exception that is generated to enforce the fail-fast state.
 *
 * @author  AO Industries, Inc.
 */
public class FailFastSQLException extends SQLException {

  private static final long serialVersionUID = 1L;

  // /**
  //  * Creates an exception to enforce the fail-fast state.
  //  */
  // public FailFastSQLException(String reason, String sqlState, int vendorCode) {
  //   super(reason, sqlState, vendorCode);
  // }

  /**
   * Creates an exception to enforce the fail-fast state.
   */
  public FailFastSQLException(String reason, String sqlState) {
    super(reason, sqlState);
  }

  /**
   * Creates an exception to enforce the fail-fast state.
   *
   * @deprecated  Please provide SQLSTATE to {@link #FailFastSQLException(java.lang.String, java.lang.String)}
   */
  @Deprecated(forRemoval = false)
  public FailFastSQLException(String reason) {
    super(reason, "25000");
  }

  // /**
  //  * Creates an exception to enforce the fail-fast state.
  //  */
  // public FailFastSQLException() {
  //   super();
  // }

  /**
   * Creates an exception to enforce the fail-fast state.
   */
  public FailFastSQLException(Throwable cause) {
    super("In fail-fast connection state: clearFailFast, rollback, close, or abort required", "25000", cause);
  }

  // /**
  //  * Creates an exception to enforce the fail-fast state.
  //  */
  // public FailFastSQLException(String reason, Throwable cause) {
  //   super(reason, cause);
  // }

  // /**
  //  * Creates an exception to enforce the fail-fast state.
  //  */
  // public FailFastSQLException(String reason, String sqlState, Throwable cause) {
  //   super(reason, sqlState, cause);
  // }

  /**
   * Creates an exception to enforce the fail-fast state.
   */
  public FailFastSQLException(String reason, String sqlState, int vendorCode, Throwable cause) {
    super(reason, sqlState, vendorCode, cause);
  }

  static {
    Throwables.registerSurrogateFactory(FailFastSQLException.class, (template, cause) ->
        new FailFastSQLException(
            template.getMessage(),
            template.getSQLState(),
            template.getErrorCode(),
            cause
        )
    );
  }
}
