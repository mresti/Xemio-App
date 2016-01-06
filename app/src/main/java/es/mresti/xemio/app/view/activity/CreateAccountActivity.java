package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.CreateAccountContract;
import es.mresti.xemio.app.presenter.CreateAccountPresenter;
import es.mresti.xemio.app.view.navigation.Navigator;
import es.mresti.xemio.app.view.validator.EmailValidator;
import es.mresti.xemio.app.view.validator.PassValidator;

public class CreateAccountActivity extends BaseActivity implements CreateAccountContract.View {

  private CreateAccountContract.UserActionsListener mActionsListener;
  private Navigator mNavigator;
  private EmailValidator mEmailValidator;
  private PassValidator mPassValidator1;
  private PassValidator mPassValidator2;

  // UI items
  @Bind(R.id.progress) ProgressBar mProgress;
  @Bind(R.id.emailInput) EditText mEmailText;
  @Bind(R.id.emailInputLayout) TextInputLayout mEmailInputLayout;
  @Bind(R.id.passInput1) EditText mPassInput1;
  @Bind(R.id.passInputLayout1) TextInputLayout mPassInputLayout1;
  @Bind(R.id.passInput2) EditText mPassInput2;
  @Bind(R.id.passInputLayout2) TextInputLayout mPassInputLayout2;
  @Bind(R.id.coordinatorLayout) CoordinatorLayout mLinearLayout;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, CreateAccountActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create_account);
    ButterKnife.bind(this);
    this.initialize();
  }

  private void initialize() {
    mNavigator = new Navigator();
    mActionsListener = new CreateAccountPresenter(this);

    // Setup field validators.
    mEmailValidator = new EmailValidator();
    mEmailText.addTextChangedListener(mEmailValidator);
    mPassValidator1 = new PassValidator();
    mPassInput1.addTextChangedListener(mPassValidator1);
    mPassValidator2 = new PassValidator();
    mPassInput2.addTextChangedListener(mPassValidator2);
  }

  @Override public void showProgress() {
    mProgress.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    mProgress.setVisibility(View.GONE);
  }

  @Override public Context getContext() {
    return getApplicationContext();
  }

  @Override public void resume() {
    super.onResume();
  }

  @Override public void pause() {
    super.onPause();
  }

  @Override public void openExtra() {
    mNavigator.navigateToExtraAccount(this);
    finish();
  }

  @Override public void getBackApp() {
    mNavigator.navigateToRegister(this);
    finish();
  }

  @Override public void showNotificationMessage(String message) {
    Snackbar snackbar = Snackbar.make(mLinearLayout, message, Snackbar.LENGTH_LONG);

    View sbView = snackbar.getView();
    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
    textView.setTextColor(Color.YELLOW);
    snackbar.show();
  }

  @Override public void setEmailError() {
    mEmailInputLayout.setErrorEnabled(true);
    mEmailInputLayout.setError(getString(R.string.error_email));
  }

  @Override public void setPass1Error() {
    mPassInputLayout1.setErrorEnabled(true);
    mPassInputLayout1.setError(getText(R.string.error_pass));
  }

  @Override public void setPass2Error() {
    mPassInputLayout2.setErrorEnabled(true);
    mPassInputLayout2.setError(getText(R.string.error_pass));
  }

  @Override public void setPassDistinctError() {
    mPassInputLayout1.setErrorEnabled(true);
    mPassInputLayout1.setError(getText(R.string.error_pass_diff));
    mPassInputLayout2.setErrorEnabled(true);
    mPassInputLayout2.setError(getText(R.string.error_pass_diff));
  }

  @OnClick(R.id.btn_next) void navigateToDashboard() {
    boolean emailValid = mEmailValidator.isValid();
    boolean passValid1 = mPassValidator1.isValid();
    boolean passValid2 = mPassValidator2.isValid();

    if (!emailValid) {
      mEmailInputLayout.setErrorEnabled(true);
      mEmailInputLayout.setError(getText(R.string.error_email));
    } else {
      mEmailInputLayout.setErrorEnabled(false);
    }

    if (!passValid1) {
      mPassInputLayout1.setErrorEnabled(true);
      mPassInputLayout1.setError(getText(R.string.error_pass));
    } else {
      mPassInputLayout1.setErrorEnabled(false);
    }

    if (!passValid2) {
      mPassInputLayout2.setErrorEnabled(true);
      mPassInputLayout2.setError(getText(R.string.error_pass));
    } else {
      mPassInputLayout2.setErrorEnabled(false);
    }

    if (emailValid && passValid1 && passValid2) {
      mActionsListener.setRegister(mEmailText.getText().toString(),
          mPassInput1.getText().toString(), mPassInput2.getText().toString());
    }
  }

  @OnClick(R.id.btn_back) void navigateToRegister() {
    this.getBackApp();
  }
}
