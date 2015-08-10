package es.mresti.xemio.app.view;

public interface PassView extends BaseView {
  public void showProgress();

  public void hideProgress();

  public void setPass1Error();

  public void setPass2Error();

  public void setPassDistinctError();

  public void navigateToHome();
}
