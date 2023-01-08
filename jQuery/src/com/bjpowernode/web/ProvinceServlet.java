package com.bjpowernode.web;

import com.alibaba.fastjson2.JSON;
import com.bjpowernode.bean.City;
import com.bjpowernode.bean.Province;
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
 * @date 2023/1/1 - 22:55
 */
@WebServlet("/jQueryTest4")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String proviceId = request.getParameter("proviceId");

        ArrayList<Province> provinces = new ArrayList<>();
        ArrayList<City> cities = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajax","root","123456");
            if (proviceId == null) {
                String sql = "select id,name,abbreviation,provincialcapital from province";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String abbreviation = rs.getString("abbreviation");
                    String provincialcapital = rs.getString("provincialcapital");
                    Province province = new Province(id,name,abbreviation,provincialcapital);
                    provinces.add(province);
                }
                String json = JSON.toJSONString(provinces);
                out.print(json);
            } else {
                String sql = "select name from city where provinceid = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,proviceId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("name");
                    City city = new City(name);
                    cities.add(city);
                }
                String json = JSON.toJSONString(cities);
                out.print(json);
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
    }
}
