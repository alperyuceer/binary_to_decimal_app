package com.alpify.binartodecimal.ui.screens

import com.alpify.binartodecimal.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.alpify.binartodecimal.viewmodel.ConverterViewModel

@Composable
fun ConverterScreen(modifier: Modifier = Modifier) {
    val viewModel: ConverterViewModel = hiltViewModel()
    val inputtakiSayi by viewModel.girilenDeger.collectAsState()
    val sonucDeger by viewModel.sonucDeger.collectAsState()
    val regexForBinary = remember { Regex("^[01]*$") }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier.padding(top = 16.dp),
            value = inputtakiSayi,
            onValueChange = {
                if (it.length <= 8 && it.matches(regexForBinary)) {
                    viewModel.inputDegisti(it)
                }

            },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.outline_data_array_24),
                    null
                )
            },
            label = { Text("Binary Sayı") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true

        )

        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = "Decimal'e Çevrilmiş Hali: "
        )
        Card(modifier = Modifier.padding(top = 8.dp)) {
            Text(sonucDeger)
        }


    }
}
