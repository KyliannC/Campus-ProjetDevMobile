package com.example.projetdevmobile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import com.example.projetdevmobile.ui.theme.ProjetDevMobileTheme

@Composable
fun EventCard(
    event: Event,
    onClick: () -> Unit,
    onBook: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            EventHeader(
                title = event.title,
                category = event.category,
                location = event.location,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp)
            )
            Button(onClick = onBook, enabled = !event.isFull) {
                Text(if (event.isFull) "Complet" else "Réserver")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventCardPreview() {
    ProjetDevMobileTheme {
        EventCard(
            event = Event(1, "Festival de musique", "Concert", "Amphithéâtre A", 50),
            onClick = {},
            onBook = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EventCardFullPreview() {
    ProjetDevMobileTheme {
        EventCard(
            event = Event(4, "Hackathon Android", "Compétition", null, 0),
            onClick = {},
            onBook = {}
        )
    }
}
