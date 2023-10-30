package com.newspage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.newspage.beans.Sinhvien;
import com.newspage.beans.Giangvien;
import com.newspage.beans.Login;
import com.newspage.beans.User;

public class UserDaoImpl implements UserDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public int register(User user) {
    String sql = "insert into users values(?,?,?)";

    return jdbcTemplate.update(sql, new Object[] { user.getMax(), user.getUsername(), user.getPassword()  });
  }

  //select * from drl INNER JOIN sinhvien ON drl.msv = sinhvien.msv
  public User validateUser(Login login) {
	if (login.getUsername().startsWith("1")) {
		String sql = "select * from users INNER JOIN sinhvien ON users.max = sinhvien.msv where username='" + login.getUsername() + "' and password='" + login.getPassword()+ "'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}else {
		String sql = "select * from users INNER JOIN giangvien ON users.max = giangvien.mgv where username='" + login.getUsername() + "' and password='" + login.getPassword()+ "'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}  
  }
}

class UserMapper implements RowMapper<User> {

  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();
    Sinhvien s = new Sinhvien();
    Giangvien g= new Giangvien();
    
    user.setMax(rs.getString("max"));
    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));

    s.setHoten(rs.getString("hoten"));
    s.setChucvu(rs.getString("chucvu"));
    user.setSinhvien(s);
    
    g.setHoten(rs.getString("hoten"));
    g.setChucvu(rs.getString("chucvu"));
    user.setGiangvien(g);

    return user;
  }
}