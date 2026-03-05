package study2.dbTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoewonDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/springgreen";
	private String user = "root";
	private String password = "1234";
	
	private String sql = "";
	private HoewonVO vo = null;
	
	public HoewonDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("fail to find out the driver : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("fail to connect db : " + e.getMessage());
		}
	}
	
	public void connClose() {
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {}
	}
	
	public void pstmtClose() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {}
		}
	}
	
	public void rsClose() {
		if(rs != null) {
			try {
				rs.close();
				pstmtClose();
			} catch (SQLException e) {}
		}
	}

	public List<HoewonVO> getHoewonList() {
		List<HoewonVO> vos = new ArrayList<>();
		try {			
			sql = "select * from hoewon order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new HoewonVO();
				vo.setIdx(rs.getInt("idx"));				
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setAddress(rs.getString("address"));
				vos.add(vo);
			}			
		} catch (SQLException e) {
			System.out.println("SQL error(getHoewonList) + " + e.getMessage() );
		} finally {
			rsClose();
		}
		return vos;
	}

	public int setHoewonInputOk(HoewonVO vo) {
		int res = 0;
		try {
			sql = "insert into hoewon values (default, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getAddress());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL error(setHoewonInputOk) + " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}

	public HoewonVO getHoewonSearch(String name) {
		HoewonVO vo = new HoewonVO();
		try {
			sql = "select * from hoewon where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));				
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			System.out.println("SQL error(getHoewonSearch) + " + e.getMessage());
		} finally {
			rsClose();
		} 
		return vo;
	}

	public int setHoewonUpdateOk(HoewonVO vo) {
		int res = 0;		
		try {
			sql = "update hoewon set age=?, gender=?, address=? where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getAge());
			pstmt.setString(2, vo.getGender());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getName());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL error(getHoewonSearch) + " + e.getMessage() );
		} finally {
			pstmtClose();
		}
		return res;
	}

	public int setHoewonDelete(String name) {
		int res = 0;
		try {
			sql = "delete from hoewon where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL error(getHoewonSearch) + " + e.getMessage() );
		} finally {
			pstmtClose();
		}
		return res;
	}

}
