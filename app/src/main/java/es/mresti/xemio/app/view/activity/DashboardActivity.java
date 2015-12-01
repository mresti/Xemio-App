package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.DashboardContract;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.DashboardPresenter;
import es.mresti.xemio.app.view.adapter.DashboardViewPagerAdapter;
import es.mresti.xemio.app.view.fragment.CheeseListFragment;
import es.mresti.xemio.app.view.fragment.InfoListFragment;

public class DashboardActivity extends BaseActivity implements DashboardContract.View {

  private DashboardContract.UserActionsListener mActionsListener;
  private Navigator mNavigator;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.viewpager) ViewPager mViewPager;
  @Bind(R.id.tabs) TabLayout mTabLayout;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, DashboardActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dashboard);
    ButterKnife.bind(this);
    this.initialize();
  }

  private void initialize() {
    mNavigator = new Navigator();
    mActionsListener = new DashboardPresenter(this);
    mActionsListener.initializeActions(this.getContext());
    mActionsListener.getUserStatus();
    setSupportActionBar(mToolbar);
    if (mViewPager != null) {
      setupViewPager(mViewPager);
    }
    mTabLayout.setupWithViewPager(mViewPager);
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

  @Override public void openMain() {
    mNavigator.navigateToMain(this);
    finish();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    if (id == R.id.action_notification) {
      mNavigator.navigateToNotifications(this);
    }

    if (id == R.id.action_incidence) {
      mNavigator.navigateToNewIncidence(this);
    }

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_logout) {
      //Goes to the settings screen.
      Firebase mFirebaseRef = new Firebase(getString(R.string.firebase_url));
      mFirebaseRef.unauth();

      startActivity(new Intent(getContext(), MainActivity.class).addFlags(
          Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP)
          .putExtra("fromDashboard", true));
      finish();
      return true;
    }

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      //Goes to the settings screen.
      mNavigator.navigateToSettings(this);
      finish();
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  private void setupViewPager(ViewPager viewPager) {
    DashboardViewPagerAdapter adapter = new DashboardViewPagerAdapter(getSupportFragmentManager());
    adapter.addFragment(new CheeseListFragment(), "Mensajes");
    adapter.addFragment(new CheeseListFragment(), "Historial");
    adapter.addFragment(new InfoListFragment(), "Información");
    viewPager.setAdapter(adapter);
  }
}
