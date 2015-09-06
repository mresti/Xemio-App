package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.presenter.DetailTreatmentPresenter;

public interface DetailTreatmentInteractor {
  void setPresenter(DetailTreatmentPresenter presenter);

  void initialize(Context c);

  Firebase getTreatmentRef(String key);
}
