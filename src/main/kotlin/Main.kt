import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.util.*

@Composable
@Preview
fun App() {
    val props = Properties()
    Thread.currentThread().contextClassLoader.getResourceAsStream("config").use { resourceStream -> props.load(resourceStream) }

    var text by remember { mutableStateOf(props.getProperty("version")) }

    MaterialTheme {
        Button(onClick = {
            text = "Runnin on JVM ${System.getProperty("java.version")}"
        }) {
            Text(text)
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
