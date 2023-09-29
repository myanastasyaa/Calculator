package id.myaanastasya.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.myaanastasya.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    //modifier untuk mengatur hak akses sebuah kelas
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculator()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calculator() {
    //remember untuk menyimpan dan mengambil nilai yang tetap ada selama komposisi ulang
    var first by remember {
        //state atau keadaan yang menyimpan value bertipe string
        mutableStateOf("")
    }
    var second by remember {
        mutableStateOf("")
    }
    var result by remember {
        mutableStateOf("")
    }
    //menempatkan satu elemen di atas elemen lainnya
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        //menempatkan item secara vertikal di layar
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            //memungkinkan user untuk memasukkan data dan modify text
            TextField(
                modifier = Modifier.fillMaxWidth(),
                //ditampilkan di dalam wadah bidang teks
                label = { Text(text = "Angka Pertama") },
                //teks masukan yang akan ditampilkan di bidang teks
                value = first,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = { value ->
                    first = value
                },
            )
            Spacer(modifier = Modifier.height(12.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Angka Kedua") },
                value = second,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = { value ->
                    second = value
                },
            )
            Spacer(modifier = Modifier.height(18.dp))
            Button(
                //pada saat klik tombol jumlah, maka
                onClick = { result = (first.toInt() + second.toInt()).toString() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Jumlah")
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = result)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatorTheme {
        Calculator()
    }
}