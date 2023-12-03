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
import com.newspage.beans.Kltn;
import com.newspage.dao.HockiDao;
import com.newspage.dao.KltnDao;

@Controller
public class KltnController {


	@Autowired
    KltnDao kltnDao;
	@Autowired
	HockiDao hockiDao;
	
    
	
    @RequestMapping(value="/kltn/kltnlist")    
    public String kltnlistLast(Model m){    
    	Hocki hocki = hockiDao.getLastHk();
    	int id =  hocki.getId();
        List<Kltn> list = kltnDao.getKltns(id);    
        m.addAttribute("list",list);  
        return "kltnlist";    
    }
    
    
    @RequestMapping(value="/kltn/kltnlist/{id}")    
    public String kltnlist(@PathVariable int id,Model m){    
        List<Kltn> list = kltnDao.getKltns(id);    
        m.addAttribute("list",list);  
        return "kltnlist";    
    }
    
    @RequestMapping("kltn/kltnadd")    
    public String addkltn(Model m){    
        m.addAttribute("command", new Kltn());  
        return "kltnadd";   
    }        
    @RequestMapping(value="kltn/addsave",method = RequestMethod.POST)    
    public String addsave(@ModelAttribute("kltn") Kltn kltn){    
    	kltnDao.saveKltn(kltn);
    		return "redirect:/kltn/kltnlist";   
    }  
    


    @RequestMapping(value="kltn/kltnedit/{id}")    
    public String editkltn(@PathVariable int id, Model m){    
        Kltn kltn=kltnDao.getKltnById(id);    
        m.addAttribute("command",kltn);  
        return "kltnedit";    
    }    
    @RequestMapping(value="kltn/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("kltn") Kltn kltn){    
    	kltnDao.updateKltn(kltn);
    		return "redirect:/kltn/kltnlist";
    }    
    
    
    
    @RequestMapping(value="kltn/kltndelete/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
    	kltnDao.deleteKltn(id);    
        return "redirect:/kltn/kltnlist";    
    }
}
