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
import com.aoapps.sql.wrapper.ArrayWrapperImpl;
import com.aoapps.sql.wrapper.StatementWrapperImpl;
import java.sql.Array;
import java.sql.SQLException;
import java.util.Map;

/**
 * @see  FailFastConnectionImpl
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings({"UseSpecificCatch", "TooBroadCatch"})
public class FailFastArrayImpl extends ArrayWrapperImpl {

  public FailFastArrayImpl(FailFastConnectionImpl failFastConnection, StatementWrapperImpl stmtWrapper, Array wrapped) {
    super(failFastConnection, stmtWrapper, wrapped);
  }

  @Override
  protected FailFastConnectionImpl getConnectionWrapper() {
    return (FailFastConnectionImpl) super.getConnectionWrapper();
  }

  @Override
  public String getBaseTypeName() throws SQLException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastSQLException();
    try {
      return super.getBaseTypeName();
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
    }
  }

  @Override
  public int getBaseType() throws SQLException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastSQLException();
    try {
      return super.getBaseType();
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
    }
  }

  @Override
  public Object getArray() throws SQLException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastSQLException();
    try {
      return super.getArray();
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
    }
  }

  @Override
  public Object getArray(Map<String, Class<?>> map) throws SQLException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastSQLException();
    try {
      return super.getArray(map);
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
    }
  }

  @Override
  public Object getArray(long index, int count) throws SQLException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastSQLException();
    try {
      return super.getArray(index, count);
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
    }
  }

  @Override
  public Object getArray(long index, int count, Map<String, Class<?>> map) throws SQLException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastSQLException();
    try {
      return super.getArray(index, count, map);
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
    }
  }

  @Override
  public FailFastResultSetImpl getResultSet() throws SQLException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastSQLException();
    try {
      return (FailFastResultSetImpl) super.getResultSet();
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
    }
  }

  @Override
  public FailFastResultSetImpl getResultSet(Map<String, Class<?>> map) throws SQLException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastSQLException();
    try {
      return (FailFastResultSetImpl) super.getResultSet(map);
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
    }
  }

  @Override
  public FailFastResultSetImpl getResultSet(long index, int count) throws SQLException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastSQLException();
    try {
      return (FailFastResultSetImpl) super.getResultSet(index, count);
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
    }
  }

  @Override
  public FailFastResultSetImpl getResultSet(long index, int count, Map<String, Class<?>> map) throws SQLException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastSQLException();
    try {
      return (FailFastResultSetImpl) super.getResultSet(index, count, map);
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
    }
  }

  @Override
  public void free() throws SQLException {
    try {
      super.free();
    } catch (Throwable t) {
      getConnectionWrapper().addFailFastCause(t);
      throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
    }
  }
}
