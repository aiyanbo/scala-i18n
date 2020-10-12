package org.jmotor.i18n

import java.text.MessageFormat
import java.util.Locale
import java.util.ResourceBundle

import org.jmotor.i18n.control.UTF8Control

import scala.collection.JavaConverters._

/**
 * Component:
 * Description:
 * Date: 16/6/25
 *
 * @author Andy Ai
 */
object Messages {

  lazy val defaultSuffix = "properties"

  def apply(name: String = "message"): Messages = {
    new Messages(name, defaultSuffix, None)
  }

  def apply(name: String, loader: ClassLoader): Messages = {
    new Messages(name, defaultSuffix, Option(loader))
  }

}

class Messages(name: String, suffix: String, loaderOpt: Option[ClassLoader] = None) {

  def format(key: String, args: Any*)(implicit locale: Locale): String = {
    val bundle = getBundle(locale)
    try {
      val message = bundle.getString(key)
      if (args.nonEmpty) {
        new MessageFormat(message, locale).format(args.map(_.asInstanceOf[java.lang.Object]).toArray)
      } else {
        message
      }
    } catch {
      case _: java.util.MissingResourceException ⇒ key
    }
  }

  def getKeys(implicit locale: Locale): Set[String] = {
    val bundle = getBundle(locale)
    bundle.getKeys.asScala.toSet
  }

  def contains(key: String)(implicit locale: Locale): Boolean = {
    getKeys.contains(key)
  }

  def getKey(value: String)(implicit locale: Locale): Option[String] = {
    val bundle = getBundle(locale)
    bundle.getKeys.asScala.find(key ⇒ bundle.getString(key) == value)
  }

  def searchValues(value: String)(implicit locale: Locale): Set[String] = {
    val bundle = getBundle(locale)
    val keys = bundle.getKeys.asScala.filter(key ⇒ bundle.getString(key).contains(value))
    keys.map(bundle.getString).toSet
  }

  private[this] def getBundle(locale: Locale): ResourceBundle = {
    loaderOpt match {
      case Some(loader) ⇒ ResourceBundle.getBundle(name, locale, loader, new UTF8Control(suffix))
      case None         ⇒ ResourceBundle.getBundle(name, locale, new UTF8Control(suffix))
    }
  }

}
