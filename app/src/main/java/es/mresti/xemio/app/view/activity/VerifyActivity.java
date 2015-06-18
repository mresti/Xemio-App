package es.mresti.xemio.app.view.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;

public class VerifyActivity extends BaseActivity {

  private Navigator mNavigator;

  @InjectView(R.id.btn_verify)
  Button mBtn_verify;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, VerifyActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_verify);

    ButterKnife.inject(this);
    this.initialize();
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    this.mNavigator = new Navigator();
    Snackbar.make(findViewById(R.id.rootLayout), "Se le ha enviado un email",
        Snackbar.LENGTH_LONG).setAction("Action", null).show();
  }

  /**
   * Goes to the user verified screen.
   */
  @OnClick(R.id.btn_verify)
  void navigateToVerified() {
    this.mNavigator.navigateToVerified(this);
  }
}
