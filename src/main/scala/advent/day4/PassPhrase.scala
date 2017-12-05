package advent.day4

import java.util

import advent.common.Utils

object PassPhrase extends App {
  def valid(unique: List[String] => Set[String])(list: List[String]): Boolean = {
    unique(list).size == list.size
  }

  def validPart1(list: List[String]) = valid(l => Set(l:_*))(list)
  def validPart2(list: List[String]) = {
    valid(l => Set(l.map(_.sortWith((a, b) => a > b)).map(_.toString):_*))(list)
  }

  val lines = Utils.fileLines("day4", "input.txt").toArray.toList
  println("Part 1: " + lines
    .map(_.toString)
    .map(line => if (validPart1(line.split(" ").toList)) 1 else 0)
    .sum)

  println("Part 2: " + lines
    .map(_.toString)
    .map(line => if (validPart2(line.split(" ").toList)) 1 else 0)
    .sum)



}