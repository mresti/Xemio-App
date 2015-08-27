package es.mresti.xemio.app.view;

public interface DashboardView extends BaseView {
  void showProgress();

  void hideProgress();

  void navigateToMainScreen();
}
