package presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.Instrument
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


const val DAVIDSTEAMLOGO = "icons/davids_team_logo.jpg"

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MainScreen() {
    Scaffold(backgroundColor = MaterialTheme.colors.background, topBar = { MainTopBar() }) {
        Row(Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState()).fillMaxHeight()
                    .width(120.dp)
            ) {
                Button(onClick = { loadSongs() }, content = {
                    Image(
                        painterResource(DAVIDSTEAMLOGO), contentDescription = null
                    )
                }, contentPadding = PaddingValues(0.dp))
                val instruments = listOf<Instrument>(
                    Instrument.ACOUSTIC,
                    Instrument.BASS,
                    Instrument.ELECTRO,
                    Instrument.PIANO,
                    Instrument.DRUMS
                )
                instruments.forEach {
                    Button(onClick = {  }, content = {
                        Image(
                            painterResource(getInstrumentIcon(it)), contentDescription = null
                        )
                    }, contentPadding = PaddingValues(0.dp))
                    Spacer(Modifier.height(2.dp))
                }
            }

            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                repeat(20) {
                    Button(onClick = { openSong() },
                        content = {
                            Card(
                                shape = RoundedCornerShape(30),
                                modifier = Modifier.fillMaxWidth().padding(2.dp).height(60.dp),
                                backgroundColor = MaterialTheme.colors.primary,
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text("SongName", color = MaterialTheme.colors.onPrimary)
                                }
                            }
                        },
                        contentPadding = PaddingValues(0.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.background)
                    )
                }
            }
        }
    }
}


fun openSong(){

}

fun loadSongs(instrument: Instrument? = null){

}

fun getInstrumentIcon(instrument: Instrument): String {
    return when (instrument) {
        Instrument.ACOUSTIC -> "icons/acustic_logo.jpg"
        Instrument.ELECTRO -> "icons/electro_logo.jpg"
        Instrument.BASS -> "icons/bass_logo.jpg"
        Instrument.PIANO -> "icons/piano_logo.jpg"
        Instrument.DRUMS -> "icons/drums_logo.jpg"
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MainTopBar() {
    TopAppBar(backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("PlayBack's")
            }
        })
}