package es.mresti.xemio.app.contract;

import android.content.Context;

public interface BaseContract {

  interface BaseView {

    /**
     * Get a {@link android.content.Context}.
     */
    Context getContext();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    void resume();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    void pause();
  }
}
