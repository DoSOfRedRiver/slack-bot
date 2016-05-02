package com.gmail.dosofredriver.slack.bot

import spray.json._
import spray.json.DefaultJsonProtocol._

import scalaj.http.{Http, HttpRequest}


class SlackApi(token: String) {
  val apiUrl = "https://slack.com/api/"



  def postMessage(params: Map[String,String]): JsValue = {
    val subUrl = "chat.postMessage"

    sendRequest(subUrl, params)
  }


  def imList(params: Map[String,String]): JsValue = {
    val subUrl = "im.list"

    sendRequest(subUrl, params)
  }


  def imHistory(params: Map[String,String]): JsValue = {
    val subUrl = "im.history"

    sendRequest(subUrl, params)
  }


  def usersList(): JsValue = {
    val subUrl = "users.list"

    sendRequest(subUrl, Map.empty)
  }


  def imOpen(params: Map[String,String]): JsValue = {
    val subUrl = "im.open"

    sendRequest(subUrl, params)
  }


  def rtmStart(params: Map[String,String]): JsValue = {
    val subUrl = "rtm.start"

    sendRequest(subUrl, params)
  }


  def sendRequest(subUrl: String, params: Map[String,String]): JsValue = {
    val queryUrl = buildQueryUrl(subUrl)

    val getParameters = makeGetParameters(params)

    val request: HttpRequest = Http(queryUrl).params(getParameters)

    extractResponse(request)
  }


  private def buildQueryUrl(subUrl: String) = s"$apiUrl/$subUrl"

  private def makeGetParameters(params: Map[String,String]): Map[String,String] = {
    params + ("token" -> token)
  }

  private def extractResponse(request: HttpRequest): JsValue =
    (new String(request.asBytes.body)).parseJson

}
