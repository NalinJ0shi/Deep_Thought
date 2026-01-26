package com.example.deepthought

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
// These two imports below are the "Property Delegate" fix!
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.deepthought.ui.theme.DeepThoughtTheme

// Screen needs to be outside the MainActivity class so it's globally accessible
sealed class Screen {
    object Categories : Screen()
    data class QuestionDetails(val category: String) : Screen()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeepThoughtTheme {
                // currentScreen uses 'by', so we need those specific runtime imports
                var currentScreen by remember { mutableStateOf<Screen>(Screen.Categories) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        when (val screen = currentScreen) {
                            is Screen.Categories -> {
                                CategoryScreen(onCategorySelected = { selectedCategory ->
                                    currentScreen = Screen.QuestionDetails(selectedCategory)
                                })
                            }
                            is Screen.QuestionDetails -> {
                                ReflectionScreen(
                                    category = screen.category,
                                    onBack = { currentScreen = Screen.Categories }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}