package com.newspage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.newspage.beans.Giangvien;
import com.newspage.beans.Kltn;
import com.newspage.beans.Sinhvien;

public class KltnDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int saveKltn(Kltn s){    
	    String sql="insert into kltn(detai, mgv, cstt, idhk) values('"+s.getDetai()+"', '"+s.getMgv()+"',  '"+s.getCstt()+"',  '"+s.getIdhk()+"')";    
	    return template.update(sql);    
	}    
	public int updateKltn(Kltn s){    
	    String sql="update kltn set detai='"+s.getDetai()+"', mgv='"+s.getMgv()+"', cstt='"+s.getCstt()+"', idhk='"+s.getIdhk()+"' where mkl="+s.getMkl()+"";    
	    return template.update(sql);    
	}    
	public int deleteKltn(int mkl){    
	    String sql="delete from kltn where mkl="+mkl+"";    
	    return template.update(sql);    
	}  
	
	public int regeKltn(int msv, int mkl){    
	    String sql="update kltn set msv='"+msv+"' where mkl="+mkl+"";    
	    return template.update(sql);    
	} 
	
	public Kltn getKltnById(int mkl){    
	    String sql="select * from kltn where mkl=?";    
	    return template.queryForObject(sql, new Object[]{mkl},new BeanPropertyRowMapper<Kltn>(Kltn.class));    
	}
	
	public List<Kltn> getKltns(int id){    
	    return template.query("select * from kltn INNER JOIN giangvien ON kltn.mgv = giangvien.mgv LEFT JOIN sinhvien ON kltn.msv = sinhvien.msv where idhk="+id+"",new RowMapper<Kltn>(){    
	        public Kltn mapRow(ResultSet rs, int row) throws SQLException {    
	        	Kltn k=new Kltn();
	            k.setMkl(rs.getInt(1));    
	            k.setDetai(rs.getString(2));    
	            k.setMgv(rs.getString(3));    
	            k.setMsv(rs.getString(4));     
	            k.setDuyet(rs.getString(5));
	            k.setCstt(rs.getString(6));
	            k.setIdhk(rs.getInt(7));
	            
	            Sinhvien s = new Sinhvien();
	            s.setHoten(rs.getString("sinhvien.hoten"));
	            s.setMsv(rs.getString("msv"));
	            s.setLop(rs.getString("sinhvien.lop"));
	            k.setSinhvien(s);
	            
	            Giangvien g= new Giangvien();
	            g.setHoten(rs.getString("giangvien.hoten"));
	            g.setBomon(rs.getString("bomon"));
	            k.setGiangvien(g);
	            
	            return k;    
	        }    
	    });    
	}
}
