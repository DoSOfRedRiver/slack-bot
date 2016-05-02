package com.gmail.dosofredriver.slack.bot.dto

//TODO: fix
//Exception in thread "main" spray.json.DeserializationException: Object is missing required member 'email'
case class Profile(real_name: String)

case class Member(is_bot: Boolean, name: String, is_admin: Boolean, id: String, profile: Profile)

case class UsersList(ok: Boolean, members: Array[Member])