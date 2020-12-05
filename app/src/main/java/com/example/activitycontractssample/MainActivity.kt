package com.example.activitycontractssample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

/**
 * @author Nav Singh
 */
class MainActivity : AppCompatActivity() {
    private val customContract = registerForActivityResult(CustomContract()) { result ->
        Log.i("MainActivity", "Obtained result: $result")
    }

    // in-built contracts
    private val preBuiltContract =
        registerForActivityResult(ActivityResultContracts.PickContact()) { result ->
            Log.i("MainActivity", "Obtained result: $result")
        }

    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
            Log.i("MainActivity", "Obtained result: $result")
        }

    private val requestMultiplePermission =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
            Log.i("MainActivity", "Obtained result: $result")
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.hello).setOnClickListener {
            customContract.launch(1)
            // preBuiltContract.launch(null)
            //requestPermission.launch(android.Manifest.permission.READ_PHONE_STATE)
            /*requestMultiplePermission.launch(
                arrayOf(
                    android.Manifest.permission.READ_CALENDAR,
                    android.Manifest.permission.READ_CALL_LOG
                )
            )*/
        }
    }
}