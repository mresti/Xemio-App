package es.mresti.xemio.app.view.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

  @InjectView(R.id.toolbar)
  Toolbar mtoolbar;

  @InjectView(R.id.btn_LogUp) Button mBtn_LogUp;
  @InjectView(R.id.btn_LogIn) Button mBtn_LogIn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
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
    setSupportActionBar(mtoolbar);
  }

  /**
   * Goes to the user LogUp screen.
   */
  @OnClick(R.id.btn_LogUp)
  void navigateToLogUp() {
    this.mNavigator.navigateToUserLogUp(this);
  }

  /**
   * Goes to the user LogIn screen.
   */
  @OnClick(R.id.btn_LogIn)
  void navigateToLogIn() {
    this.mNavigator.navigateToUserLogIn(this);
  }

}
