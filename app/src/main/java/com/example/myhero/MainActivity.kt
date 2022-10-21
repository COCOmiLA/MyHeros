package com.example.myhero

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myhero.ui.theme.MyHEROTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val HerosList = mutableListOf<Heros>()
        HerosList.add(Heros("Doctor",R.drawable.ds))
        HerosList.add(Heros("Thor",R.drawable.images))
        HerosList.add(Heros("Spider Men",R.drawable.spaderman))
        setContent {
            MyHEROTheme {
                Logo()
                HerosChange(HerosList)

            }
        }
    }
}
@Composable
fun HerosChange(HeroList: List<Heros>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .focusable(true)
    ) {
        LazyRow {
            items(HeroList) { vehicle ->
                VehicleItem(vehicle)
            }
        }
    }
}

@Composable
fun VehicleItem(vehicle: Heros) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp, vertical = 50.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Image(
            painter = painterResource(id = vehicle.imageId),
            contentDescription = vehicle.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(330.dp, 500.dp)
        )
        Text(
            text = vehicle.name,
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )
    }
}
@Preview(name = "Dark Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)

@Composable
@Preview(showBackground = true)
fun Logo() {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.marvel),
                    contentDescription = "Logo Marvel",
                    modifier = Modifier
                        .size(180.dp, 130.dp)
                )
            }
            Text(
                text = "Choose your hero",
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

