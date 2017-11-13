package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOSearch {
    private static String phone;
    private static String email;

    public static void getData(String name, String surname){
        Connection con = null;
        Statement st = null;
        ResultSet rt = null;
        String query = "SELECT * FROM task3Table WHERE name = '"+ name +"' AND surname = '"+ surname +"'";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "0054");
            st = con.createStatement();
            rt = st.executeQuery(query);
            System.out.println(rt.getMetaData().getColumnCount());
            if(!rt.next()){
                phone = "Not found";
                email = "Not found";
            } else {
                rt.beforeFirst();
            }
            while (rt.next()) {
                phone = rt.getString(3);
                email = rt.getString(4);
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try {
                if(con!=null) {
                    con.close();
                }
            } catch(SQLException se) { se.printStackTrace(); }
            try {
                if(con!=null) {
                    st.close();
                }
            } catch(SQLException se) { se.printStackTrace(); }
            try {
                if(con!=null) {
                    rt.close();
                }
            } catch(SQLException se) { se.printStackTrace(); }
        }
    }

    public static String getPhone() {
        return phone;
    }

    public static String getEmail() {
        return email;
    }

}
