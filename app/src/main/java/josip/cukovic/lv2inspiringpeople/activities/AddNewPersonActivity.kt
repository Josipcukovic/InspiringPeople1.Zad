package josip.cukovic.lv2inspiringpeople.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import josip.cukovic.lv2inspiringpeople.databinding.ActivityAddNewPersonBinding

class AddNewPersonActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAddNewPersonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() = binding.btnSavePerson.setOnClickListener{ addPerson()}


    private fun addPerson() {
        val name = binding.etInputName.text.toString().trim()
        val year = binding.etInputDate.text.toString().trim()
        val description = binding.etInputDescription.text.toString().trim()
        val quote = binding.etInputQuote.text.toString().trim()

        if(!isFilled(name,year,description,quote)){
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_LONG).show()
            return
        }

        val resultIntent = Intent().apply {
            putExtra(MainActivity.KEY_EXTRA_NAME,name)
            putExtra(MainActivity.KEY_EXTRA_YEAR,year)
            putExtra(MainActivity.KEY_EXTRA_DESCRIPTION,description)
            putExtra(MainActivity.KEY_EXTRA_QUOTE,quote)
        }
        this.setResult(Activity.RESULT_OK, resultIntent)
        this.finish()

    }

    private fun isFilled(name: String,year: String,description: String, quote : String) : Boolean{
        if(name.isEmpty() || year.isEmpty() || description.isEmpty() ||quote.isEmpty())return false else return true
    }
}