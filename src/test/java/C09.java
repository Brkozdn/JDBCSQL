import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class C09 {


    @Test
    public void test01() throws SQLException {




       Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");

       Statement statement = connection.createStatement();


        //   SORU2: isim'i 'Mehmet Ozturk' olan kisilerin isim, maas'larini  ve
        //--sehir'i 'Istabul' olan personelin sehir, maas'larini tekrarsız
        //--büyükten küçüge dogru siralayarak listeleyiniz.

        ResultSet resultSet = statement.executeQuery("select isim,maas from personel where isim='Mehmet Ozturk' union select sehir,maas from personel where sehir='Istanbul' order by maas desc");

        List<Object> list = new ArrayList<>();

        while (resultSet.next()){
            list.add(resultSet.getString("isim")+"--"+resultSet.getInt("maas"));
        }

        for (int i = 0; i <list.size() ; i++) {

            System.out.println(list.get(i));
        }


    }
}
