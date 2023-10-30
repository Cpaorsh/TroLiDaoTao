package com.newspage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newspage.beans.Drl;
import com.newspage.dao.DrlDao;

@Controller
public class DrlController {

	@Autowired
    DrlDao drlDao;
	
    @RequestMapping(value={"drl/drllist"})    
    public String drllist(Model m){    
        List<Drl> dlist = drlDao.getDrls();    
        m.addAttribute("dlist",dlist);  
        return "drllist";    
    }
    
    @RequestMapping(value="drl/drledit/{msv}")    
    public String edit(@PathVariable int msv, Model m){    
        Drl drl=drlDao.getDrlByMsv(msv);    
        m.addAttribute("command",drl);  
        return "drledit";    
    }    
    @RequestMapping(value="drl/savesv",method = RequestMethod.POST)    
    public String saveDrlSv(@ModelAttribute("drl") Drl drl){    
    	drlDao.updateSv(drl);    
        return "redirect:/drl/drllist";    
    }
    
    @RequestMapping(value="drl/savelt",method = RequestMethod.POST)    
    public String saveDrlLt(@ModelAttribute("drl") Drl drl){    
    	drlDao.updateLt(drl);    
        return "redirect:/drl/drllist";    
    }
    
    @RequestMapping(value="drl/savegv",method = RequestMethod.POST)    
    public String saveDrlGv(@ModelAttribute("drl") Drl drl){    
    	drlDao.updateGv(drl);    
        return "redirect:/drl/drllist";    
    }
}
