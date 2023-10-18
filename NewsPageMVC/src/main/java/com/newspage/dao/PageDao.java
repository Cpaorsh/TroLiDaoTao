package com.newspage.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;  

import com.newspage.beans.Page;


public class PageDao {  
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int save(Page p){    
	    String sql="insert into page(title, content, category) values('"+p.getTitle()+"', '"+p.getContent()+"',  '"+p.getCategory()+"')";    
	    return template.update(sql);    
	}    
	public int update(Page p){    
	    String sql="update page set title='"+p.getTitle()+"', content='"+p.getContent()+"', category='"+p.getCategory()+"' where id="+p.getId()+"";    
	    return template.update(sql);    
	}    
	public int delete(int id){    
	    String sql="delete from page where id="+id+"";    
	    return template.update(sql);    
	}    
	public Page getPageById(int id){    
	    String sql="select * from page where id=?";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Page>(Page.class));    
	}
	

	public List<Page> getPages(){    
	    return template.query("select * from page order by datec desc",new RowMapper<Page>(){    
	        public Page mapRow(ResultSet rs, int row) throws SQLException {    
	            Page e=new Page();    
	            e.setId(rs.getInt(1));    
	            e.setTitle(rs.getString(2));    
	            e.setAuthor(rs.getString(3));    
	            e.setCategory(rs.getString(4));     
	            e.setContent(rs.getString(5));  
	            e.setDatec(rs.getDate(6));
	            return e;    
	        }    
	    });    
	} 
	
	public List<Page> findPages(String se){    
	    return template.query("select * from page WHERE title REGEXP '"+se+"' order by datec desc",new RowMapper<Page>(){    
	        public Page mapRow(ResultSet rs, int row) throws SQLException {    
	            Page e=new Page();    
	            e.setId(rs.getInt(1));    
	            e.setTitle(rs.getString(2));    
	            e.setAuthor(rs.getString(3));    
	            e.setCategory(rs.getString(4));     
	            e.setContent(rs.getString(5));  
	            e.setDatec(rs.getDate(6));
	            return e;    
	        }    
	    });    
	}
	
	public List<Page> findCategory(String cate){    
	    return template.query("select * from page WHERE category REGEXP '"+cate+"' order by datec desc",new RowMapper<Page>(){    
	        public Page mapRow(ResultSet rs, int row) throws SQLException {    
	            Page e=new Page();    
	            e.setId(rs.getInt(1));    
	            e.setTitle(rs.getString(2));    
	            e.setAuthor(rs.getString(3));    
	            e.setCategory(rs.getString(4));     
	            e.setContent(rs.getString(5));  
	            e.setDatec(rs.getDate(6));
	            return e;    
	        }    
	    });    
	}
	
	public int getTotal(){    
		 String sql = "select count(*) from page";
		 return template.queryForObject(sql, Integer.class);
	}
	
	public List<Page> getbyPagination(int pageid,int totalRecord){    
	    String sql="select * from page limit "+(pageid-1)+","+totalRecord;    
	    return template.query(sql,new RowMapper<Page>(){    
	        public Page mapRow(ResultSet rs, int row) throws SQLException {    
	            Page e=new Page();    
	            e.setId(rs.getInt(1));    
	            e.setTitle(rs.getString(2));    
	            e.setAuthor(rs.getString(3));    
	            e.setCategory(rs.getString(4));     
	            e.setContent(rs.getString(5));  
	            e.setDatec(rs.getDate(6));    
	            return e;    
	        }    
	    });    
	} 

}

