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
import com.aoapps.sql.wrapper.NClobWrapperImpl;
import java.sql.Clob;
import java.sql.NClob;
import java.sql.SQLException;

/**
 * @see  FailFastConnectionImpl
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings({"UseSpecificCatch", "TooBroadCatch"})
public class FailFastNClobImpl extends NClobWrapperImpl {

	public FailFastNClobImpl(FailFastConnectionImpl failFastConnection, NClob wrapped) {
		super(failFastConnection, wrapped);
	}

	@Override
	protected FailFastConnectionImpl getConnectionWrapper() {
		return (FailFastConnectionImpl)super.getConnectionWrapper();
	}

	/*
	 * Clob methods
	 */

	@Override
	public long length() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.length();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public String getSubString(long pos, int length) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.getSubString(pos, length);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public FailFastReader getCharacterStream() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return (FailFastReader)super.getCharacterStream();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public FailFastInputStream getAsciiStream() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return (FailFastInputStream)super.getAsciiStream();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public long position(String searchstr, long start) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.position(searchstr, start);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public long position(Clob searchstr, long start) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.position(searchstr, start);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public int setString(long pos, String str) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.setString(pos, str);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public int setString(long pos, String str, int offset, int len) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.setString(pos, str, offset, len);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public FailFastOutputStream setAsciiStream(long pos) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return (FailFastOutputStream)super.setAsciiStream(pos);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public FailFastWriter setCharacterStream(long pos) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return (FailFastWriter)super.setCharacterStream(pos);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void truncate(long len) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.truncate(len);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void free() throws SQLException {
		try {
			super.free();
		} catch(Throwable t) {
			getConnectionWrapper().addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public FailFastReader getCharacterStream(long pos, long length) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return (FailFastReader)super.getCharacterStream(pos, length);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}
}
