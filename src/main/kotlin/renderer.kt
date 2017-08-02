import com.eclipsesource.v8.NodeJS
import com.eclipsesource.v8.JavaCallback
import utils.JavascriptFile
import com.eclipsesource.v8.V8
import kotlinx.coroutines.experimental.runBlocking
import org.jetbrains.ktor.netty.*
import org.jetbrains.ktor.routing.*
import org.jetbrains.ktor.application.*
import org.jetbrains.ktor.host.*
import org.jetbrains.ktor.http.*
import org.jetbrains.ktor.response.*



class Renderer(laygoutFilePath: String?, componentsFolderPath: String?) {
    val runtime = V8.createV8Runtime()
    val nodeJS: NodeJS = NodeJS.createNodeJS()

    fun render(call: ApplicationCall, viewFilePath: String?) {

        val renderCallback = JavaCallback { receiver, parameters ->
            runBlocking {
                call.respondText(parameters.get(0).toString(), ContentType.Text.Html)
            }
            /* required to return null as Kotlin's default is Unit and js crashes */
            null
        }

        nodeJS.runtime.registerJavaMethod(renderCallback, "renderCallback")
        nodeJS.exec(JavascriptFile("app.js").jsFile)
        while (nodeJS.isRunning) {
            nodeJS.handleMessage()
        }
        nodeJS.release()
    }
}

fun main(args: Array<String>) {
    embeddedServer(Netty, 8080) {
        routing {
            get("/") {
                Renderer(null, null).render(call, null)
            }
        }
    }.start(wait = true)
}