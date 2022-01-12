package ord.gd.maktabtestmayven;

import ord.gd.maktabtestmayven.repository.BankRepository;

import java.sql.SQLException;

public class MainJDBC {

    public static void main(String[] args) throws SQLException {
        BankRepository bankRepository=new BankRepository();
//        bankRepository.register("ali","dd","1234");
        bankRepository.deposit("1234",200);
        bankRepository.withdraw("1234",120);
    }
}
