/**
 * Created by mephi_000 on 2014-09-08.
 */

import com.ning.http.client.Response
import com.typesafe.config.{Config, ConfigFactory}
import dispatch._, Defaults._
import dispatch.as.String
import net.maeph.comicmatcher.cv.ComicVineApi
import scala.xml._


object testComicVine extends App {
  private val api: ComicVineApi = new ComicVineApi


  private val isseXML: String = api.getIssue(6)
  private val issue = XML.loadString(isseXML)
  println (isseXML)

}
