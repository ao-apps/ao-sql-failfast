/*
 * ao-sql-failfast - Fail-fast JDBC wrapper.
 * Copyright (C) 2020  AO Industries, Inc.
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
 * along with ao-sql-failfast.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aoindustries.sql.failfast;

import com.aoindustries.lang.Throwables;
import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Package-private utilities for managing throwables.
 *
 * @author  AO Industries, Inc.
 */
// TODO: Move the whole wrapping stuff to a public utility class "SQLExceptions"?
class ThrowableUtil {

	private ThrowableUtil() {}

	static boolean isSuppressed(Throwable t0, Throwable suppressed) {
		for(Throwable t : t0.getSuppressed()) {
			if(t == suppressed) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Creates a new {@link IOException} with the given cause.
	 */
	static IOException newIOException(Throwable cause) {
		// Subclasses of IOException?
		return new IOException(cause);
	}

	/**
	 * Creates a new {@link SQLClientInfoException} with the given cause.
	 */
	static SQLClientInfoException newSQLClientInfoException(Supplier<? extends Map<String,ClientInfoStatus>> failedPropertiesSupplier, Throwable cause) {
		if(cause instanceof SQLException) {
			SQLException sqlEx = (SQLException)cause;
			return new SQLClientInfoException(
				sqlEx.getMessage(),
				sqlEx.getSQLState(),
				sqlEx.getErrorCode(),
				failedPropertiesSupplier.get(),
				sqlEx
			);
		}
		return new SQLClientInfoException(failedPropertiesSupplier.get(), cause);
	}

	/**
	 * Creates a new {@link SQLException} or {@link FailFastSQLException} with the given cause.
	 */
	static SQLException newFailFastSQLException(Throwable cause) {
		if(cause instanceof SQLException) {
			SQLException surrogate = Throwables.newSurrogate((SQLException)cause);
			if(surrogate != cause) {
				// Was wrapped, return the new exception of the same type as the cause
				return surrogate;
			}
			// Was a type that has no surrogate registered, fall-through
		}
		return new FailFastSQLException(cause);
	}
}
