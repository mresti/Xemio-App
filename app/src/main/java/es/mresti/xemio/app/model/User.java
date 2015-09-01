package es.mresti.xemio.app.model;

public class User {

  private String email;
  private String pass;
  private String fullName;
  private int age;
  private String idChemo;
  private String provider;

  private String displayName;

  public User() {
  }

  public User(String email, String pass) {
    this.email = email;
    this.pass = pass;
  }

  public String getEmail() {
    return email;
  }

  public String getPass() {
    return pass;
  }

  public String getFullName() {
    return fullName;
  }

  public int getAge() {
    return age;
  }

  public String getIdChemo() {
    return idChemo;
  }

  public String getDisplayName() {
    return displayName;
  }

  public String getProvider() {
    return provider;
  }
}
