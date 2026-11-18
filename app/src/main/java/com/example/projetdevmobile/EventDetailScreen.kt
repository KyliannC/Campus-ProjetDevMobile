package com.example.projetdevmobile

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetdevmobile.ui.theme.ProjetDevMobileTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailScreen(
    event: Event,
    modifier: Modifier = Modifier,
    onBook: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier,
        topBar = { TopAppBar(title = { Text(stringResource(R.string.campus_title)) }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Pas de bibliothèque d'images pour l'instant : illustration de substitution
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = event.category.take(1),
                        style = MaterialTheme.typography.displayLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                EventHeader(
                    title = event.title,
                    category = event.category,
                    location = event.location
                )
                if (!event.isFull) {
                    Text(
                        text = pluralStringResource(
                            R.plurals.places_left,
                            event.capacity,
                            event.capacity
                        ),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                Text(
                    text = event.description,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Button(
                onClick = onBook,
                enabled = !event.isFull,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(stringResource(if (event.isFull) R.string.full else R.string.book))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventDetailScreenPreview() {
    ProjetDevMobileTheme {
        EventDetailScreen(event = sampleEvents[0])
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EventDetailScreenDarkPreview() {
    ProjetDevMobileTheme {
        EventDetailScreen(event = sampleEvents[0])
    }
}

@Preview(showBackground = true, fontScale = 2f)
@Composable
fun EventDetailScreenLargeFontPreview() {
    ProjetDevMobileTheme {
        EventDetailScreen(event = sampleEvents[0])
    }
}
