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
