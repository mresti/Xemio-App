package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.afollestad.materialdialogs.MaterialDialog;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.PresenterFactory;
import es.mresti.xemio.app.presenter.VerifyPresenter;
import es.mresti.xemio.app.view.VerifyView;

public class VerifyActivity extends BaseActivity implements VerifyView {

  private Navigator mNavigator;
  private VerifyPresenter presenter;
  private MaterialDialog mDialog1;
  private MaterialDialog mDialog2;

  // UI items
  @Bind(R.id.btn_verify) Button mBtn_verify;
  @Bind(R.id.btn_retry) Button mBtn_retry;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, VerifyActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_verify);
    ButterKnife.bind(this);
    this.initialize();
    presenter = PresenterFactory.getVerifyPresenter(this);
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    this.mNavigator = new Navigator();
  }

  /**
   * Goes to the user verified screen.
   */
  @OnClick(R.id.btn_verify) void navigateToVerified() {
    presenter.getVerifyUser();
  }

  /**
   * Goes to the user verified screen.
   */
  @OnClick(R.id.btn_retry) void retryNewEmail() {
    MaterialDialog dialog = new MaterialDialog.Builder(this).title(R.string.app_name)
        .content("Esteban " + getText(R.string.dialog_verify_reply_text))
        .positiveText(R.string.dialog_verify_pos)
        .negativeText(R.string.dialog_verify_neg)
        .callback(new MaterialDialog.ButtonCallback() {
          @Override public void onPositive(MaterialDialog dialog) {
            presenter.sendEmail();
          }

          @Override public void onNegative(MaterialDialog dialog) {
          }
        })
        .show();
  }

  @Override public void showProgress() {
    mDialog1 = new MaterialDialog.Builder(this).title(R.string.dialog_progress_title)
        .content(R.string.dialog_progress_text)
        .progress(true, 0)
        .show();
  }

  @Override public void hideProgress() {
    mDialog1.cancel();
  }

  @Override public void navigateToCancerScreen() {
    this.mNavigator.navigateToCancer(this);
  }

  @Override public void showProgress2() {
    mDialog2 = new MaterialDialog.Builder(this).title(R.string.dialog_progress_title)
        .content(R.string.dialog_progress_text)
        .progress(true, 0)
        .show();
  }

  @Override public void hideProgress2() {
    mDialog2.cancel();
  }

  @Override public void showDialogSuccess() {
    MaterialDialog dialog = new MaterialDialog.Builder(this).title(R.string.app_name)
        .content(
            "User ha sido enviado un email a su cuenta de correo con un nuevo código de activación.")
        .neutralText(R.string.dialog_verify_pos)
        .callback(new MaterialDialog.ButtonCallback() {
          @Override public void onNeutral(MaterialDialog dialog) {
          }
        })
        .show();
  }

  @Override public void showRetry() {

  }

  @Override public void hideRetry() {

  }

  @Override public void showError(String message) {

  }

  @Override public Context getContext() {
    return getApplicationContext();
  }
}
