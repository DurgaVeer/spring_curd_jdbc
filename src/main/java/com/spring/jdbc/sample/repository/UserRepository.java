package com.spring.jdbc.sample.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.spring.jdbc.sample.dto.GenericResponse;
import com.spring.jdbc.sample.dto.UserDto;

@Repository
public class UserRepository {
	private static Connection con;

	public static Connection getConnection() throws SQLException {
		if (!ObjectUtils.isEmpty(con)) {
			return con;
		}

		Connection con = DriverManager.getConnection("jdbc:mysql://101.53.155.156:3306/mysql_demo_tnj",
				"mysql_demo_tnj", "Ebrain@20");

		return con;

	}

	public void save(UserDto user) throws SQLException {
		Connection con = getConnection();
		String insertQuery = "insert into tb_durga_spring(id,full_name,email_id,mobile_no) values (?,?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getFullname());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(4, user.getMobileno());
		preparedStatement.executeUpdate();

		con.close();
	}

	public static List<UserDto> getAllUsers() throws SQLException {
		Connection con = getConnection();
		String selectQuery = "select * from tb_durga_spring";
		PreparedStatement ps = con.prepareStatement(selectQuery);
		ResultSet rs = ps.executeQuery();
		List<UserDto> a = new ArrayList<UserDto>();
		UserDto ud = null;
		while (rs.next()) {
			ud = new UserDto();
			ud.setId(rs.getInt(1));
			ud.setFullname(rs.getString(2));
			ud.setEmail(rs.getString(3));
			ud.setMobileno(rs.getString(4));
			a.add(ud);

		}
		ps.close();
		con.close();
		return a;

	}

	public void update(UserDto user) throws SQLException {
		Connection con = getConnection();
		String updateQuery = "update tb_durga_spring set mobile_no=? where id=?";
		PreparedStatement ps = con.prepareStatement(updateQuery);

		ps.setString(1, user.getMobileno());
		ps.setInt(2, user.getId());
		ps.executeLargeUpdate();
		ps.close();
		con.close();

	}

	public void delete(UserDto user) throws SQLException {
		Connection con = getConnection();
		String deleteQuery = "delete  from tb_durga_spring  where id=?";
		PreparedStatement ps = con.prepareStatement(deleteQuery);
		ps.setInt(1, user.getId());
		ps.executeLargeUpdate();
		ps.close();
		con.close();

}

		public UserDto getById(Integer id) throws SQLException {
	
			Connection con = getConnection();
			String selectQuery = "select * from tb_durga_spring where id=?";
			PreparedStatement ps = con.prepareStatement(selectQuery);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			//List<UserDto> a = new ArrayList<UserDto>();
			UserDto ud = null;
			while (rs.next()) {
				ud = new UserDto();
				ud.setId(rs.getInt(1));
				ud.setFullname(rs.getString(2));
				ud.setEmail(rs.getString(3));
				ud.setMobileno(rs.getString(4));
				
		
	
	}
			return ud;

	
	}



}
	
		
	
		
	

		
		
	


