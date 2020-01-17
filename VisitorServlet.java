package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisitorServlet
 */
@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("gname");
		String op = request.getParameter("op");
		LocalDate today = LocalDate.now();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<h2>"+name+"님이 "+today.getYear()+"년 "+today.getMonthValue()+"월 "+today.getDayOfYear()+"일에 남긴 글입니다.</h2>"); 
		out.println();
		out.print("<hr>");
		out.println();
		out.print("<li> 내용 : " + op + "</li>");
		out.print("<br>");
		out.print("<br>");
		out.print("<br>");
		out.print("</ul>"); out.print("<hr>");
		out.print("<a href='http://localhost:8000/sedu/html/visitorForm.html'>"
				+ "입력화면으로</a>");
		out.close();
	}

}
