import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class C04 {


    @Test
    public void test01() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");


        Statement statement = connection.createStatement();

        //-- SORU1 : arac tablosundaki en yüksek fiyat'ı listele


        ResultSet resultSet = statement.executeQuery("select max(fiyat) as max_fiyat from arac");

        resultSet.next();

        int sonuc = resultSet.getInt("max_fiyat");
        System.out.println(sonuc);

        Assert.assertEquals(950000,sonuc);


    }
}
