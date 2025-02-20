package edu.temple.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf

class DisplayActivity : AppCompatActivity() {

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    private val startActivityForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                // TODO Step 3: Use returned value for lyricsDisplayTextView text size
                val textSize = data?.getIntExtra("textSize", 12)
                lyricsDisplayTextView.textSize = textSize!!.toFloat()
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value
        textSizeSelectorButton.setOnClickListener {
            val intent = Intent(this, TextSizeActivity::class.java)
            startActivityForResult.launch(intent)
        }



    }
}