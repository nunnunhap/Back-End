package sec07;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberOk")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberServlet() {
        super();
    }
    
    // get요청방식일 때 호출되는 방식
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
 
	
	// post요청방식일 때 호출되는 방식
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 글자깨짐 방지, mime type(웹에서 데이터 주고받을 때의 데이터 성격을 설명)
		response.setContentType("text/html;charset=utf-8");
		
		// DB 연동기능 클래스
		MemberDAO dao = new MemberDAO();
		
		// 출력 스트림 : 네트워크를 이용한 스트림 작업
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8"); // 한글깨짐방지
		
		String command = request.getParameter("command");
		
		if(command != null && command.equals("addMember")) {
			//회원을 등록하라
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setEmail(email);
			
			dao.insMember(vo);
			
		}else if(command != null && command.equals("delMember")) {
			// 회원 삭제해라
			String id = request.getParameter("id");
			dao.delMember(id);
		}
		
		// 테이블의 모든 데이터 출력하기
		List<MemberVO> list = dao.listMembers();
		// out.print()는 클라이언트에게 전송하는 역할
		out.print("<html><body>");
		
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");
		
		for(int i = 0; i < list.size(); i++) {
			MemberVO memVO = list.get(i);
			String id = memVO.getId();
			String pwd = memVO.getPwd();
			String name = memVO.getName();
			String email = memVO.getEmail();
			Date joinDate = memVO.getJoinDate();
			
			out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>"
					+ email + "</td><td>" + joinDate + "</td><td>"
					+ "<a href='/memberOk?command=delMember&id=" + id + "'>삭제</a></td></tr>");
		}
		out.print("</table>");
		out.print("<a href='/sec07/memberForm.html'>회원등록</a>");
		out.print("</body></html>");
		
	}
}
