import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/newdb";
        String user="developer";
        String psw="1234";
        String sql=(" ALTER TABLE student ADD COLUMN country VARCHAR(30)");
        String sql2=(" UPDATE student SET country = 'germany' WHERE student_id=1");
        String sql3=(" UPDATE student SET country = 'italy' WHERE student_id=2");
        String sql4=(" UPDATE student SET country = 'germany' WHERE student_id=3");
        String sql5=(" UPDATE student SET country = 'italy' WHERE student_id=4");

ResultSet rs=null;
        try(Connection connection= DriverManager.getConnection(url, user, psw);
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            PreparedStatement preparedStatement2=connection.prepareStatement(sql2);
            PreparedStatement preparedStatement3=connection.prepareStatement(sql3);
            PreparedStatement preparedStatement4= connection.prepareStatement(sql4);
            PreparedStatement preparedStatement5= connection.prepareStatement(sql5);
            PreparedStatement ps= connection.prepareStatement("SELECT first_name, last_name, country FROM newdb.student")) {
            preparedStatement.executeUpdate(sql);
            preparedStatement2.executeUpdate(sql2);
            preparedStatement3.executeUpdate(sql3);
            preparedStatement4.executeUpdate(sql4);
            preparedStatement5.executeUpdate(sql5);
            rs= ps.executeQuery();
            while (rs.next()){
                String last_name=rs.getString("last_name");
                String first_name=rs.getString("first_name");
                String country=rs.getString("country");
                System.out.println("Surname: "+last_name+" Name: "+first_name+" Country: "+country);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}