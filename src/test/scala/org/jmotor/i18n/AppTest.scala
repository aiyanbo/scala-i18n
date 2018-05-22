package org.jmotor.i18n

import java.util.Locale

import org.scalatest._
import scala.collection.JavaConversions._

class AppTest extends FunSuite with Matchers {

  test("i18n zh-CN") {
    val messages = Messages()
    val ranges = Locale.LanguageRange.parse("zh-CN,zh;q=0.8,en;q=0.6")
    implicit val locale: Locale = Locale.lookup(ranges, Seq(Locale.US, Locale.CHINA))
    assert("您好, Andy Ai" == messages.format("hello", "Andy Ai"))
  }

  test("i18n en-US") {
    val messages = Messages()
    implicit val locale: Locale = Locale.US
    assert("Hello, Andy Ai" == messages.format("hello", "Andy Ai"))
  }

  test("i18n cannot found key will be to key") {
    val messages = Messages()
    implicit val locale: Locale = Locale.US
    assert("not-found-key" == messages.format("not-found-key"))
  }
}
