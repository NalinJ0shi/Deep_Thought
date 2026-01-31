package com.nalin.deepthought

data class DeepQuestion(
    val id: Int,
    val text: String,
    val category: String
)

object QuestionRepository {
    private val questions = listOf(
        // Life Category
        DeepQuestion(1, "What is a truth about you that you often ignore?", "Life"),
        DeepQuestion(2, "What would you do if you weren't afraid?", "Life"),
        DeepQuestion(3, "What are you most grateful for today?", "Life"),

        // Career Category
        DeepQuestion(4, "Does your current career path align with your 10-year-old self's dreams?", "Career"),
        DeepQuestion(5, "What skill do you want to master in the next year?", "Career"),
        DeepQuestion(6, "What is the biggest lesson you've learned in your professional life?", "Career"),

        // Love Category
        DeepQuestion(7, "If you lost everything tomorrow, who is the first person you’d call?", "Love"),
        DeepQuestion(8, "What does 'unconditional love' mean to you?", "Love"),
        DeepQuestion(9, "How do you show appreciation to the people you care about?", "Love"),

        // Business Category
        DeepQuestion(10, "What business risk are you avoiding out of fear rather than logic?", "Business"),
        DeepQuestion(11, "If you could automate one task in your work, what would it be?", "Business"),
        DeepQuestion(12, "What is the most important value your business or work should represent?", "Business"),

        // Curiosity Category
        DeepQuestion(13, "If you could know the absolute truth to one question, what would it be?", "Curiosity"),
        DeepQuestion(14, "What is a mystery of the universe that fascinates you?", "Curiosity"),
        DeepQuestion(15, "If you could travel to any point in time, where would you go?", "Curiosity")
    )

    fun getCategories(): List<String> {
        return questions.map { it.category }.distinct()
    }

    // New function to get the full list for the selected category
    fun getQuestionsByCategory(category: String): List<DeepQuestion> {
        return questions.filter { it.category == category }
    }
}