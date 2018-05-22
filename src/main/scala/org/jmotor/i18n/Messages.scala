package org.jmotor.i18n

import java.text.MessageFormat
import java.util.{ Locale, ResourceBundle }

import org.jmotor.i18n.control.UTF8Control

import scala.util.control.NonFatal

/**
 * Component:
 * Description:
 * Date: 16/6/25
 *
 * @author Andy Ai
 */
object Messages {

  def apply(name: String = "message", suffix: String = "properties"): Messages = new Messages(name, suffix)
}

class Messages(name: String, suffix: String) {

  def format(key: String, args: Any*)(implicit locale: Locale): String = {
    val bundle = ResourceBundle.getBundle(name, locale, new UTF8Control(suffix))
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
}
