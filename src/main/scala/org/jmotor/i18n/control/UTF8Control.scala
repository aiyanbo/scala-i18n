package org.jmotor.i18n.control

import java.io.InputStreamReader
import java.net.{ URL, URLConnection }
import java.util.ResourceBundle.Control
import java.util.{ Locale, PropertyResourceBundle, ResourceBundle }

/**
 * Component:
 * Description:
 * Date: 16/6/25
 *
 * @author Andy Ai
 */
class UTF8Control(suffix: String = "properties") extends Control {

  override def newBundle(baseName: String, locale: Locale, format: String, loader: ClassLoader, reload: Boolean): ResourceBundle = {
    // The below is a copy of the default implementation.
    val bundleName = toBundleName(baseName, locale)
    val resourceName = toResourceName(bundleName, suffix)

    val stream = if (reload) {
      for {
        url: URL ← Option(loader.getResource(resourceName))
        connection: URLConnection ← Option(url.openConnection())
      } yield {
        connection.setUseCaches(false)
        connection.getInputStream
      }
    } else {
      Option(loader.getResourceAsStream(resourceName))
    }

    (for {
      _stream ← stream
    } yield {
      new PropertyResourceBundle(new InputStreamReader(_stream, "UTF-8"))
    }).orNull
  }
}
