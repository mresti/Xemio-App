package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.Bind;
import butterknife.ButterKnife;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.DashboardContract;
import es.mresti.xemio.app.presenter.DashboardPresenter;
import es.mresti.xemio.app.view.fragment.HistoryListFragment;
import es.mresti.xemio.app.view.fragment.InfoListFragment;
import es.mresti.xemio.app.view.navigation.Navigator;

public class DashboardActivity extends BaseActivity implements DashboardContract.View {

  private DashboardContract.UserActionsListener mActionsListener;
  private Navigator mNavigator;
  private int badgeCount = 1;

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
    mActionsListener.getUserStatus();
    setSupportActionBar(mToolbar);

    /**
     * Create SectionPagerAdapter, set it as adapter to viewPager with setOffscreenPageLimit(3)
     **/
    if (mViewPager != null) {
      //setupViewPager(mViewPager);
      SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
      mViewPager.setOffscreenPageLimit(3);
      mViewPager.setAdapter(adapter);
    }

    /**
     * Setup the mTabLayout with view pager
     */
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

  @Override public void onDestroy() {
    super.onDestroy();
  }

  @Override public void openMain() {
    mNavigator.navigateToMain(this);
    finish();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);

    //ActionItemBadge.update(this, menu.findItem(R.id.action_notification),
    //    GoogleMaterial.Icon.gmd_notifications, ActionItemBadge.BadgeStyles.DARK_GREY, badgeCount);

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

    if (id == R.id.action_chat) {
      mNavigator.navigateToNewChat(this);
    }

    if (id == R.id.action_incidence) {
      mNavigator.navigateToNewIncidence(this);
    }

    if (id == R.id.action_logout) {
      showLogoutDialog();
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  private void logout_user() {
    mActionsListener.getUserLogout();
    mNavigator.navigateToMain(this);
    finish();
  }

  private void showLogoutDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
    builder.setTitle(getString(R.string.dialog_logout_title));
    builder.setMessage(getString(R.string.dialog_logout_desc));

    String positiveText = getString(android.R.string.ok);
    builder.setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
      @Override public void onClick(DialogInterface dialog, int which) {
        // positive button logic
        logout_user();
      }
    });

    String negativeText = getString(android.R.string.cancel);
    builder.setNegativeButton(negativeText, new DialogInterface.OnClickListener() {
      @Override public void onClick(DialogInterface dialog, int which) {
        // negative button logic
      }
    });

    AlertDialog dialog = builder.create();
    // display dialog
    dialog.show();
  }

  /**
   * SectionPagerAdapter class that extends FragmentStatePagerAdapter to save fragments state
   */
  public class SectionPagerAdapter extends FragmentStatePagerAdapter {

    public SectionPagerAdapter(FragmentManager fm) {
      super(fm);
    }

    /**
     * Use positions (0 and 1) to find and instantiate fragments with newInstance()
     */
    @Override public Fragment getItem(int position) {

      Fragment fragment = null;

      /**
       * Set fragment to different fragments depending on position in ViewPager
       */
      switch (position) {
        case 0:
          fragment = HistoryListFragment.newInstance();
          break;
        case 1:
        default:
          fragment = InfoListFragment.newInstance();
          break;
      }

      return fragment;
    }

    @Override public int getCount() {
      return 2;
    }

    /**
     * Set string resources as titles for each fragment by it's position
     */
    @Override public CharSequence getPageTitle(int position) {
      switch (position) {
        case 0:
          return getString(R.string.pager_title_1);
        case 1:
        default:
          return getString(R.string.pager_title_2);
      }
    }
  }
}
