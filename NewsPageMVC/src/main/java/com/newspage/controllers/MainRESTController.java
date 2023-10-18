package com.newspage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.newspage.beans.Page;
import com.newspage.dao.PageDao;
 
@Controller

public class MainRESTController {
 
 @Autowired
 PageDao pageJson;
 
 @RequestMapping(value = "/pageJson", method = RequestMethod.GET)
 @ResponseBody
 public List<Page> listEmployee() {
  return pageJson.getPages();
 }
 
 @RequestMapping(value = "/pageJson/search/{name}", method = RequestMethod.GET)
 @ResponseBody
 public List<Page> listSearch(@PathVariable String name) {
  return pageJson.findPages(name);
 }
 
 @RequestMapping(value = "/pageJson/{id}", method = RequestMethod.GET)
 @ResponseBody
 public Page findEmployee(@PathVariable("id") int pageId) {
  return pageJson.getPageById(pageId);
 }
 
 @RequestMapping(value = "/pageJson/{id}", method = RequestMethod.POST)
 @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
 public String saveEmployee(@PathVariable("id") Page pageId) throws Exception {
  pageJson.save(pageId);
  return "redirect:/pageJson/" + pageId;
 }
 
 @RequestMapping(value = "/pageJson/{id}", method = RequestMethod.PUT)
 @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
 public String updateEmployee(@PathVariable("id") Page pageId) throws Exception {
  pageJson.update(pageId);
  return "redirect:/pageJson/" + pageId;
 }
 
 @RequestMapping(value = "/pageJson/{id}", method = RequestMethod.DELETE)
 @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
 @ResponseBody
 public String deleteEmployee(@PathVariable("id") int pageId) throws Exception {
  pageJson.delete(pageId);
  return "OK";
 }
 
}

