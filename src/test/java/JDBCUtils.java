import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {


    public static Connection connection;

    public static Statement statement;

    public static ResultSet resultSet;


/*


    public static Connection baglanti(){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }



 */






    public static Connection baglanti(){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2","select_user","Medunna_pass_@6");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }












    public static Statement statementOlusturma(){
        try {
            statement = baglanti().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }








    public static boolean executeOlusturma(String query){

        try {
            return statementOlusturma().execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }








    public static ResultSet executeQueryOlusturma(String query){

        try {
            return statementOlusturma().executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }











    public static List<Object> sutunListeleme(String sutun, String tablo) throws SQLException {

        ResultSet resultSet = executeQueryOlusturma("select " + sutun + " from " + tablo);

        List<Object> list = new ArrayList<>();

        while (resultSet.next()){
            list.add(resultSet.getObject(sutun));
        }

        return list;

    }






    public static List<Map<String, Object>> tabloListeleme(String query) throws SQLException {
        resultSet = executeQueryOlusturma(query);
        List<Map<String, Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> colNameValueMap = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    colNameValueMap.put(rsmd.getColumnName(i), resultSet.getObject(i));
                }
                rowList.add(colNameValueMap);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return rowList;
    }










    public static void baglantiyiKapat() {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



// hayat cok garip



    }
    }
