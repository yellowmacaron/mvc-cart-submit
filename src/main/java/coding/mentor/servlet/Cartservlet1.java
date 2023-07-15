package coding.mentor.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.mentor.dto.CartSession;
import coding.mentor.entity.Book;
import coding.mentor.service.BookService;

/**
 * Servlet implementation class Cartservlet1
 */
@WebServlet("/Cartservlet1")
public class Cartservlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cartservlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String bookId = request.getParameter("bookId");
			BookService bookService = new BookService();
			Book book = bookService.getBookDetail(Integer.parseInt(bookId));

			HttpSession session = request.getSession();
			CartSession cart = (CartSession) session.getAttribute("cart");
			// first time add to cart, list will be null => create new list w size=0
			if (cart == null) {
				cart = new CartSession();
			}
			boolean isAddedSuccess = cart.getBooks().add(book);
			if (isAddedSuccess) {
				cart.setTotalPrice(cart.getTotalPrice() + book.getPrice());
			
			}
			else if (isAddedSuccess && bookId!=null) {
				cart=(CartSession) session.getAttribute("cart");
				request.getSession().removeAttribute(bookId);
				response.sendRedirect("cart.jsp");
			}
			session.setAttribute("cart", cart);
			response.sendRedirect("home");
			
			
			
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
