package es.mresti.xemio.app.presenter;

import android.content.Context;
import es.mresti.xemio.app.interactor.NewIncidenceInteractor;
import es.mresti.xemio.app.view.NewIncidenceView;

public class NewIncidencePresenter implements Presenter {
  private NewIncidenceView mNewIncidenceView;
  private NewIncidenceInteractor mNewIncidenceInteractor;
  private Context mContext;

  public static NewIncidencePresenter newInstance(NewIncidenceView newIncidenceView,
      NewIncidenceInteractor newIncidenceInteractor) {
    NewIncidencePresenter presenter =
        new NewIncidencePresenter(newIncidenceView, newIncidenceInteractor);
    presenter.initialize();
    return presenter;
  }

  private NewIncidencePresenter(NewIncidenceView newIncidenceView,
      NewIncidenceInteractor newIncidenceInteractor) {
    this.mNewIncidenceView = newIncidenceView;
    this.mNewIncidenceInteractor = newIncidenceInteractor;
  }

  /**
   * Initializes the presenter by start retrieving the user list.
   */
  private void initialize() {
    mNewIncidenceInteractor.setPresenter(this);
  }

  @Override public void resume() {

  }

  @Override public void pause() {

  }

  public void initializeContext(Context c) {
    mContext = c;
    mNewIncidenceInteractor.initialize(mContext);
  }

  public void addIncidence(String sub, String desc) {
    mNewIncidenceInteractor.register(sub, desc);
  }

  public void onSubjectError() {
    mNewIncidenceView.setSubjectError();
  }

  public void onDescriptionError() {
    mNewIncidenceView.setDescriptionError();
  }

  public void onSuccess() {
    mNewIncidenceView.showNotificationCreated();
  }
}
