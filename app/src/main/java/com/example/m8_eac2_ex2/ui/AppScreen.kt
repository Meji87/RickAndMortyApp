package com.example.m8_eac2_ex2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
//import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
//import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.m8_eac2_ex2.R
import com.example.m8_eac2_ex2.ui.screens.CharacterScreen
import com.example.m8_eac2_ex2.ui.screens.CharacterViewModel

enum class PantallaApp(){
    Chracter,
    Episode
}

@Composable
fun AppScreen(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier
) {

    val characterViewModel: CharacterViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = PantallaApp.Chracter.name
    ){}

    CharacterScreen(
        characterUiState = characterViewModel.characterUiState,
        modifier = modifier
    )
}

/**
 * The home screen displaying the loading message.
 */
@Preview(showBackground = true)
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )
}

/**
 * The home screen displaying error message with re-attempt button.
 */
@Preview(showBackground = true)
@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
    }
}
