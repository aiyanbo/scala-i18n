package org.jmotor.i18n

import java.util.Locale

import org.scalatest._
import scala.collection.JavaConverters._

class AppTest extends FunSuite with Matchers {

  test("i18n zh-CN") {
    val messages = Messages()
    val ranges = Locale.LanguageRange.parse("zh-CN,zh;q=0.8,en;q=0.6")
    implicit val locale: Locale = Locale.lookup(ranges, Seq(Locale.US, Locale.CHINA).asJava)
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

  test("get key") {
    val messages = Messages()
    val key = "name"
    assert(messages.getKey("名字")(Locale.CHINA).contains(key))
    assert(messages.getKey("Name")(Locale.US).contains(key))
  }

  test("contains") {
    val messages = Messages()
    assert(messages.contains("name")(Locale.CHINA))
  }

  test("searchValues") {
    val messages = Messages()
    val searchResult = messages.searchValues("名")(Locale.CHINA)
    assert(searchResult.size == 1 && searchResult.head == "名字")
  }
}
