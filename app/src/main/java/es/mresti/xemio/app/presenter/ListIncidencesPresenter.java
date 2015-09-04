package es.mresti.xemio.app.presenter;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.interactor.ListIncidencesInteractor;
import es.mresti.xemio.app.view.ListIncidencesView;

public class ListIncidencesPresenter implements Presenter {
  private ListIncidencesView mListIncidencesView;
  private ListIncidencesInteractor mListIncidencesInteractor;
  private Context mContext;

  public static ListIncidencesPresenter newInstance(ListIncidencesView view,
      ListIncidencesInteractor interactor) {
    ListIncidencesPresenter presenter = new ListIncidencesPresenter(view, interactor);
    presenter.initialize();
    return presenter;
  }

  private ListIncidencesPresenter(ListIncidencesView view, ListIncidencesInteractor interactor) {
    mListIncidencesView = view;
    mListIncidencesInteractor = interactor;
  }

  private void initialize() {
    mListIncidencesInteractor.setPresenter(this);
  }

  @Override public void resume() {
  }

  @Override public void pause() {
  }

  public void initializeContext(Context c) {
    mContext = c;
    mListIncidencesInteractor.initialize(mContext);
  }

  public Firebase getRef() {
    return mListIncidencesInteractor.getIncidenceListRef();
  }
}
