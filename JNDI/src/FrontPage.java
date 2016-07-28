
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class FrontPage
 */
@WebServlet("/FrontPage")
public class FrontPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String user = request.getUserPrincipal().getName();
		System.out.println("User:" + user);
		if (user.equals("manager")) {
			// System.out.println("Manager is welcomed ");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head><title>Manager View</title></head>");
			out.println("<body>");
			out.println("<center><h1>Employee List</h1>");

			/* DB initialization */
            out.print("<form action='http://localhost:8090/TomcatAssignment/Add'>");
			try {
				Hashtable env = new Hashtable();
				env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
				Context initialContext = new InitialContext(env);
				Context envContext = (Context) initialContext.lookup("java:/comp/env");
				DataSource dataSource = (DataSource) envContext.lookup("jdbc/MyDatabase");
				Connection connection = dataSource.getConnection();
				Statement stmt = connection.createStatement();
				String sql = "Select * from users where role_user='employee'; ";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					out.println("<h3>Employee:</h3>");
					out.println("<br/>");
					out.println("Name:" + rs.getString("name"));
					out.println("Id:" + rs.getInt("id"));
					out.println("Email:" + rs.getString("email"));
				}
				out.print("<br/><br/>");
                out.println("<button type=submit>Add Employee</button>");
                out.print("</form>");
                out.print("</body>");
                out.print("</html>");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		else if(user.equals("employee")){
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head><title>Employee View</title></head>");
			out.println("<body>");

			/* DB initialization */
			try {
				Hashtable env = new Hashtable();
				env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
				Context initialContext = new InitialContext(env);
				Context envContext = (Context) initialContext.lookup("java:/comp/env");
				DataSource dataSource = (DataSource) envContext.lookup("jdbc/MyDatabase");
				Connection connection = dataSource.getConnection();
				Statement stmt = connection.createStatement();
				String sql = "Select * from users where id=2; ";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					out.println("<br/>");
					out.println("---------------------");
					out.println("<br/>");
					out.println("Name:" + rs.getString("name"));
					out.println("<br/>");
					out.println("Id:" + rs.getInt("id"));
					out.println("<br/>");
					out.println("Email:" + rs.getString("email"));
					out.println("<br/>");
					out.println("---------------------");
				}
				out.print("<br/><br/>");
                out.print("</form>");
                out.print("</body>");
                out.print("</html>");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
