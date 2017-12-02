package advent.day2

import scala.io.Source
import advent.common.Utils.resource
import advent.common.Utils.findDivisible

object Checksum extends App {
  private def checksum(f: List[Int] => Option[Int])(rows: List[Int]*): Int = {
    rows.flatMap(f(_)).sum
  }

  private def minMaxDifference: List[Int] => Option[Int] =
    (list: List[Int]) => Some(list.max - list.min)
  private def divideDivisible: List[Int] => Option[Int] =
    (list: List[Int]) => findDivisible(list).map(t => t._1 / t._2)

  def checksumPart1(rows: List[Int]*): Int = checksum(minMaxDifference)(rows:_*)
  def checksumPart2(rows: List[Int]*): Int = checksum(divideDivisible)(rows:_*)

  val fileSource = Source.fromFile(resource("day2", "input.txt").toFile)
  val input = fileSource.getLines.map(row => {
    row.split("\\s+").map(_.toInt).toList
  }).toList

  println(checksumPart1(input:_*))
  println(checksumPart2(input:_*))
}
