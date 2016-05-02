package com.gmail.dosofredriver.slack.bot.net.ws

import io.backchat.hookup.{Disconnected, HookupClient, HookupClientConfig, Success, TextMessage}
import java.net.URI

class Client(uri: URI) {
  new HookupClient {
    val uri = new URI("ws://localhost:8080/thesocket")

    def receive = {
      case Disconnected(_) ⇒ println("The websocket to " + uri.toASCIIString + " disconnected.")
      case TextMessage(message) ⇒ {
        println("RECV: " + message)
        send("ECHO: " + message)
      }
    }

    connect() onSuccess {
      case Success ⇒
        println("The websocket to ${uri.toASCIIString} is connected.")
      case _ ⇒
        println("Can't connect to " + uri.toASCIIString)
    }

    override def settings: HookupClientConfig = HookupClientConfig.apply(uri)
  }
}
