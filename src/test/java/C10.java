import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class C10 {


    @Test
    public void test01() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");

        Statement statement = connection.createStatement();


        //  -- SORU1: isim'i 'Murat Oz' olanlarin isim'lerini, sehir'lerini ve
        // -- sehir'i 'Istanbul' olmayanların isim'lerini sehir'lerini bulup
        // -- iki sorgunun kesisimini listeleyiniz


        ResultSet resultSet = statement.executeQuery("select isim,sehir from isciler where isim='Murat Oz' intersect select isim,sehir from isciler where sehir<>'Istanbul'");

        List<Object> list = new ArrayList<>();

        while (resultSet.next()){
            list.add(resultSet.getString("isim")+"--"+resultSet.getString("sehir"));
        }


        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }






        System.out.println("***********");





        //  -- SORU2: isim'i 'Murat Oz' olanlarin isim'lerini, sehir'lerini ve
        // -- sehir'i 'Istanbul' olmayanların isim'lerini sehir'lerini bulup
        // -- ilk sorguda olup ikinci sorguda olmayan degerleri listeleyiniz



        ResultSet resultSet1 = statement.executeQuery("select isim,sehir from isciler where isim='Murat Oz' except select isim,sehir from isciler where sehir<>'Istanbul'");

        List<Object> list1 = new ArrayList<>();

        while (resultSet1.next()){
            list1.add(resultSet1.getString("isim")+"--"+resultSet1.getString("sehir"));
        }


        for (int i = 0; i <list1.size() ; i++) {
            System.out.println(list1.get(i));
        }


    }
}
