package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.presenter.ListEffectsPresenter;

public interface ListEffectsInteractor {

  void setPresenter(ListEffectsPresenter presenter);

  void initialize(Context c);

  Firebase getEffectListRef();
}
