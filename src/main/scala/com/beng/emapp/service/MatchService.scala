package com.beng.emapp.service

import akka.http.scaladsl.server.Directives._
import com.beng.emapp.data.HttpRepository
import com.beng.emapp.model.{JsonProtocol, Team}

trait MatchService extends JsonProtocol with HttpRepository {
  val matchRoute =
    pathPrefix("v1") {
      path("matches") {
        get {
          ctx => ({
            matches.map(r => {
              println(r.entity.dataBytes)
            })
            ctx.complete("done n done")
          })
        }
      } ~
      path("matches" / IntNumber) { matchNumber =>
        get {
          complete(Team("Nisse", "test"))
        }
      }
    }
}
