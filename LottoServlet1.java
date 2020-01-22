package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lotto1")
public class LottoServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html; charset=UTF-8");
		String lottonum = request.getParameter("lotto");
		int lottonum1 = (int) (Math.random()*6)+1;
		
		System.out.println("전달된 값 : " + lottonum + " "+"추출된 값 : "+lottonum1);
		
		if(Integer.parseInt(lottonum)==lottonum1) {
			RequestDispatcher rd = request.getRequestDispatcher("jspexam/success.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("jspexam/fail.jsp");
			rd.forward(request, response);
		}
	}
}
