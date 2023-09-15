import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class C12 {


    @Test
    public void test01() throws SQLException {

        // --SORU4: kurs tablosundaki isim'i 'Aliye' olan satırları siliniz


        JDBCUtils.executeOlusturma("delete from kurs where isim='Aliye'");

        ResultSet resultSet = JDBCUtils.executeQueryOlusturma("select * from kurs");

        List<String> list = new ArrayList<>();

        while (resultSet.next()){
            list.add(resultSet.getString("isim") +"--"+ resultSet.getString("soyisim"));
        }

        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }








        System.out.println("*****************************");








        // --SORU4: kurs tablosundaki isim sutununu listeleyiniz

        List<Object> list1 = JDBCUtils.sutunListeleme("isim","kurs");

        System.out.println(list1);







        System.out.println("*****************************");







        // Kurs tablosundaki verileri sutun isimleriyle eslestirerek listeleyiniz
        List<Map<String, Object>> rowList = JDBCUtils.tabloListeleme("select * from kurs");

        System.out.println(rowList);



    }
}
