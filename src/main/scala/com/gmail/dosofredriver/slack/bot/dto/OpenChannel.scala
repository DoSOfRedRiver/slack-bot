package com.gmail.dosofredriver.slack.bot.dto


case class Channel(id: String)

case class OpenChannel(ok: Boolean, channel: Channel)
