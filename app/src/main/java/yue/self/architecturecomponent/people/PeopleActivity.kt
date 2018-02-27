package yue.self.architecturecomponent.people

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_test_recycler_view.*
import yue.self.architecturecomponent.R
import yue.self.architecturecomponent.data.DataProvider

/**
 * Created by GEM on 2/27/2018.
 */
class PeopleActivity : AppCompatActivity() {
  private lateinit var mAdapter: PeopleAdapter

  private var mIsFirstList = true

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_test_recycler_view)

    rvPeople.layoutManager = LinearLayoutManager(this)

    mAdapter = PeopleAdapter()
    rvPeople.adapter = mAdapter

    mAdapter.refreshList(DataProvider.getPeopleList1())

    btnChangeItem.setOnClickListener {
      if (mIsFirstList) {
        mIsFirstList = false
        mAdapter.refreshList(DataProvider.getPeopleList2())
      } else {
        mIsFirstList = true
        mAdapter.refreshList(DataProvider.getPeopleList1())
      }
    }
  }
}