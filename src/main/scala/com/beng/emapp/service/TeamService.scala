package com.beng.emapp.service

import akka.http.scaladsl.server.Directives._

trait TeamService {
  val teamRoute =
    pathPrefix("v1") {
      path("teams") {
        get {
          ctx => ({
            ctx.complete("teams!")
          })
        }
      }
    }
}
