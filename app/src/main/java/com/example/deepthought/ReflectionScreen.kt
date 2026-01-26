package com.example.deepthought

import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun ReflectionScreen(category: String, onBack: () -> Unit) {
    Column {
        Text(text = "You chose: $category. Now go deeper.")
        Button(onClick = onBack) {
            Text("Go Back")
        }
    }
}