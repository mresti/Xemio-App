package es.mresti.xemio.app.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
  private final List<Fragment> mFragments = new ArrayList<>();

  public ViewPagerAdapter(FragmentManager fm) {
    super(fm);
  }

  public void addFragment(Fragment fragment) {
    mFragments.add(fragment);
  }

  @Override public Fragment getItem(int position) {
    return mFragments.get(position);
  }

  @Override public int getCount() {
    return mFragments.size();
  }
}

