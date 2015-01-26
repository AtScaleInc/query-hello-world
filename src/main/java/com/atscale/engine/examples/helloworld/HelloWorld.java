/*
 * Copyright AtScale, Inc. 2014. All Rights Reserved.
 *
 * No part of this project or any of its contents may be reproduced, copied,
 * modified or adapted, without the prior written consent of AtScale, Inc..
 */

package com.atscale.engine.examples.helloworld;

import java.sql.*;

/**
 * Simple example of using the AtScale Engine via JDBC.
 * Example: $ mvn clean compile exec:java -Dexec.mainClass="com.atscale.engine.examples.helloworld.HelloWorld" -Dexec.args="192.168.99.test_export"
 * Reference: https://cwiki.apache.org/confluence/display/Hive/HiveServer2+Clients
 */
public class HelloWorld {

  private static String SQL_QUERY =
    "SELECT " +
    "`C_53616c657320496e7369676874732043756265`.`Gender` AS `C_6e6f6e655f67656e6465725f6e6b`, " +
    "SUM(`C_53616c657320496e7369676874732043756265`.`orderquantity`) AS `C_73756d5f6f726465727175616e746974795f6f6b` " +
    "FROM " +
    "`Internet Sales Insights`.`sales insights cube` `C_53616c657320496e7369676874732043756265` " +
    "GROUP BY " +
    "`C_53616c657320496e7369676874732043756265`.`Gender`";

  private static String SQL_EXPORT_TEMPLATE =
    "CREATE TABLE %s AS (\n" +
    "%s \n" +
    ") WITH DATA";

  public static void main(String args[]) throws SQLException, ClassNotFoundException, InterruptedException {
    Class.forName("org.apache.hive.jdbc.HiveDriver");

    String host = args[0];
    String connectionUrl = String.format("jdbc:hive2://%s:11111", host);
    System.out.println("About to connect to: " + connectionUrl);
    Connection connection = DriverManager.getConnection(connectionUrl, "admin", "admin");
    Statement statement = connection.createStatement();
    ResultSet resultSet = null;

    System.out.println("\n\nAbout to execute query:\n\n" + SQL_QUERY);
    resultSet = statement.executeQuery(SQL_QUERY);
    System.out.println("\n\nQuery results:\n");
    while (resultSet.next()) {
      System.out.println(resultSet.getString(1) + "\t" + resultSet.getDouble(2));
    }

    String createTableName = args[1] + "_" + new java.util.Date().getTime();
    String sqlExport = String.format(SQL_EXPORT_TEMPLATE, createTableName, SQL_QUERY);
    System.out.println("\n\nAbout to execute export:\n\n" + sqlExport);

    resultSet = statement.executeQuery(sqlExport);
    resultSet.next();
    System.out.println("\n\nTable created!");
  }
}
