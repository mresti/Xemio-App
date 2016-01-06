package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.InfoContract;
import es.mresti.xemio.app.view.adapter.ViewPagerAdapter;
import es.mresti.xemio.app.view.fragment.InfoFragment;

public class InfoActivity extends BaseActivity implements InfoContract.View {

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
    mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        onBackPressed();
      }
    });

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
          showFABInit();
        } else if (mPager.getCurrentItem() == 6) {
          showFABEnd();
        } else {
          showFABNext();
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

  @Override public void showFABNext() {
    mFABBack.show();
    mFABEnd.hide();
    mFABNext.show();
  }

  @Override public void showFABEnd() {
    mFABNext.hide();
    mFABEnd.show();
  }

  @Override public void showFABInit() {
    mFABBack.hide();
    mFABEnd.hide();
    mFABNext.show();
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
}
