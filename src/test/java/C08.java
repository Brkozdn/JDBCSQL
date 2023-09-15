import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class C08 {


    @Test
    public void test01() throws SQLException {

      Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");

      Statement statement = connection.createStatement();


      // -- SORU05: ulke'lere göre ve sehir'lere göre gruplayarak çalışan sayısını listeleyiniz.


        ResultSet resultSet = statement.executeQuery("select ulke,sehir,count(isim) from insan group by ulke,sehir");

        List<Object> list = new ArrayList<>();


        while (resultSet.next()){
            list.add(resultSet.getString("ulke") +"--"+ resultSet.getString("sehir") +"--"+ resultSet.getInt("count"));
        }

        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }







        System.out.println("****************");









        // -- SORU07: maas'ı 30000 den büyük olanların,
        //-- ulke'lere göre ve cinsiyet'e göre gruplayarak çalışan sayısını, yas ortalamasını listeleyiniz.



        ResultSet resultSet1 = statement.executeQuery("select ulke,cinsiyet,count(isim),avg(yas) from insan where maas>30000 group by ulke,cinsiyet");

        List<Object> list1 = new ArrayList<>();


        while (resultSet1.next()){
            list1.add(resultSet1.getString("ulke") +"--"+ resultSet1.getString("cinsiyet") +"--"+ resultSet1.getInt("count") +"--"+ resultSet1.getInt("avg"));
        }

        for (int i = 0; i <list1.size() ; i++) {
            System.out.println(list1.get(i));
        }










        System.out.println("****************");











        // --SORU08: ulke'lere göre gruplayarak yas ortalamasını bulup, yas ortalaması 33'den buyuk olanları listeleyiniz.


        ResultSet resultSet2 = statement.executeQuery("select ulke,avg(yas) from insan group by ulke having avg(yas)>33");

        List<Object> list2 = new ArrayList<>();


        while (resultSet2.next()){
            list2.add(resultSet2.getString("ulke") +"--"+ resultSet2.getString("avg"));
        }

        for (int i = 0; i <list2.size() ; i++) {
            System.out.println(list2.get(i));
        }







    }
}
