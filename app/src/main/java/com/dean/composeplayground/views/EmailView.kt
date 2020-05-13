package com.dean.composeplayground.views

import androidx.compose.Composable
import androidx.compose.MutableState
import androidx.compose.mutableStateOf
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.foundation.selection.Toggleable
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.dean.composeplayground.model.Email
import com.dean.composeplayground.R

@Composable
fun EmailView(emailState: MutableState<Email>) {
  val email = emailState.value
  Column(
      modifier = Modifier.padding(16.dp)
  ) {
    EmailHeader(sender = email.sender, receiptTime = email.receiptTime)
    Row(
        verticalGravity = Alignment.Bottom
    ) {
      Column {
        Subject(subject = email.subject)
        Body(body = email.body)
      }
      Spacer(modifier = Modifier.weight(1f))
      Star(isStarred = email.starred) { enabled ->
        val newEmail = email.copy(starred = enabled)
        emailState.value = newEmail
      }
    }
  }
}

@Composable
fun Subject(subject: String) {
  Text(
      text = subject,
      style = TextStyle(
          color = Color.Black,
          fontSize = 16.sp
      )
  )
}

@Composable
fun Body(body: String) {
  Text(
      text = body,
      style = TextStyle(
          color = Color.Black,
          fontSize = 16.sp
      )
  )
}

@Composable
fun Star(isStarred: Boolean, onStarClick: (Boolean) -> Unit) {
  val color = if (isStarred) {
    Color(0xFFFDD663)
  } else {
    Color.DarkGray
  }
  Toggleable(isStarred, onValueChange = onStarClick) {
    Icon(
        asset = vectorResource(id = R.drawable.ic_baseline_star_24),
        tint = color
    )
  }
}

//region *** Header ***
@Composable
fun EmailHeader(sender: String, receiptTime: String) {
  Row(
      verticalGravity = Alignment.Bottom,
      modifier = Modifier.fillMaxWidth()
  ) {
    Important()
    Sender(sender = sender)
    Spacer(modifier = Modifier.weight(1f))
    ReceiptTime(receiptTime = receiptTime)
  }
}

@Composable
fun Sender(sender: String, modifier: Modifier = Modifier) {
  Text(
      text = sender,
      style = TextStyle(
          color = Color.Black,
          fontSize = 20.sp
      ),
      modifier = modifier
  )
}

@Composable
fun Important() {
  Icon(
      asset = vectorResource(id = R.drawable.ic_baseline_label_important_24),
      tint = Color(0xFFFDD663)
  )
}

@Composable
fun ReceiptTime(receiptTime: String) {
  Text(
      text = receiptTime,
      style = TextStyle(
          color = Color.Black,
          fontSize = 14.sp
      )
  )
}

// endregion

//region *** Previews ***

@Composable
@Preview
fun EmailViewPreview() {
  val email = Email(
      "Dean Djermanovic",
      true,
      "Mar 5, 2020",
      "Subject",
      "Body text",
      true
  )

  EmailView(emailState = mutableStateOf(email))
}

//endregion