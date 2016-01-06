package es.mresti.xemio.app.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Base {@link android.app.Activity} class for every Activity in this application.
 */
public abstract class BaseActivity extends AppCompatActivity {

  @Override public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
  }

  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
  }
}
