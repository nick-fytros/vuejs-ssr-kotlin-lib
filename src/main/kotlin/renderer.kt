import com.eclipsesource.v8.NodeJS
import com.eclipsesource.v8.JavaCallback
import utils.JavascriptFile



fun main(args: Array<String>) {
    val nodeJS = NodeJS.createNodeJS()
    val callback = JavaCallback { receiver, parameters -> "Hello, Kotlin + NodeJs with uuid: " + parameters.get(0) }

    nodeJS.runtime.registerJavaMethod(callback, "someKotlinMethod")

    val nodeScript = JavascriptFile("app.js").jsFile

    nodeJS.exec(nodeScript)

    while (nodeJS.isRunning) {
        nodeJS.handleMessage()
    }
    nodeJS.release()
}