package com.bjpowernode.ajax.ajaxrequest;

import com.alibaba.fastjson2.JSON;
import com.bjpowernode.ajax.beans.Area;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @author wangxuedeng
 * @date 2022/12/29 - 22:41
 */
@WebServlet("/auto-complete")
public class AutoTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        StringBuilder s = new StringBuilder();
        s.append("[");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajax","root","123456");
            String sql = "select content from t_ajax2 where content like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                String content = rs.getString("content");
                s.append("{\"content\":\"" +content+ "\"},");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        out.print(s.subSequence(0,s.length() - 1) + "]");
    }
}
