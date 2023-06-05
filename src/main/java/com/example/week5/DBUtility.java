package com.example.week5;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    // user, pass and connectionString
    private static String user;
    private static String pass;

    static {
        try {
            user = DBCreds.findUser();
            pass = DBCreds.findPass();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // You dont have to create the above files
    // write your username and pass as a string
    private static String connectURL = "jdbc:mysql://172.31.22.43:3306/" + user;

    // static method to store book in the db
    // this will return the bookId
    public static int insertBookIntoDB(Book book) throws SQLException {
        int bookID = -1;
        ResultSet resultSet = null;

        String sql = "INSERT INTO book (book_name, author, genre, price, is_available)\n" +
                "VALUES (?,?,?,?,?);";

        // this is called a 'try with resources' block
        // everything inside this will be closed automatically
        try(
                Connection conn = DriverManager.getConnection(connectURL, user, pass);
                PreparedStatement preparedStatement = conn.prepareStatement(sql, new String[]{"bookID"})
        )
        {
            // add values to our prepared statement
            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getGenre());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.setBoolean(5, book.isAvailable());

            // execute the statement
            preparedStatement.executeUpdate();

            // get the value of bookID
            resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                bookID = resultSet.getInt(1);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(resultSet != null){
                resultSet.close();
            }
        }

        return bookID;
    }

    public static ArrayList<Book> retrieveBooksFromDB(){
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT book.book_id, book.book_name, book.author, book.genre, book.price, book.is_available, COUNT(bookSales.sale_id) AS 'unit_sold'\n" +
                "FROM book\n" +
                "INNER JOIN bookSales\n" +
                "ON book.book_id = bookSales.book_id\n" +
                "GROUP BY book.book_id;";

        // try with resource block
        try(
                Connection conn = DriverManager.getConnection(connectURL, user, pass);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ){
            while (resultSet.next()){
                int bookId = resultSet.getInt("book_id");
                String bookName = resultSet.getString("book_name");
                String author = resultSet.getString("author");
                String genre = resultSet.getString("genre");
                Double price = resultSet.getDouble("price");
                Boolean available = resultSet.getBoolean("is_available");
                int unitsSold = resultSet.getInt("unit_sold");

                Book newBook = new Book(bookId, bookName, author, genre, price, available, unitsSold);
                books.add(newBook);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return books;
    }
}
