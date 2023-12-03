package com.newspage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newspage.beans.Detaitt;
import com.newspage.beans.Hocki;
import com.newspage.dao.DetaittDao;
import com.newspage.dao.HockiDao;

@Controller
public class DetaittController {

	@Autowired
    DetaittDao detaittDao;
	@Autowired
	HockiDao hockiDao;
	
    @RequestMapping(value="detaitt/detaittlist/{id}", method = RequestMethod.GET)    
    public String detaittlist(@PathVariable int id, Model m){    
        List<Detaitt> list = detaittDao.getDts(id);    
        m.addAttribute("list",list);  
        return "detaittlist";    
    }
    
    @RequestMapping(value="detaitt/detaittlist", method = RequestMethod.GET)    
    public String detaittlistlast(Model m){
    	Hocki hocki = hockiDao.getLastHk();
    	int id =  hocki.getId();
        List<Detaitt> list = detaittDao.getDts(id);    
        m.addAttribute("list",list);  
        return "detaittlist";    
    }
    
    @RequestMapping("detaitt/detaittadd")    
    public String adddetaitt(Model m){    
        m.addAttribute("command", new Detaitt());  
        return "detaittadd";   
    }        
    @RequestMapping(value="detaitt/addsave",method = RequestMethod.POST)    
    public String addsave(@ModelAttribute("detaitt") Detaitt detaitt){    
    	detaittDao.saveDt(detaitt);
    		return "redirect:/detaitt/detaittlist";   
    }  
    


    @RequestMapping(value="detaitt/detaittedit/{id}")    
    public String editdetaitt(@PathVariable String id, Model m){    
        Detaitt detaitt=detaittDao.getDtById(id);    
        m.addAttribute("command",detaitt);  
        return "detaittedit";    
    }    
    @RequestMapping(value="detaitt/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("detaitt") Detaitt detaitt){    
    	detaittDao.updateDt(detaitt);
    		return "redirect:/detaitt/detaittlist";
    }    
    
    
    
    @RequestMapping(value="detaitt/detaittdelete/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable String id){    
    	detaittDao.deleteDt(id);    
        return "redirect:/detaitt/detaittlist";    
    }

}
