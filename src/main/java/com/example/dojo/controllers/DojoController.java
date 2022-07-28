package com.example.dojo.controllers;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dojo.models.Dojo;
import com.example.dojo.services.DojoService;

@Controller
@RequestMapping("dojos")
public class DojoController {
	private final DojoService dojoService;

	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	// show a form page to create dojo
	@RequestMapping("new")
	public String index(Model model) {
		if (!model.containsAttribute("dojo")) {
			model.addAttribute("dojo",new Dojo());
		}
		return "/create_dojo.jsp";
	}
	
	// create a dojo
	@PostMapping("")
	public String create(Model model, @Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, RedirectAttributes redirectAttributes ) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("dojo",dojo);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.dojo",result);
			return "redirect:/dojos/new";
        	} 
		else {
			dojoService.createDojo(dojo);
	    	redirectAttributes.addFlashAttribute("success", "Dojo was created successfully");
		}
        return "redirect:/dojos/"+dojo.getId();
        
	}
	
	//show a page has list of ninjas in specific dojo 
	@RequestMapping("/{id}")
	public String show(@PathVariable(value="id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
        model.addAttribute("dojo", dojo);
		return "/show_dojo.jsp";
	}
	
}
