Scala i18n
==================

[![Build Status](https://travis-ci.org/aiyanbo/scala-i18n.svg?branch=master)](https://travis-ci.org/aiyanbo/scala-i18n)

#Synopsis

```scala
  val messages = Messages()
  val ranges = Locale.LanguageRange.parse("zh-CN,zh;q=0.8,en;q=0.6")
  implicit val locale = Locale.lookup(ranges, Seq(Locale.US, Locale.CHINA))
  messages.format("hello", "Andy Ai")
```

# Credits

- https://github.com/osinka/scala-i18n

- https://stackoverflow.com/questions/4659929/how-to-use-utf-8-in-resource-properties-with-resourcebundle