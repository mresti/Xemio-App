package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;

public class RegisterActivity extends BaseActivity {

  private static final String mLOGTAG = "LogsAndroid";

  private Navigator mNavigator;

  @InjectView(R.id.btn_login) Button mBtn_login;
  @InjectView(R.id.btn_logup) Button mBtn_logup;
  @InjectView(R.id.btn_deny) Button mBtn_deny;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, RegisterActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);

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
   * Goes to the user LogIn screen.
   */
  @OnClick(R.id.btn_deny) void navigateToFinish() {
    finish();
  }

  /**
   * Goes to the user LogIn screen.
   */
  @OnClick(R.id.btn_login) void navigateToLogIn() {
    this.mNavigator.navigateToUserLogIn(this);
  }

  /**
   * Goes to the user LogUp screen.
   */
  @OnClick(R.id.btn_logup) void navigateToLogUp() {
    this.mNavigator.navigateToUserLogUp(this);
  }
}
