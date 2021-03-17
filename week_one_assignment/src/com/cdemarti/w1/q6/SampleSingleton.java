package com.cdemarti.w1.q6;

import java.math.BigDecimal;
import java.sql.*;

public class SampleSingleton {
    private static Connection conn = null;

    private static SampleSingleton instance = null;

    public static SampleSingleton getInstance() {

        // check to see if the instance has already been created or not, simply returning the instance will
        // never instantiate an instance
        if (instance == null) {
            synchronized (instance){
                if(instance == null){
                    instance = new SampleSingleton();
                }
            }

        }
        return instance;
    }

    public static void databaseQuery(BigDecimal input) throws SQLException {
        conn = DriverManager.getConnection("url of database");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select id from table");

        // fixed typing issues of multiplying by an integer by a BigDecimal. BigDecimal has Math built in through
        // functions.

        // to get a BigDecimal with a value of zero, must use ZERO attribute
        BigDecimal x = BigDecimal.ZERO;
        while(rs.next()) {
            BigDecimal columnIndex = new BigDecimal(rs.getInt(1));
            x = columnIndex.multiply(input);
        }
    }
}

