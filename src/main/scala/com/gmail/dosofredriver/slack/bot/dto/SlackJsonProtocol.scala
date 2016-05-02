package com.gmail.dosofredriver.slack.bot.dto

import spray.json.DefaultJsonProtocol


object SlackJsonProtocol extends DefaultJsonProtocol{
  implicit val profileFormat = jsonFormat1(Profile)
  implicit val memberFormat = jsonFormat5(Member)
  implicit val userListFormat = jsonFormat2(UsersList)

  implicit val channelFormat = jsonFormat1(Channel)
  implicit val openChannelFormat = jsonFormat2(OpenChannel)

  implicit val messageFormat = jsonFormat4(Message)
  implicit val chatHistoryFormat = jsonFormat2(ChatHistory)

  implicit val imFormat = jsonFormat4(IM)
  implicit val realTimeFormat = jsonFormat2(RealTime)
}
