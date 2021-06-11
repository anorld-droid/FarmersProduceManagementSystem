package sample.database;

import java.io.File;
import java.sql.*;

public class DatabaseConnection {


    public Connection connect(){
        Connection conn = null;
        Statement statement = null;
        try{
            //Check if the database already exists, if it does connect
            // to it then set auto commit to false, if not create one with tables
            File file = new File("Wholesale.db");
            if (!file.exists()){
                Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:Wholesale.db";
                conn = DriverManager.getConnection(url);
                statement = conn.createStatement();

                String sql1 = "CREATE TABLE \"Products\" (\n" +
                        "\t\"Id\"\tINTEGER NOT NULL,\n" +
                        "\t\"Name\"\tTEXT NOT NULL,\n" +
                        "\t\"Amount\"\tINTEGER NOT NULL,\n" +
                        "\t\"Unit\"\tTEXT NOT NULL,\n" +
                        "\t\"ExpiryDate\"\tTEXT NOT NULL,\n" +
                        "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                        ");";
                String sql2 = "CREATE TABLE \"Farmers\" (\n" +
                        "\t\"Id\"\tINTEGER NOT NULL,\n" +
                        "\t\"Products_id\"\tINTEGER NOT NULL,\n" +
                        "\t\"FirstName\"\tTEXT NOT NULL,\n" +
                        "\t\"LastName\"\tTEXT NOT NULL,\n" +
                        "\t\"PhoneNumber\"\tINTEGER NOT NULL,\n" +
                        "\t\"Price\"\tINTEGER NOT NULL,\n" +
                        "\tFOREIGN KEY(\"Products_id\") REFERENCES \"Products\",\n" +
                        "\tPRIMARY KEY(\"Id\" AUTOINCREMENT)\n" +
                        ");";
                String sql = "CREATE TABLE \"Retailers\" (\n" +
                        "\t\"Id\"\tINTEGER NOT NULL,\n" +
                        "\t\"Products_id\"\tINTEGER NOT NULL,\n" +
                        "\t\"FirstName\"\tTEXT NOT NULL,\n" +
                        "\t\"LastName\"\tTEXT NOT NULL,\n" +
                        "\t\"PhoneNumber\"\tINTEGER NOT NULL,\n" +
                        "\t\"Price\"\tINTEGER NOT NULL,\n" +
                        "\tPRIMARY KEY(\"Id\" AUTOINCREMENT),\n" +
                        "\tFOREIGN KEY(\"Products_id\") REFERENCES \"Products\"\n" +
                        ");";
                System.out.println("Created the database");
                statement.executeUpdate(sql1);
                statement.executeUpdate(sql2);
                statement.executeUpdate(sql);
                statement.close();

            }else{
                Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:Wholesale.db";
                conn = DriverManager.getConnection(url);
                System.out.println("Connection to sqlite has been established");
                conn.setAutoCommit(false);
            }
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
