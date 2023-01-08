package com.bjpowernode.ajax.ajaxrequest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wangxuedeng
 * @date 2022/10/7 - 13:59
 */
@WebServlet("/ajaxrequest")
public class AjaxRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //out.print("<font color='red'>welcome to study ajax!</font>");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        out.print("username=" + username + "<br>" + "password=" + password);
    }
}
