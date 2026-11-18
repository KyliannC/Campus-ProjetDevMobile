package com.example.projetdevmobile

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetdevmobile.ui.theme.ProjetDevMobileTheme

private const val TAG = "EventListScreen"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventListScreen(events: List<Event>, modifier: Modifier = Modifier) {
    val categories = events.map { it.category }.distinct()

    Scaffold(
        modifier = modifier,
        topBar = { TopAppBar(title = { Text(stringResource(R.string.campus_title)) }) }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(categories) { category ->
                        AssistChip(
                            onClick = { Log.d(TAG, "Clic sur la catégorie : $category") },
                            label = { Text(category) }
                        )
                    }
                }
            }
            items(events, key = { it.id }) { event ->
                EventCard(
                    event = event,
                    onClick = { Log.d(TAG, "Clic sur la carte : ${event.title}") },
                    onBook = { Log.d(TAG, "Réservation : ${event.title}") }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventListScreenPreview() {
    ProjetDevMobileTheme {
        EventListScreen(events = sampleEvents)
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EventListScreenDarkPreview() {
    ProjetDevMobileTheme {
        EventListScreen(events = sampleEvents)
    }
}

@Preview(showBackground = true, fontScale = 2f)
@Composable
fun EventListScreenLargeFontPreview() {
    ProjetDevMobileTheme {
        EventListScreen(events = sampleEvents)
    }
}
