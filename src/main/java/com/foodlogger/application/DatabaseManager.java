package com.foodlogger.application;

import java.sql.*;

public class DatabaseManager
{
  Connection con = null;

  public Connection connect(){
    //trys the connection of the database
    try{
      String url = "jdbc:sqlite:C:/Users/mikay/personal_projects/FoodLogger/src/main//java/com/foodlogger/db" +
              ".db";
      con = DriverManager.getConnection(url);
      con.commit();
      System.out.println("Connection has been established");
    }catch(SQLException e){
      System.out.println(e.getMessage());
    }
    return con;
  }

  public void addUser(String email, String name, String username, String password) throws SQLException{
    //creates an insert statement for the user when a
    //new user is created
      //creates the statement that is entered into the database
      PreparedStatement pstmt = con.prepareStatement("INSERT INTO alluser(email, fname, username, psw) VALUES(?,?,?," +
              "?)" +
              ";");
      pstmt.setString(1, email);
      pstmt.setString(2, name);
      pstmt.setString(3, username);
      pstmt.setString(4, password);


      //executes the preparedstatement
      pstmt.execute();

  }

  /**
   * checks if the username that is entered is in the database
   * if it is, it call the @correctPassword method
   * @param username the username that was entered
   * @return whether the username is in the database
   */
  public boolean hasRecord(String username) throws SQLException{
    boolean exists = false;
    String sql = "SELECT 1 FROM alluser where username = ?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, username);
    ResultSet rs = ps.executeQuery();
    if(rs.next()){
      final int count = rs.getInt(1);
      exists = true;
    }
    System.out.println(exists);
    return exists;
  }

  public boolean passwordMatches(String username, String password) throws SQLException{
    boolean found = false;
    int rowNum = 1;
    Statement stmt = con.createStatement();
    String query = "SELECT * FROM alluser";

    ResultSet rs = stmt.executeQuery(query);

    while(!found){
      String name = rs.getString(rowNum);
      //looks for the username
      if(name.equals(username)){
        String psw = rs.getString(2);
        //checks if the password matches what it should be
        if(psw.equals(password)){
          found = true;
          System.out.println("found bitches");
          break;
        }
      }
      else{

        rowNum++;
      }
    }
    return found;
  }
}
