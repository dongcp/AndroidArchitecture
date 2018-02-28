package yue.self.architecturecomponent

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

/**
 * Created by GEM on 2/28/2018.
 */
class SplashScreen : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)

    Handler().postDelayed({
      startActivity(Intent(this, MainActivity::class.java).apply {
        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
      })
    }, 2000)
  }
}