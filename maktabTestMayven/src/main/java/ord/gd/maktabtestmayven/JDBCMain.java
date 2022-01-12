package ord.gd.maktabtestmayven;

import java.sql.*;

public class JDBCMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        //load jdbc driver
//       Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","root");
//        Statement statement = connection.createStatement();
//        String createTable = "create table if not exists person (\n" +
//                "    id serial primary key ,\n" +
//                "    nationalCode char(10),\n" +
//                "    first_name varchar(100),\n" +
//                "    last_name varchar(100)\n" +
//                ");";
//        statement.execute(createTable);
//        String insert ="insert into person(first_name,last_name) values (?,?)";
//        PreparedStatement preparedStatement= connection.prepareStatement(insert);
//        preparedStatement.setString(1,"mahdi");
//        preparedStatement.setString(2,"karimi");
//        int i = preparedStatement.executeUpdate();
//        System.out.println(i);
//
//        String select = "select * from person";
//        preparedStatement = connection.prepareStatement(select);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()){
//            System.out.println(resultSet.getString(1));
//            System.out.println(resultSet.getString(2));
//            System.out.println(resultSet.getString(3));
//        }
//        connection.close();
    }
}
