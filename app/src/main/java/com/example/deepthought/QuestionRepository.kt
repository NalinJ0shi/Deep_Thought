package com.example.deepthought

data class DeepQuestion(
    val id: Int,
    val text: String,
    val category: String
)

// This is our Logic Controller for data
object QuestionRepository {
    private val questions = listOf(
        DeepQuestion(1, "What is a truth about you that you often ignore?", "Life"),
        DeepQuestion(2, "Does your current career path align with your 10-year-old self's dreams?", "Career"),
        DeepQuestion(3, "If you lost everything tomorrow, who is the first person you’d call?", "Love"),
        DeepQuestion(4, "What business risk are you avoiding out of fear rather than logic?", "Business"),
        DeepQuestion(5, "If you could know the absolute truth to one question, what would it be?", "Curiosity")
    )

    fun getCategories(): List<String> {
        return questions.map { it.category }.distinct()
    }

    fun getRandomQuestionByCategory(category: String): DeepQuestion {
        return questions.filter { it.category == category }.random()
    }
}