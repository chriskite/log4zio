package com.chriskite.log4zio

import ch.qos.logback.classic.Level
import com.chriskite.log4zio.{Logger => L4ZLogger}
import log.effect.internal.Show
import log.effect.internal.syntax._

import log.effect.zio.ZioLogWriter._
import org.log4s._
import org.scalatest._
import zio.{DefaultRuntime, RIO}

class LoggerSpec extends FunSpec with Matchers {
  val testLogger = getLogger("log4zio.test")
  val testMessage = "test message"
  val testThrowable: Throwable = new Exception("test throwable")

  case class TestShow(a: String)

  implicit val testShow: Show[TestShow] = (x: TestShow) => x.a

  val rts = new DefaultRuntime {}

  def logProgram(p: RIO[L4ZLogger, Unit]) =
    for {
      logWriter <- log4sFromLogger provide testLogger
      env = new L4ZLogger {
        def logger = logWriter
      }
      _ <- p provide env
    } yield ()

  def runLogProgram(p: RIO[L4ZLogger, Unit]) = rts.unsafeRunSync(logProgram(p))

  def assertCorrectLogging(msg: String,
                           th: Option[Throwable],
                           level: Option[Level])(f: RIO[L4ZLogger, Unit]) = {
    TestAppender.withAppender() {
      runLogProgram(f)
      val eventOpt = TestAppender.dequeue
      eventOpt shouldBe defined
      eventOpt foreach { e =>
        e.message should equal(msg)
        th match {
          case Some(_) => e.throwable shouldBe defined
          case None    => e.throwable should not be defined
        }
        level match {
          case Some(lvl) => e.level shouldBe lvl
          case None      =>
        }
      }
    }
  }

  describe("logger package") {
    describe("trace") {
      describe("msg: String") {
        it("should log the msg string") {
          assertCorrectLogging(testMessage, None, Some(Level.TRACE)) {
            logger.trace(testMessage)
          }
        }
        describe("a: Show") {
          it("should log the Show") {
            assertCorrectLogging(testMessage, None, Some(Level.TRACE)) {
              logger.trace(TestShow(testMessage))
            }
          }
          describe("th: Throwable") {
            it("should log the throwable") {
              assertCorrectLogging(testThrowable.show, None, Some(Level.TRACE)) {
                logger.trace(testThrowable)
              }
            }
          }
          describe("msg: String, th: Throwable") {
            it("should log the message and throwable") {
              assertCorrectLogging(testMessage,
                                   Some(testThrowable),
                                   Some(Level.TRACE)) {
                logger.trace(testMessage, testThrowable)
              }
            }
          }
        }
      }
    }
    describe("debug") {
      describe("msg: String") {
        it("should log the msg string") {
          assertCorrectLogging(testMessage, None, Some(Level.DEBUG)) {
            logger.debug(testMessage)
          }
        }
        describe("a: Show") {
          it("should log the Show") {
            assertCorrectLogging(testMessage, None, Some(Level.DEBUG)) {
              logger.debug(TestShow(testMessage))
            }
          }
          describe("th: Throwable") {
            it("should log the throwable") {
              assertCorrectLogging(testThrowable.show, None, Some(Level.DEBUG)) {
                logger.debug(testThrowable)
              }
            }
          }
          describe("msg: String, th: Throwable") {
            it("should log the message and throwable") {
              assertCorrectLogging(testMessage,
                                   Some(testThrowable),
                                   Some(Level.DEBUG)) {
                logger.debug(testMessage, testThrowable)
              }
            }
          }
        }
      }
    }
    describe("info") {
      describe("msg: String") {
        it("should log the msg string") {
          assertCorrectLogging(testMessage, None, Some(Level.INFO)) {
            logger.info(testMessage)
          }
        }
        describe("a: Show") {
          it("should log the Show") {
            assertCorrectLogging(testMessage, None, Some(Level.INFO)) {
              logger.info(TestShow(testMessage))
            }
          }
          describe("th: Throwable") {
            it("should log the throwable") {
              assertCorrectLogging(testThrowable.show, None, Some(Level.INFO)) {
                logger.info(testThrowable)
              }
            }
          }
          describe("msg: String, th: Throwable") {
            it("should log the message and throwable") {
              assertCorrectLogging(testMessage,
                                   Some(testThrowable),
                                   Some(Level.INFO)) {
                logger.info(testMessage, testThrowable)
              }
            }
          }
        }
      }
    }
    describe("error") {
      describe("msg: String") {
        it("should log the msg string") {
          assertCorrectLogging(testMessage, None, Some(Level.ERROR)) {
            logger.error(testMessage)
          }
        }
        describe("a: Show") {
          it("should log the Show") {
            assertCorrectLogging(testMessage, None, Some(Level.ERROR)) {
              logger.error(TestShow(testMessage))
            }
          }
          describe("th: Throwable") {
            it("should log the throwable") {
              assertCorrectLogging(testThrowable.show, None, Some(Level.ERROR)) {
                logger.error(testThrowable)
              }
            }
          }
          describe("msg: String, th: Throwable") {
            it("should log the message and throwable") {
              assertCorrectLogging(testMessage,
                                   Some(testThrowable),
                                   Some(Level.ERROR)) {
                logger.error(testMessage, testThrowable)
              }
            }
          }
        }
      }
    }
    describe("warn") {
      describe("msg: String") {
        it("should log the msg string") {
          assertCorrectLogging(testMessage, None, Some(Level.WARN)) {
            logger.warn(testMessage)
          }
        }
        describe("a: Show") {
          it("should log the Show") {
            assertCorrectLogging(testMessage, None, Some(Level.WARN)) {
              logger.warn(TestShow(testMessage))
            }
          }
          describe("th: Throwable") {
            it("should log the throwable") {
              assertCorrectLogging(testThrowable.show, None, Some(Level.WARN)) {
                logger.warn(testThrowable)
              }
            }
          }
          describe("msg: String, th: Throwable") {
            it("should log the message and throwable") {
              assertCorrectLogging(testMessage,
                                   Some(testThrowable),
                                   Some(Level.WARN)) {
                logger.warn(testMessage, testThrowable)
              }
            }
          }
        }
      }
    }
  }
}
