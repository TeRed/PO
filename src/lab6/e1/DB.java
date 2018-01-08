package lab6.e1;

import java.sql.*;
import java.util.Scanner;
import lab6.e1.DatabaseConnectionException;

import static java.lang.System.exit;

public class DB {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/duz",
                            "duz","QoBDbJmnHfURiB6r");

//      ...
            if(conn == null) System.out.println("NULL");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch(Exception e){e.printStackTrace();}
    }

     public boolean connectTry() {
        int index = 0;
        while (conn == null && index < 3) {
            connect();
            index++;
        }
        System.out.println("Liczba prób połaczenia: " + index);
        if(index == 3) {
            System.out.println("DB connection Exception");
            exit(1);
        }
        return true;
    }
    /*public void getByAuthor(String author){
        try {
            connectTry();
            stmt = conn.createStatement();

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli users
            rs = stmt.executeQuery("SELECT * FROM books WHERE author=\"" + author + "\"");
            while(rs.next()){
//                String name = rs.getString(1);
//                System.out.println("Title: "+name);
                System.out.print("isbn: " + rs.getString("isbn"));
                System.out.print(" title: " + rs.getString("title"));
                System.out.print(" author: "  + rs.getString("author"));
                System.out.println(" year: " + rs.getString("year"));
            }
        }catch (SQLException ex){
            // handle any errors

        }finally {
            closeConnections();
        }
    }*/

    /*public void deleteByAuthor(String author){
        try {
            connectTry();
            stmt = conn.createStatement();

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli users
            stmt.executeUpdate("DELETE FROM books WHERE author=\"" + author + "\"");
        }catch (SQLException ex){
            // handle any errors

        }finally {
            closeConnections();
        }
    }*/

    /*public void getByISBN(String isbn){
        try {
            connectTry();
            stmt = conn.createStatement();

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli users
            rs = stmt.executeQuery("SELECT * FROM books WHERE isbn=\"" + isbn + "\"");
            while(rs.next()){
                System.out.print("isbn: " + rs.getString("isbn"));
                System.out.print(" title: " + rs.getString("title"));
                System.out.print(" author: "  + rs.getString("author"));
                System.out.println(" year: " + rs.getString("year"));
            }
        }catch (SQLException ex){
            // handle any errors

        }finally {
            closeConnections();
        }
    }*/

    public void listAll() {
        try {
            connectTry();
            stmt = conn.createStatement();


            rs = stmt.executeQuery("SELECT * FROM books");

            System.out.println("Pozycje w tabeli:");
            while(rs.next()){
                System.out.print("isbn: \"" + rs.getString("isbn") + "\"");
                System.out.print(" title: \"" + rs.getString("title") + "\"");
                System.out.print(" author: \""  + rs.getString("author") + "\"");
                System.out.println(" year: \"" + rs.getString("year") + "\"");;
            }
        }catch (SQLException ex){

        }finally {
            closeConnections();
        }
    }


    public void getByAll(String value) {
        try {
            connectTry();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM books WHERE author LIKE '%" + value + "%' OR isbn=\"" +
                    value + "\"");
            while(rs.next()) {
                System.out.print("isbn: \"" + rs.getString("isbn") + "\"");
                System.out.print(" title: \"" + rs.getString("title") + "\"");
                System.out.print(" author: \""  + rs.getString("author") + "\"");
                System.out.println(" year: \"" + rs.getString("year") + "\"");
            }
        }catch (SQLException ex){
            // handle any errors

        }finally {
            closeConnections();
        }
    }

    public void deleteByAll(String value) {
        try {
            connectTry();
            stmt = conn.createStatement();

            stmt.executeUpdate("DELETE FROM books WHERE author LIKE '%" + value + "%' OR isbn=\"" +
                    value + "\"");
        }catch (SQLException ex){
            // handle any errors

        }finally {
            closeConnections();
        }
    }

    public void addBook(String isbn, String title, String author, int year) {
        try {
            connectTry();
            stmt = conn.createStatement();

            stmt.executeUpdate("INSERT INTO books VALUES ('"+isbn+"', '"+title+"', '"+author+"', '"+year+"')");
        }catch (SQLException ex){
            // handle any errors
        }finally {
            closeConnections();
        }
    }

    private void closeConnections() {
        // zwalniamy zasoby, które nie będą potrzebne
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException sqlEx) { } // ignore
            rs = null;
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) { } // ignore

            stmt = null;
        }
    }

    public static void main(String[] args) {

        DB db = new DB();
        Scanner reader = new Scanner(System.in);

        int key = 9;

            while (key != 0) {

                System.out.println("1. List All");
                System.out.println("2. Find by author or isbn");
                System.out.println("3. Add book");
                System.out.println("4. Delete book");
                System.out.println("0. Quit");
                key = reader.nextInt();
                switch (key) {
                    case 1:
                        db.listAll();
                        break;
                    case 2:
                        System.out.print("Author or isbn: ");
                        db.getByAll(reader.next());
                        break;
                    case 3:
                        System.out.println("ISBN, Title, Author, year");
                        db.addBook(reader.next(), reader.next(), reader.next(), reader.nextInt());
                        break;
                    case 4:
                        System.out.print("Author or isbn: ");
                        db.deleteByAll(reader.next());
                        break;
                }
            }
        reader.close();
    }
}

