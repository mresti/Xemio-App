package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.presenter.ChemoPresenter;

public interface ChemoInteractor {
  void setPresenter(ChemoPresenter presenter);

  Firebase getChemoRef();

  void initialize(Context c);

  void setChemo(String key);
}

