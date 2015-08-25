package es.mresti.xemio.app.model;

public class User {

  public int userId;

  public String email;

  public String pass;

  public String alias;

  public int age;

  public int cancerId;

  public int chemoId;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getCancerId() {
    return cancerId;
  }

  public void setCancerId(int cancerId) {
    this.cancerId = cancerId;
  }

  public int getChemoId() {
    return chemoId;
  }

  public void setChemoId(int chemoId) {
    this.chemoId = chemoId;
  }
}
