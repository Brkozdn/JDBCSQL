import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class C02 {


    @Test
    public void test01() throws SQLException {

    // -- SORU1: film_no’su 300 olan film'in
    //--film_ismi'ni 'Recep İvedik' olarak güncelleyeniz.


        Connection connection = DriverManager.getConnection("jdbc:postgresql://localHost:5432/postgres","postgres","1234");

        Statement statement = connection.createStatement();


        int a = statement.executeUpdate("update film set film_ismi='Recep İvedik' where film_no=300");
        System.out.println("update edilen satır sayısı: " + a);
        // executeUpdate() methodu guncellenen satır sayısını verir


        ResultSet resultSet = statement.executeQuery("select * from film");


        List<Object> list = new ArrayList<>();

        while (resultSet.next()){
            list.add(resultSet.getInt("film_no") + resultSet.getString("film_ismi") + resultSet.getString("film_turu"));
        }

        System.out.println(list);







        System.out.println("****************");






    /*


        boolean b = statement.execute("update film set film_ismi='Recep İvedik' where film_no=300");
        System.out.println(b);


        ResultSet resultSet1 = statement.executeQuery("select * from film");


        List<Object> list1 = new ArrayList<>();

        while (resultSet1.next()){
            list1.add(resultSet1.getInt("film_no") + resultSet1.getString("film_ismi") + resultSet1.getString("film_turu"));
        }

        System.out.println(list1);


    */


        System.out.println("****************");








        // -- SORU3: film_no’su 100 olan film'in
        //--film_ismi'ni 'Cakallarla Dans' , film_turu’nu 'Komedi' olarak güncelleyiniz.

        int c = statement.executeUpdate("update film set film_ismi='Cakallarla Dans', film_turu='Dram' where film_no=100");
        System.out.println("update edilen satır sayısı: " + c);

        ResultSet resultSet2 = statement.executeQuery("select * from film");

        List<Object> list2 = new ArrayList<>();

        while (resultSet2.next()){
            list2.add(resultSet2.getInt("film_no") + resultSet2.getString("film_ismi") + resultSet2.getString("film_turu"));
        }


        System.out.println(list2);











    }
}
