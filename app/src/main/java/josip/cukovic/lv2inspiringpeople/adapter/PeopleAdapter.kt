package josip.cukovic.lv2inspiringpeople.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import josip.cukovic.lv2inspiringpeople.R
import josip.cukovic.lv2inspiringpeople.model.InspiringPerson

class PeopleAdapter( people : MutableList<InspiringPerson>): RecyclerView.Adapter<PeopleHolder>() {
    private val people : MutableList<InspiringPerson> = mutableListOf()

    init {
        this.people.addAll(people)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_layout,parent,false)
        return PeopleHolder(view,parent.context)
    }

    override fun onBindViewHolder(holder: PeopleHolder, position: Int) = holder.bind(people[position])

    override fun getItemCount(): Int = people.size

    fun refreshData(person: MutableList<InspiringPerson>){
        this.people.clear()
        this.people.addAll((person))
        notifyItemInserted(itemCount-1)

    }

}

class PeopleHolder(itemView: View, private val context: Context): RecyclerView.ViewHolder(itemView) {

    fun bind(person : InspiringPerson){
        itemView.findViewById<ImageView>(R.id.iv_person_image).setImageResource(person.image)
        itemView.findViewById<TextView>(R.id.tv_name).text = person.name
        itemView.findViewById<TextView>(R.id.tv_date).text = person.dateOfDeath
        itemView.findViewById<TextView>(R.id.tv_description).text = person.description

        itemView.findViewById<ImageView>(R.id.iv_person_image).setOnClickListener{ Toast.makeText(context, person.randomQuote(), Toast.LENGTH_LONG).show()}
    }

}


