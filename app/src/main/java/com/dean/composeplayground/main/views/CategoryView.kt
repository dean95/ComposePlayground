package com.dean.composeplayground.main.views

import androidx.compose.Composable
import androidx.compose.MutableState
import androidx.ui.core.Alignment
import androidx.ui.core.ContentScale
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.material.IconButton
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.dean.composeplayground.R
import com.dean.composeplayground.exam.ExamActivity
import com.dean.composeplayground.main.MainViewModel
import com.dean.composeplayground.model.Category

@Composable
fun CategoryView(categoryState: MutableState<Category>, viewModel: MainViewModel) {
    val category = categoryState.value
    Card(
        shape = RoundedCornerShape(24.dp),
        color = Color(android.graphics.Color.parseColor("#E1E2E7")),
        elevation = 2.dp,
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Row(
            verticalGravity = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        ) {
            Column(
                Modifier.weight(1f)
            ) {
                Category(category = category.title)
                Spacer(modifier = Modifier.height(8.dp))
                Description(
                    title = category.subtitle
                )
                Spacer(modifier = Modifier.height(32.dp))
                Arrow()
            }
            CategoryImage(
                resId = category.imageRes,
                modifier = Modifier.weight(1f) + Modifier.preferredHeight(160.dp)
            )
        }
    }
}

@Composable
fun Category(category: String) {
    Text(
        text = category,
        style = TextStyle(
            color = Color.Black,
            fontSize = 24.sp
        ),
        maxLines = 2
    )
}

@Composable
fun CategoryImage(resId: Int, modifier: Modifier) {
    val image = imageResource(id = resId)
    Image(
        asset = image,
        contentScale = ContentScale.Inside,
        modifier = modifier
    )
}

@Composable
fun Description(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        modifier = modifier,
        style = TextStyle(
            color = Color.Gray,
            fontSize = 12.sp
        )
    )
}

@Composable
fun Arrow() {
    val context = ContextAmbient.current
    IconButton(
        onClick = { context.startActivity(ExamActivity.createIntent(context)) },
        modifier = Modifier.padding(4.dp)
    ) {
        Icon(
            asset = vectorResource(id = R.drawable.ic_baseline_arrow_forward_24),
            tint = Color(android.graphics.Color.parseColor("#E4460B"))
        )
    }
}