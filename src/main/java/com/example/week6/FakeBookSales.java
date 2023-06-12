package com.example.week6;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Formatter;

public class FakeBookSales {
    /*
    This method will generate the SQL script to
    insert in our bookSales table
    e.g. INSERT INTO bookSales(book_id, date_sold) VALUES (3, "2021-03-05");
     */
    public static void generateSQL() {
        SecureRandom secureRandom = new SecureRandom();
        // this is try with resources block
        try(
                Formatter formatter = new Formatter("fakeSalesData.sql");
                ) {
            for (int i = 0; i < 500; i++) {
                int bookId = secureRandom.nextInt(1, 13);
                LocalDate dateSold = LocalDate.now().minusDays(secureRandom.nextInt(1095));
                formatter.format("INSERT INTO bookSales(book_id, date_sold) VALUES (%d, '%s');\n", bookId, dateSold);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        generateSQL();
//    }
}
