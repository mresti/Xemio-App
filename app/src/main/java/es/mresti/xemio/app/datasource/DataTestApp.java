package es.mresti.xemio.app.datasource;

import java.util.ArrayList;

public class DataTestApp {
  public static ArrayList<SampleModel> getSampleData(int size) {

    ArrayList<SampleModel> sampleData = new ArrayList<SampleModel>(size);

    sampleData.add(new SampleModel("Android 1.0 Apple Pie"));
    sampleData.add(new SampleModel("Android 1.1 Banana Bread"));
    sampleData.add(new SampleModel("Android 1.5 Cupcake"));
    sampleData.add(new SampleModel("Android 1.6 Donut"));
    sampleData.add(new SampleModel("Android 2.0/2.1 Eclair"));
    sampleData.add(new SampleModel("Android 2.2 Froyo"));
    sampleData.add(new SampleModel("Android 2.3 Gingerbread"));
    sampleData.add(new SampleModel("Android 3.x Honeycomb"));
    sampleData.add(new SampleModel("Android 4.0.x Ice Cream Sandwich"));
    sampleData.add(new SampleModel("Android 4.1/4.2/4.3 Jelly Bean"));
    sampleData.add(new SampleModel("Android 5.0/5.1 Lollipop"));
    sampleData.add(new SampleModel("Android 6.0 Marshmallow"));

    return sampleData;
  }
}
