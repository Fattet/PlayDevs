package com.playdevs

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity

import android.animation.ObjectAnimator
import android.annotation.SuppressLint

import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView


class GameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_game)
        val diceImageView = findViewById<ImageView>(R.id.diceImageView)

        animateDiceRoll(diceImageView)
    }


    @SuppressLint("DiscouragedApi")
    private fun animateDiceRoll(diceImageView: ImageView) {
        val randomDiceValue = (1..6).random() // Genera un valor aleatorio entre 1 y 6

        val rotationAnimator = ObjectAnimator.ofFloat(diceImageView, "rotation", 0f, 360f)
        rotationAnimator.duration = 1000 // Duración de la animación en milisegundos
        rotationAnimator.interpolator = AccelerateDecelerateInterpolator()

        rotationAnimator.addUpdateListener { animator ->
            val value = animator.animatedValue as Float
            if (value % 90 == 0f) {
                // Cambia la imagen del dado cada 90 grados (cara nueva)
                val diceDrawableId = resources.getIdentifier(
                    "dice$randomDiceValue",
                    "drawable",
                    packageName
                )
                diceImageView.setImageResource(diceDrawableId)
            }
        }

        rotationAnimator.start()
    }

    fun onDiceClick(view: View) {
        val diceImageView: ImageView = findViewById(R.id.diceImageView)
        animateDiceRoll(diceImageView)
    }

}