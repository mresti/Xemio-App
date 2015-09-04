package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.presenter.ListIncidencesPresenter;

public interface ListIncidencesInteractor {
  void setPresenter(ListIncidencesPresenter presenter);

  Firebase getIncidenceListRef();

  void initialize(Context c);
}
