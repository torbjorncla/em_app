package com.beng.emapp.service

import akka.actor.{Actor}
import akka.http.scaladsl.server.Directives._
import com.beng.emapp.data.HttpRepository
import com.beng.emapp.model.{JsonProtocol, Team}

trait MatchService extends JsonProtocol with HttpRepository {
  val matchRoute =
    pathPrefix("v1") {
      path("matches") {
        get {
          ctx => ({
            import context.dispatcher
            matches.map(r => {
              println("done")
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
