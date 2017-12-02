package advent.day1

import java.nio.file.{Files, Paths}

import common.Utils.fileLines


object Captcha extends App {
  private def captcha(init: List[(Int, Int)])(pair: (List[(Int, Int)], Int) => List[(Int, Int)])(seq: Seq[Int]): Int = {
    def check(p: (Int, Int)) = p._1 == p._2
    seq.foldLeft(init)(pair).map(p => if (check(p)) p._1 else 0).sum
  }

  def captcha(input: String, ahead: Int = 1): Int = {
    captcha(ahead)(input.toCharArray.map(_.asDigit).toList)
  }

  def captchaHalf(input: String) = captcha(input, input.length / 2)

  def captcha(seq: Seq[Int]): Int = seq match {
    case Nil => 0
    case _ =>
      val c = seq :+ seq.head
      val init = List((c.head, c.tail.head))
      def pair(s: List[(Int, Int)], n: Int) = s :+ (s.last._2, n)

      captcha(init)(pair)(c.tail.tail)
  }

  def captcha1(list: List[Int]): Int = captcha(1)(list)

  // The final solution -- a generalized version for any number of elements ahead
  def captcha(ahead: Int)(list: List[Int]): Int = {
    def elementsEqual(t: (Int, Int)) = t._1 == t._2
    val pairs = list.drop(ahead) ++ list.take(ahead)
    list.zip(pairs).map(p => if (elementsEqual(p)) p._1 else 0).sum
  }


  fileLines("day1", "input.txt").forEach(line => {
    println(captchaHalf(line))
  })
}