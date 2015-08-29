package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.view.utils.Preferences;

public class SettingsActivity extends PreferenceActivity {

  private AppCompatDelegate mDelegate;
  private Navigator mNavigator;

  /**
   * Log out Preference
   */
  private static Preference logOutPref;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, SettingsActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    this.mNavigator = new Navigator();
    getDelegate().installViewFactory();
    getDelegate().onCreate(savedInstanceState);
    super.onCreate(savedInstanceState);
    setToolbar();
    addPreferencesFromResource(R.xml.settings_view);

    logOutPref = findPreference(Preferences.LOGOUTPREF);

    logOutPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {

      @Override public boolean onPreferenceClick(Preference preference) {
        Firebase mFirebaseRef = new Firebase(getString(R.string.firebase_url));
        mFirebaseRef.unauth();

        startActivity(new Intent(getBaseContext(), MainActivity.class).addFlags(
            Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP)
            .putExtra("fromPreference", true));

        finish();
        return true;
      }
    });
  }

  @Override public void onBackPressed() {
    // Return to previous page when we press back button
    this.mNavigator.navigateToDashboard(this);
    finish();
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
