package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitordb")
public class visitorDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html ; charset=utf-8");
		PrintWriter out = response.getWriter();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 오류");
		}
		String sql = "select name, to_char(writedate, 'yyyy\"년\" mm\"월\" dd\"일\"') writedate, memo from visitor";
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest",
				"jdbctest"); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
			out.print("<h1>방명록 리스트</h1><hr>");
			out.print("<table border='1'>");
			while (rs.next()) {
				out.print("<tr>");
				out.print("<td>" + rs.getString("name") + "</td>");
				out.print("<td>" + rs.getString("writedate") + "</td>");
				out.print("<td>" + rs.getString("memo") + "</td>");
				out.print("</tr>");
			}
			out.print("</table>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.print("<hr><a href='/sedu/html/visitorMain.html'>방명록 메인 화면으로 가기</a>");
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html ; charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("gname");
		String memo = request.getParameter("op");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 오류");
		}
		String sql = "insert into visitor values('"+name+"',sysdate,'"+memo+"')";
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest",
				"jdbctest"); 
			 Statement stmt = conn.createStatement(); //클로즈를 리턴하는 변수만 안에 넣어야 한다
			 ) { 
		    stmt.executeQuery(sql);
			out.print("<h2>방명록 저장 성공</h2>");
		} catch (SQLException e) {
			out.print("<h2>방명록 저장 실패</h2>");
			e.printStackTrace();
		}
		out.print("<hr><a href='/sedu/html/visitorMain.html'>방명록 메인 화면으로 가기</a>");
		out.close();

	}

}
