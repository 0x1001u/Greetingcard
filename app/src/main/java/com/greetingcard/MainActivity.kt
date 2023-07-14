package com.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.greetingcard.ui.theme.GreetingcardTheme
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingcardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingWithImage(message = stringResource(R.string.greeting_kotlin), from = stringResource(R.string.signature
                    ))
                }
            }
        }
    }
}

@Composable
fun GreetingWithText(message: String, from:String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = message,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(top = 16.dp)
        )
        Text(
            text = from,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 16.dp, end = 16.dp)
                .align(alignment = Alignment.End)
        )
    }

}

@Composable
fun GreetingWithImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable._0027_3566736378)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        GreetingWithText(message = message, from = from )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreetingcardTheme {
        GreetingWithImage(stringResource(R.string.greeting_kotlin), stringResource(R.string.signature))
    }
}