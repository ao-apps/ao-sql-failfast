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

import com.aoapps.sql.wrapper.DriverWrapper;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;

/**
 * Makes {@linkplain Connection connections} obtained from other {@linkplain Driver drivers} perform in a
 * fail-fast manner.  All access to the connection will fail once a {@link SQLException} has been thrown by the
 * underlying driver, with this state only being cleared by rollback.
 *
 * @author  AO Industries, Inc.
 */
public abstract class FailFastDriver extends DriverWrapper {

	protected FailFastDriver() {}

	@Override
	protected FailFastConnectionImpl newConnectionWrapper(Connection connection) {
		return new FailFastConnectionImpl(this, connection);
	}
}
