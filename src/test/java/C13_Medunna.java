import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class C13_Medunna {


    // Database'e baglanır
    // (Host name: medunna.com, Database name: medunna_db_v2, Username: select_user, Password: Medunna_pass_@6))

    // Kullanıcı, oluşturulan odayı getirmek için sorgu gönderir
    // Odanın düzgün kaydedildiğini doğrular
    // baglantıyı kapatır


    @Test
    public void test01() throws SQLException {

        // Database'e baglanır
        // (Host name: medunna.com, Database name: medunna_db_v2, Username: select_user, Password: Medunna_pass_@6))

        // Kullanıcı, oluşturulan odayı getirmek için sorgu gönderir
        ResultSet resultSet = JDBCUtils.executeQueryOlusturma("select * from room where room_number=66666666");

        List<String> list = new ArrayList<>();

        while (resultSet.next()){
           list.add(resultSet.getString("description"));
        }
        System.out.println(list.get(0));

        // Odanın düzgün kaydedildiğini doğrular
        Assert.assertEquals("Burak Deneme",list.get(0));


        // baglantıyı kapatır
        JDBCUtils.baglantiyiKapat();


    }
}
