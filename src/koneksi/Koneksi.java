package koneksi;
import java.sql.*;
import javax.swing.*;

public class Koneksi {
    public static Connection con;
    public static Statement stat;
    public ResultSet rs;
   
    public static void konek(){
        try {
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost/lelang_online","root","");
           stat  = con.createStatement();
        } catch (Exception e) {
            System.out.println("gagal" + e.getMessage());
            System.exit(0);
        }
    }
}
