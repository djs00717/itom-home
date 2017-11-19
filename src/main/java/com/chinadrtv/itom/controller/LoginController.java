package com.chinadrtv.itom.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 系统登陆
 * User: liuhaidong
 * Date: 2017-11-20
 */
@Controller(value = "loginControl")
public class LoginController {
    Logger log = LogManager.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "login/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String toLogout(HttpServletRequest request, HttpServletResponse response, Model model) {
        //wirteLog("退出","退出系统",request);
        log.info("退出系统");
        return "login/logout";
    }


    @RequestMapping(value = "/wel", method = RequestMethod.POST)
    public String toWel(HttpServletRequest request, HttpServletResponse response, Model model) {
        if (request.getSession().getAttribute("OMSsessiongId") == null) {
            String ip = this.getIpAddr(request);
            log.info("登陆", "系统登陆 " + ip, "", request);
        }
        request.getSession().setAttribute("ITOMsessiongId",
                request.getSession().getId());
        request.getSession().setAttribute("username","admin");
        return "login/welcome";
    }
/*

    @RequestMapping(value = "/wel", method = RequestMethod.GET)
    public String wel(HttpServletRequest request, HttpServletResponse response, Model model) {
        //log.info("OMSsession:" + request.getSession().getAttribute("OMSsessiongId"));
        if (request.getSession().getAttribute("OMSsessiongId") == null) {
            String ip = this.getIpAddr(request);
            log.info("登陆", "系统登陆 " + ip, "", request);
        }
        request.getSession().setAttribute("OMSsessiongId",
                request.getSession().getId());
        request.getSession().setAttribute("username", SecurityHelper.getLoginUser().getUsername());
        return "login/welcome";
    }
*/


    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
