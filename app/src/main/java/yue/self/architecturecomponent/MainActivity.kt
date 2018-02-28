package yue.self.architecturecomponent

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import yue.self.architecturecomponent.people.PeopleActivity

class MainActivity : AppCompatActivity() {
  private lateinit var mAppLifecycleObserver: AppLifecycleObserver

  private lateinit var mAppData: AppDataViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    setTheme(R.style.AppTheme)

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    mAppData = ViewModelProviders.of(this).get(AppDataViewModel::class.java)

    mAppLifecycleObserver = AppLifecycleObserver(this, lifecycle) {
      Log.e(Constants.LOG_TAG, "Call back")
    }

    btnClickMe.setOnClickListener {
      startActivity(Intent(this, PeopleActivity::class.java))
    }
  }

  override fun onResume() {
    super.onResume()
    mAppLifecycleObserver.enable()
  }
}
