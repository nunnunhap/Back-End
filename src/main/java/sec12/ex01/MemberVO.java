package sec12.ex01;

import java.sql.Date;

// 오라클의 테이블을 기반으로 클래스 생성. 테이블이 여러개면 이 MemberVO 클래스가 여러개 생김.
public class MemberVO {
	//DB테이블의 구조를 가지고 내용을 채워야 함.
	private String 	id;
	private String 	pwd;
	private String 	name;
	private String 	email;
	private Date	joinDate;
	
	public MemberVO() {
		System.out.println("MemberVO 생성자 호출");
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}
