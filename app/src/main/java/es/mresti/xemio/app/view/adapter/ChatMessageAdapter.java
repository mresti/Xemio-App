package es.mresti.xemio.app.view.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.firebase.client.Query;
import es.mresti.xemio.R;
import es.mresti.xemio.app.model.Chat;

public class ChatMessageAdapter extends FirebaseListAdapter<Chat> {
  private String mUsername;

  public ChatMessageAdapter(Query ref, Activity activity, int layout, String mUsername) {
    super(ref, Chat.class, layout, activity);
    this.mUsername = mUsername;
  }

  @Override protected void populateView(View v, Chat model) {
    String author = model.getAuthor();

    TextView authorText = (TextView) v.findViewById(R.id.author);
    authorText.setText(author + ": ");
    // If the message was sent by this user, color it differently
    if (author != null && author.equals(mUsername)) {
      authorText.setTextColor(Color.RED);
    } else {
      authorText.setTextColor(Color.BLUE);
    }
    ((TextView) v.findViewById(R.id.message)).setText(model.getMessage());
  }
}
