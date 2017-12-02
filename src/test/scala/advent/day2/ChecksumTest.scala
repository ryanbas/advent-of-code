package advent.day2

import org.scalatest.{FreeSpec, Matchers}
import advent.day2.Checksum.{checksum, checksum2, findDivisible}

class ChecksumTest extends FreeSpec with Matchers {
  """
    |5 1 9 5
    |7 5 3
    |2 4 6 8
  """.stripMargin - {
    "should be 18" in {
      checksum(List(5, 1, 9, 5), List(7, 5, 3), List(2, 4, 6, 8)) shouldBe 18
    }
  }

  """
    |5 9 2 8
    |9 4 7 3
    |3 8 6 5
  """.stripMargin - {
    "should be 18" in {
      checksum2(List(5, 9, 2, 8), List(9, 4, 7, 3), List(3, 8, 6, 5)) shouldBe 9
    }
  }

  "findDivisible should find (9, 3) divisible in List(1, 9, 5, 3)" in {
    findDivisible(List(1, 9, 5, 3)) shouldBe Some((9, 3))
  }

  "findDivisible should find (10, 5) divisible in List(10, 9, 5, 11)" in {
    findDivisible(List(10, 9, 5, 11)) shouldBe Some((10, 5))
  }

  "findDivisible should find (4, 2) divisible in List(4, 2, 9, 11)" in {
    findDivisible(List(4, 2, 9, 11)) shouldBe Some((4, 2))
  }
}
