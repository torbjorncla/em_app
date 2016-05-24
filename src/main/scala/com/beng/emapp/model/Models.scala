package com.beng.emapp.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, JsString, JsValue, RootJsonFormat}


final case class Team(country: String, countryCode: String)

final case class Match(
                        homeTeam: Team,
                        homeScore: Int,
                        awayTeam: Team,
                        awayScore: Int,
                        kickOff: java.time.LocalDateTime)



trait JsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {

  implicit val dateProtocol = new RootJsonFormat[java.time.LocalDateTime] {

    lazy val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    override def write(obj: LocalDateTime): JsString = {
      JsString(obj.format(formatter))
    }

    override def read(json: JsValue): LocalDateTime = {
      LocalDateTime.parse(json.toString(), formatter)
    }
  }

  implicit val teamProtocol = jsonFormat(Team, "country", "country_code")
  implicit val matchProtocol =
    jsonFormat(Match,
      "home_team",
      "home_score",
      "away_team",
      "away_score",
      "kick_off")
}






