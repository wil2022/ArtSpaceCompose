package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}


@Composable
fun ArtSpaceScreen(){

    var currentArtWork by remember { mutableStateOf(1) }

    when(currentArtWork){
        1 -> {
            ArtImageAndText(

                drawableResourceId = R.drawable.monalisa,
                textLabelResourceId = R.string.monalisa,
                secondTextLabelResourceId = R.string.leonardo,
                onPreviousClick = {
                    currentArtWork = 3
                },
                onNextClick = {
                    currentArtWork = 2
                }
            )
        }

        2 -> {
            ArtImageAndText(
                drawableResourceId = R.drawable.starry_night,
                textLabelResourceId = R.string.starry_night,
                secondTextLabelResourceId = R.string.vincent,
                onPreviousClick = {
                    currentArtWork = 1
                },
                onNextClick = {
                    currentArtWork = 3
                }
            )
        }
        3 -> {
            ArtImageAndText(
                drawableResourceId = R.drawable.persistencia_memoria,
                textLabelResourceId = R.string.persistencia_memoria,
                secondTextLabelResourceId = R.string.salvador,
                onPreviousClick = {
                    currentArtWork = 2
                },
                onNextClick = {
                    currentArtWork = 1
                }
            )
        }
    }

}


@Composable
fun ArtImageAndText(
    drawableResourceId: Int,
    textLabelResourceId: Int,
    secondTextLabelResourceId: Int,
    onNextClick: () -> Unit,
    onPreviousClick: () -> Unit,
    modifier: Modifier = Modifier

){
Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier.fillMaxSize()
) {
    Image(painter = painterResource(drawableResourceId), contentDescription = null)
    Column() {
        Text(text = stringResource(textLabelResourceId))
        Text(text = stringResource(secondTextLabelResourceId))
    }
    Row() {
        Button(onClick = onPreviousClick) {
            Text(text = "Previous")
        }
        Spacer(Modifier.padding(end = 10.dp))
        Button(onClick = onNextClick) {
            Text(text = "Next")
        }
    }
}
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}