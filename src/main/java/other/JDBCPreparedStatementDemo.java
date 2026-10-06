package other;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCPreparedStatementDemo {

    public static void main(String[] args)throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
       /* Class<T> aClass = Class.forName("java.lang.String");
        Object o = aClass.newInstance();
        System.out.println(aClass.getMethods());

        for (Method m : aClass.getMethods()){
            System.out.println(m.getName());
        }
        System.out.println(aClass.getName());*/
        String url = "jdbc:mysql://localhost:3306/sys";
        String uName = "root";
        String password = "60425159";
        ResultSet resultSet = null;
        /*Connection con = DriverManager.getConnection(url,uName,password);*/
        /*Statement st = con.createStatement();*/
        Connection con = null;
        String query = "select * from employee"; //DQL
        String insertQuery = "insert into employee values ('7','Shubbam','Pune');";
        //READ
        try {
            con = DriverManager.getConnection(url,uName,password);
            Statement st = con.createStatement();
            boolean execute = st.execute(query);
            if (execute) {
                ResultSet rs = st.getResultSet();
                rs.next();
                System.out.println(rs.getString(2));
            }
        } finally {
            if (resultSet != null)
                resultSet.close();
            if (con != null)
                con.close();
        }
        /*String insertQuery = "insert into employee values('6','Barkha','Wembley');";

        //READ
        try {
            con = DriverManager.getConnection(url,uName,password);
            Statement st = con.createStatement();
            int count = st.executeUpdate(insertQuery);
            System.out.println("No of affected rows = "+count);
        } finally {
            con.close();
        }*/
        /*ResultSet resultSet = st.executeQuery("select * from employee");
        while (resultSet.next()){
            System.out.println("Employee id :"+ resultSet.getInt(1));
            System.out.println("Employee Name :"+ resultSet.getString(2));
            System.out.println("Employee Address :"+ resultSet.getString(3));
        }*/
    }
}
