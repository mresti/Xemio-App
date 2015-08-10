package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.afollestad.materialdialogs.MaterialDialog;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.PresenterFactory;
import es.mresti.xemio.app.presenter.VerifyPresenter;
import es.mresti.xemio.app.view.VerifyView;

public class VerifyActivity extends BaseActivity implements VerifyView {

  private static final String mLOGTAG = "LogsAndroid";
  private Navigator mNavigator;
  private VerifyPresenter presenter;
  private MaterialDialog mDialog1;
  private MaterialDialog mDialog2;

  // UI items
  @InjectView(R.id.btn_verify) Button mBtn_verify;
  @InjectView(R.id.btn_retry) Button mBtn_retry;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, VerifyActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_verify);

    ButterKnife.inject(this);
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
    //this.mNavigator.navigateToCancer(this);
    presenter.getVerifyUser();
  }

  /**
   * Goes to the user verified screen.
   */
  @OnClick(R.id.btn_retry) void retryNewEmail() {
    MaterialDialog dialog = new MaterialDialog.Builder(this).title("Xemio")
        .content("Esteban " + getText(R.string.str_dialog_reply))
        .positiveText("OK")
        .negativeText("CANCELAR")
        .callback(new MaterialDialog.ButtonCallback() {
          @Override public void onPositive(MaterialDialog dialog) {
            presenter.sendEmail();
          }

          @Override public void onNegative(MaterialDialog dialog) {
            Log.w(mLOGTAG, "Cancel pulsado");
          }
        })
        .show();
  }

  @Override public void showProgress() {
    mDialog1 = new MaterialDialog.Builder(this).title(R.string.progress_dialog)
        .content(R.string.please_wait)
        .progress(true, 0)
        .show();
  }

  @Override public void hideProgress() {
    Log.w(mLOGTAG, "Cancel indeterminate progress dialog");
    mDialog1.cancel();
  }

  @Override public void navigateToCancerScreen() {
    this.mNavigator.navigateToCancer(this);
  }

  @Override public void showProgress2() {
    mDialog2 = new MaterialDialog.Builder(this).title(R.string.progress_dialog)
        .content(R.string.please_wait)
        .progress(true, 0)
        .show();
  }

  @Override public void hideProgress2() {
    Log.w(mLOGTAG, "Cancel indeterminate progress dialog 2");
    mDialog2.cancel();
  }

  @Override public void showDialogSuccess() {
    MaterialDialog dialog = new MaterialDialog.Builder(this).title("Xemio")
        .content(
            "User ha sido enviado un email a su cuenta de correo con un nuevo código de activación.")
        .neutralText("OK")
        .callback(new MaterialDialog.ButtonCallback() {
          @Override public void onNeutral(MaterialDialog dialog) {
            Log.w(mLOGTAG, "OK verificado pulsado");
          }
        })
        .show();
    Log.w(mLOGTAG, "OK pulsado");
  }

  @Override public void showLoading() {

  }

  @Override public void hideLoading() {

  }

  @Override public void showRetry() {

  }

  @Override public void hideRetry() {

  }

  @Override public void showError(String message) {

  }

  @Override public Context getContext() {
    return null;
  }
}
