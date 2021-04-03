package josip.cukovic.lv2inspiringpeople.model

import josip.cukovic.lv2inspiringpeople.R
import java.io.Serializable

class InspiringPerson(val name:String, val dateOfDeath : String, val description : String, quotes : MutableList<String>, val image : Int = R.drawable.character) {
    private val quotes : MutableList<String> = mutableListOf()

    init {
        this.quotes.addAll(quotes)
    }

    fun randomQuote():String{
        val randomPosition = (0 until quotes.size).random()
        return this.quotes[randomPosition]
    }

}