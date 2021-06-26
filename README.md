Scala i18n
==================

[![Build Status](https://travis-ci.com/aiyanbo/scala-i18n.svg?branch=master)](https://travis-ci.com/aiyanbo/scala-i18n)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.jmotor/scala-i18n_2.12/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.jmotor/scala-i18n_2.12)

# SBT

```
"org.jmotor" %% "scala-i18n" % "1.0.9"
```

# Synopsis

```scala
  val messages = Messages()
  val ranges = Locale.LanguageRange.parse("zh-CN,zh;q=0.8,en;q=0.6")
  implicit val locale = Locale.lookup(ranges, Seq(Locale.US, Locale.CHINA))
  messages.format("hello", "Andy Ai")
```

# Credits

- https://github.com/osinka/scala-i18n

- https://stackoverflow.com/questions/4659929/how-to-use-utf-8-in-resource-properties-with-resourcebundle
