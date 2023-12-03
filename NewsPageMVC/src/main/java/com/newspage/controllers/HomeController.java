package com.newspage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newspage.beans.Doc;
import com.newspage.dao.DocDao;

@Controller
public class HomeController {

	@Autowired
    DocDao dao;
	
    @RequestMapping("/")
	  public String docs(Model m){    
	  List<Doc> liss = dao.getDocs();    
	  m.addAttribute("liss",liss);  
	  return "index";    
	}
    
    @RequestMapping(value="list/{docid}")    
    public String pagination(@PathVariable int docid, Model m){  
    	int totalRecord = 5;
    	if(docid==1){}    
        else{    
            docid=(docid-1)*totalRecord+1;    
        }
    	int total = dao.getTotal();
    	
    	int numberpage = (int) Math.round(total/totalRecord +0.5);
    	m.addAttribute("numberpage", numberpage);
    	
    	List<Doc> doclist = dao.getbyPagination(docid, totalRecord); 
    	m.addAttribute("doclist", doclist);
        return "doclist";    
    }
    
    @RequestMapping("/search")
	  public String searchDocs(Model m){    
	  List<Doc> liss = dao.getDocs();    
	  m.addAttribute("liss",liss);  
	  return "search";    
	}
    @RequestMapping(value="/search/{se}")
	public String searchDocs(@PathVariable String se, Model m){    
	  List<Doc> liss = dao.findDocs(se);    
	  m.addAttribute("liss",liss);  
	  return "search";     
	}
    
    @RequestMapping(value="category/{cate}")    
    public String showCate(@PathVariable String cate, Model m){  
    	List<Doc> liss = dao.findCategory(cate); 
    	m.addAttribute("liss", liss);
        return "search";    
    }
    
}
