package com.nalin.deepthought

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
    // Get all questions for this category
    val questions = remember { QuestionRepository.getQuestionsByCategory(category) }
    // State to keep track of which question is currently displayed
    var currentIndex by remember { mutableIntStateOf(0) }
    val currentQuestion = questions[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        // Top Bar - Close button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.Close, contentDescription = "Exit")
            }
        }

        // Center the question text
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = currentQuestion.text,
                style = MaterialTheme.typography.displaySmall,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                lineHeight = MaterialTheme.typography.displaySmall.lineHeight * 1.2
            )
        }

        // The "Next" Button
        Button(
            onClick = {
                // Loop back to the first question after the last one
                if (currentIndex < questions.size - 1) {
                    currentIndex++
                } else {
                    currentIndex = 0
                }
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        ) {
            Text("Next Question")
        }

        // Question counter and prompt
        Text(
            text = "Question ${currentIndex + 1} of ${questions.size}",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.outline,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 32.dp)
        )
    }
}