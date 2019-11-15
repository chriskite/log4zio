publishMavenStyle := true

import xerial.sbt.Sonatype._

sonatypeProjectHosting := Some(GitHubHosting("chriskite", "log4zio", "chris@chriskite.com"))
