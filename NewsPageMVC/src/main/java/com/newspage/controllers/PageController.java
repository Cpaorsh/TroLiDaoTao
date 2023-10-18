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
 
    @RequestMapping("page/pageaddform")    
    public String showform(Model m){    
        m.addAttribute("command", new Page());  
        return "pageaddform";   
    }    
       
    
    
    @RequestMapping(value="page/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("page") Page page){    
        dao.save(page);    
        return "redirect:/page/pageslist";   
    }  
    
    
    
    @RequestMapping(value={"page/pageslist", "page/pageslist/search"})    
    public String pageslist(Model m){    
        List<Page> list = dao.getPages();    
        m.addAttribute("list",list);  
        return "pageslist";    
    }
    @RequestMapping(value="page/pageslist/search/{se}")    
    public String pageslist(@PathVariable String se,Model m){    
        List<Page> list = dao.findPages(se);    
        m.addAttribute("list",list);  
        return "pageslist";    
    }
    @RequestMapping(value="page/detailpage/{id}",method = RequestMethod.GET)    
    public String detailPage(@PathVariable int id, Model m){    
    	m.addAttribute("page", dao.getPageById(id));
        return "pagedetail";    
    }

    
    
    
    @RequestMapping("/")
	  public String pages(Model m){    
	  List<Page> liss = dao.getPages();    
	  m.addAttribute("liss",liss);  
	  return "index";    
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
    

    
    @RequestMapping(value="page/editpage/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Page page=dao.getPageById(id);    
        m.addAttribute("command",page);  
        return "pageeditform";    
    }    
    @RequestMapping(value="page/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("page") Page page){    
        dao.update(page);    
        return "redirect:/page/pageslist";    
    }    
    
    
    
    
    @RequestMapping(value="page/deletepage/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        dao.delete(id);    
        return "redirect:/page/pageslist";    
    }
}