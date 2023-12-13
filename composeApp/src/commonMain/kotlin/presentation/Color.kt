package presentation

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val Gray800 = Color(0xFF585858)
val Gray900 = Color(0xFF212121)




@Composable
fun appColors() : Colors{
    return MaterialTheme.colors.copy(
        onPrimary = Color.White,
        primary= Gray800,
        background = Color.Black
    )
}