
package online.examination;
import java.sql.*;
import javax.swing.JOptionPane;
public class OnlineExamination {

    
//    check the database in services or type localhost/phpmyadmin in the web to get the localhost:3306
//    Connected to "db"-> "mysql" database
//    ** The table used for this application is Users where it contains login crendentials
    
    
    
    
    
    public static Connection jdbc()
    {
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","Nithin281");
            Statement st = con.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Connection error");
            
        }
        return con;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        LoginPage lp = new LoginPage();
        lp.setVisible(true);
        lp.pack();
        lp.setLocationRelativeTo(null);
    }
    
}
