package com.example.formhomework001

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.formhomework001.ui.theme.FormHomework001Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormHomework001Theme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                  FormRegister()
                }
            }
        }
    }
}

@Composable
fun learnLayout(){
    ConstraintLayout {
        val (redButton, greenButton, blueButton, blackButton) = createRefs()

        Button(onClick = { /*TODO*/ } , colors = ButtonDefaults.buttonColors(Color.Red) ,
            modifier = Modifier.constrainAs(redButton){
                top.linkTo(parent.top)
                width = Dimension.matchParent
                height = Dimension.value(60.dp)
            }) {
            Text(text = "Red Button")
        }

        Button(onClick = { /*TODO*/ } , colors = ButtonDefaults.buttonColors(Color.Green),
            modifier = Modifier.constrainAs(greenButton){
                top.linkTo(redButton.bottom)
            }) {
            Text(text = "Red Green")
        }

        Button(onClick = { /*TODO*/ } , colors = ButtonDefaults.buttonColors(Color.Blue),
            modifier = Modifier.constrainAs(blueButton){
                top.linkTo(redButton.bottom)
            }) {
            Text(text = "Red Blue")
        }
        createHorizontalChain(greenButton , blueButton, chainStyle = ChainStyle.Packed)

        Button(onClick = { /*TODO*/ } , colors = ButtonDefaults.buttonColors(Color.Black),
            modifier = Modifier.constrainAs(blackButton){
                top.linkTo(blueButton.bottom)
            }) {
            Text(text = "Red Black")
        }
    }
}
