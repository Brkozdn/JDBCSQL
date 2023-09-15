import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class C07 {


    @Test
    public void test01() throws SQLException {


        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");


        Statement statement = connection.createStatement();



        // -- SORU6: musteriler tablosunda en yüksek maaşı alan 3. 4. 5. 6. kişilerin bilgilerini listeleyiniz

        ResultSet resultSet = statement.executeQuery("select * from musteriler order by maas desc offset 2 limit 4");

        List<Object> list = new ArrayList<>();

        while (resultSet.next()){
            list.add(resultSet.getInt("id") +"--"+ resultSet.getInt("maas") +"--"+ resultSet.getString("musteri_isim"));
        }



        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }






        System.out.println("**************");









        // -- SORU2: musteriler tablosunda id degeri 2 den büyük olan,
        //-- ilk 3 veriyi listeleyiniz

        ResultSet resultSet1 = statement.executeQuery("select * from musteriler where id>2 limit 3");

        List<Object> list1 = new ArrayList<>();

        while (resultSet1.next()){
            list1.add(resultSet1.getInt("id") +"--"+ resultSet1.getInt("maas") +"--"+ resultSet1.getString("musteri_isim"));
        }


        for (int i = 0; i <list1.size() ; i++) {
            System.out.println(list1.get(i));
        }




    }
}
