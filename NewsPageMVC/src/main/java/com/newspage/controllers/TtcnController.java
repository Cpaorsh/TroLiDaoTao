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
import com.newspage.beans.Dttt;
import com.newspage.beans.Ttcn;
import com.newspage.dao.HockiDao;
import com.newspage.dao.TtcnDao;
import com.newspage.dao.DtttDao;

@Controller
public class TtcnController {


	@Autowired
    TtcnDao ttcnDao;
	@Autowired
	HockiDao hockiDao;
	@Autowired
	DtttDao dtttDao;
	
	
    @RequestMapping("/ttcn/ttcnlist")    
    public String ttcnlist(Model m){ 
    	Hocki hocki = hockiDao.getLastHk();
    	int id =  hocki.getId();
        List<Ttcn> list = ttcnDao.getTtcns(id);    
        m.addAttribute("list",list);  
        return "ttcnlist";    
    }
    @RequestMapping("/ttcn/ttcnlistcd")    
    public String ttcnunlist(Model m){    
        List<Ttcn> list = ttcnDao.getTtcnCd();    
        m.addAttribute("list",list);  
        return "ttcnunlist";    
    }
    @RequestMapping("/ttcn/ttcnlistkd")    
    public String ttcnun(Model m){    
        List<Ttcn> list = ttcnDao.getTtcnKd();    
        m.addAttribute("list",list);  
        return "ttcnunlist";    
    }
    
    @RequestMapping("/ttcn/ttcnlist/{id}")    
    public String ttcnlist(@PathVariable int id, Model m){    
        List<Ttcn> list = ttcnDao.getTtcns(id);    
        m.addAttribute("list",list);  
        return "ttcnlist";    
    }
    

    

    
    
    @RequestMapping("ttcn/ttcnadd/{msv}")    
    public String addttcn(@PathVariable String msv, Model m){    
    	Ttcn ttcn=ttcnDao.getTtcnById(msv);
    	if (ttcn == null) {
    		ttcnDao.addTtcn(msv);
    	}
    	return "ttcnlist";   
    }   
    
    
    @RequestMapping(value="ttcn/ttcnduyet/{id}")    
    public String duyetttcn(@PathVariable String id, Model m){    
        Ttcn ttcn=ttcnDao.getTtcnById(id);    
        m.addAttribute("command",ttcn);  
        return "ttcnduyet";    
    }    
    @RequestMapping(value="ttcn/duyetsave",method = RequestMethod.POST)    
    public String duyetsave(@ModelAttribute("ttcn") Ttcn ttcn){    
    	ttcnDao.duyetTtcn(ttcn);
    		return "redirect:/ttcn/ttcnlist";
    } 
    


    @RequestMapping(value="ttcn/ttcnedit/{id}")    
    public String editttcn(@PathVariable String id, Model m){    
    	Hocki hocki = hockiDao.getLastHk();
    	int idhk =  hocki.getId();
    	List<Dttt> dt = dtttDao.getDts(idhk);    
        m.addAttribute("dt",dt);
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
    	Ttcn ttcn=ttcnDao.getTtcnById(id);
    	if (ttcn != null) {
    		ttcnDao.deleteTtcn(id);
    	} else {
    		
    	}
        return "redirect:/ttcn/ttcnlist";    
    }
}