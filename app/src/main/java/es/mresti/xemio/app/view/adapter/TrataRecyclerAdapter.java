package es.mresti.xemio.app.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import es.mresti.xemio.R;
import es.mresti.xemio.app.datasource.DataTestApp;
import es.mresti.xemio.app.model.SampleModel;
import java.util.ArrayList;

public class TrataRecyclerAdapter extends RecyclerView.Adapter<TrataRecyclerAdapter.ViewHolder> {
  private final ArrayList<SampleModel> sampleData = DataTestApp.getSampleData(12);

  @Override public ViewHolder onCreateViewHolder(ViewGroup parentViewGroup, int i) {

    View rowView = LayoutInflater.from(parentViewGroup.getContext())
        .inflate(R.layout.list_trata_item, parentViewGroup, false);

    return new ViewHolder(rowView);
  }

  @Override public void onBindViewHolder(ViewHolder viewHolder, final int position) {

    final SampleModel rowData = sampleData.get(position);
    viewHolder.textViewSample.setText(rowData.getSampleText());

    viewHolder.itemView.setTag(rowData);
  }

  @Override public int getItemCount() {

    return sampleData.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {

    private final TextView textViewSample;

    public ViewHolder(View itemView) {
      super(itemView);

      textViewSample = (TextView) itemView.findViewById(R.id.textViewSample);
    }
  }
}

