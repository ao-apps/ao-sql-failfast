/*
 * ao-sql-failfast - Fail-fast JDBC wrapper.
 * Copyright (C) 2020, 2021  AO Industries, Inc.
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
import com.aoapps.sql.wrapper.PreparedStatementWrapperImpl;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * @see  FailFastConnectionImpl
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings({"UseSpecificCatch", "TooBroadCatch"})
public class FailFastPreparedStatementImpl extends PreparedStatementWrapperImpl {

	public FailFastPreparedStatementImpl(FailFastConnectionImpl failFastConnection, PreparedStatement wrapped) {
		super(failFastConnection, wrapped);
	}

	@Override
	protected FailFastConnectionImpl getConnectionWrapper() {
		return (FailFastConnectionImpl)super.getConnectionWrapper();
	}

	/*
	 * Statement methods
	 */

	@Override
	public FailFastResultSetImpl executeQuery(String sql) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return (FailFastResultSetImpl)super.executeQuery(sql);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public int executeUpdate(String sql) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.executeUpdate(sql);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void close() throws SQLException {
		try {
			super.close();
		} catch(Throwable t) {
			getConnectionWrapper().addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public int getMaxFieldSize() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.getMaxFieldSize();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setMaxFieldSize(int max) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setMaxFieldSize(max);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public int getMaxRows() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.getMaxRows();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setMaxRows(int max) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setMaxRows(max);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setEscapeProcessing(boolean enable) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setEscapeProcessing(enable);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public int getQueryTimeout() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.getQueryTimeout();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setQueryTimeout(int seconds) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setQueryTimeout(seconds);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void cancel() throws SQLException {
		try {
			super.cancel();
		} catch(Throwable t) {
			getConnectionWrapper().addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.getWarnings();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void clearWarnings() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.clearWarnings();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setCursorName(String name) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setCursorName(name);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public boolean execute(String sql) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.execute(sql);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public FailFastResultSetImpl getResultSet() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return (FailFastResultSetImpl)super.getResultSet();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public int getUpdateCount() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.getUpdateCount();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public boolean getMoreResults() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.getMoreResults();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setFetchDirection(int direction) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setFetchDirection(direction);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public int getFetchDirection() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.getFetchDirection();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setFetchSize(int rows) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setFetchSize(rows);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public int getFetchSize() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.getFetchSize();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public int getResultSetConcurrency() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.getResultSetConcurrency();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public int getResultSetType() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.getResultSetType();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void addBatch(String sql) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.addBatch(sql);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void clearBatch() throws SQLException {
		try {
			super.clearBatch();
		} catch(Throwable t) {
			getConnectionWrapper().addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public int[] executeBatch() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.executeBatch();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public FailFastConnectionImpl getConnection() throws SQLException {
		try {
			return (FailFastConnectionImpl)super.getConnection();
		} catch(Throwable t) {
			getConnectionWrapper().addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public boolean getMoreResults(int current) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.getMoreResults(current);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public FailFastResultSetImpl getGeneratedKeys() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return (FailFastResultSetImpl)super.getGeneratedKeys();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.executeUpdate(sql, autoGeneratedKeys);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.executeUpdate(sql, columnIndexes);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public int executeUpdate(String sql, String[] columnNames) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.executeUpdate(sql, columnNames);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.execute(sql, autoGeneratedKeys);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public boolean execute(String sql, int[] columnIndexes) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.execute(sql, columnIndexes);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public boolean execute(String sql, String[] columnNames) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.execute(sql, columnNames);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public int getResultSetHoldability() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.getResultSetHoldability();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public boolean isClosed() throws SQLException {
		try {
			return super.isClosed();
		} catch(Throwable t) {
			getConnectionWrapper().addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setPoolable(boolean poolable) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setPoolable(poolable);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public boolean isPoolable() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.isPoolable();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void closeOnCompletion() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.closeOnCompletion();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public boolean isCloseOnCompletion() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.isCloseOnCompletion();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public long getLargeUpdateCount() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.getLargeUpdateCount();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setLargeMaxRows(long max) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setLargeMaxRows(max);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public long getLargeMaxRows() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.getLargeMaxRows();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public long[] executeLargeBatch() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.executeLargeBatch();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public long executeLargeUpdate(String sql) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.executeLargeUpdate(sql);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public long executeLargeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.executeLargeUpdate(sql, autoGeneratedKeys);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public long executeLargeUpdate(String sql, int[] columnIndexes) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.executeLargeUpdate(sql, columnIndexes);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public long executeLargeUpdate(String sql, String[] columnNames) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.executeLargeUpdate(sql, columnNames);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public String enquoteLiteral(String val) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.enquoteLiteral(val);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public String enquoteIdentifier(String identifier, boolean alwaysQuote) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.enquoteIdentifier(identifier, alwaysQuote);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public boolean isSimpleIdentifier(String identifier) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.isSimpleIdentifier(identifier);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public String enquoteNCharLiteral(String val) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.enquoteNCharLiteral(val);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	/*
	 * PreparedStatement methods
	 */

	@Override
	public FailFastResultSetImpl executeQuery() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return (FailFastResultSetImpl)super.executeQuery();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public int executeUpdate() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.executeUpdate();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setNull(int parameterIndex, int sqlType) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setNull(parameterIndex, sqlType);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setBoolean(int parameterIndex, boolean x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setBoolean(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setByte(int parameterIndex, byte x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setByte(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setShort(int parameterIndex, short x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setShort(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setInt(int parameterIndex, int x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setInt(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setLong(int parameterIndex, long x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setLong(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setFloat(int parameterIndex, float x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setFloat(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setDouble(int parameterIndex, double x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setDouble(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setBigDecimal(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setString(int parameterIndex, String x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setString(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setBytes(int parameterIndex, byte[] x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setBytes(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setDate(int parameterIndex, Date x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setDate(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setTime(int parameterIndex, Time x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setTime(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setTimestamp(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setAsciiStream(parameterIndex, x, length);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	@Deprecated(since="1.2")
	public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setUnicodeStream(parameterIndex, x, length);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setBinaryStream(parameterIndex, x, length);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void clearParameters() throws SQLException {
		try {
			super.clearParameters();
		} catch(Throwable t) {
			getConnectionWrapper().addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setObject(parameterIndex, x, targetSqlType);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setObject(int parameterIndex, Object x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setObject(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public boolean execute() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.execute();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void addBatch() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.addBatch();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setCharacterStream(parameterIndex, reader, length);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setRef(int parameterIndex, Ref x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setRef(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setBlob(int parameterIndex, Blob x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setBlob(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setClob(int parameterIndex, Clob x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setClob(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setArray(int parameterIndex, Array x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setArray(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public FailFastResultSetMetaDataImpl getMetaData() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return (FailFastResultSetMetaDataImpl)super.getMetaData();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setDate(parameterIndex, x, cal);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setTime(parameterIndex, x, cal);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setTimestamp(parameterIndex, x, cal);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setNull (int parameterIndex, int sqlType, String typeName) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setNull(parameterIndex, sqlType, typeName);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setURL(int parameterIndex, URL x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setURL(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public FailFastParameterMetaDataImpl getParameterMetaData() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return (FailFastParameterMetaDataImpl)super.getParameterMetaData();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setRowId(int parameterIndex, RowId x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setRowId(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setNString(int parameterIndex, String value) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setNString(parameterIndex, value);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setNCharacterStream(parameterIndex, value, length);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setNClob(int parameterIndex, NClob value) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setNClob(parameterIndex, value);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setClob(parameterIndex, reader, length);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setBlob(parameterIndex, inputStream, length);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setNClob(parameterIndex, reader, length);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setSQLXML(parameterIndex, xmlObject);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setAsciiStream(parameterIndex, x, length);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setBinaryStream(parameterIndex, x, length);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setCharacterStream(parameterIndex, reader, length);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setAsciiStream(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setBinaryStream(parameterIndex, x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setCharacterStream(parameterIndex, reader);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setNCharacterStream(parameterIndex, value);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setClob(int parameterIndex, Reader reader) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setClob(parameterIndex, reader);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setBlob(parameterIndex, inputStream);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setNClob(int parameterIndex, Reader reader) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setNClob(parameterIndex, reader);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setObject(int parameterIndex, Object x, SQLType targetSqlType, int scaleOrLength) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void setObject(int parameterIndex, Object x, SQLType targetSqlType) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.setObject(parameterIndex, x, targetSqlType);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public long executeLargeUpdate() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.executeLargeUpdate();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}
}
