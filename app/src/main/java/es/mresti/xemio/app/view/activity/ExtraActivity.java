package es.mresti.xemio.app.view.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;

public class ExtraActivity extends BaseActivity {
  private Navigator mNavigator;

  // The input field where the user enters his email.
  @InjectView(R.id.ageInput)
  EditText mAgeInput;

  // The input field where the user enters his email.
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
  }

  /**
   * Goes to the dashboard screen.
   */
  @OnClick(R.id.btn_next)
  void navigateToVerified() {
    this.mNavigator.navigateToDashboard(this);
  }
}
