package advent.common

import org.scalatest.{FreeSpec, Matchers}
import Utils.findDivisible

class UtilsTest extends FreeSpec with Matchers {
  "findDivisible should find (9, 3) divisible in List(1, 9, 5, 3)" in {
    findDivisible(List(1, 9, 5, 3)) shouldBe Some((9, 3))
  }

  "findDivisible should find (10, 5) divisible in List(10, 9, 5, 11)" in {
    findDivisible(List(10, 9, 5, 11)) shouldBe Some((10, 5))
  }

  "findDivisible should find (4, 2) divisible in List(4, 2, 9, 11)" in {
    findDivisible(List(4, 2, 9, 11)) shouldBe Some((4, 2))
  }

  "findDivisible should find None divisible in Nil" in {
    findDivisible(Nil) shouldBe None
  }

  "findDivisible should find None divisible in List(2, 3, 5, 7)" in {
    findDivisible(List(2, 3, 5, 7)) shouldBe None
  }
}
