package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Submit
 */
@WebServlet("/servlet/Submit")
public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Submit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");*/
		String uname = (String) request.getParameter("name");
		String pass = (String) request.getParameter("password");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		
		
		try {
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		 try {
			 Connection connect = DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/myweb","root","root");
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      Statement stmt = connect.createStatement();
		      System.out.println("Success connect Mysql server!");
		      ResultSet rs = stmt.executeQuery("select * from consumer");
		      while(rs.next()){
		    	  if(rs.getString("name").equals(uname)){
		    		  
		    	  }
		      }
		      
		      
		 }catch (Exception e) {
			 e.printStackTrace();
		}
		
		/*ServletContext context = getServletConfig().getServletContext();*/
		if (!(uname == null || pass == null || "".equals(uname) || "".equals(pass))) {
			if ("李四".equals(uname) && "123".equals(pass)||
					"张三".equals(uname) && "123".equals(pass)||
					"王五".equals(uname) && "123".equals(pass)) {
				/* response.setHeader("refresh", "0;URL=JSP/Index2.jsp"); */
				/*context.getRequestDispatcher("/JSP/Index2.jsp").forward(request, response);*/
				session.setAttribute("user", uname);
				session.setMaxInactiveInterval(600);
				response.sendRedirect(request.getContextPath()+"/JSP/Index2.jsp");
			} else {
				out.print("<script language='javascript'>alert('用户名或密码错误！！！')</script>");
				response.setHeader("refresh", "0;URL=../Index.jsp");
				// response.sendRedirect(request.getContextPath()+"/Index.jsp");
			}
		} else {
			out.print("<script language='javascript'>alert('用户名或密码不能为空！！！')</script>");
			response.setHeader("refresh", "0;URL=../Index.jsp");
			// response.sendRedirect(request.getContextPath()+"/Index.jsp");
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
