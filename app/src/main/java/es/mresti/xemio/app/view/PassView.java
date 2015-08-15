package es.mresti.xemio.app.view;

public interface PassView extends BaseView {
  void showProgress();

  void hideProgress();

  void setPass1Error();

  void setPass2Error();

  void setPassDistinctError();

  void navigateToHome();
}
