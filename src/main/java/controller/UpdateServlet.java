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
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
 		String name=request.getParameter("userName");
 		String email=request.getParameter("emailId");
 		String address=request.getParameter("address");
 		String password=request.getParameter("password");
 		User user=new User();
 		user.setAddress(address);
 		user.setName(name);
 		user.setPassword(password);
 		UserDao dao=new UserDao();
 		if(dao.updateUser(email, user))
 		{
 			printWriter.print("<b>User Updated Successfully");
 		}
 		else
 		{
 			printWriter.print("<h1>Invalid User</h1>");
 		}
 	}

 

}
