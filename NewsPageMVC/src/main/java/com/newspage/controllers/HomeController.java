package com.newspage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newspage.beans.Hocki;
import com.newspage.dao.HockiDao;

@Controller
public class HomeController {

	@Autowired
    HockiDao dao;
	
    @RequestMapping("/")
	  public String hockis(Model m){    
	  List<Hocki> liss = dao.getHks();    
	  m.addAttribute("liss",liss);  
	  return "index";    
	}
    
    @RequestMapping(value="list/{hockiid}")    
    public String pagination(@PathVariable int hockiid, Model m){  
    	int totalRecord = 5;
    	if(hockiid==1){}    
        else{    
            hockiid=(hockiid-1)*totalRecord+1;    
        }
    	int total = dao.getTotal();
    	
    	int numberpage = (int) Math.round(total/totalRecord +0.5);
    	m.addAttribute("numberpage", numberpage);
    	
    	List<Hocki> hockilist = dao.getbyPagination(hockiid, totalRecord); 
    	m.addAttribute("hockilist", hockilist);
        return "hockilist";    
    }

    
    
}
