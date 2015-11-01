package es.mresti.xemio.app.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.view.activity.MainActivity;
import es.mresti.xemio.app.view.utils.Preferences;

public class SettingsFragment extends PreferenceFragmentCompat {

  //Log out Preference
  private static Preference logOutPref;

  @Override public void onCreatePreferences(Bundle bundle, String s) {
    addPreferencesFromResource(R.xml.settings_view);

    LogOutButton();
  }

  private void LogOutButton() {
    final Context ctx = getPreferenceManager().getContext(); // this is the material styled context

    logOutPref = findPreference(Preferences.LOGOUTPREF);

    logOutPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {

      @Override public boolean onPreferenceClick(Preference preference) {
        Firebase mFirebaseRef = new Firebase(getString(R.string.firebase_url));
        mFirebaseRef.unauth();

        startActivity(new Intent(getActivity(), MainActivity.class).addFlags(
            Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP)
            .putExtra("fromPreference", true));

        getActivity().finish();
        return true;
      }
    });
  }
}

