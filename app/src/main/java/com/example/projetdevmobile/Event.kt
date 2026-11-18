package com.example.projetdevmobile

data class Event(
    val id: Int,
    val title: String,
    val category: String,
    val location: String?,
    val description: String,
    val capacity: Int
) {
    val isFull: Boolean get() = capacity == 0
}

val sampleEvents = listOf(
    Event(
        1, "Festival de musique", "Concert", "Amphithéâtre A",
        "Une soirée de concerts avec les groupes étudiants du campus. Trois scènes, des food trucks et une ambiance garantie jusqu'à minuit. Pensez à venir avec votre carte étudiante : elle sera demandée à l'entrée.\n\n" +
            "Le programme complet sera communiqué par mail quelques jours avant l'événement. Les portes ouvrent à 18 h et la première scène démarre à 19 h.",
        200
    ),
    Event(
        2, "Atelier Kotlin : les coroutines", "Atelier", "Salle B12",
        "Apprenez à écrire du code asynchrone propre avec les coroutines Kotlin : suspend, scopes, dispatchers et gestion des erreurs. Apportez votre ordinateur portable avec Android Studio installé.",
        30
    ),
    Event(
        3, "Soirée d'intégration", "Soirée", null,
        "La grande soirée de rentrée pour rencontrer les nouveaux et les anciens. Jeux, musique et buffet. Le lieu sera annoncé prochainement.",
        150
    ),
    Event(
        4, "Hackathon Android", "Compétition", "Labo informatique",
        "48 heures pour concevoir une application Android en équipe de quatre. Un jury de professionnels récompensera les trois meilleurs projets. Les inscriptions sont closes : toutes les places ont été prises.",
        0
    ),
    Event(
        5, "Conférence IA embarquée", "Conférence", "Amphithéâtre B",
        "Des chercheurs et des ingénieurs présentent les dernières avancées de l'intelligence artificielle sur appareil mobile : modèles compacts, quantification et accélération matérielle.",
        80
    )
)
