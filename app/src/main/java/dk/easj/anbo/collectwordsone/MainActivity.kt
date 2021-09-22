package dk.easj.anbo.collectwordsone

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import dk.easj.anbo.collectwordsone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val words = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        //requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        // requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT

        binding.buttonSave.setOnClickListener {
            val word = binding.editTextWord.text.toString().trim()
            if (word.isEmpty()) {
                binding.editTextWord.error = "No word"
                return@setOnClickListener
            }
            words.add(word)
        }

        binding.buttonClear.setOnClickListener {
            words.clear()
        }

        binding.buttonShow.setOnClickListener {
            if (words.size==0) {
                binding.textViewMessage.text = "empty"
            }else {
                binding.textViewMessage.text = words.toString()
            }
        }
    }
}