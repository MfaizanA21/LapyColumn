package com.example.lazierz

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import com.example.lazierz.ui.theme.LazierzTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("PrivateResource")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazierzTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingPreview()
                }
            }
        }
    }
}

@Composable
fun ListRow(model: Fruits) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
         modifier = Modifier
         .fillMaxHeight()
        .fillMaxWidth()
        .background(Color(0xFF063041))
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .size(100.dp)
                .padding(5.dp)
        )
    }
}

@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    device = "id:pixel_3"
)
@Composable
fun GreetingPreview() {
    val fruitList = mutableListOf<Fruits>()

    fruitList.add(Fruits(androidx.core.R.drawable.notification_template_icon_bg, "Apple"))
    fruitList.add(Fruits(androidx.core.R.drawable.notification_icon_background, "Apple"))
    fruitList.add(Fruits(androidx.core.R.drawable.notify_panel_notification_icon_bg, "Apple"))
    fruitList.add(Fruits(androidx.core.R.drawable.notification_template_icon_low_bg, "Apple"))
    fruitList.add(Fruits(androidx.core.R.drawable.notification_icon_background, "Apple"))

    LazierzTheme {
        LazyColumn(modifier = Modifier
            .background(Color.White)
            .fillMaxSize()) {
            items(fruitList){ model ->
            ListRow(model = model )
            }
        }
    }
}