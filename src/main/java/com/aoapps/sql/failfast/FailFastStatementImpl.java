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
import com.aoapps.sql.wrapper.StatementWrapperImpl;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

/**
 * @see  FailFastConnectionImpl
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings({"UseSpecificCatch", "TooBroadCatch"})
public class FailFastStatementImpl extends StatementWrapperImpl {

	public FailFastStatementImpl(FailFastConnectionImpl failFastConnection, Statement wrapped) {
		super(failFastConnection, wrapped);
	}

	@Override
	protected FailFastConnectionImpl getConnectionWrapper() {
		return (FailFastConnectionImpl)super.getConnectionWrapper();
	}

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
}
