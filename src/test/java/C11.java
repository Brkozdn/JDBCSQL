import org.junit.Assert;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class C11 {

    @Test
    public void test01() throws SQLException {


        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");

        Statement statement = connection.createStatement();


        // -- SORU1: Tüm film_name'leri, tüm category'lerini ve bu filmlerde oynayan actor_name'leri listeleyiniz.

       ResultSet resultSet = statement.executeQuery("select film_name,category,actor_name from filmler left join aktorler on filmler.film_id=aktorler.film_id");

        List<Object> list = new ArrayList<>();

       while (resultSet.next()){
           list.add(resultSet.getString("film_name") +"--"+ resultSet.getString("category") +"--"+ resultSet.getString("actor_name"));
       }


        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }

        Assert.assertTrue(list.get(2).toString().contains("Ayla"));


    }
}
