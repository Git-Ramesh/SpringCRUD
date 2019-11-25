package com.rs.user.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.rs.user.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	private static final String INSERT_QUERY = "INSERT INTO JDBC_USER (NAME, AGE, EMAIL, ADDRESS) VALUES (?,?,?,?)";
	private static final String FIND_USER_QUERY = "SELECT ID, NAME, AGE, EMAIL, ADDRESS FROM JDBC_USER WHERE ID = ?";
	private static final String FIND_USERS_QUERY = "SELECT ID, NAME, AGE, EMAIL, ADDRESS FROM JDBC_USER";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User save(User user) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(conn -> {
			PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY, new String[] { "id" });
			stmt.setString(1, user.getName());
			stmt.setInt(2, user.getAge());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getAddress());
			return stmt;
		}, keyHolder);

		user.setId(Long.valueOf(keyHolder.getKey().longValue()));
		return user;
	}

	@Override
	public void update(User user) {

	}

	@Override
	public void delete(Long id) {

	}

	@Override
	public User fetch(Long id) {
		return jdbcTemplate.queryForObject(FIND_USER_QUERY, new UserRowMapper());
	}

	@Override
	public List<User> fetchAll() {
		return jdbcTemplate.query(FIND_USERS_QUERY, new UserRowMapper());
	}

	private class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getLong(1));
			user.setName(rs.getString(2));
			user.setAge(rs.getInt(3));
			user.setEmail(rs.getString(4));
			user.setAddress(rs.getString(5));
			return user;
		}
	}

}
