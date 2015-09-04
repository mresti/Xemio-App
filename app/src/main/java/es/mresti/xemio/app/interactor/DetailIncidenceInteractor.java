package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.presenter.DetailIncidencePresenter;

public interface DetailIncidenceInteractor {

  void setPresenter(DetailIncidencePresenter detailIncidencePresenter);

  void initialize(Context c);

  Firebase getIncidenceRef(String key);

  void removeItem(String key);
}
