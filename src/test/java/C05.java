import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class C05 {


    @Test
    public void test01() throws SQLException {


        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");


        Statement statement = connection.createStatement();



        // --SORU1 : Çalisan sayisi 15.000’den cok olan 'isyeri' lerini,
        //--calisanlarin 'isim' lerini ve 'maas' larini listeleyin.

        //ResultSet resultSet = statement.executeQuery("select isyeri,isim,maas from calisanlar where isyeri in('Pierre Cardin', 'LCWaikiki')");

        ResultSet resultSet = statement.executeQuery("select isyeri,isim,maas from calisanlar where isyeri in(select marka_isim from markalar where calisan_sayisi>15000)");

        List<Object> list = new ArrayList<>();

        while (resultSet.next()){

          list.add(resultSet.getString("isyeri") + resultSet.getString("isim") + resultSet.getString("maas"));

        }

        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }


        System.out.println("****************");









       // -- SORU1: Malzemeler tablosundaki musteri_isim'i 'Ali Can' olanın malzeme_isim'ini,
       // --toptancilar  tablosunda irtibat_ismi 'Adem Cos' olanın sirket_ismi ile güncelleyiniz.

       //int a = statement.executeUpdate("update malzemeler set malzeme_isim=('Apple') musteri_isim='Ali Can'");

        int a = statement.executeUpdate("update malzemeler set malzeme_isim=(select sirket_ismi from toptancilar where irtibat_ismi='Adem Cos') where musteri_isim='Ali Can'");

        System.out.println("update edilen satır sayısı: " + a);

        ResultSet resultSet1 = statement.executeQuery("select * from malzemeler");

        List<Object> list1 = new ArrayList<>();

        while (resultSet1.next()){
           list1.add(resultSet1.getInt("malzeme_id") + resultSet1.getString("malzeme_isim") + resultSet1.getString("musteri_isim") + resultSet1.getInt("ted_vergino"));
        }


        for (int i = 0; i <list1.size() ; i++) {
            System.out.println(list1.get(i));
        }

    }
}
