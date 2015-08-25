package es.mresti.xemio.app.view;

public interface MainView extends BaseView {
  void showProgress();

  void hideProgress();

  void navigateToDashboardScreen();
}
