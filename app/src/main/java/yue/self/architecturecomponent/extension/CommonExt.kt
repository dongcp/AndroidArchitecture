package yue.self.architecturecomponent.extension

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity

/**
 * Created by GEM on 2/28/2018.
 */
fun Activity.moveToActivity(intent: Intent, destroyCurrent: Boolean = false) {
  startActivity(intent.apply {
    if (destroyCurrent) {
      addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
      addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
  })
}

fun AppCompatActivity.moveToActivity(intent: Intent, destroyCurrent: Boolean = false) {
  startActivity(intent.apply {
    if (destroyCurrent) {
      addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
      addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
  })
}