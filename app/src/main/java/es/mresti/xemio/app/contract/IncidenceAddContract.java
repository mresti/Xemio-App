package es.mresti.xemio.app.contract;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface IncidenceAddContract {

  interface View extends BaseContract.BaseView {
    void setSubjectError();

    void setDescriptionError();

    void openDashboard();

    void showNotificationCreated();
  }

  interface UserActionsListener {
    void addIncidence(String subject, String description);
  }
}
