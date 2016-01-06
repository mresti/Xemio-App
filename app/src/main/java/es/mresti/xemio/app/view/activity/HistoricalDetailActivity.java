package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Bind;
import butterknife.ButterKnife;
import es.mresti.xemio.R;
import es.mresti.xemio.app.view.fragment.HistoricalDetailFragment;

public class HistoricalDetailActivity extends BaseActivity {

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;

  public static Intent getCallingIntent(Context context, String key) {
    Intent callingIntent = new Intent(context, HistoricalDetailActivity.class);
    callingIntent.putExtra("EFFECT_ID", key);
    return callingIntent;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent intent = getIntent();
    String mEffectID = intent.getStringExtra("EFFECT_ID");
    setContentView(R.layout.activity_historical_detail);
    ButterKnife.bind(this);
    this.initialize();

    HistoricalDetailFragment detail =
        (HistoricalDetailFragment) getSupportFragmentManager().findFragmentById(
            R.id.fragmentHistoricalDetail);
    detail.showDetail(mEffectID);
  }

  private void initialize() {
    mToolbar.setTitle(R.string.toolbar_title_effect_detail);
    mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        onBackPressed();
      }
    });
  }
}
