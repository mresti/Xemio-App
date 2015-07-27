package es.mresti.xemio.app.view.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;


/**
 * Base {@link android.app.Fragment} class for every fragment in this application.
 */
public abstract class BaseFragment extends Fragment {

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
    initializePresenter();
  }

  /**
   * Initializes the {@link es.mresti.xemio.app.presenter.Presenter}
   * for this fragment in a MVP pattern used to architect the application presentation layer.
   */
  abstract void initializePresenter();

  /**
   * Shows a {@link android.widget.Toast} message.
   *
   * @param message An string representing a message to be shown.
   */
  protected void showToastMessage(String message) {
    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
  }
}
