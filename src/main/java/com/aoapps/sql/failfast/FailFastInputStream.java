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
import com.aoapps.sql.wrapper.InputStreamWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;

/**
 * @see  FailFastConnectionImpl
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings({"UseSpecificCatch", "TooBroadCatch"})
public class FailFastInputStream extends InputStreamWrapper {

  public FailFastInputStream(FailFastConnectionImpl failFastConnection, InputStream wrapped) {
    super(failFastConnection, wrapped);
  }

  @Override
  protected FailFastConnectionImpl getConnectionWrapper() {
    return (FailFastConnectionImpl) super.getConnectionWrapper();
  }

  @Override
  public int read() throws IOException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastIOException();
    try {
      return super.read();
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, IOException.class, IOException::new);
    }
  }

  @Override
  public int read(byte[] b) throws IOException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastIOException();
    try {
      return super.read(b);
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, IOException.class, IOException::new);
    }
  }

  @Override
  public int read(byte[] b, int off, int len) throws IOException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastIOException();
    try {
      return super.read(b, off, len);
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, IOException.class, IOException::new);
    }
  }

  @Override
  public byte[] readAllBytes() throws IOException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastIOException();
    try {
      return super.readAllBytes();
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, IOException.class, IOException::new);
    }
  }

  @Override
  public byte[] readNBytes(int len) throws IOException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastIOException();
    try {
      return super.readNBytes(len);
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, IOException.class, IOException::new);
    }
  }

  @Override
  public int readNBytes(byte[] b, int off, int len) throws IOException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastIOException();
    try {
      return super.readNBytes(b, off, len);
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, IOException.class, IOException::new);
    }
  }

  @Override
  public long skip(long n) throws IOException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastIOException();
    try {
      return super.skip(n);
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, IOException.class, IOException::new);
    }
  }

  @Override
  public int available() throws IOException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastIOException();
    try {
      return super.available();
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, IOException.class, IOException::new);
    }
  }

  @Override
  public void close() throws IOException {
    try {
      super.close();
    } catch (Throwable t) {
      getConnectionWrapper().addFailFastCause(t);
      throw Throwables.wrap(t, IOException.class, IOException::new);
    }
  }

  @Override
  public void mark(int readlimit) {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    try {
      ffConn.failFastIOException();
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
    try {
      super.mark(readlimit);
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, WrappedException.class, WrappedException::new);
    }
  }

  @Override
  public void reset() throws IOException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastIOException();
    try {
      super.reset();
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, IOException.class, IOException::new);
    }
  }

  @Override
  public boolean markSupported() {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    if (ffConn.getFailFastState() == FailFastConnection.State.OK) {
      try {
        return super.markSupported();
      } catch (Throwable t) {
        ffConn.addFailFastCause(t);
        throw Throwables.wrap(t, WrappedException.class, WrappedException::new);
      }
    } else {
      return false;
    }
  }

  @Override
  public long transferTo(OutputStream out) throws IOException {
    FailFastConnectionImpl ffConn = getConnectionWrapper();
    ffConn.failFastIOException();
    try {
      return super.transferTo(out);
    } catch (Throwable t) {
      ffConn.addFailFastCause(t);
      throw Throwables.wrap(t, IOException.class, IOException::new);
    }
  }
}
