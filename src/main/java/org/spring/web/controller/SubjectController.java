package org.spring.web.controller;

import org.spring.web.model.Subject;
import org.spring.web.service.CrudUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Handles requests for the subject management.
 */
@Controller
@RequestMapping(value = "/subject")
public class SubjectController {

	
	@Autowired
	CrudUtilService crudUtilService;

	@ModelAttribute("subject")
	public Subject creatSubjectModel() {
		return new Subject();
	}

	
	@RequestMapping(value = "/showAdd", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView showAddForm() {
		return new ModelAndView("addSubject");
	}

	//@PostMapping
	@RequestMapping(value = "/subject/save",method = RequestMethod.POST, headers = "Accept=application/json")
	public String addSubject(@ModelAttribute("subject") Subject subject, BindingResult bindingResult) {
				
		crudUtilService.addSubject(subject);

		return "redirect:/subject/list";
	}

	//@GetMapping(value = "/update/{id}")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView showEditForm(@PathVariable String id) {

		Subject subject = crudUtilService.getSubject(Long.valueOf(id)).get();
		return new ModelAndView("updateSubject", "subject", subject);
	}

	// @PutMapping(value = "/update")
	//@PostMapping(value = "/update")
	@RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Accept=application/json")
	public String updateSubject(@ModelAttribute Subject subject, BindingResult bindingResult) {
	
		
		crudUtilService.updateSubject(subject);
		
		return "redirect:/subject/list"; 
	}

	//@GetMapping(value = "/delete/{id}")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteSubject(@PathVariable String id) {
        System.out.println("inside deleteSubect for id="+id);
        crudUtilService.deleteSubject(Integer.valueOf(id));
        return "redirect:/subject/list"; 
		//return new ModelAndView("redirect:/subject/list");
	}

	//@GetMapping(value = "/list")
	@RequestMapping(value = "/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView listEmployees() {

		Iterable<Subject> subList = crudUtilService.getAllSubjects();
		return new ModelAndView("listSubjects", "subList", subList);
	}

}
