package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		UserDao dao=new UserDao();
		if(dao.deleteUser(email))
		{
			printWriter.println("<b>User Deleted Sucessfully!!!!!!!!!!</b><br>");
		}
		else
		{
			printWriter.print("<h1>User not found</h1>");
		}

	}

}
