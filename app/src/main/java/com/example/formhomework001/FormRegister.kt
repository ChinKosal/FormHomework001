package com.example.formhomework001

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FormRegister(){
    var viewModel : RegisterViewModel = viewModel();
    var event by remember { mutableStateOf("") }
       Column (modifier = Modifier
           .fillMaxSize()
           .background(Color.Transparent)
           .padding(10.dp, 20.dp, 10.dp, 0.dp)){
           Row {
               Text(text = "Registration Form",
                   fontSize = 24.sp ,
                   color = Color.Blue ,
                   fontWeight = FontWeight.SemiBold)
               Spacer(modifier = Modifier.weight(0.1f))
               Icon(imageVector = Icons.Default.AccountCircle , contentDescription = "User Icon",
                   modifier = Modifier.size(26.dp))
           }
           Row(modifier = Modifier.padding(0.dp,20.dp,0.dp,0.dp)) {
               TextFieldComponent(
                   "Enter your name",
                   "Name",
                  onTextChange = {newValue -> viewModel.updateUserData("name", newValue)},
                   "name",
                    vm = viewModel
               )
           }
           Row  {
              Box(modifier = Modifier
                  .weight(1f)
                  .padding(0.dp, 0.dp, 6.dp, 0.dp)){
                  TextFieldComponent(
                      placeholder = "Male",
                      label = "Gender",
                      onTextChange = { newValue ->
                          viewModel.updateUserData("gender", newValue)
                      },
                      event = "gender",
                      vm = viewModel
                  )

              }
             Box(modifier = Modifier.weight(2f)){
                 TextFieldComponent(
                     "0887683082",
                     "Phone",
                     onTextChange = {
                         newValue -> viewModel.updateUserData("phone" , newValue)
                     },
                     "phone",
                     vm = viewModel,
                 )
                 Log.d("Event", "FormRegister: $event")
             }
           }
           Row(modifier =  Modifier.padding(0.dp,0.dp,0.dp,15.dp)) {
               TextFieldComponent(
                   "Enter your Address",
                   "Address",
                    onTextChange = {newValue -> viewModel.updateUserData("address", newValue)},
                   "address",
                   vm = viewModel
               )
           }
               ConstraintLayout {
                   val (submitButton) = createRefs()
                   Button(
                       onClick = { /* TODO */ },
                       colors = ButtonDefaults.buttonColors(Color.Magenta),
                       modifier = Modifier.constrainAs(submitButton) {
                           top.linkTo(submitButton.top)
                           width = Dimension.matchParent
                       },
                       enabled = event.isNotEmpty()
                   ) {
                       Text(text = "Submit")
                   }
               }
       }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(placeholder: String,label: String,onTextChange:(text:String) -> Unit, event: String , vm: RegisterViewModel){
    val textFieldValue = when(event) {
        "name" -> vm.userData.value.name
        "gender" -> vm.userData.value.gender
        "phone" -> vm.userData.value.phone
        else -> vm.userData.value.address
    }
    OutlinedTextField(value = textFieldValue,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = {
            onTextChange(it)
        },
        placeholder = {
            Text(text = placeholder, fontSize = 16.sp)
        },
        label = {
            Text(text = label)
        },
        maxLines = 2,
        keyboardOptions = KeyboardOptions(
            keyboardType = if (event == "phone") KeyboardType.Phone else KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Gray,
            focusedLabelColor = Color.Magenta,
            unfocusedLabelColor = Color.Gray,
            focusedLeadingIconColor = Color.Blue,
            unfocusedLeadingIconColor = Color.Gray,
            focusedTrailingIconColor = Color.Blue,
            unfocusedTrailingIconColor = Color.Gray,
            disabledTextColor = Color.DarkGray,
            disabledBorderColor = Color.LightGray,
            disabledLabelColor = Color.Gray,
            disabledPlaceholderColor = Color.Gray
        )
    )
}