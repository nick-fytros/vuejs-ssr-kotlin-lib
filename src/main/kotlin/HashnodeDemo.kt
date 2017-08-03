import io.vertx.core.AbstractVerticle
import io.vertx.core.Vertx
import io.vertx.core.logging.LoggerFactory
import io.vertx.ext.web.Router
import java.io.IOException


object HashnodeDemo : AbstractVerticle() {

    // initiate logging system
    private val log = LoggerFactory.getLogger(HashnodeDemo.javaClass)

    @JvmStatic
    @Throws(IOException::class)
    fun main(args: Array<String>) {
        // setup verx
        val vertx = Vertx.vertx()
        val router = Router.router(vertx)

        router.get("/").handler {
            val renderer = Renderer(null, null)
            it.response().putHeader("content-type", "text/html; charset=utf-8")
            renderer.render(it.response(), null)
        }

        // start vertx
        vertx.createHttpServer().requestHandler { router.accept(it) }.listen(9090)

    }
}