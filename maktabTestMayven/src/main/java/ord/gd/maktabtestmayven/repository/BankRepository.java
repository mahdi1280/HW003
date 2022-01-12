package ord.gd.maktabtestmayven.repository;

import java.sql.*;
import java.util.Random;

public class BankRepository {

    private Connection connection;

    public BankRepository() throws SQLException {
      connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","root");
      String tableAccount="create table if not exists account(\n" +
              "        id integer primary key ,\n" +
              "        amount integer\n" +
              ");";
      String tableCustomer="create table if not exists customer(\n" +
              "    id serial primary key ,\n" +
              "    first_name varchar(200),\n" +
              "    last_name varchar(200),\n" +
              "    national_code char(10),\n" +
              "    account_id integer,\n" +
              "    constraint  fk_ac foreign key(account_id) references account(id)\n" +
              ");\n";
        PreparedStatement preparedStatement=connection.prepareStatement(tableAccount);
        preparedStatement.execute();
        connection.prepareStatement(tableCustomer).execute();
    }

    public void register(String firstName, String lastName, String nationalCode) throws SQLException {
        Random random = new Random();
        int accountId=random.nextInt(999999999);
        String insertAccount="insert into account(id,amount) values(?,?)";
        String insertCustomer="insert into customer(first_name,last_name,national_code,account_id) values(?,?,?,?)";
        PreparedStatement preparedStatementAccount=connection.prepareStatement(insertAccount);
        preparedStatementAccount.setInt(1,accountId);
        preparedStatementAccount.setInt(2,0);
        PreparedStatement preparedStatementCustomer=connection.prepareStatement(insertCustomer);
        preparedStatementCustomer.setString(1,firstName);
        preparedStatementCustomer.setString(2,lastName);
        preparedStatementCustomer.setString(3,nationalCode);
        preparedStatementCustomer.setInt(4,accountId);
        preparedStatementAccount.executeUpdate();
        preparedStatementCustomer.executeUpdate();
        preparedStatementCustomer.close();
        preparedStatementAccount.close();
    }

    public void withdraw(String nationalCode, int amount) throws SQLException {
        ResultSet resultset = resultset(nationalCode);
        resultset.next();
        int amountCustomer=resultset.getInt("amount");
        int accountId=resultset.getInt("id");
        if(amount>amountCustomer){
            System.out.println("not enugh many!");
            return;
        }
        String update="update account set  amount = ?  where id = ?;";
        PreparedStatement preparedStatement1 = connection.prepareStatement(update);
        preparedStatement1.setInt(1,amountCustomer - amount);
        preparedStatement1.setInt(2,accountId);
        preparedStatement1.executeUpdate();
    }

    public void deposit(String nationalCode, int amount) throws SQLException {
        ResultSet resultSet = resultset(nationalCode);
        resultSet.next();
        int amountCustomer=resultSet.getInt("amount");
        int accountId=resultSet.getInt("id");
        String update="update account set  amount = ?  where id = ?;";
        PreparedStatement preparedStatement1 = connection.prepareStatement(update);
        preparedStatement1.setInt(1,amount + amountCustomer);
        preparedStatement1.setInt(2,accountId);
        preparedStatement1.executeUpdate();
    }

    public ResultSet resultset(String nationalCode) throws SQLException {
        String select="select a.amount,a.id from customer inner join account a on a.id = customer.account_id where customer.national_code = ?";
        PreparedStatement preparedStatement=connection.prepareStatement(select);
        preparedStatement.setString(1,nationalCode);
        return preparedStatement.executeQuery();
    }
}