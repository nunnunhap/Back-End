package sec08.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:9098/Sec08Ex01FirstServlet
@WebServlet("/Sec08Ex01FirstServlet")
public class Sec08Ex01FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Sec08Ex01FirstServlet() {
        super();
    }

    // get요청 시 동작
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버에서 클라이언트로 보내는 데이터에 대한 처리를 MIME-Type정보와 인코딩 방식으로 하라.
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 서버에서 클라이언트로 보내는 응답 정보속에 아래 header작업도 추가되어 보내진다.
		// Refresh키는 예약어, 1은 초
		// 헤더를 클라이언트의 브라우저가 읽고, 브라우저의 내용을 새로고침하는데 1초가 경과되고 url주소로 새로고침
		response.addHeader("Refresh", "1;url=/Sec08Ex01SecondServlet");
	}
}
