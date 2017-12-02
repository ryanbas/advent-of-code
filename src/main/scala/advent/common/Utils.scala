package advent.common

import java.nio.file.{Files, Path, Paths}
import java.util.stream.Stream

object Utils {
  def resource(pkg: String, filename: String): Path = {
    Paths.get("src", "main", "resources", pkg).resolve(filename)
  }

  def fileLines(pkg: String, filename: String): Stream[String] = {
    Files.lines(resource(pkg, filename))
  }

  def findDivisible(list: List[Int]): Option[(Int, Int)] = {
    list.combinations(2)
      .map(x => (x.max, x.min))
      .find(x => x._1 != x._2 && x._1 % x._2 == 0)
  }
}
