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
import com.aoapps.sql.wrapper.SQLDataWrapperImpl;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 * @see  FailFastConnectionImpl
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings({"UseSpecificCatch", "TooBroadCatch"})
public class FailFastSQLDataImpl extends SQLDataWrapperImpl {

	public FailFastSQLDataImpl(FailFastConnectionImpl failFastConnection, SQLData wrapped) {
		super(failFastConnection, wrapped);
	}

	@Override
	protected FailFastConnectionImpl getConnectionWrapper() {
		return (FailFastConnectionImpl)super.getConnectionWrapper();
	}

	@Override
	public String getSQLTypeName() throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			return super.getSQLTypeName();
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void readSQL(SQLInput stream, String typeName) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.readSQL(stream, typeName);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeSQL(SQLOutput stream) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeSQL(stream);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}
}
