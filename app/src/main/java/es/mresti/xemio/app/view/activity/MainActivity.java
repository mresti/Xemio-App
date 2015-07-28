package es.mresti.xemio.app.view.activity;

import android.os.Bundle;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;

/**
 * Main application screen. This is the app entry point.
 */
public class MainActivity extends BaseActivity {

  private Navigator mNavigator;

  @InjectView(R.id.btn_begin) Button mBtn_begin;
  @InjectView(R.id.btn_deny) Button mBtn_deny;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

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
  @OnClick(R.id.btn_begin) void navigateToLogUp() {
    this.mNavigator.navigateToUserRegister(this);
  }

  /**
   * Goes to the user LogIn screen.
   */
  @OnClick(R.id.btn_deny) void navigateToFinish() {
    finish();
  }
}
