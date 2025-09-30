package org.lyd.kmp01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.lyd.kmp01.designSystem.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme { colorScheme ->
                MaterialTheme(
                    colorScheme = colorScheme
                ) {
                    App()
                }
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    AppTheme {colorScheme ->
        MaterialTheme(
            colorScheme = colorScheme
        ) {
            App()
        }
    }
}