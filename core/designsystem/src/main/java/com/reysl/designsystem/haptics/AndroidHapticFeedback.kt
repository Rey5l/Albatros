package com.reysl.designsystem.haptics

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager

class AndroidHapticFeedback(
    context: Context
) : AlbatrosHapticFeedback {
    private val vibrator: Vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val manager = context.getSystemService(VibratorManager::class.java)
        manager.defaultVibrator
    } else {
        context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }

    override fun perform(type: HapticType) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            val duration = when (type) {
                HapticType.Selection -> 10L
                HapticType.Tap -> 20L
            }

            vibrator.vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE))
            return
        }

        val effect = when (type) {
            HapticType.Selection -> {
                VibrationEffect.createPredefined(
                    VibrationEffect.EFFECT_TICK
                )
            }

            HapticType.Tap -> {
                VibrationEffect.createPredefined(
                    VibrationEffect.EFFECT_CLICK
                )
            }
        }

        vibrator.vibrate(effect)

    }
}