package com.beng.emapp.data

import akka.actor.Actor
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpRequest, HttpResponse}
import akka.stream.ActorMaterializer

import scala.concurrent.Future


trait HttpRepository extends Actor {

  final val fixturesUrl = "http://api.football-data.org/v1/soccerseasons/424/fixtures";

  case class fixtures(fixtures: Array[fixture])
  case class fixture(date: String, status: String, matchday: Int, homeTeamName: String,
                           awayTeamName: String, result: result)
  case class result(goalsHomeTeam: Option[Int], goalsAwayTeam: Option[Int])

  val matches: Future[HttpResponse] = {
    implicit val materializer = ActorMaterializer()
    Http(context.system).singleRequest(HttpRequest(uri = fixturesUrl))
  }


}

object HttpRepositoryActor extends Actor {
  override def receive = {
    case _ => sender ! "blabla"
  }
}

trait MongoRepository {

}

