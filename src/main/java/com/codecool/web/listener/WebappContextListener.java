package com.codecool.web.listener;

import com.codecool.web.service.LoginService;
import com.codecool.web.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public final class WebappContextListener implements ServletContextListener {

    /*
     * Creating services like this is an alternative to singletons.
     * Every servlet can access these using the HttpServletRequest.getServletContext method.
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        UserService userService = new UserService();
        LoginService loginService = new LoginService(userService);

        ServletContext ctx = sce.getServletContext();
        ctx.setAttribute("userService", userService);
        ctx.setAttribute("loginService", loginService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
