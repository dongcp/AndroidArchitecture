package yue.self.architecturecomponent.data

import android.os.Bundle
import android.support.v7.util.DiffUtil
import yue.self.architecturecomponent.Constants

/**
 * Created by GEM on 2/27/2018.
 */
class PeopleDiffCallback(private val oldPeople: MutableList<Person>, private val newPeople: MutableList<Person>) : DiffUtil.Callback() {

  override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
      oldPeople[oldItemPosition].id == newPeople[newItemPosition].id

  override fun getOldListSize(): Int = oldPeople.size

  override fun getNewListSize(): Int = newPeople.size

  override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
      oldPeople[oldItemPosition] == newPeople[newItemPosition]

  override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
    val oldPerson = oldPeople[oldItemPosition]
    val newPerson = newPeople[newItemPosition]

    val data = Bundle()

    if (oldPerson.name != newPerson.name) {
      data.putString(Constants.Key.KEY_NAME, newPerson.name)
    }

    if (oldPerson.age != newPerson.age) {
      data.putInt(Constants.Key.KEY_AGE, newPerson.age)
    }

    if (data.isEmpty)
      return null

    return data
  }
}