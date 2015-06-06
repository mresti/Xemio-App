package es.mresti.xemio.app.view.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.view.validator.EmailValidator;
import es.mresti.xemio.app.view.validator.NumericValidator;

public class ExtraActivity extends BaseActivity {
  private Navigator mNavigator;

  private static final String mLOGTAG = "LogsAndroid";

  // The input field where the user enters his age.
  @InjectView(R.id.ageInput)
  EditText mAgeInput;

  @InjectView(R.id.ageInputLayout)
  TextInputLayout mAgeInputLayout;

  // The validator for the age input field.
  private NumericValidator mNumericValidator;

  // The input field where the user enters his description.
  @InjectView(R.id.extraInput)
  EditText mExtraInput;

  @InjectView(R.id.btn_next)
  Button btn_next;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, ExtraActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_extra);

    ButterKnife.inject(this);
    this.initialize();
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    this.mNavigator = new Navigator();

    // Setup field validators.
    mNumericValidator = new NumericValidator();
    mAgeInput.addTextChangedListener(mNumericValidator);
  }

  /**
   * Goes to the dashboard screen.
   */
  @OnClick(R.id.btn_next)
  void navigateToVerified() {
    if (!mNumericValidator.isValid()) {
      mAgeInputLayout.setError(getText(R.string.error_age));
      Log.w(mLOGTAG, "Not saving personal information: Invalid age");
    }else{
      this.mNavigator.navigateToDashboard(this);
    }
  }
}
