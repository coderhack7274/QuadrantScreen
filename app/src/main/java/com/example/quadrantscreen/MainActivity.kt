package com.example.quadrantscreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import android.R.attr.description
import androidx.compose.runtime.Composable
import android.R.attr.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.background
import android.R.attr.title
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.example.quadrantscreen.ui.theme.QuadrantScreenTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.focusModifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuadrantScreenTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color= MaterialTheme.colorScheme.background){
                    QuadrantScreen()
                }
            }
        }
    }
}

@Composable
fun QuadrantBox(
                title : String,
                description: String,
                backgroundColor: Color,
                modifier: Modifier = Modifier
            ){
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            Text(
                text = description,
                textAlign = TextAlign.Center

            )
        }
    }

    @Composable
    fun QuadrantScreen(){
    Column(Modifier.fillMaxWidth().statusBarsPadding()){
        Row(Modifier.weight(1f)) {
            QuadrantBox(
                title= stringResource(R.string.box_1),
                description= stringResource(R.string.box_1_description),
                backgroundColor= Color.White,
                modifier=Modifier.weight(1f)
            )
            QuadrantBox(
                title= stringResource(R.string.box_2),
                description= stringResource(R.string.box_2_description),
                backgroundColor= Color.LightGray,
                modifier=Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            QuadrantBox(
                      title= stringResource(R.string.box_3),
                    description= stringResource(R.string.box_3_description),
                    backgroundColor= Color.Gray,
                    modifier=Modifier.weight(1f)
            )
            QuadrantBox(
                title= stringResource(R.string.box_4),
                description= stringResource(R.string.box_4_description),
                backgroundColor= Color.Transparent,
                modifier=Modifier.weight(1f)
            )
        }
    }
    }
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    QuadrantScreenTheme {
        QuadrantScreen()
    }
}