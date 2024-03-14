package com.playdevs

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.playdevs.ui.theme.PlayDevsGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayDevsGameTheme {
                // A surface container using the 'background' color from the theme
                Image(
                    painter = painterResource(id = R.drawable.splash_screen_image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        // Handler para agregar un retraso de 2 segundos antes de iniciar la nueva actividad
        Handler().postDelayed({
            val intent = Intent(this@MainActivity, GameActivity::class.java)
            startActivity(intent)
            finish() // Opcional, si deseas cerrar la actividad actual
        }, 2500) // 3000 milisegundos = 3 segundos
    }
}
