package com.beng.emapp.service

trait MainRouter extends MatchService with TeamService {
  import akka.http.scaladsl.server.Directives._
  val routes = matchRoute ~ teamRoute
}

