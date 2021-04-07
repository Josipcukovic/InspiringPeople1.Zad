package josip.cukovic.lv2inspiringpeople.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import josip.cukovic.lv2inspiringpeople.R
import josip.cukovic.lv2inspiringpeople.adapter.PeopleAdapter
import josip.cukovic.lv2inspiringpeople.data.PeopleRepository
import josip.cukovic.lv2inspiringpeople.databinding.ActivityMainBinding
import josip.cukovic.lv2inspiringpeople.model.InspiringPerson

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setupUI()
    }

    private fun setupUI() {
        val people = mainBinding.rvInspiringPeople
        people.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        people.adapter = PeopleAdapter(PeopleRepository.people)
        mainBinding.btnAddNewPerson.setOnClickListener{retrieveData()}
    }

    companion object{
       const val REQUEST_CODE = 10
        const val KEY_EXTRA_NAME = "name"
        const val KEY_EXTRA_YEAR = "year"
        const val KEY_EXTRA_DESCRIPTION = "description"
        const val KEY_EXTRA_QUOTE = "quote"
    }

    private fun retrieveData() {
        val intent = Intent(this, AddNewPersonActivity::class.java)
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val name :String
        val year : String
        val description : String
        val quotes = mutableListOf<String>(getString(R.string.random_quote))

        if(requestCode == REQUEST_CODE){
            name = data?.getStringExtra(KEY_EXTRA_NAME).toString()
            year = data?.getStringExtra(KEY_EXTRA_YEAR).toString()
            description = data?.getStringExtra(KEY_EXTRA_DESCRIPTION).toString()
            quotes.add(data?.getStringExtra(KEY_EXTRA_QUOTE).toString())
            if(name == "null" ||year == "null" || description == "null") return
            addNewPersonToRepository(name,year,description,quotes)

           val adapter = (mainBinding.rvInspiringPeople.adapter as PeopleAdapter)
            adapter.refreshData(PeopleRepository.people)
            mainBinding.rvInspiringPeople.scrollToPosition(adapter.itemCount-1)
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun addNewPersonToRepository(name : String,
                                         year : String,
                                         description : String,
                                         quotes : MutableList<String>
                                        ) = PeopleRepository.add(InspiringPerson(name, year, description, quotes))

}