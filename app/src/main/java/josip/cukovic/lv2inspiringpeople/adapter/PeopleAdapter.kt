package josip.cukovic.lv2inspiringpeople.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
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




