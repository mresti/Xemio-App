package es.mresti.xemio.app.view.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.view.adapter.ViewPagerAdapter;
import es.mresti.xemio.app.view.fragment.HomeTab;
import es.mresti.xemio.app.view.fragment.HistoryTab;
import es.mresti.xemio.app.view.fragment.CalendarTab;

public class DashboardActivity extends BaseActivity {
  private static final String mLOGTAG = "LogsAndroid";

  private Navigator mNavigator;

  @InjectView(R.id.toolbar) Toolbar mToolbar;

  @InjectView(R.id.viewpager) ViewPager mViewPager;

  @InjectView(R.id.fab) FloatingActionButton fab;

  @InjectView(R.id.tabs) TabLayout mTabLayout;

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
    setSupportActionBar(mToolbar);
    Log.i(mLOGTAG, "estoy en el inicialize");

    if (mViewPager != null) {
      setupViewPager(mViewPager);
    }


    Snackbar.make(findViewById(R.id.main_content), "¡¡Bienvenido <alias>!!",
        Snackbar.LENGTH_LONG).setAction("Action", null).show();
    /*
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
      }
    });*/

    mTabLayout.setupWithViewPager(mViewPager);
  }

  /**
   * Goes to the dashboard screen.
   */
  @OnClick(R.id.fab)
  void navigateToIncidence() {
    Log.e(mLOGTAG, "Estoy en navigatetoincidence");
    this.mNavigator.navigateToNewIncidence(this);
  }



  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private void setupViewPager(ViewPager viewPager) {
    ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
    adapter.addFragment(new HomeTab(), "Inicio");
    adapter.addFragment(new HistoryTab(), "Historial");
    adapter.addFragment(new CalendarTab(), "Calendario");
    viewPager.setAdapter(adapter);
  }

}
