package com.example.dojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dojo.models.Dojo;
import com.example.dojo.models.Ninja;
import com.example.dojo.services.DojoService;
import com.example.dojo.services.NinjaService;

@Controller
@RequestMapping("ninjas")
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;


	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	// show create page
	@RequestMapping("/new")
	public String add(Model model) {
		if (!model.containsAttribute("ninja")) {
			model.addAttribute("ninja",new Ninja());
		}
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "/create_ninja.jsp";
	}
	
	// add new ninja
	@PostMapping("/new")
	public String add(Model model, @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, RedirectAttributes redirectAttributes ) {
		if (result.hasErrors()) {
			
			redirectAttributes.addFlashAttribute("ninja",ninja);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.ninja",result);
        	} 
		else {
			ninjaService.createNinja(ninja);
	    	redirectAttributes.addFlashAttribute("success", "Ninja was created successfully");
		}
		
        return "redirect:./new";
        
	}
	


}
