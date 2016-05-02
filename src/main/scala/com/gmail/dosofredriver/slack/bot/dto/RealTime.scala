package com.gmail.dosofredriver.slack.bot.dto


case class IM(user: String, id: String, unread_count: Int, latest: Option[Message])

case class RealTime(ims: Array[IM], url: String)
