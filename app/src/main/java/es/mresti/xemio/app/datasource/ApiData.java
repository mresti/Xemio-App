package es.mresti.xemio.app.datasource;

import es.mresti.xemio.app.model.User;

public interface ApiData {

  void addIncidence(String subject, String description);

  void createUser(User user);

  boolean existUserByEmail(String email);

  User retrieveUser(String email);
}
