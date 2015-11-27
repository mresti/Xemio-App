package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.view.adapter.ViewPagerAdapter;
import es.mresti.xemio.app.view.fragment.InfoFragment;

public class InfoActivity extends BaseActivity {

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.fab_next) FloatingActionButton mFABNext;
  @Bind(R.id.fab_back) FloatingActionButton mFABBack;
  @Bind(R.id.fab_end) FloatingActionButton mFABEnd;
  @Bind(R.id.pager) ViewPager mPager;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, InfoActivity.class);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_info);
    ButterKnife.bind(this);
    this.initialize();
  }

  private void initialize() {
    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    final ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
    adapter.addFragment(InfoFragment.newInstance(getString(R.string.info_title_1)));
    adapter.addFragment(InfoFragment.newInstance(getString(R.string.info_title_2)));
    adapter.addFragment(InfoFragment.newInstance(getString(R.string.info_title_3)));
    adapter.addFragment(InfoFragment.newInstance(getString(R.string.info_title_4)));
    adapter.addFragment(InfoFragment.newInstance(getString(R.string.info_title_5)));
    adapter.addFragment(InfoFragment.newInstance(getString(R.string.info_title_6)));
    adapter.addFragment(InfoFragment.newInstance(getString(R.string.info_title_7)));
    mPager.setAdapter(adapter);

    mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (mPager.getCurrentItem() == 0) {
          mFABBack.hide();
          mFABEnd.hide();
          mFABNext.show();
        } else if (mPager.getCurrentItem() == 6) {
          mFABNext.hide();
          mFABEnd.show();
        } else {
          mFABBack.show();
          mFABEnd.hide();
          mFABNext.show();
        }
      }

      @Override public void onPageSelected(int position) {
      }

      @Override public void onPageScrollStateChanged(int state) {
      }
    });
  }

  @Override public void onBackPressed() {
    // Return to previous page when we press back button
    if (mPager.getCurrentItem() == 0) {
      super.onBackPressed();
    } else {
      mPager.setCurrentItem(mPager.getCurrentItem() - 1);
    }
  }

  @OnClick(R.id.fab_next) void navigateToNextPage() {
    mPager.setCurrentItem(mPager.getCurrentItem() + 1);
  }

  @OnClick(R.id.fab_back) void navigateToBackPage() {
    mPager.setCurrentItem(mPager.getCurrentItem() - 1);
  }

  @OnClick(R.id.fab_end) void navigateToDashboard() {
    finish();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    //getMenuInflater().inflate(R.menu.menu_incidence, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    if (id == android.R.id.home) {
      finish();
    }
    return super.onOptionsItemSelected(item);
  }
}
