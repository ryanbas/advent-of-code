package advent.day1

import org.scalatest.{FreeSpec, Matchers}
import Captcha.captcha
import Captcha.captchaHalf

class CaptchaTest extends FreeSpec with Matchers {
  "when looking ahead 1 element" - {
    "empty string should produce a sum of 0" in {
      captcha("") shouldBe 0
    }

    "1221 should produce a sum of 3" in {
      captcha("1221") shouldBe 3
    }

    "1111 should produce a sum of 4" in {
      captcha("1111") shouldBe 4
    }

    "1234 should produce a sum of 0" in {
      captcha("1234") shouldBe 0
    }

    "91212129 should produce a sum of 9" in {
      captcha("91212129") shouldBe 9
    }
  }

  "when looking halfway around the list" - {
    "empty string should produce a sum of 0" in {
      captchaHalf("") shouldBe 0
    }

    "1212 should produce a sum of 3" in {
      captchaHalf("1212") shouldBe 6
    }

    "1221 should produce a sum of 4" in {
      captchaHalf("1221") shouldBe 0
    }

    "123425 should produce a sum of 0" in {
      captchaHalf("123425") shouldBe 4
    }

    "123123 should produce a sum of 9" in {
      captchaHalf("123123") shouldBe 12
    }

    "12131415 should produce a sum of 4" in {
      captchaHalf("12131415") shouldBe 4
    }
  }
}
