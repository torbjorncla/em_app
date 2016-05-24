package com.beng.emapp.data

import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpRequest, HttpResponse}
import akka.stream.{ActorMaterializer, ActorMaterializerSettings}

import scala.concurrent.Future


trait HttpRepository {

  import akka.pattern.pipe
  import context.dispatcher

  final implicit val materializer: ActorMaterializer = ActorMaterializer(ActorMaterializerSettings(context.system))

  val http = Http(context.system)

  final val fixturesUrl = "http://api.football-data.org/v1/soccerseasons/424/fixtures";

  final case class fixtures(fixtures: Array[fixture])
  final case class fixture(date: String, status: String, matchday: Int, homeTeamName: String,
                           awayTeamName: String, result: result)
  final case class result(goalsHomeTeam: Option[Int], goalsAwayTeam: Option[Int])

  val matches: Future[HttpResponse] = {
    val resp = Http().singleRequest(HttpRequest(uri = fixturesUrl))
  }
}

trait MongoRepository {

}

