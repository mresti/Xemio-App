package es.mresti.xemio.app.view.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;
import butterknife.InjectView;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;

public class DashboardActivity extends BaseActivity {

  private Navigator mNavigator;

  @InjectView(R.id.toolbar)
  Toolbar mtoolbar;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, DashboardActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dashboard);

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

}
