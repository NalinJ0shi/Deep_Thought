package com.example.deepthought

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryScreen(onCategorySelected: (String) -> Unit) {
    val categories = QuestionRepository.getCategories()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Deep Thought",
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 40.dp, bottom = 8.dp)
        )

        Text(
            text = "Select a category to begin your reflection",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // The modifier.weight(1f) is the hero here.
        // it pushes everything else out of the way to fill the screen.
        LazyColumn(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            items(categories) { category ->
                CategoryCard(category = category) {
                    onCategorySelected(category)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCard(category: String, onClick: () -> Unit) {
    // Elevating the UI from a basic button to a Card
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Box(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = category,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Medium
            )
        }
    }
}