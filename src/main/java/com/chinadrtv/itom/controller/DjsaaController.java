package com.chinadrtv.itom.controller;

import com.chinadrtv.itom.dao.DjsaaDao;
import com.chinadrtv.itom.dao.impl.DjsaaDaoImpl;
import com.chinadrtv.itom.model.Djsaa;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by djs on 2017/11/18.
 */
@Controller(value = "/djs")
public class DjsaaController extends HttpServlet {
    Logger log = LogManager.getLogger(DjsaaController.class);

    @Override
    @RequestMapping(value = "/get" ,method = RequestMethod.GET)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DjsaaDao dao = new DjsaaDaoImpl();
        Djsaa djs=dao.load("1");

        log.info(djs);

        PrintWriter writer = resp.getWriter();
        writer.print("get = " + djs.toString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
