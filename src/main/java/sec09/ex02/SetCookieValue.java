package sec09.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetCookieValue")
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetCookieValue() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		// 클라이언트(브라우저)에게 보내는 작업
		PrintWriter out = response.getWriter(); // out이름은 바꾸지 말 것.
		Date d = new Date();
		
		// 쿠키 작업
		Cookie cookie = new Cookie("cookieTest", URLEncoder.encode("JSP프로그래밍입니다.", "utf-8"));
		cookie.setMaxAge(24 * 60 * 60); // 1일(초단위)
		
		// 이 작업을 하면 client(브라우저)에게 쿠키 정보가 전송된다.
		response.addCookie(cookie); // 자동으로 서버에 존재하고 있는 정보가 브라우저로 보내짐.
		out.println("현재시간 : " + d);
		out.println("<br>문자열을 Cookie에 저장합니다.");
	}
}
