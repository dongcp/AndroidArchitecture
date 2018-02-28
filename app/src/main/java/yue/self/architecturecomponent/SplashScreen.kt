package yue.self.architecturecomponent

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import yue.self.architecturecomponent.extension.moveToActivity

/**
 * Created by GEM on 2/28/2018.
 */
class SplashScreen : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)

    Handler().postDelayed({
      moveToActivity(Intent(this, MainActivity::class.java), true)
    }, 2000)
  }
}