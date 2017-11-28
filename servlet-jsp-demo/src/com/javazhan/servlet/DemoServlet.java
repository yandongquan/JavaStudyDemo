package com.javazhan.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 这是一个Demo类
 * @author yando
 * @date 2017/11/28
 */
public class DemoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse responsere) throws ServletException, IOException {
        doGet(request, responsere);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("username", "javazhan");
        response.sendRedirect("success.jsp");
    }

}
