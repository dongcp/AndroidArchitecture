package yue.self.architecturecomponent.data

/**
 * Created by GEM on 2/27/2018.
 */
object DataProvider {
  fun getPeopleList1(): MutableList<Person> {
    val people: MutableList<Person> = ArrayList()
    people.add(Person(1, "Dong", 24))
    people.add(Person(2, "Nam", 24))
    people.add(Person(3, "Phuc", 24))
    people.add(Person(4, "Tu", 24))
    people.add(Person(5, "Cuong", 24))
    return people
  }

  fun getPeopleList2(): MutableList<Person> {
    val people: MutableList<Person> = ArrayList()
    people.add(Person(1, "Dong", 24))
    people.add(Person(2, "Thanh", 24))
    people.add(Person(3, "Phuc", 24))
    people.add(Person(4, "Lan", 24))
    people.add(Person(5, "Cuong", 23))
    return people
  }
}