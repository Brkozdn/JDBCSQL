import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class C03 {


    @Test
    public void test01() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");

        Statement statement = connection.createStatement();






        // --SORU1: arabalar tablosuna kilometre varchar(10) seklinde yeni sutun ekleyiniz

        boolean a = statement.execute("alter table arabalar add column kilometre varchar(10)");
        System.out.println(a);

        ResultSet resultSet = statement.executeQuery("select * from arabalar");

        List<Object> list = new ArrayList<>();

        while (resultSet.next()){
           list.add(resultSet.getInt("id") +"--"+ resultSet.getString("marka") +"--"+ resultSet.getString("model") +"--"+ resultSet.getString("vites") +"--"+ resultSet.getInt("fiyat") +"--"+ resultSet.getString("kilometre"));
        }

        for (int i = 0; i <list.size() ; i++) {

            System.out.println(list.get(i));
        }







        System.out.println("************");






        // --SORU1: arabalar tablosuna kilometre varchar(10) seklinde yeni sutun ekleyiniz



/*
        int b = statement.executeUpdate("alter table arabalar add column kilometre varchar(10)");
        // System.out.println("update edilen satır sayısı: " + b);  herhangi bir veri update etmiyorum bu yuzden 0 yazar

        ResultSet resultSet1 = statement.executeQuery("select * from arabalar");

        List<Object> list2 = new ArrayList<>();

        while (resultSet1.next()){
            list2.add(resultSet1.getInt("id") +"--"+ resultSet1.getString("marka") +"--"+ resultSet1.getString("model") +"--"+ resultSet1.getString("vites") +"--"+ resultSet1.getInt("fiyat") +"--"+ resultSet1.getString("kilometre"));
        }

        for (int i = 0; i <list2.size() ; i++) {

            System.out.println(list2.get(i));
        }









 */


        System.out.println("************");










        //  --SORU2: arabalar tablosuna  yas int ve renk varchar(25) seklinde yeni sutun ekleyiniz

        boolean c = statement.execute("alter table arabalar add column yas int, add column renk varchar(25)");
        System.out.println(c);


        ResultSet resultSet2 = statement.executeQuery("select * from arabalar");


        List<Object> list3 = new ArrayList<>();

        while (resultSet2.next()){
            list3.add(resultSet2.getInt("id") +"--"+ resultSet2.getString("marka") +"--"+ resultSet2.getString("model") +"--"+ resultSet2.getString("vites") +"--"+ resultSet2.getInt("fiyat") +"--"+ resultSet2.getString("kilometre") +"--"+ resultSet2.getString("yas") +"--"+ resultSet2.getString("renk"));
        }

        for (int i = 0; i <list3.size() ; i++) {

            System.out.println(list3.get(i));
        }












        System.out.println("************");








        // --SORU5: arabalar tablosundan vites sutununu siliniz


        boolean d = statement.execute("alter table arabalar drop column vites");
        System.out.println(d);


        ResultSet resultSet3 = statement.executeQuery("select * from arabalar");


        resultSet3.next();

            try {
                System.out.println(resultSet3.getString("vites"));
            } catch (SQLException e) {
                System.out.println("vites sutunu silinmis");
            }












         System.out.println("************");


        // -- SORU8: galeri tablosundaki, model sutununun data turunu VARCHAR(30) olarak değiştiriniz.

       boolean e = statement.execute("alter table arabalar alter column model type varchar(30)");

        System.out.println(e);









        System.out.println("************");


        //  --SORU9: arabalar tablosunun marka sutununa unique kısıtlaması veriniz.


        boolean f = statement.execute("alter table arabalar add constraint uni_ks unique(marka)");

        System.out.println(e);











        System.out.println("************");


        //  --SORU9: arabalar tablosunun marka sutununa unique kısıtlaması veriniz.


        boolean g = statement.execute("alter table arabalar drop constraint uni_ks");

        System.out.println(e);





    }
    }

