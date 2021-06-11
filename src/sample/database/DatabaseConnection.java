package sample.database;

import java.sql.*;

public class ProductsData {


    public static void connect(){
        Connection conn = null;
//        ResultSet resultSet = null;
        Statement statement = null;
        try{
           Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:Wholesale.db";
            conn = DriverManager.getConnection(url);
            statement = conn.createStatement();
            System.out.println("Connection to sqlite has been established");
            String sql;
            int id;
            sql = "CREATE TABLE \"Product\" (\n" +
                    "\t\"id\"\tINTEGER NOT NULL,\n" +
                    "\t\"name\"\tTEXT NOT NULL,\n" +
                    "\t\"price\"\tINTEGER NOT NULL,\n" +
                    "\t\"expiryDate\"\tDATE,\n" +
                    "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                    ");";
            String sql1 = "Select * FROM Farmers";
//            sql = "INSERT INTO Products (name, quantity, expiryDate) VALUES ('Beans', '20 bags', 2021-04-23 )";
            statement.executeUpdate(sql);
            ResultSet rs= statement.executeQuery(sql1);
            while (rs.next()){
                id = rs.getInt("id");
                System.out.println(id);
            }
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                if(conn != null){
                    statement.close();
//                    resultSet.close();
                    conn.close();
                }
            }catch (SQLException ex){
                System.out.println(ex.getMessage());

            }
        }
    }

    public static void main(String[] args){
        connect();
    }

}
