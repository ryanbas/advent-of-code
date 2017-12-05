package advent.day4

import org.scalatest.{FreeSpec, Matchers}
import advent.day4.PassPhrase.{validPart1, validPart2}

class PassPhraseTest extends FreeSpec with Matchers {
  "for part 1" - {
    "aa bb cc dd ee should be valid" in {
      validPart1("aa bb cc dd ee".split(" ").toList) shouldBe true
    }

    "aa bb cc dd aa should not be valid" in {
      validPart1("aa bb cc dd aa".split(" ").toList) shouldBe false
    }

    "aa bb cc dd aaa should be valid" in {
      validPart1("aa bb cc dd aaa".split(" ").toList) shouldBe true
    }
  }

  "for part 2" - {
    "abcde fghij should be valid" in {
      validPart2("abcde fghij".split(" ").toList) shouldBe true
    }

    "abcde xyz ecdab should not be valid" in {
      validPart2("abcde xyz ecdab".split(" ").toList) shouldBe false
    }

    "a ab abc abd abf abj should be valid" in {
      validPart2("a ab abc abd abf abj".split(" ").toList) shouldBe true
    }

    "iiii oiii ooii oooi oooo should be valid" in {
      validPart2("iiii oiii ooii oooi oooo".split(" ").toList) shouldBe true
    }

    "oiii ioii iioi iiio should not be valid" in {
      validPart2("oiii ioii iioi iiio".split(" ").toList) shouldBe false
    }
  }
}
