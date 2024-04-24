package sec12.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 요청주소 : http://192.168.0.129:9098/sess
@WebServlet("/sess")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		// 수강생들이 강사컴에 들어갈 때마다 각각 session객체가 생성되면서 name이란 이름으로 이순신이 저장됨.
		session.setAttribute("name", "이순신");
		
		out.println("<html><body>");
		out.println("<h1>세션에 이름을 바인딩합니다.</h1>");
		out.println("<a href='/sec12/test01/session1.jsp'>첫번째 페이지로 이동하기</a>");
		out.println("</body></html>");
		
	}

}
