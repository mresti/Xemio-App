package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.presenter.DetailEffectPresenter;

public interface DetailEffectInteractor {
  void setPresenter(DetailEffectPresenter presenter);

  void initialize(Context c);

  Firebase getEffectRef(String key);
}
