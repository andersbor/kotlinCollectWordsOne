package dk.easj.anbo.collectwordsone

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
            binding.textViewMessage.text = words.toString()
        }
    }
}