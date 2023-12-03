package com.newspage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newspage.beans.Hocki;
import com.newspage.beans.Ttcn;
import com.newspage.dao.HockiDao;
import com.newspage.dao.TtcnDao;

@Controller
public class TtcnController {


	@Autowired
    TtcnDao ttcnDao;
	@Autowired
	HockiDao hockiDao;
	
    @RequestMapping("/ttcn/ttcnlist")    
    public String ttcnlist(Model m){ 
    	Hocki hocki = hockiDao.getLastHk();
    	int id =  hocki.getId();
        List<Ttcn> list = ttcnDao.getTtcns(id);    
        m.addAttribute("list",list);  
        return "ttcnlist";    
    }
    
    @RequestMapping("/ttcn/ttcnlist/{id}")    
    public String ttcnlist(@PathVariable int id, Model m){    
        List<Ttcn> list = ttcnDao.getTtcns(id);    
        m.addAttribute("list",list);  
        return "ttcnlist";    
    }
    
    @RequestMapping("ttcn/ttcnadd")    
    public String addttcn(Model m){    
        m.addAttribute("command", new Ttcn());  
        return "ttcnadd";   
    }        
    @RequestMapping(value="ttcn/addsave",method = RequestMethod.POST)    
    public String addsave(@ModelAttribute("ttcn") Ttcn ttcn){    
    	ttcnDao.saveTtcn(ttcn);
    		return "redirect:/ttcn/ttcnlist";   
    }  
    


    @RequestMapping(value="ttcn/ttcnedit/{id}")    
    public String editttcn(@PathVariable String id, Model m){    
        Ttcn ttcn=ttcnDao.getTtcnById(id);    
        m.addAttribute("command",ttcn);  
        return "ttcnedit";    
    }    
    @RequestMapping(value="ttcn/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("ttcn") Ttcn ttcn){    
    	ttcnDao.updateTtcn(ttcn);
    		return "redirect:/ttcn/ttcnlist";
    }    
    
    
    
    @RequestMapping(value="ttcn/ttcndelete/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable String id){    
    	ttcnDao.deleteTtcn(id);    
        return "redirect:/ttcn/ttcnlist";    
    }
}