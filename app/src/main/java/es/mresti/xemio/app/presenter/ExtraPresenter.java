package es.mresti.xemio.app.presenter;

import android.content.Context;
import es.mresti.xemio.app.interactor.ExtraInteractor;
import es.mresti.xemio.app.view.ExtraView;

public class ExtraPresenter implements Presenter {
  private ExtraView mExtraView;
  private ExtraInteractor mExtraInteractor;
  private Context mContext;

  public static ExtraPresenter newInstance(ExtraView extraView, ExtraInteractor extraInteractor) {
    ExtraPresenter presenter = new ExtraPresenter(extraView, extraInteractor);
    presenter.initialize();
    return presenter;
  }

  private ExtraPresenter(ExtraView extraView, ExtraInteractor extraInteractor) {
    this.mExtraView = extraView;
    this.mExtraInteractor = extraInteractor;
  }

  private void initialize() {
    mExtraInteractor.setPresenter(this);
  }

  @Override public void resume() {
  }

  @Override public void pause() {
  }

  public void setRegister(String username, String age) {
    mExtraView.showProgress();
    mExtraInteractor.saveExtraData(this.mContext, username, age);
  }

  public void onUsernameError() {
    mExtraView.setUsernameError();
    mExtraView.hideProgress();
  }

  public void onAgeError() {
    mExtraView.setAgeError();
    mExtraView.hideProgress();
  }

  public void onSuccess() {
    mExtraView.navigateToChemoScreen();
  }

  public void initializeContext(Context c) {
    this.mContext = c;
  }
}
