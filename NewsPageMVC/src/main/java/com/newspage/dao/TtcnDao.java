package com.newspage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.newspage.beans.Detaitt;
import com.newspage.beans.Giangvien;
import com.newspage.beans.Sinhvien;
import com.newspage.beans.Ttcn;

public class TtcnDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int saveTtcn(Ttcn s){    
	    String sql="insert into ttcn(mdt, cstt, msv) values('"+s.getMdt()+"', '"+s.getCstt()+"',  '"+s.getMsv()+"')";    
	    return template.update(sql);    
	}    
	public int updateTtcn(Ttcn s){    
	    String sql="update ttcn set mdt='"+s.getMdt()+"', cstt='"+s.getCstt()+"' where msv="+s.getMsv()+"";    
	    return template.update(sql);    
	}    
	public int deleteTtcn(String msv){    
	    String sql="delete from ttcn where mgv="+msv+"";    
	    return template.update(sql);    
	}    
	public Ttcn getTtcnById(String msv){    
	    String sql="select * from ttcn where msv=?";    
	    return template.queryForObject(sql, new Object[]{msv},new BeanPropertyRowMapper<Ttcn>(Ttcn.class));    
	}
	
	public List<Ttcn> getTtcns(int id){    
	    return template.query("select * from ttcn INNER JOIN sinhvien ON ttcn.msv = sinhvien.msv INNER JOIN detaitt INNER JOIN giangvien ON detaitt.mgv = giangvien.mgv ON ttcn.mdt = detaitt.mdt where idhk="+id+"",new RowMapper<Ttcn>(){    
	        public Ttcn mapRow(ResultSet rs, int row) throws SQLException {    
	        	Ttcn t=new Ttcn();    
	        	t.setMsv(rs.getString(1));
	        	t.setMdt(rs.getInt(2));       
	            t.setCstt(rs.getString(3)); 

	            Sinhvien s = new Sinhvien();
	            s.setHoten(rs.getString("sinhvien.hoten"));
	            s.setMsv(rs.getString("msv"));
	            s.setLop(rs.getString("sinhvien.lop"));
	            t.setSinhvien(s);           
	            
	            Detaitt d=new Detaitt(); 
	            d.setTendt(rs.getString("tendt"));
	            Giangvien g= new Giangvien();
	            g.setHoten(rs.getString("giangvien.hoten"));
	            g.setBomon(rs.getString("bomon"));
	            d.setGiangvien(g);          
	            t.setDetaitt(d);
	             
	            return t;    
	        }    
	    });    
	}
}
