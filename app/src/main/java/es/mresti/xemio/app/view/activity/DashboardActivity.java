package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.view.DashboardView;

public class DashboardActivity extends BaseActivity
    implements DashboardView, AdapterView.OnItemClickListener {
  private static final String mLOGTAG = "LogsAndroid";
  private Navigator mNavigator;
  static final String EXTRA_MAP = "map";
  static final LauncherIcon[] ICONS = {
      new LauncherIcon(R.drawable.ic_info_black_48dp, "Información", "ic_info_black_48dp.png"),
      new LauncherIcon(R.drawable.ic_assignment_black_48dp, "Tratamientos",
          "ic_assignment_black_48dp.png"),
      new LauncherIcon(R.drawable.ic_add_circle_black_48dp, "Incidencia",
          "ic_add_circle_black_48dp.png"),
      new LauncherIcon(R.drawable.ic_event_note_black_48dp, "Historial",
          "ic_event_note_black_48dp.png"),
      new LauncherIcon(R.drawable.ic_settings_black_48dp, "Ajustes", "ic_settings_black_48dp.png"),
      new LauncherIcon(R.drawable.ic_public_black_48dp, "Web", "ic_public_black_48dp.png"),
  };

  // UI items
  @InjectView(R.id.toolbar) Toolbar mToolbar;
  //@InjectView(R.id.btn_inci) Button mBtn_inci;
  //@InjectView(R.id.btn_web) Button mBtn_web;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, DashboardActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
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

    Snackbar.make(findViewById(R.id.main_content), "¡¡Bienvenido <alias>!!", Snackbar.LENGTH_LONG)
        .setAction("Action", null)
        .show();

    GridView gridview = (GridView) findViewById(R.id.dashboard_grid);
    gridview.setAdapter(new ImageAdapter(this));
    gridview.setOnItemClickListener(this);

    // Hack to disable GridView scrolling
    gridview.setOnTouchListener(new View.OnTouchListener() {
      @Override public boolean onTouch(View v, MotionEvent event) {
        return event.getAction() == MotionEvent.ACTION_MOVE;
      }
    });
  }

  /**
   * Goes to the xemio website.
   */
  //@OnClick(R.id.btn_web)
  void navigateToXemioWeb() {
    this.mNavigator.navigateToXemioWeb(this);
  }

  /**
   * Goes to the incidence screen.
   */
  //@OnClick(R.id.btn_inci)
  void navigateToIncidence() {
    this.mNavigator.navigateToNewIncidence(this);
  }

  @Override public void showProgress() {

  }

  @Override public void hideProgress() {

  }

  @Override public void setUsernameError() {

  }

  @Override public void setPasswordError() {

  }

  @Override public void navigateToHome() {

  }

  @Override public void showLoading() {

  }

  @Override public void hideLoading() {

  }

  @Override public void showRetry() {

  }

  @Override public void hideRetry() {

  }

  @Override public void showError(String message) {

  }

  @Override public Context getContext() {
    return null;
  }

  @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    Log.w(mLOGTAG, "item pulsado");
    Log.w(mLOGTAG, Integer.toString(position));
    switch (position) {
      case 0:
        break;
      case 1:
        break;
      case 2:
        this.mNavigator.navigateToNewIncidence(this);
        break;
      case 3:
        break;
      case 4:
        break;
      case 5:
        this.mNavigator.navigateToXemioWeb(this);
        break;
      default:
        break;
    }
  }

  static class LauncherIcon {
    final String text;
    final int imgId;
    final String map;

    public LauncherIcon(int imgId, String text, String map) {
      super();
      this.imgId = imgId;
      this.text = text;
      this.map = map;
    }
  }

  static class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
      mContext = c;
    }

    @Override public int getCount() {
      return ICONS.length;
    }

    @Override public LauncherIcon getItem(int position) {
      return null;
    }

    @Override public long getItemId(int position) {
      return 0;
    }

    static class ViewHolder {
      public ImageView icon;
      public TextView text;
    }

    // Create a new ImageView for each item referenced by the Adapter
    @Override public View getView(int position, View convertView, ViewGroup parent) {
      View v = convertView;
      ViewHolder holder;
      if (v == null) {
        LayoutInflater vi =
            (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        v = vi.inflate(R.layout.icon_dashboard, null);
        holder = new ViewHolder();
        holder.text = (TextView) v.findViewById(R.id.dashboard_icon_text);
        holder.icon = (ImageView) v.findViewById(R.id.dashboard_icon_img);
        v.setTag(holder);
      } else {
        holder = (ViewHolder) v.getTag();
      }

      holder.icon.setImageResource(ICONS[position].imgId);
      holder.text.setText(ICONS[position].text);

      return v;
    }
  }
}
