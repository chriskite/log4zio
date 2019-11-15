/*
 * Copyright (c) 2019 Chris Kite
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.chriskite.log4zio

import log.effect.internal.Show
import zio.{RIO, ZIO}

package object logger {
  def trace[A: Show](a: => A): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.trace(a))

  def trace(msg: => String): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.trace(msg))

  def trace(th: => Throwable)(implicit `_`: DummyImplicit): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.trace(th))

  def trace(msg: => String, th: => Throwable): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.trace(msg, th))

  def debug[A: Show](a: => A): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.debug(a))

  def debug(msg: => String): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.debug(msg))

  def debug(th: => Throwable)(implicit `_`: DummyImplicit): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.debug(th))

  def debug(msg: => String, th: => Throwable): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.debug(msg, th))

  def info[A: Show](a: => A): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.info(a))

  def info(msg: => String): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.info(msg))

  def info(th: => Throwable)(implicit `_`: DummyImplicit): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.info(th))

  def info(msg: => String, th: => Throwable): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.info(msg, th))

  def error[A: Show](a: => A): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.error(a))

  def error(msg: => String): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.error(msg))

  def error(th: => Throwable)(implicit `_`: DummyImplicit): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.error(th))

  def error(msg: => String, th: => Throwable): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.error(msg, th))

  def warn[A: Show](a: => A): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.warn(a))

  def warn(msg: => String): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.warn(msg))

  def warn(th: => Throwable)(implicit `_`: DummyImplicit): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.warn(th))

  def warn(msg: => String, th: => Throwable): RIO[Logger, Unit] =
    ZIO.accessM[Logger](_.logger.warn(msg, th))
}
