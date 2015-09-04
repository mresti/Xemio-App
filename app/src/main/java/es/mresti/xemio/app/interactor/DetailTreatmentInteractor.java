package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.presenter.DetailTreatmentPresenter;

public interface DetailTreatmentInteractor {
  void initialize(Context mContext);

  void setPresenter(DetailTreatmentPresenter presenter);

  Firebase getTreatmentRef(String key);
}
