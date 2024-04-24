package sec12.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 데이터베이스 연동기능 : Data Access Object(연결하고 동작(sql문 실행))
// JDK 안에 JDBC 기능 라이브러리
// 이건 그냥 사용법이 정의되어 있으니 그냥 가져다 쓰면 됨.
public class MemberDAO {
	private Connection conn; // 데이터베이스 연결 목적
	private PreparedStatement pstmt; // 연결상태에서 sql문 실행 목적
//	private ResultSet rs; // sql문 중 Select문 실행 시 출력되는 결과 저장 목적
	
		// url format = jdbc:oracle:thin:@[HOST][:PORT]:SID // 자기 컴퓨터를 가리키기에 localhost
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; //오라클서버 호스트 이름
	private String uid = "jspuser"; // 계정
	private String pw = "jspuser"; // 비밀번호
		
	public MemberDAO() {
		
	}
	
	public Connection getConnection() throws SQLException {
		if(conn == null || conn.isClosed()) {
			try {
				// 메모리 상에 DriverManager 객체가 로딩
				// 절대 알집으로 풀고 압축하면 안되긴 하는데 OracleDriver가 알집으로 봤을 때 밑의 경로에 있음.
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			// 위의 Class.forName()의 값으로 DriverManager 객체 생성하고 getConnection() 메서드로 연결
			// conn객체가 생성된다.(데이터베이스와 연결상태)
			// conn객체가 생성 시 오류가 나면 (url, uid, pw)값이 문제일 수 있음.
			conn = DriverManager.getConnection(url, uid, pw);
		}
		return conn;
	}
	
	// 회원가입(insert)
	public void insMember(MemberVO vo) {
		try {
			// 1) Connection 객체 생성
			conn = getConnection(); // open의 개념
			
			// 2) 쿼리 준비단계
			String id = vo.getId();
			String pwd = vo.getPwd();
			String name = vo.getName();
			String email = vo.getEmail();
			
			String sql = "insert into t_member(id, pwd, name, email)";
			sql += " values(?, ?, ?, ?)";
			 
			// sql 변수 안에 ?(placeholder)에 값을 대입한 insert문이 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			// 3) 쿼리 실행단계
			// sql변수의 insert문을 오라클 데이터베이스 서버에게 실행요청
			pstmt.executeUpdate(); // sql문이 insert, delete, update에 사용할 메서드
			
			// 4) 객체 연결 닫기(닫기도 순서가 있음)
			pstmt.close();
			conn.close(); // 가장 처음 open했으니 마지막에 close()
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 회원삭제(delete)
	public void delMember(String id) {
		try {
			conn = getConnection();
			String sql = "delete from t_member " + " where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 회원목록(select), 테이블의 여러 데이터를 받아오기 위해서 무조건 list컬렉션 사용해야 함.
	public List<MemberVO> listMembers() {
		// 회원 테이블의 모든 데이터를 list컬렉션 객체 저장
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			// 1) Connection 객체 생성
			conn = getConnection();
			
			// 2) 
			String sql = "select * from t_member";
			pstmt = conn.prepareStatement(sql);
			
			// 데이터 존재유무를 떠나서 rs객체가 생성되고 커서라는 것이 존재함.
			// 커서의 현재 위치는 table의 제목행(헤더)라는 곳을 가리킨다.
			ResultSet rs = pstmt.executeQuery(); // sql문의 select일 경우 사용
			
			// next()는 커서를 다음 위치로 이동하면서 데이터가 있으면 true, 없으면 false 반환
			while(rs.next()) {
				
				// rs객체로부터 데이터를 읽어옴.
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(rs.getDate("joinDate"));
				
				list.add(vo);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}