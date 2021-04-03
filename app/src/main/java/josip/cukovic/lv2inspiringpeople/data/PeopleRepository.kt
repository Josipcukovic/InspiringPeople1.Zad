package josip.cukovic.lv2inspiringpeople.data

import josip.cukovic.lv2inspiringpeople.R
import josip.cukovic.lv2inspiringpeople.model.InspiringPerson

object PeopleRepository {
    val people : MutableList<InspiringPerson>

    init {
        this.people = initializeData()
    }

    private fun initializeData() : MutableList<InspiringPerson> {
        val linusQuotes = mutableListOf<String>("'Talk is cheap. Show me the code.'", "'Humans are destined to be party animals, and technology will follow.'", "'software is like sex : it's better when it's free..'")
        val dennisQuotes = mutableListOf<String>("'For infrastructure technology, C will be hard to displace.'","'I'm not a person who particularly had heros when growing up.'","'I fix things now and then, more often tweak HTML and make scripts to do things.'")
        val royQuotes = mutableListOf<String>("'A few people complained that my dissertation is too hard to read.'","'Apparently, I use words with too many syllables when comparing design trade-offs for network-based applications.","'I use too many general concepts, like hypertext, to describe REST instead of sticking to a concrete example, like HTML.'")

        return mutableListOf(
            InspiringPerson("Linus Torvalds","Born December 28, 1969","Linus Benedict Torvalds is a Finnish-American software engineer who is the creator and, historically, the main developer of the Linux kernel.",linusQuotes,R.drawable.linus_torvalds),
            InspiringPerson("Dennis Ritchie","1941-2011", "Dennis MacAlistair Ritchie was an American computer scientist who created C programming language.", dennisQuotes,R.drawable.dennis_ritchie_2011),
            InspiringPerson("Roy Fielding","Born in September 1995", "Roy Thomas Fielding  is an American computer scientist, one of the principal authors of the HTTP specification and the originator of the Representational State Transfer (REST) architectural style.",royQuotes,R.drawable.roy_fielding),
        )

    }

    fun add(person: InspiringPerson) = people.add(person)
}