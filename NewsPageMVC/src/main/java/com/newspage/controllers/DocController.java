package com.newspage.controllers;


import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;


import com.newspage.beans.Doc;
import com.newspage.dao.DocDao;   

@Controller
public class DocController {
	
	@Autowired
    DocDao dao;

    @RequestMapping("doc/docadd")    
    public String docadd(Model m){    
        m.addAttribute("command", new Doc());  
        return "docadd";   
    }        
    @RequestMapping(value="doc/addsave",method = RequestMethod.POST)    
    public String addsave(@ModelAttribute("doc") Doc doc){    
    	if (doc.getFiled().isEmpty()) {
    		dao.save(doc);
    		//return new ModelAndView("redirect:/doc/docmana");
    		return "redirect:/doc/docmana"; 
    	}
		byte[] bytes = doc.getFiled().getBytes();
		String bytess = dao.bytesToHex(bytes);
		doc.setBytefi(bytess);
		doc.setNamefi(doc.getFiled().getOriginalFilename());
		dao.save(doc);   
    	//return new ModelAndView("/docmana");
    	return "redirect:/doc/docmana";   
    }  
    


    @RequestMapping(value="doc/docedit/{id}")    
    public String docedit(@PathVariable int id, Model m){    
        Doc doc=dao.getDocById(id);    
        m.addAttribute("command",doc);  
        return "docedit";    
    }    
    @RequestMapping(value="doc/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("doc") Doc doc){    
    	if (doc.getFiled().isEmpty()) {
    		dao.update(doc);
    		return "redirect:/doc/docmana";
    	}
		byte[] bytes = doc.getFiled().getBytes();
		String bytess = dao.bytesToHex(bytes);
		doc.setBytefi(bytess);
		doc.setNamefi(doc.getFiled().getOriginalFilename());
		dao.update(doc);    	    
		return "redirect:/doc/docmana";    
    }    
    
    
    
    @RequestMapping(value="doc/docdelete/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        dao.delete(id);    
        return "redirect:/doc/docmana";    
    }
    
    
    
    
    @RequestMapping(value={"doc/docmana", "doc/docmana/search"})    
    public String docmana(Model m){    
        List<Doc> list = dao.getDocs();    
        m.addAttribute("list",list);  
        return "docmana";    
    }
    @RequestMapping(value="doc/docmana/search/{se}")    
    public String docmana(@PathVariable String se,Model m){    
        List<Doc> list = dao.findDocs(se);    
        m.addAttribute("list",list);  
        return "docmana";    
    }
    
    
    @RequestMapping(value="doc/docdetail/{id}",method = RequestMethod.GET)    
    public String docdetail(@PathVariable int id, Model m){    
    	m.addAttribute("doc", dao.getDocById(id));
        return "docdetail";    
    }
    
   @RequestMapping(value = "doc/docdetail/{id}/down", method = RequestMethod.GET)
     public ResponseEntity<byte[]> getDownloadData(@PathVariable int id) throws Exception {

    	Doc doc = dao.getDocById(id);
    	Blob blob = doc.getHexfi();
    	int blobLength = (int) blob.length();  
    	byte[] output = blob.getBytes(1, blobLength);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("charset", "utf-8");
        responseHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        responseHeaders.setContentLength(output.length);
        responseHeaders.set("Content-disposition", "attachment; filename="+doc.getNamefi()+"");

        return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
    }
}