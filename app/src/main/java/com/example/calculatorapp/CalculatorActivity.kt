package com.example.calculatorapp

import android.content.Intent
import android.graphics.BitmapFactory.Options
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.KeyboardType.Companion.Number
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorapp.ui.theme.CalculatorAppTheme
import androidx.compose.material3.Text as Text

class CalculatorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calc()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calc() {
    var firstnum by remember { mutableStateOf(TextFieldValue(""))}
    var secondnum by remember { mutableStateOf(TextFieldValue(""))}
    var answer by remember { mutableStateOf("") }
    var context = LocalContext.current

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(33, 4, 64))
            .padding(10.dp)) {

        Text(text = "Answer Below !",
            color = Color.White,
            fontFamily = FontFamily.Cursive,
            fontSize = 27.sp
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = answer,
            fontFamily = FontFamily.Cursive,
            color = Color(red = 232, green = 210 , blue = 187, alpha = 255),
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = firstnum ,
            label = { Text(text = "Enter First No",
                color = Color.White,
                fontSize = 20.sp)},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(255, 186, 0),
                unfocusedBorderColor = Color(229, 149, 142),
                focusedTextColor = Color(red = 232, green = 210 , blue = 187, alpha = 255),
                unfocusedTextColor = Color(red = 232, green = 210 , blue = 187, alpha = 255)
            ),
            onValueChange ={
                firstnum = it

            } )
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            value = secondnum ,
            label = { Text(text = "Enter second No",
                color = Color.White,
                fontSize = 20.sp)},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(255, 186, 0),
                unfocusedTextColor = Color(red = 232, green = 210 , blue = 187, alpha = 255),
                unfocusedBorderColor = Color(229, 149, 142),
                focusedTextColor = Color(red = 232, green = 210 , blue = 187, alpha = 255)
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                secondnum = it }
        )

        Spacer(modifier = Modifier.height(50.dp))
        OutlinedButton(
            onClick = {  var myfirstnum = firstnum.text.trim()
                var mysecondnum = secondnum.text.trim()
                if (myfirstnum.isEmpty() && mysecondnum.isEmpty()){
                    answer = "Please fill in all details"
                }
                else {
                    var myanswer = myfirstnum.toDouble() + mysecondnum.toDouble()
                    answer = myanswer.toString()
                }},
            colors = buttonColors(Color(45, 50, 80)),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "+",
                fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.height(50.dp))
        OutlinedButton(onClick = {
            var myfirstnum = firstnum.text.trim()
            var mysecondnum = secondnum.text.trim()
            if (myfirstnum.isEmpty() && mysecondnum.isEmpty()){
                answer = "Please fill in all details"
            }
            else {
                var myanswer = myfirstnum.toDouble() - mysecondnum.toDouble()
                answer = myanswer.toString()
            }
        },
            colors = buttonColors(Color(45, 50, 80)),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "-",
                fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.height(50.dp))
        OutlinedButton(
            onClick = {
                var myfirstnum = firstnum.text.trim()
                var mysecondnum = secondnum.text.trim()
                if (myfirstnum.isEmpty() && mysecondnum.isEmpty()){
                    answer = "Please fill in all details"
                }
                else {
                    var myanswer = myfirstnum.toDouble() * mysecondnum.toDouble()
                    answer = myanswer.toString()
                }
            },
            colors = buttonColors(Color(45, 50, 80)),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "*",
                fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.height(45.dp))
        OutlinedButton(onClick = {
            var myfirstnum = firstnum.text.trim()
            var mysecondnum = secondnum.text.trim()
            if (myfirstnum.isEmpty() && mysecondnum.isEmpty()){
                answer = "Please fill in all details"
            }
            else {
                var myanswer = myfirstnum.toDouble() / mysecondnum.toDouble()
                answer = myanswer.toString()
            }
        },
            colors = buttonColors(Color(45, 50, 80)),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "/",
                fontSize = 30.sp)
        }
    }



}

@Preview(showBackground = true)
@Composable
fun CalcPreview() {
    Calc()
}