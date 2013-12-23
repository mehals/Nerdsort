package com.mehal.nerdsort.controllers;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mehal.nerdsort.dao.NerdsortDao;
import com.mehal.nerdsort.types.OrderableList;
import com.mehal.nerdsort.types.Vote;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes
public class HomeController {
	
	@Autowired
	private NerdsortDao nerdsortDao;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		List<OrderableList> allLists = nerdsortDao.getAllLists();
		model.addAttribute("allLists", allLists);
		model.addAttribute("vote", new Vote());
				
		return "home";
	}	
	
	@RequestMapping(value = "/vote", method = RequestMethod.POST)
	public String getVote(@ModelAttribute("vote") Vote vote, BindingResult result, Model model) {
		System.out.println(vote.toString());
		List<OrderableList> allLists = nerdsortDao.getAllLists();
		model.addAttribute("allLists", allLists);
		model.addAttribute("vote", new Vote());
		
		return "home";
	}

}
