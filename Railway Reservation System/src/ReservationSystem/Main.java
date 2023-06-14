package ReservationSystem;
import java.io.IOException;
import java.sql.*;
import javax.swing.JOptionPane;





// check the database in services or type localhost/phpmyadmin in the web to get the localhost:3306
// connected to db database
// The database of this project is "mysql" 
// the tables we used are Passengers, Trains, and Tickets








public class Main {
    public static Connection jdbc()
    {
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","phpmyadmin","PassWord123");
            
            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from Passengers");
//            while(rs.next())
//            {
//                System.out.println(rs.getString(1)+"  "+rs.getString(2));  
//                
//            }
//            con.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        return con;
    }
    public static void main(String[] args) throws IOException
    {
        LoginPage lp = new LoginPage();
        lp.setVisible(true);
        lp.pack();
        lp.setLocationRelativeTo(null);
//          JOptionPane.showMessageDialog(null, "connected");

        String s = lp.username;
        
    }
}