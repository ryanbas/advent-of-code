package advent.day2

import common.Utils.resource

import scala.io.Source

object Checksum extends App {
  def findDivisible(list: List[Int]): Option[(Int, Int)] = {
    var sorted = list.sorted.reverse
    var smaller: Option[Int] = None
    val bigger = sorted.dropWhile(h => {
      val tmp = sorted.dropWhile(c => h % c != 0 || h == c).headOption.map((h, _))
      smaller = tmp.map(_._2)

      tmp.isEmpty
    }).headOption

    Some(bigger.get, smaller.get)
  }

  def checksum(rows: List[Int]*): Int = {
    rows.map(list => list.max - list.min).sum
  }

  def checksum2(rows: List[Int]*): Int = {
    rows.flatMap(findDivisible(_).map(t => t._1 / t._2)).sum
  }

  val fileSource = Source.fromFile(resource("day2", "input.txt").toFile)
  val input = fileSource.getLines.map(row => {
    row.split("\\s+").map(_.toInt).toList
  }).toList

  println(checksum2(input:_*))
}
