package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.afollestad.materialdialogs.MaterialDialog;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.PassPresenter;
import es.mresti.xemio.app.presenter.PresenterFactory;
import es.mresti.xemio.app.view.PassView;
import es.mresti.xemio.app.view.validator.AlphaNumericValidator;

public class PassActivity extends BaseActivity implements PassView {

  private static final String mLOGTAG = "LogsAndroid";
  private Navigator mNavigator;
  private PassPresenter presenter;
  private MaterialDialog mDialog;
  private AlphaNumericValidator mAlphaNumericValidator1;
  private AlphaNumericValidator mAlphaNumericValidator2;

  // UI items
  @InjectView(R.id.btn_next) Button mBtn_save;
  @InjectView(R.id.btn_deny) Button mBtn_Deny;
  @InjectView(R.id.passInput1) EditText mPassInput1;
  @InjectView(R.id.passInputLayout1) TextInputLayout mPassInputLayout1;
  @InjectView(R.id.passInput2) EditText mPassInput2;
  @InjectView(R.id.passInputLayout2) TextInputLayout mPassInputLayout2;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, PassActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pass);

    ButterKnife.inject(this);
    this.initialize();
    presenter = PresenterFactory.getPassPresenter(this);
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    this.mNavigator = new Navigator();
    // Setup field validators.
    mAlphaNumericValidator1 = new AlphaNumericValidator();
    mPassInput1.addTextChangedListener(mAlphaNumericValidator1);
    mAlphaNumericValidator2 = new AlphaNumericValidator();
    mPassInput2.addTextChangedListener(mAlphaNumericValidator2);
  }

  /**
   * Goes to the dashboard screen.
   */
  @OnClick(R.id.btn_next) void navigateToDashboard() {
    boolean passValid1 = mAlphaNumericValidator1.isValid();
    boolean passValid2 = mAlphaNumericValidator2.isValid();

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

  /**
   * Goes to the user LogIn screen.
   */
  @OnClick(R.id.btn_deny) void navigateToFinish() {
    finish();
  }

  @Override public void showProgress() {
    mDialog = new MaterialDialog.Builder(this).title(R.string.progress_dialog)
        .content(R.string.please_wait)
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
