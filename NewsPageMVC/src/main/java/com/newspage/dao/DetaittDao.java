package com.newspage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.newspage.beans.Detaitt;
import com.newspage.beans.Giangvien;

public class DetaittDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int saveDt(Detaitt s){    
	    String sql="insert into detaitt(tendt, mgv) values('"+s.getTendt()+"', '"+s.getMgv()+"')";    
	    return template.update(sql);    
	}    
	public int updateDt(Detaitt s){    
	    String sql="update detaitt set tendt='"+s.getTendt()+"', mgv='"+s.getMgv()+"', duyet='"+s.getDuyet()+"' where mdt="+s.getMdt()+"";    
	    return template.update(sql);    
	}    
	public int deleteDt(String mdt){    
	    String sql="delete from detaitt where mdt="+mdt+"";    
	    return template.update(sql);    
	}    
	public Detaitt getDtById(String mdt){    
	    String sql="select * from detaitt where mdt=?";    
	    return template.queryForObject(sql, new Object[]{mdt},new BeanPropertyRowMapper<Detaitt>(Detaitt.class));    
	}
	
	public List<Detaitt> getDts(int id){    
	    return template.query("select * from detaitt INNER JOIN giangvien ON detaitt.mgv = giangvien.mgv where idhk="+id+"",new RowMapper<Detaitt>(){    
	        public Detaitt mapRow(ResultSet rs, int row) throws SQLException {    
	        	Detaitt d=new Detaitt();    
	            d.setMdt(rs.getInt(1));    
	            d.setTendt(rs.getString(2));    
	            d.setMgv(rs.getString(3));       
	            d.setDuyet(rs.getByte(4));
	            d.setLidotc(rs.getString(5));
	            d.setIdhk(rs.getInt(6));
	            
	            Giangvien g= new Giangvien();
	            g.setHoten(rs.getString("hoten"));
	            g.setBomon(rs.getString("bomon"));
	            d.setGiangvien(g);
	            
	            return d;    
	        }    
	    });    
	}
}
