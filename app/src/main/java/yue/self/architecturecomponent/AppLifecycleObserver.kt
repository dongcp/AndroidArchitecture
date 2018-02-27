package yue.self.architecturecomponent

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.util.Log

/**
 * Created by GEM on 2/22/2018.
 */
class AppLifecycleObserver(val context: Context, val lifecycle: Lifecycle, val callback: () -> Unit) : LifecycleObserver {
  private var enabled = false

  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  protected fun start() {
    Log.e(Constants.LOG_TAG, "Start")
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  protected fun stop() {
    Log.e(Constants.LOG_TAG, "Stop")
  }

  fun enable() {
    enabled = true
    if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
      Log.e(Constants.LOG_TAG, "Started")
    }
  }
}