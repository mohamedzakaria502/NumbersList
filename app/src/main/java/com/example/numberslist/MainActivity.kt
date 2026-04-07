package com.example.numberslist // اتأكد إن ده نفس اسم الباكيدج عندك

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class NumberItem(
    val englishName: String,
    val arabicName: String,
    val imageRes: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NumberListScreen()
                }
            }
        }
    }
}

@Composable
fun NumberListScreen() {
    val numbers = listOf(
        NumberItem("One", "واحد", R.drawable.number_one),
        NumberItem("Two", "اثنان", R.drawable.number_two),
        NumberItem("Three", "ثلاثة", R.drawable.number_three),
        NumberItem("Four", "أربعة", R.drawable.number_four),
        NumberItem("Five", "خمسة", R.drawable.number_five),
        NumberItem("Six", "ستة", R.drawable.number_six),
        NumberItem("Seven", "سبعة", R.drawable.number_seven),
        NumberItem("Eight", "ثمانية", R.drawable.number_eight),
        NumberItem("Nine", "تسعة", R.drawable.number_nine),
        NumberItem("Ten", "عشرة", R.drawable.number_ten)
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(numbers) { item ->
            NumberRow(item)
        }
    }
}

@Composable
fun NumberRow(item: NumberItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.LightGray.copy(alpha = 0.2f))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = item.englishName,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = item.englishName,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = item.arabicName,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.DarkGray
            )
        }
    }
}