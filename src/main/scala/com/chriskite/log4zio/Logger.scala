package com.chriskite.log4zio

import log.effect.LogWriter
import zio.Task

trait Logger {
  def logger: LogWriter[Task]
}
