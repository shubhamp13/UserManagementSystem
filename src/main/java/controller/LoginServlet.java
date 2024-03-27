package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter printWriter=response.getWriter();
		response.setContentType("text/html");
		String email=request.getParameter("emailId");
		String password=request.getParameter("password");
		UserDao dao=new UserDao();
		User user=dao.getUser(email);
		
		if(user!=null)
		{
			if(user.getPassword().equals(password))
			{
			 
				printWriter.print("<h1> Login Sucessful "+user.getName()+"</h1> You Have Logged In<br>");
			}
			else
			{
				printWriter.print("<h1>Incorrect Password</h1><br>");
			}
		}
		else
		{
			printWriter.print("<b>Register Here</b>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("register.html");
			dispatcher.include(request, response);
		}
	}

}
