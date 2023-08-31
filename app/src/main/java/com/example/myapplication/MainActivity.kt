package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var displayedSentence by remember { mutableStateOf<String?>(null) }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                            verticalArrangement = Arrangement.Center
                    ) {
                        displayedSentence?.let {
                            when (it) {
                                "sentence1" -> Sentence1(name = "Fenix", age = 26)
                                "sentence2" -> Sentence2(school = "HKR", field = "Computer Science")
                                "sentence3" -> Sentence3(hobby1 = "Coding", hobby2 = "Painting", hobby3 = "Cooking")
                                "sentence4" -> Sentence4(hobby2 = "Painting")
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))



                        SmallButton(
                            text = "Click here",
                            selectedSentence = displayedSentence,
                            onClick = {
                                val randomNum = Random.nextInt(4)
                                displayedSentence = when (randomNum) {
                                    0 -> "sentence1"
                                    1 -> "sentence2"
                                    2 -> "sentence3"
                                    else -> "sentence4"
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}




@Composable
fun SmallButton(text: String, selectedSentence: String?, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(150.dp)
            .height(36.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        Text(
            text = text,
            fontSize = 14.sp
        )
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
                .background(Color.Cyan)
                .padding(16.dp)
                .background(Color.Magenta),

            color = Color.White,
            fontSize = 15.sp
    )
}

@Composable
fun Sentence1(name: String, age: Int, modifier: Modifier = Modifier){

    Text(
        text = "My name is $name and I am $age years old",
        modifier = modifier
            .background(Color.Cyan)
            .padding(16.dp)
            .background(Color.Magenta),

        color = Color.White,
        fontSize = 15.sp
    )
}

@Composable
fun Sentence2(school: String, field: String, modifier: Modifier = Modifier){
    Text(
        text = "I am studying at $school, the programme $field",
        modifier = modifier
            .background(Color.Yellow)
            .padding(16.dp)
            .background(Color.Blue),

        color = Color.White,
        fontSize = 15.sp
    )

}

@Composable
fun Sentence3(hobby1: String, hobby2: String, hobby3: String, modifier: Modifier = Modifier){
    Text(
        text = "My Hobbies are $hobby1, $hobby2 and $hobby3.",

        modifier = modifier
            .background(Color.LightGray)
            .padding(16.dp)
            .background(Color.DarkGray),

        color = Color.White,
        fontSize = 15.sp

    )
}

@Composable
fun Sentence4(hobby2: String, modifier:Modifier = Modifier){
    Text(
        text="My favorite hobby of them all is $hobby2 because I like that I can freely express myself when $hobby2",

        modifier = modifier
            .background(Color.Green)
            .padding(16.dp)
            .background(Color.Blue),

        color = Color.White,
        fontSize= 15.sp
    )
}




// Add picture, center the button



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("You are so fucking slow")
    }
}