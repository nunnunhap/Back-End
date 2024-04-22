package sec08.ex05;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sec08Ex05FirstServlet")
public class Sec08Ex05FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Sec08Ex05FirstServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글깨짐방지
		response.setContentType("text/html;charset=utf-8");
		
		// request객체 : 클라이언트에서 보내온 모든 정보를 관리하는 객체
		/*
		 - 사용자가 입력한 데이터
		 - 클라이언트의 브라우저 종류, 버전, ip 등
		 */
		// request객체에 정보 추가 작업. 클라이언트가 직접 찍은건 아니지만...
		request.setAttribute("address", "서울시 노원구 이젠빌딩");
		// 주소 이동   이동주소가 클라이언트로 보내져서 새로운 주소 요청작업이 발생된다.
		// 새로운 주소요청작업 : 이전 request객체와는 다른 새로운 request객체로 이전 정보를 참조할 수 가 없다.
		response.sendRedirect("/Sec08Ex05SecondServlet");
	}
}
