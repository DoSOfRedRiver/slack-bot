package com.gmail.dosofredriver.slack.bot.dto


case class Message(username: Option[String], text: String, `type`: String, subtype: Option[String])

case class ChatHistory(ok: Boolean, messages: Array[Message])
