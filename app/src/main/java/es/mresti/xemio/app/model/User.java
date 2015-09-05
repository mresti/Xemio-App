package es.mresti.xemio.app.model;

public class User {

  private String email;
  private String pass;
  private String fullName;
  private int age;
  private String idChemo;
  private String provider;

  public User() {
  }

  public User(String email, String pass) {
    this.email = email;
    this.pass = pass;
  }

  public User(String fullName, int age, String idChemo, String provider) {
    this.fullName = fullName;
    this.age = age;
    this.idChemo = idChemo;
    this.provider = provider;
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

  public String getProvider() {
    return provider;
  }
}
