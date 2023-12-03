package com.newspage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newspage.beans.Hocki;
import com.newspage.dao.HockiDao;

@Controller
public class HockiController {

	@Autowired
	HockiDao hockiDao;
	
	@RequestMapping(value="hocki/hockilist", method = RequestMethod.GET)    
    public String hockilist(Model m){    
        List<Hocki> list = hockiDao.getHks();    
        m.addAttribute("list",list);  
        return "hockilist";    
    }
	
	@RequestMapping(value="detaitt/hocki")    
    public String addHockidt(){  
		Hocki hocki = hockiDao.getLastHk();
		String str= hocki.getTenhk();
    	hockiDao.addHk(str);
    	return "redirect:/detaitt/detaittlist";     
    }
	
	@RequestMapping(value="ttcn/hocki")    
    public String addHockitt(){  
		Hocki hocki = hockiDao.getLastHk();
		String str= hocki.getTenhk();
    	hockiDao.addHk(str);
    	return "redirect:/ttcn/ttcnlist";     
    }
	
	@RequestMapping(value="kltn/hocki")    
    public String addHockikl(){  
		Hocki hocki = hockiDao.getLastHk();
		String str= hocki.getTenhk();
    	hockiDao.addHk(str);
    	return "kltn/kltnlist";   
    }
	
//	<div class="dropdown-content">
//		<c:forEach items="${list}" var="hocki">
//			<a class="" href="/kltnlist/${hocki.id}">${hocki.tenhk}</a>
//		</c:forEach>	  
//	</div>

}
