package com.dean.composeplayground.main.views

import androidx.compose.*
import androidx.ui.core.*
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.input.ImeAction
import androidx.ui.layout.*
import androidx.ui.material.Surface
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.ipx
import androidx.ui.unit.sp
import com.dean.composeplayground.R
import com.dean.composeplayground.main.MainViewModel
import com.dean.composeplayground.utils.hideKeyboard

@Composable
fun CategorySearchView(viewModel: MainViewModel) {
    Surface(
        color = Color(android.graphics.Color.parseColor("#E1E2E7")),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalGravity = Alignment.CenterVertically
        ) {
            SearchIcon(modifier = Modifier.padding(end = 16.dp))
            SearchText(viewModel)
        }
    }
}

@Composable
fun SearchText(viewModel: MainViewModel) {
    val hint = "Search..."
    HintTextField(hintText = hint, viewModel = viewModel)
}

@Composable
fun HintTextField(
    hintText: String = "",
    viewModel: MainViewModel
) {
    val context = ContextAmbient.current
    val state = state { TextFieldValue("") }
    val inputField = @Composable {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            imeAction = ImeAction.Search,
            textColor = Color.Black,
            textStyle = TextStyle(fontSize = 16.sp),
            value = state.value,
            onValueChange = {
                state.value = it
                viewModel.querySubject.onNext(it.text)
            },
            onImeActionPerformed = {
                hideKeyboard(context)
            })
    }

    Layout(
        children = @Composable {
            inputField()
            Text(
                text = hintText,
                color = Color(android.graphics.Color.parseColor("#B9BBC4")),
                style = TextStyle(fontSize = 16.sp)
            )
        },
        measureBlock = { measurables: List<Measurable>, constraints: Constraints, _ ->
            val inputFieldPlace = measurables[0].measure(constraints)
            val hintPlace = measurables[1].measure(constraints)
            layout(
                inputFieldPlace.width,
                inputFieldPlace.height
            ) {
                inputFieldPlace.place(0.ipx, 0.ipx)
                if (state.value.text.isEmpty()) hintPlace.place(0.ipx, 0.ipx)
            }
        }
    )
}

@Composable
fun SearchIcon(modifier: Modifier = Modifier) {
    val icon = vectorResource(id = R.drawable.ic_baseline_search_24)
    Icon(
        asset = icon,
        modifier = modifier,
        tint = Color(android.graphics.Color.parseColor("#B9BBC4"))
    )
}