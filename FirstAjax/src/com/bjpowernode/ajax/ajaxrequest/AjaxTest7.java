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
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxuedeng
 * @date 2022/12/29 - 11:15
 */
@WebServlet("/ajaxTest7")
public class AjaxTest7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Area> areas = new ArrayList<>();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String pcode = request.getParameter("pcode");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajax","root","123456");
            String sql = "";
            if (pcode == null) {
                sql = "select code,name from t_area where pcode is null";
                ps = conn.prepareStatement(sql);
            } else {
                sql = "select code,name from t_area where pcode = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,pcode);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                Area area = new Area(code,name);
                areas.add(area);
            }
            String json = JSON.toJSONString(areas);
            out.print(json);
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
    }
}
