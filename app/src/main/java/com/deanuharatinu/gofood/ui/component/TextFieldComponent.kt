package com.deanuharatinu.gofood.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deanuharatinu.gofood.ui.theme.GoFoodTheme

@Composable
fun TextFieldComponent(
  modifier: Modifier = Modifier,
  label: String = "Label",
  placeholder: String = "Placeholder",
  keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
  onValueChange: (String) -> Unit,
) {
  val textValue = remember { mutableStateOf("") }

  Column(modifier = modifier) {
    Text(text = label, fontSize = 12.sp)
    OutlineTextField(
      placeholder = placeholder,
      value = textValue.value,
      onValueChange = {
        textValue.value = it
        onValueChange.invoke(it)
      },
      keyboardOptions = keyboardOptions,
    )
  }
}

@Composable
fun OutlineTextField(
  modifier: Modifier = Modifier,
  placeholder: String,
  value: String,
  onValueChange: (String) -> Unit,
  keyboardOptions: KeyboardOptions,
) {
  val focusManager = LocalFocusManager.current

  BasicTextField(
    modifier = modifier
      .fillMaxWidth(),
    value = value,
    onValueChange = onValueChange,
    textStyle = TextStyle(
      color = Color.Black,
      fontSize = 16.sp
    ),
    decorationBox = { innerTextField ->
      Column {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp, bottom = 6.dp, end = 6.dp)
        ) {
          if (value.isEmpty()) {
            Text(
              text = placeholder,
              color = Color.Gray,
              fontSize = 16.sp
            )
          }

          innerTextField()
        }
        Divider(color = Color.Gray, thickness = 1.dp)
      }
    },
    singleLine = true,
    maxLines = 1,
    keyboardActions = KeyboardActions(
      onDone = {
        focusManager.clearFocus()
      }
    ),
    keyboardOptions = keyboardOptions,
  )
}

@Preview(showBackground = true)
@Composable
private fun TextFieldComponentPreview() {
  GoFoodTheme {
    TextFieldComponent(
      label = "email",
      placeholder = "Masukan email",
      onValueChange = {}
    )
  }
}