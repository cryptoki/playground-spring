package de.javaclub.playground.spring.ressources;


import de.javaclub.playground.spring.auth.AuthService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    private static Log logger = LogFactory.getLog(LoginController.class);

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        mav.addObject("username", "");
        mav.addObject("password", "");
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    ModelAndView login(HttpServletRequest request, HttpServletResponse response,
                       @ModelAttribute("username") String username, @ModelAttribute("password") String password) {
        logger.info("username " + username);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        String sessionId = authService.auth(username, password);
        response.addCookie(new Cookie("sessionId", sessionId));
        mav.addObject("sessionId", sessionId);

        return mav;
    }

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    ModelAndView login(@CookieValue("sessionId") String sessionId) {
        logger.info("sessionId " + sessionId);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        mav.addObject("sessionId", sessionId);

        return mav;
    }

}
