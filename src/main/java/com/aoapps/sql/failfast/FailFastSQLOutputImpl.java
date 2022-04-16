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
import com.aoapps.sql.wrapper.SQLOutputWrapperImpl;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.RowId;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.SQLType;
import java.sql.SQLXML;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * @see  FailFastConnectionImpl
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings({"UseSpecificCatch", "TooBroadCatch"})
public class FailFastSQLOutputImpl extends SQLOutputWrapperImpl {

	public FailFastSQLOutputImpl(FailFastConnectionImpl failFastConnection, SQLOutput wrapped) {
		super(failFastConnection, wrapped);
	}

	@Override
	protected FailFastConnectionImpl getConnectionWrapper() {
		return (FailFastConnectionImpl)super.getConnectionWrapper();
	}

	@Override
	public void writeString(String x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeString(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeBoolean(boolean x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeBoolean(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeByte(byte x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeByte(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeShort(short x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeShort(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeInt(int x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeInt(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeLong(long x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeLong(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeFloat(float x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeFloat(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeDouble(double x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeDouble(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeBigDecimal(BigDecimal x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeBigDecimal(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeBytes(byte[] x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeBytes(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeDate(Date x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeDate(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeTime(Time x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeTime(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeTimestamp(Timestamp x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeTimestamp(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeCharacterStream(Reader x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeCharacterStream(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeAsciiStream(InputStream x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeAsciiStream(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeBinaryStream(InputStream x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeBinaryStream(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeObject(SQLData x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeObject(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeRef(Ref x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeRef(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeBlob(Blob x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeBlob(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeClob(Clob x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeClob(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeStruct(Struct x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeStruct(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeArray(Array x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeArray(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeURL(URL x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeURL(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeNString(String x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeNString(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeNClob(NClob x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeNClob(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeRowId(RowId x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeRowId(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeSQLXML(SQLXML x) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeSQLXML(x);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}

	@Override
	public void writeObject(Object x, SQLType targetSqlType) throws SQLException {
		FailFastConnectionImpl ffConn = getConnectionWrapper();
		ffConn.failFastSQLException();
		try {
			super.writeObject(x, targetSqlType);
		} catch(Throwable t) {
			ffConn.addFailFastCause(t);
			throw Throwables.wrap(t, SQLException.class, FailFastSQLException::new);
		}
	}
}
