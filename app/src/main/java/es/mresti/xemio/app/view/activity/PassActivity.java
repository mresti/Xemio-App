package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.afollestad.materialdialogs.MaterialDialog;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.PassPresenter;
import es.mresti.xemio.app.presenter.PresenterFactory;
import es.mresti.xemio.app.view.PassView;
import es.mresti.xemio.app.view.validator.PassValidator;

public class PassActivity extends BaseActivity implements PassView {

  private static final String mLOGTAG = "LogsAndroid";
  private Navigator mNavigator;
  private PassPresenter presenter;
  private MaterialDialog mDialog;
  private PassValidator mPassValidator1;
  private PassValidator mPassValidator2;

  // UI items
  @Bind(R.id.btn_next) Button mBtn_next;
  @Bind(R.id.passInput1) EditText mPassInput1;
  @Bind(R.id.passInputLayout1) TextInputLayout mPassInputLayout1;
  @Bind(R.id.passInput2) EditText mPassInput2;
  @Bind(R.id.passInputLayout2) TextInputLayout mPassInputLayout2;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, PassActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pass);
    ButterKnife.bind(this);
    this.initialize();
    presenter = PresenterFactory.getPassPresenter(this);
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    this.mNavigator = new Navigator();
    // Setup field validators.
    mPassValidator1 = new PassValidator();
    mPassInput1.addTextChangedListener(mPassValidator1);
    mPassValidator2 = new PassValidator();
    mPassInput2.addTextChangedListener(mPassValidator2);
  }

  /**
   * Goes to the dashboard screen.
   */
  @OnClick(R.id.btn_next) void navigateToDashboard() {
    boolean passValid1 = mPassValidator1.isValid();
    boolean passValid2 = mPassValidator2.isValid();

    if (!passValid1) {
      mPassInputLayout1.setErrorEnabled(true);
      mPassInputLayout1.setError(getText(R.string.error_empty));
      Log.w(mLOGTAG, "Not saving personal information: Invalid pass1");
    } else {
      mPassInputLayout1.setErrorEnabled(false);
    }

    if (!passValid2) {
      mPassInputLayout2.setErrorEnabled(true);
      mPassInputLayout2.setError(getText(R.string.error_empty));
      Log.w(mLOGTAG, "Not saving personal information: Invalid pass2");
    } else {
      mPassInputLayout2.setErrorEnabled(false);
    }

    if (passValid1 && passValid2) {
      presenter.validatePass(mPassInput1.getText().toString(), mPassInput2.getText().toString());
    }
  }

  @Override public void showProgress() {
    mDialog = new MaterialDialog.Builder(this).title(R.string.dialog_progress_title)
        .content(R.string.dialog_progress_text)
        .progress(true, 0)
        .show();
  }

  @Override public void hideProgress() {
    Log.w(mLOGTAG, "Cancel indeterminate progress dialog 2");
    mDialog.cancel();
  }

  @Override public void setPass1Error() {
    mPassInputLayout1.setErrorEnabled(true);
    mPassInputLayout1.setError(getText(R.string.error_empty));
  }

  @Override public void setPass2Error() {
    mPassInputLayout2.setErrorEnabled(true);
    mPassInputLayout2.setError(getText(R.string.error_empty));
  }

  @Override public void setPassDistinctError() {
    mPassInputLayout1.setErrorEnabled(true);
    mPassInputLayout1.setError(getText(R.string.error_empty));
    mPassInputLayout2.setErrorEnabled(true);
    mPassInputLayout2.setError(getText(R.string.error_empty));
  }

  @Override public void navigateToHome() {
    this.mNavigator.navigateToDashboard(this);
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
