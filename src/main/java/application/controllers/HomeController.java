package application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController{
@RequestMapping(method = RequestMethod.GET)
public String index(){
    return "home/index.jsp";
}
}