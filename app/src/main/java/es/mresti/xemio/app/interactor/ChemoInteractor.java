package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.presenter.ChemoPresenter;

public interface ChemoInteractor {
  void setPresenter(ChemoPresenter presenter);

  void initialize(Context c);

  Firebase getChemoRef();

  void setChemo(String key);
}

