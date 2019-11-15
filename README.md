# log4zio

```scala
import log.effect.zio.ZioLogWriter._
import zio.{Task, ZIO}
import zio.console._
import com.chriskite.log4zio.logger

object Main extends zio.App {
  val printingProgram = for {
    _ <- putStrLn("print to console")
    _ <- logger.info("log a message")
  } yield ()

  val program = for {
    logWriter <- log4sFromName provide "test logger"
    env = new Logger with Console.Live {
      def logger = logWriter
    }
    _ <- printingProgram provide env
  } yield ()

  override def run(args: List[String]): ZIO[zio.ZEnv, Nothing, Int] =
    program.foldM(err => Task(System.err.println(err.getMessage)).orDie.as(1),
                  _ => Task.succeed(0))
}

```
