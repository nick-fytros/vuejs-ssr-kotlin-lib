package utils

import java.io.File

class JavascriptFile(val fileName: String) {
    val basePath = "src/js/"
    val jsFile = File(this.basePath + this.fileName)

    override fun toString(): String {
        return jsFile.readText()
    }
}