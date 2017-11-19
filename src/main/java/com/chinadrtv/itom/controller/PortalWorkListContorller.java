package com.chinadrtv.itom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by djs on 2017/11/9.
 */
@Controller
@RequestMapping("portal")
public class PortalWorkListContorller {

    @RequestMapping(value = "/ppp" ,method = RequestMethod.GET)
    public ModelAndView ppp(ModelMap modelMap){
        ModelAndView mv = new ModelAndView("jndi/jndiTest");
        mv.addObject("message","Hello Word!中文字体很漂亮");
        mv.addObject("list","此地无银三百两!");

//        logger.warn("return mv");
        return mv;
    }
}
