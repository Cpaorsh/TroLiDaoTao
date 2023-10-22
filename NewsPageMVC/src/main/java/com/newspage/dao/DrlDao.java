package com.newspage.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;

import com.newspage.beans.Drl;
import com.newspage.beans.Sinhvien;  

public class DrlDao {

JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	
	
	public int saveSv(Drl p){    
		String sql="insert into drl(ythuc, clbhoc, quyche, vuotkho, hoctap, tsvgioi, kqchaphanh, tgngoaikhoa, dangnn, bieuduong, giupdo, tgdoanhoi) values('"+p.getYthuc()+"', '"+p.getClbhoc()+"',  '"+p.getQuyche()+"', '"+p.getVuotkho()+"','"+p.getHoctap()+"','"+p.getTsvgioi()+"','"+p.getKqchaphanh()+"','"+p.getTgngoaikhoa()+"','"+p.getDangnn()+"','"+p.getBieuduong()+"','"+p.getGiupdo()+"','"+p.getTgdoanhoi()+"')"; 
	    return template.update(sql);    
	}    
	public int updateSv(Drl p){    
		String sql="update page set ythuc='"+p.getYthuc()+"', clbhoc='"+p.getClbhoc()+"', quyche='"+p.getQuyche()+"', vuotkho='"+p.getVuotkho()+"', hoctap='"+p.getHoctap()+"', tsvgioi='"+p.getTsvgioi()+"', kqchaphanh='"+p.getKqchaphanh()+"', tgngoaikhoa='"+p.getTgngoaikhoa()+"', dangnn='"+p.getDangnn()+"', bieuduong='"+p.getBieuduong()+"', giupdo='"+p.getGiupdo()+"', tgdoanhoi='"+p.getTgdoanhoi()+"' where masv="+p.getMsv()+"";    
	    return template.update(sql);    
	}
	
	public int saveLt(Drl p){    
		String sql="insert into drl(ltythuc, ltclbhoc, ltquyche, ltvuotkho, lthoctap, lttsvgioi, ltkqchaphanh, lttgngoaikhoa, ltdangnn, ltbieuduong, ltgiupdo, lttgdoanhoi) values('"+p.getLtythuc()+"', '"+p.getLtclbhoc()+"',  '"+p.getLtquyche()+"', '"+p.getLtvuotkho()+"','"+p.getLthoctap()+"','"+p.getLttsvgioi()+"','"+p.getLtkqchaphanh()+"','"+p.getLttgngoaikhoa()+"','"+p.getLtdangnn()+"','"+p.getLtbieuduong()+"','"+p.getLtgiupdo()+"','"+p.getLttgdoanhoi()+"')"; 
	    return template.update(sql);    
	}    
	public int updateLt(Drl p){    
		String sql="update page set ltythuc='"+p.getLtythuc()+"', ltclbhoc='"+p.getLtclbhoc()+"', ltquyche='"+p.getLtquyche()+"', ltvuotkho='"+p.getLtvuotkho()+"', lthoctap='"+p.getLthoctap()+"', lttsvgioi='"+p.getLttsvgioi()+"', ltkqchaphanh='"+p.getLtkqchaphanh()+"', lttgngoaikhoa='"+p.getLttgngoaikhoa()+"', ltdangnn='"+p.getLtdangnn()+"', ltbieuduong='"+p.getLtbieuduong()+"', ltgiupdo='"+p.getLtgiupdo()+"', lttgdoanhoi='"+p.getLttgdoanhoi()+"' where masv="+p.getMsv()+"";    
	    return template.update(sql);    
	}
	
	public int saveGv(Drl p){    
		String sql="insert into drl(gvythuc, gvclbhoc, gvquyche, gvvuotkho, gvhoctap, gvtsvgioi, gvkqchaphanh, gvtgngoaikhoa, gvdangnn, gvbieuduong, gvgiupdo, gvtgdoanhoi) values('"+p.getGvythuc()+"', '"+p.getGvclbhoc()+"',  '"+p.getGvquyche()+"', '"+p.getGvvuotkho()+"','"+p.getGvhoctap()+"','"+p.getGvtsvgioi()+"','"+p.getGvkqchaphanh()+"','"+p.getGvtgngoaikhoa()+"','"+p.getGvdangnn()+"','"+p.getGvbieuduong()+"','"+p.getGvgiupdo()+"','"+p.getGvtgdoanhoi()+"')"; 
	    return template.update(sql);    
	}    
	public int updateGv(Drl p){    
		String sql="update page set gvythuc='"+p.getGvythuc()+"', gvclbhoc='"+p.getGvclbhoc()+"', gvquyche='"+p.getGvquyche()+"', gvvuotkho='"+p.getGvvuotkho()+"', gvhoctap='"+p.getGvhoctap()+"', gvtsvgioi='"+p.getGvtsvgioi()+"', gvkqchaphanh='"+p.getGvkqchaphanh()+"', gvtgngoaikhoa='"+p.getGvtgngoaikhoa()+"', gvdangnn='"+p.getGvdangnn()+"', gvbieuduong='"+p.getGvbieuduong()+"', gvgiupdo='"+p.getGvgiupdo()+"', gvtgdoanhoi='"+p.getGvtgdoanhoi()+"' where masv="+p.getMsv()+"";    
	    return template.update(sql);    
	}
	
	
	public Drl getDrlByMsv(int msv){    
	    String sql="select * from drl where msv=?";    
	    return template.queryForObject(sql, new Object[]{msv},new BeanPropertyRowMapper<Drl>(Drl.class));    
	}
	
	
	public List<Drl> getDrls(){    
	    return template.query("select * from drl INNER JOIN sinhvien ON drl.msv = sinhvien.msv",new RowMapper<Drl>(){    
	        public Drl mapRow(ResultSet rs, int row) throws SQLException {    
	        	Drl e=new Drl(); 
	        	Sinhvien s= new Sinhvien();
	            e.setMsv(rs.getInt(1));    
	            e.setYthuc(rs.getInt(2));    
	            e.setClbhoc(rs.getInt(3));    
	            e.setQuyche(rs.getInt(4));     
	            e.setVuotkho(rs.getInt(5));  
	            e.setHoctap(rs.getInt(6));
	            e.setTsvgioi(rs.getInt(7));
	            e.setKqchaphanh(rs.getInt(8));
	            e.setTgngoaikhoa(rs.getInt(9));
	            e.setDangnn(rs.getInt(10));
	            e.setBieuduong(rs.getInt(11));
	            e.setGiupdo(rs.getInt(12));
	            e.setTgdoanhoi(rs.getInt(13));
	            e.setTongdiem(rs.getInt(14));
	            
	            e.setLtythuc(rs.getInt(15));    
	            e.setLtclbhoc(rs.getInt(16));    
	            e.setLtquyche(rs.getInt(17));     
	            e.setLtvuotkho(rs.getInt(18));  
	            e.setLthoctap(rs.getInt(19));
	            e.setLttsvgioi(rs.getInt(20));
	            e.setLtkqchaphanh(rs.getInt(21));
	            e.setLttgngoaikhoa(rs.getInt(22));
	            e.setLtdangnn(rs.getInt(23));
	            e.setLtbieuduong(rs.getInt(24));
	            e.setLtgiupdo(rs.getInt(25));
	            e.setLttgdoanhoi(rs.getInt(26));
	            e.setLttongdiem(rs.getInt(27));
	            
	            e.setGvythuc(rs.getInt(28));    
	            e.setGvclbhoc(rs.getInt(29));    
	            e.setGvquyche(rs.getInt(30));     
	            e.setGvvuotkho(rs.getInt(31));  
	            e.setGvhoctap(rs.getInt(32));
	            e.setGvtsvgioi(rs.getInt(33));
	            e.setGvkqchaphanh(rs.getInt(34));
	            e.setGvtgngoaikhoa(rs.getInt(35));
	            e.setGvdangnn(rs.getInt(36));
	            e.setGvbieuduong(rs.getInt(37));
	            e.setGvgiupdo(rs.getInt(38));
	            e.setGvtgdoanhoi(rs.getInt(39));
	            e.setGvtongdiem(rs.getInt(40));
	           
	            s.setHoten(rs.getString("hoten"));
	            s.setLop(rs.getString("lop"));
	            e.setSinhvien(s);
	            return e;    
	        }    
	    });    
	}
}
