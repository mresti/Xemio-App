package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import butterknife.InjectView;
import es.mresti.xemio.R;

public class SettingsActivity extends PreferenceActivity {

  private AppCompatDelegate mDelegate;

  @InjectView(R.id.toolbar) Toolbar mToolbar;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, SettingsActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    getDelegate().installViewFactory();
    getDelegate().onCreate(savedInstanceState);
    super.onCreate(savedInstanceState);
    setToolbar();
    addPreferencesFromResource(R.xml.settings_view);
  }

  @Override protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    getDelegate().onPostCreate(savedInstanceState);
  }

  @Override public MenuInflater getMenuInflater() {
    return getDelegate().getMenuInflater();
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      onBackPressed();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override public void setContentView(@LayoutRes int layoutResID) {
    getDelegate().setContentView(layoutResID);
  }

  @Override public void onResume() {
    super.onResume();
  }

  @Override public void onPause() {
    super.onPause();
  }

  @Override protected void onPostResume() {
    super.onPostResume();
    getDelegate().onPostResume();
  }

  @Override protected void onStop() {
    super.onStop();
    getDelegate().onStop();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    getDelegate().onDestroy();
  }

  private void setToolbar() {
    setContentView(R.layout.activity_settings);
    setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
    getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME |
        ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_TITLE);
  }

  private ActionBar getSupportActionBar() {
    return getDelegate().getSupportActionBar();
  }

  private void setSupportActionBar(@Nullable Toolbar toolbar) {
    getDelegate().setSupportActionBar(toolbar);
  }

  private AppCompatDelegate getDelegate() {
    if (mDelegate == null) {
      mDelegate = AppCompatDelegate.create(this, null);
    }
    return mDelegate;
  }
}
