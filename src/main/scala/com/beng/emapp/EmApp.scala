import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.beng.emapp.service.MainRouter

object EmApp extends App with MainRouter {
  implicit val system = ActorSystem("em-app")
  implicit val matz = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val binding = Http().bindAndHandle(routes, "0.0.0.0", 8080)

}