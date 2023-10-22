package com.newspage.controllers;

import java.util.List;    
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;

import com.newspage.beans.Page;
import com.newspage.dao.PageDao;   

@Controller
public class PageController {
	
	@Autowired
    PageDao dao;
 
    @RequestMapping("page/pageadd")    
    public String showform(Model m){    
        m.addAttribute("command", new Page());  
        return "pageadd";   
    }        
    
    
    @RequestMapping(value="page/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("page") Page page){    
        dao.save(page);    
        return "redirect:/page/pagelist";   
    }  
    
     
    @RequestMapping(value={"page/pagelist", "page/pagelist/search"})    
    public String pagelist(Model m){    
        List<Page> list = dao.getPages();    
        m.addAttribute("list",list);  
        return "pagelist";    
    }
    @RequestMapping(value="page/pagelist/search/{se}")    
    public String pagelist(@PathVariable String se,Model m){    
        List<Page> list = dao.findPages(se);    
        m.addAttribute("list",list);  
        return "pagelist";    
    }
    
    
    @RequestMapping(value="page/detailpage/{id}",method = RequestMethod.GET)    
    public String detailPage(@PathVariable int id, Model m){    
    	m.addAttribute("page", dao.getPageById(id));
        return "pagedetail";    
    }


    @RequestMapping(value="page/editpage/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Page page=dao.getPageById(id);    
        m.addAttribute("command",page);  
        return "pageedit";    
    }    
    @RequestMapping(value="page/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("page") Page page){    
        dao.update(page);    
        return "redirect:/page/pagelist";    
    }    
    
    
    @RequestMapping(value="page/deletepage/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        dao.delete(id);    
        return "redirect:/page/pagelist";    
    }
}