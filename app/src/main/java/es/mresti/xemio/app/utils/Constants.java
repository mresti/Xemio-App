package es.mresti.xemio.app.utils;

import es.mresti.xemio.BuildConfig;

/**
 * Constants class store most important strings and paths of the app
 */
public final class Constants {

  /**
   * Constants for Firebase object properties
   */
  public static final String FIREBASE_PROPERTY_CHEMO = "idChemo";
  public static final String FIREBASE_PROPERTY_PROVIDER = "provider";
  public static final String FIREBASE_PROPERTY_NAME = "displayName";
  public static final String FIREBASE_PROPERTY_FULLNAME = "fullName";
  public static final String FIREBASE_PROPERTY_AGE = "age";

  public static final String FIREBASE_PROPERTY_TIMESTAMP = "timestamp";

  /**
   * Constants for Firebase URL
   */
  public static final String FIREBASE_URL = BuildConfig.UNIQUE_FIREBASE_ROOT_URL;

  /**
   * Constants for nodes
   */
  public static final String FIREBASE_NODE_FOUNDATION = "foundation";
  public static final String FIREBASE_NODE_CHAT = "chat";
  public static final String FIREBASE_NODE_CHANNEL = "channel";
  public static final String FIREBASE_NODE_INCIDENCE = "incidences";
  public static final String FIREBASE_NODE_CHEMO = "chemo";
  public static final String FIREBASE_NODE_USERS = "users";
  public static final String FIREBASE_NODE_EFFECTS = "effects";
  public static final String FIREBASE_NODE_HISTORICAL = "historical";
  public static final String FIREBASE_NODE_NOTIFICATION = "notifications";
  public static final String FIREBASE_NODE_TREATMENT = "treatments";

  /**
   * Constants for bundles, extras and shared preferences keys
   */
  public static final String KEY_CHAT_ID = "CHAT_ID";

  /**
   * Constant for errors
   */
  public static final String USER_DOES_NOT_EXIST = "El usuario no existe";
  public static final String USER_EXIST = "El usuario ya existe";
  public static final String INVALID_PASSWORD = "Contraseña inválida";
  public static final String INVALID_EMAIL = "Email inválido";
  public static final String INVALID_CREDENTIAL = "Credenciales inválidas";
  public static final String OTHER_ERROR = "¡Sin conexión a internet!";

  public static final String ORDER_BY_KEY = "orderByPushKey";
}
