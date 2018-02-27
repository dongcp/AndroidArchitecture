package yue.self.architecturecomponent.people

import android.os.Bundle
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.item_test.view.*
import yue.self.architecturecomponent.Constants
import yue.self.architecturecomponent.R
import yue.self.architecturecomponent.data.PeopleDiffCallback
import yue.self.architecturecomponent.data.Person
import java.util.*

/**
 * Created by GEM on 2/27/2018.
 */
class PeopleAdapter : RecyclerView.Adapter<PeopleAdapter.PersonItemViewHolder>() {
  private val people: MutableList<Person> = ArrayList()

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PersonItemViewHolder =
      PersonItemViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_test, parent, false))

  override fun getItemCount(): Int =
      people.size

  override fun onBindViewHolder(holder: PersonItemViewHolder?, position: Int) {
    holder?.bindView(people[position])
  }

  override fun onBindViewHolder(holder: PersonItemViewHolder?, position: Int, payloads: MutableList<Any>?) {
    if (payloads != null && payloads.isNotEmpty()) {
      val data = payloads[0] as Bundle
      data.keySet().forEach {

        if (it == Constants.Key.KEY_NAME) {
          holder?.itemView?.tvName?.text = people[position].name
        }

        if (it == Constants.Key.KEY_AGE) {
          holder?.itemView?.tvAge?.text = "" + people[position].age
        }
      }
    } else
      super.onBindViewHolder(holder, position, payloads)
  }

  fun refreshList(newPeople: MutableList<Person>) {
    Observable.create(ObservableOnSubscribe<DiffUtil.DiffResult> { emitter ->
      emitter.onNext(DiffUtil.calculateDiff(PeopleDiffCallback(people, newPeople)))
    })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ diffResult ->
          diffResult.dispatchUpdatesTo(PeopleAdapter@ this)
          people.clear()
          people.addAll(newPeople)
        })
  }

  inner class PersonItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bindView(person: Person) {
      itemView.tvId.text = "" + person.id
      itemView.tvName.text = person.name
      itemView.tvAge.text = "" + person.age
    }
  }
}