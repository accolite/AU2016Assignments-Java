

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		String user = request.getParameter("name");
		String password = request.getParameter("password");
	    String empid = request.getParameter("id");
		String email = request.getParameter("email");
		String role = "employee";
		try {
			PrintWriter out = response.getWriter();
			Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
			Context initialContext = new InitialContext(env);
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/MyDatabase");
			Connection connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			String sql1 = "use spring";
			stmt.execute(sql1);
			String sql = "insert into users(id,name,pass_word,email,role_user)values("+empid+",'"+user+"','"+password+"','"+email+"','"+role+"');";
			System.out.println(sql);
			stmt.execute(sql);
			
			System.out.println("Inside add");
			Session session = (Session) envContext.lookup("mail/Session");
	        
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("loghithasundar@gmail.com"));
			InternetAddress to[] = new InternetAddress[1];
			
			System.out.println(email);
			to[0] = new InternetAddress(email);
			message.setRecipients(Message.RecipientType.TO, to);
			message.setSubject("You are hired");
			message.setContent("We are happy to inform you that you have cleared all rounds of interview. You are ready to join us", "text/plain");
			Transport.send(message);
			
		} catch (Exception e) {
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
