package pe.com.chaponan.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class VistaController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getWelcome() {
		ModelAndView model = new ModelAndView("unexpected");
		return model;
	}
	
	@RequestMapping(value = "/televisor", method = RequestMethod.POST)
	public ModelAndView postWelcome() {
		ModelAndView model = new ModelAndView("redirect:televisor");
		return model;
	}
	
	@RequestMapping(value="televisor", method = RequestMethod.GET)
	public ModelAndView about() {
		ModelAndView model = new ModelAndView("televisor");
		return model;
	}
	
	@RequestMapping(value = "/celular", method = RequestMethod.POST)
	public ModelAndView postWelcome1() {
		ModelAndView model = new ModelAndView("redirect:celular");
		return model;
	}
	
	@RequestMapping(value="celular", method = RequestMethod.GET)
	public ModelAndView about1() {
		ModelAndView model = new ModelAndView("celular");
		return model;
	}
	
}
