package common

import java.nio.file.{Files, Path, Paths}
import java.util.stream.Stream

object Utils {
  def resource(pkg: String, filename: String): Path = {
    Paths.get("src", "main", "resources", pkg).resolve(filename)
  }

  def fileLines(pkg: String, filename: String): Stream[String] = {
    Files.lines(resource(pkg, filename))
  }
}
