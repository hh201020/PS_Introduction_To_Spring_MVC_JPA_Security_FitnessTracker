package com.pluralsight.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pluralsight.model.Goal;

@Controller
@SessionAttributes("goal")
public class GoalController {
	
	@RequestMapping(value="addGoal", method=RequestMethod.GET)	// Only get works
	public String addGoal(Model model) {	// Pass in the backend model directly
		Goal goal = new Goal();
		goal.setMinutes(10);
		model.addAttribute("goal", goal );
		
		return "addGoal";
	}
	
	@RequestMapping(value="addGoal", method=RequestMethod.POST)
	public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result) { // result is from @Valid
		System.out.println("result has errors: " + result.hasErrors());
		System.out.println("Minutes updated: " + goal.getMinutes());
		
		if(result.hasErrors()){
			return "addGoal";
		}
		return "redirect:addMinutes.html";
	}
}
