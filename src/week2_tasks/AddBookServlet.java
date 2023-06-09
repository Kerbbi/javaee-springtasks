package week2_tasks;
import week1_tasks.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;

@WebServlet(value = "/add-book")
public class AddBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("book_name");
        String author = request.getParameter("book_author");
        String price = request.getParameter("book_price");
        String genre = request.getParameter("book_genre");
        String description = request.getParameter("book_description");

        double bookPrice = Double.parseDouble(price);

        Book book = new Book();
        book.setName(name);
        book.setPrice(bookPrice);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setDescription(description);

        DBConnection.addBook(book);

        response.sendRedirect("/");

    }
}
