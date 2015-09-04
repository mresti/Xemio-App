package es.mresti.xemio.app.view;

public interface NewIncidenceView extends BaseView {
  void setSubjectError();

  void setDescriptionError();

  void navigateToDashboard();

  void showNotificationCreated();
}
