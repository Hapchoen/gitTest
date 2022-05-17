package com.example.myapplication

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel : MainViewModel by viewModels()

        setContent {

            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android" , "project" , viewModel = viewModel)
                }
            }

        }
    }

}

@OptIn(ExperimentalFoundationApi::class, ExperimentalUnitApi::class)
@Composable
fun Greeting(name: String , myName : String , viewModel : MainViewModel) {

    val userData by viewModel.userData.collectAsState()

    LazyColumn() {

        item {
            Text("Header"  , style = TextStyle(fontSize = TextUnit(22f, TextUnitType.Sp)))
        }

        items(userData) { item ->
            Text(item.login  , style = TextStyle(fontSize =  TextUnit(35f, TextUnitType.Sp)))
        }

        item {
            Text("footer"  , style = TextStyle(fontSize =  TextUnit(22f, TextUnitType.Sp)))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    MyApplicationTheme {
        Greeting("Android",  "project" , viewModel = MainViewModel())
    }

}