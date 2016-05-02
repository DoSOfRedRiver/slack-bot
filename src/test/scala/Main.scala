import com.gmail.dosofredriver.slack.bot.SlackApi
import com.gmail.dosofredriver.slack.bot.dto.{ChatHistory, OpenChannel, RealTime, UsersList}
import com.gmail.dosofredriver.slack.bot.dto.SlackJsonProtocol._
import spray.json.{JsObject, JsString}

/**
  * Created by Александр on 15.04.2016.
  */
object Main extends App {
  val token = "my-secret-key"
  val api = new SlackApi(token)

  val commands = Map(
    "my tasks" -> "Помыть посуду",
    "is bisy" -> "Yes"
  )
/*
  val response = api.sendMessage(JsObject(
    "channel" -> JsString("#general"),
    "text" -> JsString("Hello from Scala!")
  ))
  println(response.prettyPrint)
*/


/*  val response1 = api.usersList()
  println(response1.prettyPrint)

  val ul = response1.convertTo[UsersList]
  val dorrMember = ul.members.find(_.name == "dosofredriver")
  val dorrId = dorrMember.get.id


  val jsObj = Map(
    "user" -> dorrId
  )

  val response2 = api.imOpen(jsObj)

  println(response2.prettyPrint)

  val openChannelMsg = response2.convertTo[OpenChannel]
  val dorrChannelId = openChannelMsg.channel.id


  val response3 = api.imHistory(
    Map(
      "channel" -> dorrChannelId,
      "count" -> "5"
    )
  )

  println(response3.prettyPrint)

  val chatHistory = response3.convertTo[ChatHistory]
  val message = chatHistory.messages.head

  if (message.subtype.isDefined)
    System.exit(0)

  val text = message.text

  println("Message: " + message)
  val answer = commands.getOrElse(text, "Command not found")

  val response4 = api.postMessage(Map(
    "channel" -> dorrChannelId,
    "text" -> answer
  ))

  println(response4.prettyPrint)*/

  val response5 = api.rtmStart(Map.empty)
  println(response5.prettyPrint)
  val rt = response5.convertTo[RealTime]
  val unreadedIms = rt.ims.filter(_.unread_count > 0)
  val userId = unreadedIms.head.user

  val jsObj = Map(
    "user" -> userId
  )

  val response2 = api.imOpen(jsObj)

  println(response2.prettyPrint)

  val openChannelMsg = response2.convertTo[OpenChannel]
  val dorrChannelId = openChannelMsg.channel.id


  val response3 = api.postMessage(
    Map(
      "channel" -> dorrChannelId,
      "text" -> "HAHOHAHO!!1"
    )
  )

  println(response2)
  println(response3)
}
