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
 * along with ao-sql-failfast.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aoapps.sql.failfast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ServiceLoader;
import java.util.logging.Logger;

/**
 * A registered driver that makes {@linkplain Connection connections} obtained from other {@linkplain Driver drivers}
 * perform in a fail-fast manner.  All access to the connection will fail once a {@link SQLException} has been thrown
 * by the underlying driver, with this state only being cleared by rollback.
 *
 * @author  AO Industries, Inc.
 */
public class Driver extends FailFastDriver {

	private static final Logger PARENT_LOGGER = Logger.getLogger(Driver.class.getPackageName());

	static {
		try {
			register();
		} catch(SQLException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	private static Driver registered;

	/**
	 * Registers the driver if not yet already registered.  This is done automatically during class initialization.
	 *
	 * @return  {@code true} when an new driver instance is registered, or {@code false} when already registered.
	 *
	 * @see  DriverManager#registerDriver(java.sql.Driver)
	 */
	public static synchronized boolean register() throws SQLException {
		if(registered == null) {
			Driver d = new Driver();
			DriverManager.registerDriver(d, () -> d.onDeregister());
			registered = d;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Deregisters the driver if currently registered.
	 *
	 * @return  {@code true} when the driver instance is deregistered, or {@code false} when nothing to deregister.
	 *
	 * @see  DriverManager#deregisterDriver(java.sql.Driver)
	 */
	public static synchronized boolean deregister() throws SQLException {
		if(registered != null) {
			DriverManager.deregisterDriver(registered);
			registered = null;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Public constructor required for service loader.
	 *
	 * @see  ServiceLoader
	 */
	public Driver() {}

	@Override
	public String getUrlPrefix() {
		return "failfast";
	}

	@Override
	protected String getVersion() {
		return Maven.properties.getProperty("project.version");
	}

	@Override
	public int getMajorVersion() {
		return Integer.parseInt(Maven.properties.getProperty("project.artifact.selectedVersion.majorVersion"));
	}

	@Override
	public int getMinorVersion() {
		return Integer.parseInt(Maven.properties.getProperty("project.artifact.selectedVersion.minorVersion"));
	}

	@Override
	public Logger getParentLogger() {
		return PARENT_LOGGER;
	}
}
