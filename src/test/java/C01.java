import org.junit.Assert;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class C01 {


    @Test
    public void test01() throws SQLException {


       Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");

       Statement statement = connection.createStatement();

      // --SORU6: ogrenciler tablosundaki sinav_notu 80'den büyük olan öğrencilerin tüm bilgilerini listele
      ResultSet resultSet = statement.executeQuery("select * from ogrenciler where sinav_notu>80");
      // cagırılan datayı gorebilmek icin executeQuery() methodunu kullanmalıyız


        List<String> list = new ArrayList<>();

      while (resultSet.next()){
        list.add(resultSet.getString("adres") + resultSet.getString("id") + resultSet.getString("isim") + resultSet.getString("sinav_notu"));
      }

      list.stream().forEach(t-> System.out.println(t+" "));

        System.out.println("**************");








      // --SORU8: ogrenciler tablosundaki sinav_notu 85 ve adres'i 'Ankara' olan öğrenci isim'ini listele
      ResultSet resultSet1 = statement.executeQuery("select * from ogrenciler where sinav_notu=85 and adres='Ankara'");

      List<Object> list1 = new ArrayList<>();

      while (resultSet1.next()){
          list1.add(resultSet1.getInt("id") +resultSet1.getString("isim") + resultSet1.getString("adres")+ resultSet1.getInt("sinav_notu"));
      }

        System.out.println(list1);


        System.out.println("**************");













        // --SORU9: ogrenciler tablosundaki sinav_notu 65 veya 85 olan ogrencilerin tüm bilgilerini listele
        ResultSet resultSet2 = statement.executeQuery("select * from ogrenciler where sinav_notu in(65,85)");

        List<Object> list2 = new ArrayList<>();

        while (resultSet2.next()){
            list2.add(resultSet2.getInt("id") +resultSet2.getString("isim") + resultSet2.getString("adres")+ resultSet2.getInt("sinav_notu"));
        }

        System.out.println(list2);



        System.out.println("**************");









        // --SORU11: ogrenciler tablosunda sinav_notu 65 ve 85 arasında olan ogrencilerin tüm bilgilerini listele
        ResultSet resultSet3 = statement.executeQuery("select * from ogrenciler where sinav_notu between 65 and 85");

        List<Object> list3 = new ArrayList<>();

        while (resultSet3.next()){
            list3.add(resultSet3.getInt("id") +resultSet3.getString("isim") + resultSet3.getString("adres")+ resultSet3.getInt("sinav_notu"));
        }

        System.out.println(list3);





        System.out.println("**************");





        // --SORU12:.ogrenciler tablosunda sinav_notu 75 ve 90 arasında olmayan ögrencilerin isim'ini ve sinav_notu listele
        ResultSet resultSet4 = statement.executeQuery("select * from ogrenciler where sinav_notu not between 75 and 90");

        List<Object> list4 = new ArrayList<>();

        while (resultSet4.next()){
            list4.add(resultSet4.getInt("id") +resultSet4.getString("isim") + resultSet4.getString("adres")+ resultSet4.getInt("sinav_notu"));
        }

        System.out.println(list4);







        System.out.println("**************");





        // --SORU1: kursiyerler tablosundaki sinav_notu 75 olan satırı siliniz

        boolean a = statement.execute("delete from kursiyerler where sinav_notu=75");
        // System.out.println(a); execute() methodu data cagrılmazsa false verir. data cagırılırsa true verir

        ResultSet resultSet5 = statement.executeQuery("select * from kursiyerler");

        List<Object> list5 = new ArrayList<>();

        while (resultSet5.next()){
            list5.add(resultSet5.getInt("sinav_notu"));
        }

        System.out.println(list5);
        Assert.assertFalse(list5.contains(75));








        System.out.println("**************");





        // --SORU1: kursiyerler tablosundaki sinav_notu 75 olan satırı siliniz

        boolean b = statement.execute("delete from kursiyerler where isim in('Derya Soylu','Yavuz Bal')");
        // System.out.println(a); execute() methodu data cagrılmazsa false verir

        ResultSet resultSet6 = statement.executeQuery("select * from kursiyerler");

        List<Object> list6 = new ArrayList<>();

        while (resultSet6.next()){
            list6.add(resultSet6.getString("isim"));
        }

        System.out.println(list6);
        Assert.assertFalse(list6.contains("Derya Soylu"));




        System.out.println("**************");





        // --SORU1: kursiyerler tablosunu siliniz

        boolean c = statement.execute("drop table kursiyerler");
        // System.out.println(a); execute() methodu data cagrılmazsa false verir

        try {
            ResultSet resultSet7 = statement.executeQuery("select * from kursiyerler");
        } catch (SQLException e) {
            System.out.println("Kursiyerler tablosu silinmis");
        }

// hacı naptın guncelleme yaptım
    }
}
