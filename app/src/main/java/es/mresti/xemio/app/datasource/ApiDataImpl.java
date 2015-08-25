package es.mresti.xemio.app.datasource;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.model.User;

public class ApiDataImpl implements ApiData {

  private Firebase myFirebaseRef;

  public ApiDataImpl(Context c) {
    Firebase.setAndroidContext(c);
    myFirebaseRef = new Firebase("https://<YOUR-FIREBASE-APP>.firebaseio.com/");
  }

  @Override public void addIncidence(String subject, String description) {
    myFirebaseRef.child("message1").setValue("Do you havea? You'll love Firebasasase.1");
    myFirebaseRef.child("message2").setValue("Do you have? You'll love Firebasasase.2");
  }

  @Override public void createUser(User user) {

  }

  @Override public boolean existUserByEmail(String email) {
    return false;
  }

  @Override public User retrieveUser(String email) {
    return null;
  }
}
