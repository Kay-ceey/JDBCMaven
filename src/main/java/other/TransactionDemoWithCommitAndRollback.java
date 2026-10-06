package other;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionDemoWithCommitAndRollback {
    public static void main(String[] args)throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/sys";
        String uName = "root";
        String password = "60425159";

        Connection con = DriverManager.getConnection(url,uName,password);
        Statement st = con.createStatement();
        System.out.println("Data before Transaction");
        System.out.println("------------------------");
        ResultSet rs = st.executeQuery("select * from accounts");
        while (rs.next())
            System.out.println(rs.getString(1)+"...."+rs.getInt(2));
        System.out.println("Transaction begins .... ");
        con.setAutoCommit(false);
        st.executeUpdate("update accounts set balance = balance - 2000 where user = 'Milan'");
        st.executeUpdate("update accounts set balance = balance + 2000 where user = 'Anushka'");
        System.out.println("can you please confirm this transaction of 10000 ....[Yes | No]");
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        if (option.equalsIgnoreCase("Yes")){
            con.commit();
            System.out.println("Transaction committed");
        } else {
            con.rollback();
            System.out.println("Transaction rolled back");
        }
        System.out.println("Data after Transaction");
        System.out.println("-----------------------");
        ResultSet rs1 = st.executeQuery("select * from accounts ");
        while (rs1.next())
            System.out.println(rs1.getString(1)+"...."+rs1.getInt(2));
    }
}
