package com.hexaware.MLP269.persistence;

import org.skife.jdbi.v2.DBI;

/**
 */
public class DbConnection {
    /**
     * Connecting to MYSQL DB.
     * @return database Connection.
     */
  public final DBI getConnect() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String dbc = System.getenv("DB_CONNECTION");
      String queryString = "/MLP269V1?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
      if (dbc == null || dbc.equals("")) {
        dbc = "localhost:3306";
      }
      DBI dbi = new DBI("jdbc:mysql://" + dbc + queryString, "MLP269V1", "MLP269V1");
      return dbi;
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
