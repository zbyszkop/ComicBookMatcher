package net.maeph.comicmatcher.cv

import com.typesafe.config.{Config, ConfigFactory}
import dispatch._, Defaults._

/**
 * Created by zbyszko on 08.09.14.
 */
class ComicVineApi {

  private val config: Config = ConfigFactory.load()

  private val apiKey: String = config.getString("api_key")
  private val api: Req = :/("www.comicvine.com") / "api" addQueryParameter("api_key", apiKey)

  def http: Http = {
    Http.configure(_ setFollowRedirects true)
  }

  def getIssue(id:Int):String = {
    val typeId: String = "4000-"
    http(api / "issue" / (typeId + id) OK as.String).apply()

  }

}

case class Issue(id:String, volume:String, issueNumber:Int)
