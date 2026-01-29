package com.example.deepthought

data class DeepQuestion(
    val id: Int,
    val text: String,
    val category: String
)

// This is our Logic Controller for data
// Updated QuestionRepository.kt
object QuestionRepository {
    private val questions = listOf(
        // Life Category
        DeepQuestion(1, "What is a truth about you that you often ignore?", "Life"),
        DeepQuestion(2, "What would you do if you weren't afraid?", "Life"),
        DeepQuestion(3, "What are you most grateful for today?", "Life"),

        // Career Category
        DeepQuestion(4, "Does your current career path align with your 10-year-old self's dreams?", "Career"),
        DeepQuestion(5, "What skill do you want to master in the next year?", "Career"),

        // Love Category
        DeepQuestion(6, "If you lost everything tomorrow, who is the first person you’d call?", "Love"),
        DeepQuestion(7, "What does 'unconditional love' mean to you?", "Love"),

        // Business Category
        DeepQuestion(8, "What business risk are you avoiding out of fear rather than logic?", "Business"),
        DeepQuestion(9, "If you could automate one task in your work, what would it be?", "Business"),

        // Curiosity Category
        DeepQuestion(10, "If you could know the absolute truth to one question, what would it be?", "Curiosity"),
        DeepQuestion(11, "What is a mystery of the universe that fascinates you?", "Curiosity")
    )

    fun getCategories(): List<String> {
        return questions.map { it.category }.distinct()
    }

    // New function to return the full list of questions for a category
    fun getQuestionsByCategory(category: String): List<DeepQuestion> {
        return questions.filter { it.category == category }
    }
}