import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class C06 {


    @Test
    public void test01() throws SQLException {


        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");


        Statement statement = connection.createStatement();


        // -- SORU1: meslekler tablosunu isim'e göre alfabetik sıralayarak listeleyiniz.

        ResultSet resultSet = statement.executeQuery("select * from meslekler order by maas desc");

        List<Object> list = new ArrayList<>();

        while (resultSet.next()){
            list.add(resultSet.getInt("id") +"--"+ resultSet.getString("isim") +"--"+ resultSet.getInt("maas") +"--"+ resultSet.getString("meslek") +"--"+ resultSet.getString("soyisim"));
        }


        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }







        System.out.println("*************");










        //  -- SORU5: meslekler tablosunda isim'i 'Ali' olanları,
        //-- maas'a göre büyükten küçüge sıralayarak listeleyiniz



        ResultSet resultSet1 = statement.executeQuery("select * from meslekler where isim='Ali' order by maas desc");

        List<Object> list1 = new ArrayList<>();

        while (resultSet1.next()){
            list1.add(resultSet1.getInt("id") +"--"+ resultSet1.getString("isim") +"--"+ resultSet1.getInt("maas") +"--"+ resultSet1.getString("meslek") +"--"+ resultSet1.getString("soyisim"));
        }


        for (int i = 0; i <list1.size() ; i++) {
            System.out.println(list1.get(i));
        }




    }
}
