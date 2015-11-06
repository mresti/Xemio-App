package es.mresti.xemio.app.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import es.mresti.xemio.R;
import es.mresti.xemio.app.model.DashboardIcon;

public class DashboardIconAdapter extends BaseAdapter {
  private Context mContext;

  static final DashboardIcon[] ICONS = {
      new DashboardIcon(R.drawable.ic_info_black_48dp, "Información", "ic_info_black_48dp.png"),
      new DashboardIcon(R.drawable.ic_assignment_black_48dp, "Tratamientos",
          "ic_assignment_black_48dp.png"),
      new DashboardIcon(R.drawable.ic_assignment_late_black_48dp, "Efectos",
          "ic_assignment_late_black_48dp.png"),
      new DashboardIcon(R.drawable.ic_add_circle_black_48dp, "Incidencia",
          "ic_add_circle_black_48dp.png"),
      new DashboardIcon(R.drawable.ic_event_note_black_48dp, "Historial",
          "ic_event_note_black_48dp.png"),
      new DashboardIcon(R.drawable.ic_settings_black_48dp, "Web", "ic_settings_black_48dp.png"),
  };

  public DashboardIconAdapter(Context c) {
    mContext = c;
  }

  @Override public int getCount() {
    return ICONS.length;
  }

  @Override public DashboardIcon getItem(int position) {
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