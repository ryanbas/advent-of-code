package advent.day2

import org.scalatest.{FreeSpec, Matchers}
import advent.day2.Checksum.{checksumPart1, checksumPart2}

class ChecksumTest extends FreeSpec with Matchers {
  """when difference of max and min is used
    |(5 1 9 5),
    |(7 5 3  ),
    |(2 4 6 8)
  """.stripMargin - {
    "checksum should be 18" in {
      checksumPart1(List(5, 1, 9, 5), List(7, 5, 3), List(2, 4, 6, 8)) shouldBe 18
    }
  }

  """ when quotient of divisible elements is used
    |(5 9 2 8),
    |(9 4 7 3),
    |(3 8 6 5)
  """.stripMargin - {
    "checksum should be 18" in {
      checksumPart2(List(5, 9, 2, 8), List(9, 4, 7, 3), List(3, 8, 6, 5)) shouldBe 9
    }
  }
}
