package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.presenter.ListTreatmentsPresenter;

public interface ListTreatmentsInteractor {

  void setPresenter(ListTreatmentsPresenter presenter);

  void initialize(Context c);

  Firebase getTreatmentListRef();
}