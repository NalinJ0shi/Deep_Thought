package com.example.deepthought

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ReflectionScreen(category: String, onBack: () -> Unit) {
    // Logic remains: pick one question and stick with it
    val question = remember { QuestionRepository.getRandomQuestionByCategory(category) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        // Top Bar - Just a close button to exit the "meditation"
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.Close, contentDescription = "Exit")
            }
        }

        // Centering the question in the remaining space
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = question.text,
                style = MaterialTheme.typography.displaySmall,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                lineHeight = MaterialTheme.typography.displaySmall.lineHeight * 1.2
            )
        }

        // A simple prompt at the bottom
        Text(
            text = "Take a moment to breathe and reflect.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.outline,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 32.dp)
        )
    }
}