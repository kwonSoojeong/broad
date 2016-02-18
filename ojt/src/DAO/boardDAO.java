package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.Bean;

public class boardDAO {
	Connection conn = null;
	// Bean bean = new Bean();

	public boardDAO() {
		String url = "jdbc:mysql://testdb.cfouw2jf5pmt.ap-northeast-2.rds.amazonaws.com:3306/testdb?characterEncoding=utf8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "test", "test1234");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Bean> selectall() {
		List<Bean> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Bean bean = null;
		try {
			String sql = "select * from tb_board order by seq ASC ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 쿼리 결과

			while (rs.next()) { // 담는다
				bean = new Bean();
				bean.setSeq(rs.getInt("seq"));
				bean.setTitle(rs.getString("title"));
				bean.setContent(rs.getString("content"));
				bean.setName(rs.getString("name"));
				bean.setReg_date(rs.getString("reg_date"));
				bean.setUpdate_date(rs.getString("update_date"));
				list.add(bean);
				// System.out.println("seq===="+rs.getInt("seq"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("테이블 호출 실패");
		}
		return list;

	}

	public Bean select(int oneseq) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Bean bean = new Bean();
		try {
			String sql = "select seq, title, content, name, password, reg_date, update_date from tb_board WHERE seq=?";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, oneseq);
			rs = pstmt.executeQuery(); // 쿼리 결과

			// 담는다
		
			rs.next();
			bean.setSeq(rs.getInt("seq"));
			bean.setTitle(rs.getString("title"));
			bean.setContent(rs.getString("content"));
			bean.setName(rs.getString("name"));
			bean.setPassword(rs.getString("password"));
			bean.setReg_date(rs.getString("reg_date"));
			bean.setUpdate_date(rs.getString("update_date"));

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("테이블 호출 실패");
		} /*finally {

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException sqle) {
				} // Resultset 객체 해제
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sqle) {
				} // PreparedStatement 객체 해제
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException sqle) {
				} // Connection 해제
		}*/
		return bean;

	}

	public void insert(Bean bean) {

		// Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			String sql = "insert into tb_board ( title, content, name , password ,reg_date ) values(?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, bean.getContent());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getPassword());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sqle) {
				} // PreparedStatement 객체 해제
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException sqle) {
				}
		}
	}

	public void delete(int oneseq) {
		
		PreparedStatement pstmt = null;
		try {
		String sql = "delete from tb_board where seq=?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, oneseq);
		pstmt.executeUpdate(); // 쿼리 결과

		// 담는다
	

	} catch (SQLException se) {
		se.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("테이블 호출 실패");
	}

	}

	public void update(Bean bean) {
		PreparedStatement pstmt = null;

		try {

			String sql = "update tb_board set title =?,content=?,name=?,password=?,update_date=now() where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, bean.getContent());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getPassword());
			pstmt.setInt(5, bean.getSeq());
			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} /*finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sqle) {
				} // PreparedStatement 객체 해제
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException sqle) {
				}
		}*/

	}
}
