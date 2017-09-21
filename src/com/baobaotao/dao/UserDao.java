package com.baobaotao.dao;

import java.net.UnknownServiceException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int getMatchCount(String userName, String passWord) {
		String sqlStr = "SELECT COUNT(*) FROM t_USER "
				+ " WHERE user_name = ? and password = ? ";
		return jdbcTemplate.queryForInt(sqlStr, new Object[]{userName,passWord});
	}
	
	public User findUserByUserName(final String userName){
		String sqlStr = " SELECT user_id,user_name,credits "
				+ " FROM t_user WHERE user_name = ? ";
		final User user = new User();
		jdbcTemplate.query(sqlStr, new Object[]{userName}, 
				new RowCallbackHandler() {
					
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						user.setUserId(rs.getInt("user_id"));
						user.setUserName(rs.getString("user_name"));
						user.setCredits(rs.getInt("credits"));
					}
				});
		return user;
	}
	
	public void updateLoginInfo(User user){
		String sqlStr = " UPDATE t_user SET last_visit = ?, last_ip = ?, credits = ? "
				+ " WHERE user_id = ? ";
		jdbcTemplate.update(sqlStr, new Object[]{user.getLastVisit(),user.getLatIp(),user.getCredits(),user.getUserId()});
	}
}
