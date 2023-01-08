package com.bjpowernode.ajax.ajaxrequest;

import com.alibaba.fastjson2.JSON;
import com.bjpowernode.ajax.beans.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author wangxuedeng
 * @date 2022/12/28 - 10:34
 */
@WebServlet("/ajaxTest4")
public class AjaxTest4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder json = new StringBuilder();
        String str = "";
        ArrayList<Student> student = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","123456");
            String sql = "select name,sex,age from t_student";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            json.append("[");
            while (rs.next()) {
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                String age = rs.getString("age");
                /*json.append("{\"name\":\"");
                json.append(name);
                json.append("\",\"sex\":\"");
                json.append(sex);
                json.append("\",\"age\":");
                json.append(age);
                json.append("},");*/
                Student s = new Student(name,sex,age);
                student.add(s);
            }
            //str = json.substring(0,json.length() - 1) + "]";
            //out.print(str);
            String s = JSON.toJSONString(student);
            out.print(s);
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
