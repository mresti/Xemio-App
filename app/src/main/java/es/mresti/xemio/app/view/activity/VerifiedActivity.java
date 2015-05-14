package es.mresti.xemio.app.view.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;

public class VerifiedActivity extends BaseActivity {

  private Navigator mNavigator;

  @InjectView(R.id.toolbar)
  Toolbar mtoolbar;

  @InjectView(R.id.btn_verified)
  Button mBtn_verify;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, VerifiedActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_verified);

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
   * Goes to the user cancer screen.
   */
  @OnClick(R.id.btn_verified)
  void navigateToCancer() {
    this.mNavigator.navigateToCancer(this);
  }
}
