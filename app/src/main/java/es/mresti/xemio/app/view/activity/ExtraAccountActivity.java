package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.ExtraAccountContract;
import es.mresti.xemio.app.presenter.ExtraAccountPresenter;
import es.mresti.xemio.app.view.navigation.Navigator;
import es.mresti.xemio.app.view.validator.AlphaNumericValidator;
import es.mresti.xemio.app.view.validator.NumericValidator;

public class ExtraAccountActivity extends BaseActivity implements ExtraAccountContract.View {

  private ExtraAccountContract.UserActionsListener mActionsListener;
  private Navigator mNavigator;
  private AlphaNumericValidator mAlphaNumericValidator;
  private NumericValidator mNumericValidator;

  // UI items
  @Bind(R.id.btn_next) Button mBtn_next;
  @Bind(R.id.progress) ProgressBar mProgress;
  @Bind(R.id.aliasInput) EditText mAliasText;
  @Bind(R.id.aliasInputLayout) TextInputLayout mAliasInputLayout;
  @Bind(R.id.ageInput) EditText mAgeInput;
  @Bind(R.id.ageInputLayout) TextInputLayout mAgeInputLayout;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, ExtraAccountActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_extra);
    ButterKnife.bind(this);
    this.initialize();
  }

  private void initialize() {
    mNavigator = new Navigator();
    mActionsListener = new ExtraAccountPresenter(this);

    // Setup field validators.
    mAlphaNumericValidator = new AlphaNumericValidator();
    mAliasText.addTextChangedListener(mAlphaNumericValidator);
    mNumericValidator = new NumericValidator();
    mAgeInput.addTextChangedListener(mNumericValidator);
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

  @Override public void openChemo() {
    mNavigator.navigateToChemoAccount(this);
    finish();
  }

  @Override public void setUsernameError() {
    mAliasInputLayout.setErrorEnabled(true);
    mAliasInputLayout.setError(getString(R.string.error_empty_field));
  }

  @Override public void setAgeError() {
    mAgeInputLayout.setErrorEnabled(true);
    mAgeInputLayout.setError(getString(R.string.error_age));
  }

  @OnClick(R.id.btn_next) void navigateToChemo() {
    boolean aliasValid = mAlphaNumericValidator.isValid();
    boolean ageValid = mNumericValidator.isValid();

    if (!aliasValid) {
      mAliasInputLayout.setErrorEnabled(true);
      mAliasInputLayout.setError(getText(R.string.error_empty_field));
    } else {
      mAliasInputLayout.setErrorEnabled(false);
    }

    if (!ageValid) {
      mAgeInputLayout.setErrorEnabled(true);
      mAgeInputLayout.setError(getText(R.string.error_age));
    } else {
      mAgeInputLayout.setErrorEnabled(false);
    }

    if (aliasValid && ageValid) {
      mActionsListener.setRegisterExtra(mAliasText.getText().toString(),
          mAgeInput.getText().toString());
    }
  }
}
