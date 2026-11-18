package com.example.projetdevmobile

data class Event(
    val id: Int,
    val title: String,
    val category: String,
    val location: String?,
    val capacity: Int
) {
    val isFull: Boolean get() = capacity == 0
}

val sampleEvents = listOf(
    Event(1, "Festival de musique", "Concert", "Amphithéâtre A", 200),
    Event(2, "Atelier Kotlin : les coroutines", "Atelier", "Salle B12", 30),
    Event(3, "Soirée d'intégration", "Soirée", null, 150),
    Event(4, "Hackathon Android", "Compétition", "Labo informatique", 0),
    Event(5, "Conférence IA embarquée", "Conférence", "Amphithéâtre B", 80)
)
