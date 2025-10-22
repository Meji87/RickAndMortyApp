package com.example.m8_eac2_ex2.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.m8_eac2_ex2.dades.Character
import com.example.m8_eac2_ex2.dades.CharacterData
import com.example.m8_eac2_ex2.ui.ErrorScreen
import com.example.m8_eac2_ex2.ui.LoadingScreen

@Composable
fun CharacterScreen(
    characterUiState: CharacterUiState,
    modifier: Modifier
) {
    when (characterUiState) {
        is CharacterUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is CharacterUiState.Success -> CharacterList(
            characterUiState.items
            )
        is CharacterUiState.Error -> ErrorScreen( modifier = modifier.fillMaxSize())
    }
}

@Composable
private fun CharacterList(
    items: Character
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items.results, key = { it.id }) { p ->
            CharacterCard(
                character = p,
                onClick = {}
            )
        }
    }
}

@Composable
private fun CharacterCard(
    character: CharacterData,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 120.dp),
        shape = MaterialTheme.shapes.large,
        onClick = {onClick}


    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(character.image)
                    .crossfade(true)
                    .build(),
                contentDescription = "Imatge de ${character.name}",
                contentScale = ContentScale.Crop,
                modifier = Modifier //Modifier.clip(CircleShape)
                    .size(96.dp)
                    .clip(MaterialTheme.shapes.medium)
            )

            Spacer(Modifier.width(12.dp))

            Column {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),

                    )
                Text("Status: " + character.status, style = MaterialTheme.typography.labelMedium,)
                Text("Gender: " + character.gender, style = MaterialTheme.typography.labelMedium,)
                Text("Specie: " + character.species, style = MaterialTheme.typography.labelMedium,)

            }

        }
    }
}