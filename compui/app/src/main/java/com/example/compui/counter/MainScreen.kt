package com.example.compui.counter


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compui.ui.theme.ComposeUITheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel, onNavigate: () -> Unit = {} ){

    val state by viewModel.uiState.collectAsState()

    val snackBarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current


    // collect one-shot events
    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->

            when(event){
                is UiEvent.ShowToast -> {
                    snackBarHostState.showSnackbar(event.message)
                }

                UiEvent.NavigateNext -> {
                    snackBarHostState.showSnackbar("Navigate to the Next Screen")
                    onNavigate()
                }
            }
        }
    }



    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackBarHostState)},
        topBar = { TopAppBar(title = { Text("Stateflow vs SharedFlow") }) }
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)) {

            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Count: ${state.count}",
                    style = MaterialTheme.typography.bodyMedium)

                Spacer(Modifier.height(12.dp))

                Row {

                    Button(onClick = { viewModel.increment() }) {
                        Text("Increment")
                    }

                    Spacer(Modifier.width(8.dp))

                    Button(onClick = {viewModel.simulateNetworkAndNavigate()}) {
                        Text("Simulate + Navigate")
                    }

                }
            }
        }
    }

}


@Composable
@Preview()
fun MainScreenPreview(){

    ComposeUITheme{
        MainScreen(viewModel = MainViewModel())
    }
}