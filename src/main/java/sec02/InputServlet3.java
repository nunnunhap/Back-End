package sec02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet3
 */
@WebServlet("/input3")
public class InputServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	@Override
	public void init() throws ServletException {
		System.out.println("init 동작");
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 한글 깨짐방지 get방식은 한글 깨짐방식 안함.
//		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("u_name");
		String id = request.getParameter("u_id");
		String pw = request.getParameter("u_pw");
		String addr = request.getParameter("u_addr");
		String tel = request.getParameter("u_tel");
		// 나이를 숫자(정수)로 변환작업
		int age = Integer.parseInt(request.getParameter("u_age"));
		
		System.out.println("이름은? " + name);
		System.out.println("아이디는? " + id);
		System.out.println("비밀번호는? " + pw);
		System.out.println("주소는? " + addr);
		System.out.println("전화번호는? " + tel);
		System.out.println("나이는? " + age);
	}

}
