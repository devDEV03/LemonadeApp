package com.example.lemonade

import android.annotation.SuppressLint
import android.graphics.Paint
import android.graphics.fonts.FontStyle
import android.os.Bundle
import android.util.Size
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(text = "Lemonade")
                            },
                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Yellow)


                        )

                    }


                ){
                    LemonMaker()
            }
            }
            }
        }
    }

    @Composable
    fun LemonMaker(modifier: Modifier = Modifier) {
//    Column() {
//        Surface(color = Color.Yellow) {
//            Column(modifier = Modifier.fillMaxWidth().height(24.dp), verticalArrangement = Arrangement.Center) {
//                Text(text = "Lemonade",modifier.padding(16.dp),textAlign = TextAlign.Center)
//            }
//        }
//
//        Spacer(Modifier.height(50.dp))

        var result by remember { mutableStateOf(1) }
        var i by remember { mutableStateOf(0) }
        var x by remember { mutableStateOf(0) }
        when (result) {
            1 -> Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.lemon_tree),
                    contentDescription = "lemon_tree",
                )
                Spacer(Modifier.height(16.dp))
                Button(onClick = { result = 2 }) {
                    Text(text = stringResource(R.string.lemonTree))
                }

            }

            2 -> Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.lemon_squeeze),
                    contentDescription = "lemon"
                )
                Spacer(Modifier.height(16.dp))
                Button(onClick = {
                    i++
                    if (i == (2..4).random()) {
                        result = 3
                    }
                }) {
                    Text(text = stringResource(R.string.lemon))
                    i = 0
                }

            }

            3 -> Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.lemon_drink),
                    contentDescription = "lemon_drink"
                )
                Spacer(Modifier.height(16.dp))
                Button(onClick = { result = 4 }) {
                    Text(text = stringResource(R.string.lemonade))
                }
            }

            4 -> Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.lemon_restart),
                    contentDescription = "empty glass"
                )
                Spacer(Modifier.height(16.dp))
                Button(onClick = { result = 1 }) {
                    Text(text = stringResource(R.string.empty))
                }

            }

        }
    }


    @Preview(showBackground = true)
    @Composable
    fun LemonMakerPreview() {
        LemonadeTheme {
            LemonMaker()
        }
    }
