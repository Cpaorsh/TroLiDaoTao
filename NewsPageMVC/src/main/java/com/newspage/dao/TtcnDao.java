package com.newspage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.newspage.beans.Dttt;
import com.newspage.beans.Giangvien;
import com.newspage.beans.Sinhvien;
import com.newspage.beans.Ttcn;

public class TtcnDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int addTtcn(String msv){    
	    String sql="insert into ttcn(msv) values('"+msv+"')";    
	    return template.update(sql);    
	} 
	public int duyetTtcn(Ttcn s){    
	    String sql="update ttcn set duyet='"+s.getDuyet()+"', lidotc='"+s.getLidotc()+"' where msv="+s.getMsv()+"";    
	    return template.update(sql);    
	}
	public int updateTtcn(Ttcn s){    
	    String sql="update ttcn set mdt='"+s.getMdt()+"', cstt='"+s.getCstt()+"' where msv="+s.getMsv()+"";    
	    return template.update(sql);    
	}    
	public int deleteTtcn(String msv){    
	    String sql="delete from ttcn where msv="+msv+"";    
	    return template.update(sql);    
	}    
	public Ttcn getTtcnById(String msv){    
	    String sql="select * from ttcn where msv=?";    
	    return template.queryForObject(sql, new Object[]{msv},new BeanPropertyRowMapper<Ttcn>(Ttcn.class));    
	}
	
	public List<Ttcn> getTtcns(int id){    
	    return template.query("select * from ttcn INNER JOIN sinhvien ON ttcn.msv = sinhvien.msv INNER JOIN dttt INNER JOIN giangvien ON dttt.mgv = giangvien.mgv ON ttcn.mdt = dttt.mdt where idhk="+id+" and ttcn.duyet=1",new RowMapper<Ttcn>(){    
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
	            
	            Dttt d=new Dttt(); 
	            d.setTendt(rs.getString("tendt"));
	            Giangvien g= new Giangvien();
	            g.setHoten(rs.getString("giangvien.hoten"));
	            g.setBomon(rs.getString("bomon"));
	            d.setGiangvien(g);          
	            t.setDttt(d);
	             
	            return t;    
	        }    
	    });    
	}
	
	
	public List<Ttcn> getTtcnCd(){    
	    return template.query("select * from ttcn INNER JOIN sinhvien ON ttcn.msv = sinhvien.msv INNER JOIN dttt INNER JOIN giangvien ON dttt.mgv = giangvien.mgv ON ttcn.mdt = dttt.mdt where ttcn.duyet is null",new RowMapper<Ttcn>(){    
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
	             
	            return t;    
	        }    
	    });    
	}
	
	public List<Ttcn> getTtcnKd(){    
	    return template.query("select * from ttcn INNER JOIN sinhvien ON ttcn.msv = sinhvien.msv INNER JOIN dttt INNER JOIN giangvien ON dttt.mgv = giangvien.mgv ON ttcn.mdt = dttt.mdt where  ttcn.duyet=0",new RowMapper<Ttcn>(){    
	    public Ttcn mapRow(ResultSet rs, int row) throws SQLException {    
	        	Ttcn t=new Ttcn();    
	        	t.setMsv(rs.getString(1));
	        	t.setMdt(rs.getInt(2));       
	            t.setCstt(rs.getString(3)); 
	            t.setLidotc(rs.getString(4)); 

	            Sinhvien s = new Sinhvien();
	            s.setHoten(rs.getString("sinhvien.hoten"));
	            s.setMsv(rs.getString("msv"));
	            s.setLop(rs.getString("sinhvien.lop"));
	            t.setSinhvien(s);           
	             
	            return t;    
	        }    
	    });    
	}
}
