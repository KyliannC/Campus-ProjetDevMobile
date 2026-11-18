package com.example.projetdevmobile

import   android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetdevmobile.ui.theme.ProjetDevMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjetDevMobileTheme {
                EventListScreen(events = sampleEvents, modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun EventHeader(title: String, category: String, location: String?, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = category,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = location ?: stringResource(R.string.location_unknown),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EventHeaderPreview() {
    ProjetDevMobileTheme {
        EventHeader(title = "Festival de musique", category = "Concert", location = null)
    }
}

@Composable
fun ActionRow(
    title: String,
    buttonLabel: String,
    onAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp)
        )
        Button(onClick = onAction) {
            Text(buttonLabel)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActionRowPreview() {
    ProjetDevMobileTheme {
        ActionRow(
            title = "Atelier Kotlin : les coroutines sur Android",
            buttonLabel = "Voir",
            onAction = {}
        )
    }
}
