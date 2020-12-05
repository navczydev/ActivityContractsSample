package com.example.activitycontractssample

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

/**
 * @author Nav Singh
 */
class CustomContract : ActivityResultContract<Int, String>() {

    companion object {
        const val INPUT_INT = "input_int"
        const val OUTPUT_STRING = "output_string"
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        return when (resultCode) {
            Activity.RESULT_OK -> intent?.getStringExtra(OUTPUT_STRING)
            else -> null
        }
    }

    override fun createIntent(context: Context, input: Int?): Intent {
        return Intent(context,MainActivity2::class.java)
            .apply {
                putExtra(INPUT_INT, input)
            }
    }

}