import com.eclipsesource.v8.NodeJS
import com.eclipsesource.v8.JavaCallback
import utils.JavascriptFile
import com.eclipsesource.v8.V8
import io.vertx.core.http.HttpServerResponse
import javax.script.ScriptEngineManager
import com.coveo.nashorn_modules.Require
import java.io.File
import com.coveo.nashorn_modules.FilesystemFolder
import jdk.nashorn.api.scripting.NashornScriptEngine
import jdk.nashorn.api.scripting.NashornScriptEngineFactory


class Renderer(laygoutFilePath: String?, componentsFolderPath: String?) {
    val runtime = V8.createV8Runtime()
    val nodeJS: NodeJS = NodeJS.createNodeJS()
//    var engine: NashornScriptEngine = ScriptEngineManager().getEngineByName("nashorn") as NashornScriptEngine
    val engine: NashornScriptEngine = NashornScriptEngineFactory().getScriptEngine("--language=es6") as NashornScriptEngine

    fun render(response: HttpServerResponse, viewFilePath: String?) {
        val renderCallback = JavaCallback { receiver, parameters ->
            response.end(parameters.get(0).toString())
            /* required to return null as Kotlin's default is Unit and js crashes */
            null
        }
//        val result = runtime.executeStringScript(JavascriptFile("app.js").toString())
        val rootFolder = FilesystemFolder.create(File("node_modules"), "UTF-8")
        print(rootFolder.path)
        Require.enable(engine, rootFolder)
        val result = engine.eval(JavascriptFile("app.js").toString())

        response.end(result.toString())
//        nodeJS.runtime.registerJavaMethod(renderCallback, "renderCallback")
//        nodeJS.exec(JavascriptFile("app.js").jsFile)
//        while (nodeJS.isRunning) {
//            nodeJS.handleMessage()
//        }
//        nodeJS.release()
    }
}