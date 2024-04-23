package sec09.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 쿠키목적 : 쿠키정보를 서버 측의 메모리 또는 DB에 저장하지 않고, 사용자 측(클라이언트)에 저장하여, 서블릿 측의 부담을 덜고자 할 때 사용.
// 브라우저에 의하여 전송되어 온 쿠키를 서버에서 읽는 예제
@WebServlet("/GetCookieValue")
public class GetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetCookieValue() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		Cookie[] allValues = request.getCookies();
		for(int i = 0; i < allValues.length; i++) {
			if(allValues[i].getName().equals("cookieTest")) {
				out.println("<h2>Cookie값 가져오기 : " + URLDecoder.decode(allValues[i].getValue(), "utf-8"));
			}
		}
	}
}
