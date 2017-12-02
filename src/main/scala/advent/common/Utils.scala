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
    var sorted = list.sorted.reverse
    var smaller: Option[Int] = None
    val bigger = sorted.dropWhile(h => {
      val tmp = sorted.dropWhile(c => h % c != 0 || h == c).headOption.map((h, _))
      smaller = tmp.map(_._2)

      tmp.isEmpty
    }).headOption

    for {
      max <- bigger
      min <- smaller
    } yield (max, min)
  }
}
