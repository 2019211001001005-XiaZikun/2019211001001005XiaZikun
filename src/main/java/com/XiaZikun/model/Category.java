package com.XiaZikun.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private int categoryId;
    private String categoryName;
    private String description;
    private boolean active;

    public Category(){}

    public Category(int categoryId, String categoryName, String description, boolean active) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.active = active;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public static List<Category> findAllCategory(Connection con)throws SQLException{
        List<Category> list = new ArrayList<Category>();
        String sql = "select * from Category";
        try {
            PreparedStatement pt=con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                Category c=new Category();
                c.setCategoryId(rs.getInt("CategoryId"));
                c.setCategoryName(rs.getString("CategoryName"));
                c.setDescription(rs.getString("Description"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static String findByCategoryId(Connection con, int categoryId){
        String categoryName=null;
        try {
            String sql = "select * from Category where CategoryId=?";
            PreparedStatement pt=con.prepareStatement(sql);
            pt.setInt(1,categoryId);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                categoryName=rs.getString("CategoryName");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryName;
    }
}
