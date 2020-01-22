package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector.Matcher;

@WebServlet("/basket2")
public class BasketServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if (session.getAttribute("productcnt") == null)
			session.setAttribute("productcnt", new int[11]);

		int id = Integer.parseInt(request.getParameter("pid"));
		
			if(id == 0) {
				session.invalidate();
				String str = "{\"메세지 \" : \"상품이 모두 삭제되었습니다.\"}";
				System.out.println(str);
				out.println(str);
			} else {
				String pid = String.format("{\"pid\":\"%s\"}", id);
				int[] session_p = (int[]) session.getAttribute("products");
				session_p[id] += 1;
				

				String path = "C:\\logtest";
				File isDir = new File(path);
				if (!isDir.exists()) {
					try {
						isDir.mkdir(); // 폴더 생성합니다.
						System.out.println("폴더가 생성되었습니다.");
					} catch (Exception e) {
						e.getStackTrace();
					}
				} else {
					System.out.println("이미 폴더가 생성되어 있습니다.");
				}
				
				FileWriter writer = null; // ""과 null은 다르다
				LocalDateTime today = LocalDateTime.now();
				DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
				
				try {
		            // 기존 파일의 내용에 이어서 쓰려면 true를, 기존 내용을 없애고 새로 쓰려면 false를 지정한다.
					writer = new FileWriter("c:\\logtest\\mylog.txt", true);
		            writer.write(today.format(myFormat)+" "+pid);
		            writer.write("\r\n");
		            writer.flush();
		            
		            System.out.println("파일이 생성되었습니다.");
		        } catch(IOException e) {
		            e.printStackTrace();
		        } 
			String str = "{";
			for (int i = 1 ; i<11; i++) {
				if(session_p[i]==0) continue;
				str += "\"p" + String.format("{\"pid\":\"%s\"}", id) + "\" : " + session_p[i];
				str += ",";
			}
			str = str.substring(0, str.length()-1);
			str += "}";
			System.out.println(str);
			out.println(str);
				
			}
		}
}

		


