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
import com.aoapps.lang.exception.WrappedException;
import com.aoapps.sql.wrapper.RowIdWrapperImpl;
import java.sql.RowId;

/**
 * @see  FailFastConnectionImpl
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings({"UseSpecificCatch", "TooBroadCatch"})
public class FailFastRowIdImpl extends RowIdWrapperImpl {

  public FailFastRowIdImpl(FailFastConnectionImpl failFastConnection, RowId wrapped) {
    super(failFastConnection, wrapped);
  }

  @Override
  protected FailFastConnectionImpl getConnectionWrapper() {
    return (FailFastConnectionImpl)super.getConnectionWrapper();
  }

  @Override
  @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
  public boolean equals(Object obj) {
    try {
      return super.equals(obj);
    } catch (Throwable t) {
      getConnectionWrapper().addFailFastCause(t);
      throw Throwables.wrap(t, WrappedException.class, WrappedException::new);
    }
  }

  @Override
  public byte[] getBytes() {
    try {
      return super.getBytes();
    } catch (Throwable t) {
      getConnectionWrapper().addFailFastCause(t);
      throw Throwables.wrap(t, WrappedException.class, WrappedException::new);
    }
  }

  @Override
  public String toString() {
    try {
      return super.toString();
    } catch (Throwable t) {
      getConnectionWrapper().addFailFastCause(t);
      throw Throwables.wrap(t, WrappedException.class, WrappedException::new);
    }
  }

  @Override
  public int hashCode() {
    try {
      return super.hashCode();
    } catch (Throwable t) {
      getConnectionWrapper().addFailFastCause(t);
      throw Throwables.wrap(t, WrappedException.class, WrappedException::new);
    }
  }
}
