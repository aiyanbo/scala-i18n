package org.jmotor.i18n

import java.text.MessageFormat
import java.util.{Locale, ResourceBundle}

import org.jmotor.i18n.control.UTF8Control

/**
 * Component:
 * Description:
 * Date: 16/6/25
 *
 * @author Andy Ai
 */
object Messages {

  def apply(name: String = "message", suffix: String = "properties", locale: Locale): Messages = new Messages(name, suffix, locale)
}

class Messages(name: String, suffix: String, locale: Locale) {
  private[this] val bundle = ResourceBundle.getBundle(name, locale, new UTF8Control(suffix))

  def format(message: String, args: Any*): String = {
    new MessageFormat(bundle.getString(message), locale).format(args.map(_.asInstanceOf[java.lang.Object]).toArray)
  }
}
