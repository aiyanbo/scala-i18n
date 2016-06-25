package org.jmotor.i18n

import java.util.Locale

import org.scalatest._

class AppTest extends FunSuite with Matchers {

  test("i18n zh-CN") {
    val messages = Messages(locale = Locale.CHINA)
    assert("您好, Andy Ai" == messages.format("hello", "Andy Ai"))
  }

  test("i18n en-US") {
    val messages = Messages(locale = Locale.US)
    assert("Hello, Andy Ai" == messages.format("hello", "Andy Ai"))
  }
}
