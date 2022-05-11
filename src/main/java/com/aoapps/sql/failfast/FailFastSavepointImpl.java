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
import com.aoapps.sql.wrapper.SavepointWrapperImpl;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 * See {@link FailFastConnectionImpl}.
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings({"UseSpecificCatch", "TooBroadCatch"})
public class FailFastSavepointImpl extends SavepointWrapperImpl {

  public FailFastSavepointImpl(FailFastConnectionImpl failFastConnection, Savepoint wrapped) {
    super(failFastConnection, wrapped);
  }

  @Override
  protected FailFastConnectionImpl getConnectionWrapper() {
    return (FailFastConnectionImpl) super.getConnectionWrapper();
  }

  @Override
  public int getSavepointId() throws SQLException {
    try {
      return super.getSavepointId();
    } catch (Throwable t) {
      getConnectionWrapper().addFailFastCause(t);
      throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
    }
  }

  @Override
  public String getSavepointName() throws SQLException {
    try {
      return super.getSavepointName();
    } catch (Throwable t) {
      getConnectionWrapper().addFailFastCause(t);
      throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
    }
  }
}
