package es.mresti.xemio.app.view;

public interface VerifyView extends BaseView {
  void showProgress();

  void hideProgress();

  void navigateToCancerScreen();

  void showProgress2();

  void hideProgress2();

  void showDialogSuccess();
}
