package com.newspage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newspage.beans.Page;
import com.newspage.dao.PageDao;

@Controller
public class HomeController {

	@Autowired
    PageDao dao;
	
    @RequestMapping("/")
	  public String pages(Model m){    
	  List<Page> liss = dao.getPages();    
	  m.addAttribute("liss",liss);  
	  return "index";    
	}
    
    @RequestMapping(value="list/{pageid}")    
    public String pagination(@PathVariable int pageid, Model m){  
    	int totalRecord = 6;
    	if(pageid==1){}    
        else{    
            pageid=(pageid-1)*totalRecord+1;    
        }
    	int total = dao.getTotal();
    	
    	int numberpage = (int) Math.round(total/totalRecord +0.5);
    	m.addAttribute("numberpage", numberpage);
    	
    	List<Page> listpagination = dao.getbyPagination(pageid, totalRecord); 
    	m.addAttribute("listpagination", listpagination);
        return "listpagi";    
    }
    
    @RequestMapping("/search")
	  public String searchPages(Model m){    
	  List<Page> liss = dao.getPages();    
	  m.addAttribute("liss",liss);  
	  return "search";    
	}
    @RequestMapping(value="/search/{se}")
	public String searchPages(@PathVariable String se, Model m){    
	  List<Page> liss = dao.findPages(se);    
	  m.addAttribute("liss",liss);  
	  return "search";     
	}
    
    @RequestMapping(value="category/{cate}")    
    public String showCate(@PathVariable String cate, Model m){  
    	List<Page> liss = dao.findCategory(cate); 
    	m.addAttribute("liss", liss);
        return "search";    
    }
    
}
