import com.eclipsesource.v8.NodeJS
import com.eclipsesource.v8.JavaCallback
import utils.JavascriptFile
import com.eclipsesource.v8.V8



class Renderer(laygoutFilePath: String?, componentsFolderPath: String?) {
    val runtime = V8.createV8Runtime()
    val nodeJS = NodeJS.createNodeJS()

    fun render(viewFilePath: String?) {
        val callback = JavaCallback { receiver, parameters -> print(parameters.get(0)) }

        nodeJS.runtime.registerJavaMethod(callback, "renderCallback")
        nodeJS.exec(JavascriptFile("app.js").jsFile)
        while (nodeJS.isRunning) {
            nodeJS.handleMessage()
        }
        nodeJS.release()
    }
}

fun main(args: Array<String>) {
    Renderer(null, null).render(null)
}