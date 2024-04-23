package sec09.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sec09Ex01LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		// hidden 필드의 값을 여기서 확인한다.
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");
		
		// db를 이용하여, 아이디비밀번호 존재여부 체크 작업 => spring가서 하기
		// 사용자가 입력한 로그인 정보가 admin, 1234일 경우 아래 if문은 true가 됨.
		if(user_id.equals("admin") && user_pw.equals("1234")) {
			// 인증된 사용자로 처리작업 - session객체 이용
			// 브라우저에게 발급해준 JSessionID의 식별자값으로 활성화된 서버 측 메모리에 "auth"란 키 이름으로 user_id변수의 값을 저장
			request.getSession().setAttribute("auth", user_id);
			
			//response.sendRedirect(); ()안의 주소로 이동됨.
			response.sendRedirect("/sec09/main.jsp");
		}else {
			// 인증실패
			// 다시 로그온 페이지로 돌아가도록 : 3가지 방법
			// 클라이언트로 사용하는 브라우저에 아래 정보가 전송
			// 브라우저에게 보내는 한글 데이터 인코딩과 콘텐트에 MIME TYPE 작업
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('로그인정보가 틀렸습니다. 확인해주세요.');");
			out.print("location.href='/sec09/login.jsp';");
			out.print("</script>");
		}	
	}
}
