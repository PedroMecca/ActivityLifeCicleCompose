package br.edu.ifsp.scl.prdm.sc303500x.activitylifeciclecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifsp.scl.prdm.sc303500x.activitylifeciclecompose.ui.theme.ActivityLifeCicleComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActivityLifeCicleComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var name by rememberSaveable { mutableStateOf ("") } //saveable mantém estado do valor
                                                               // após quebra da tela
    var age = rememberSaveable { mutableStateOf("") }
    Column (
        modifier = modifier.fillMaxSize()
    ) {
        TextField(
            value = name,
            label = { Text("Name") },
            keyboardOptions =  KeyboardOptions( keyboardType =  KeyboardType.Text),
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {name = it} //passa o conteudo da caixa de texto pro nome
        )
        TextField(
            value = age.value,
            label = { Text("Age") },
            keyboardOptions =  KeyboardOptions( keyboardType =  KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {age.value = it}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    ActivityLifeCicleComposeTheme {
        MainScreen()
    }
}