package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Bind;
import butterknife.ButterKnife;
import es.mresti.xemio.R;
import es.mresti.xemio.app.view.fragment.AdviceDetailFragment;

public class AdviceDetailActivity extends BaseActivity {

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;

  public static Intent getCallingIntent(Context context, String key, String effect) {
    Intent callingIntent = new Intent(context, AdviceDetailActivity.class);
    callingIntent.putExtra("EFFECT_ID", key);
    callingIntent.putExtra("EFFECT_NAME", effect);
    return callingIntent;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent intent = getIntent();
    String mEffectID = intent.getStringExtra("EFFECT_ID");
    String mEffectName = intent.getStringExtra("EFFECT_NAME");
    setContentView(R.layout.activity_advice_detail);
    ButterKnife.bind(this);
    this.initialize();

    AdviceDetailFragment detail =
        (AdviceDetailFragment) getSupportFragmentManager().findFragmentById(
            R.id.fragmentAdviceDetail);
    detail.showDetail(mEffectID, mEffectName);
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


