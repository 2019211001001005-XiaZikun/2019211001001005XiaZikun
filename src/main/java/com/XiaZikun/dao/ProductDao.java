package com.XiaZikun.dao;

import com.XiaZikun.model.Product;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        String sql = "insert into Product(ProductName,ProductDescription,Picture,price,CategoryId) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        int n=0;
        n=pt.executeUpdate();
        if (n > 0) {
            return 1;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        String sql="delete from Product where ProductId=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,productId);
        pt.executeQuery();
        if (pt.executeUpdate() > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        String sql = "update Product set ProductName=?,ProductDescription=?,Picture=?,price=?,CategoryId=? where ProductId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, instance.getProductName());
        pt.setString(2, instance.getProductDescription());
        if(instance.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, instance.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, instance.getPrice());
        pt.setInt(5, instance.getCategoryId());
        pt.setInt(6,instance.getProductId());
        if (pt.executeUpdate() > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String sql="Select * from Product where ProductId=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs= pt.executeQuery();
        Product product=null;
        if(rs.next()){
            Integer ProductId=rs.getInt("ProductId");
            Integer CategoryId=rs.getInt("CategoryId");
            String ProductName=rs.getString("ProductName");
            String ProductDescription=rs.getString("ProductDescription");
            InputStream Picture=rs.getBinaryStream("Picture");
            double price=rs.getDouble("price");
            product=new Product(ProductId,CategoryId,ProductName,ProductDescription,Picture,price);
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product where CategoryId=?";
        try {
            PreparedStatement pt=con.prepareStatement(sql);
            pt.setInt(1,categoryId);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                Integer ProductId=rs.getInt("ProductId");
                Integer CategoryId=rs.getInt("CategoryId");
                String ProductName=rs.getString("ProductName");
                String ProductDescription=rs.getString("ProductDescription");
                InputStream Picture=rs.getBinaryStream("Picture");
                double price=rs.getDouble("price");
                Product product=new Product(ProductId,CategoryId,ProductName,ProductDescription,Picture,price);
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return productList;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product where price=?";
        try {
            PreparedStatement pt=con.prepareStatement(sql);
            pt.setDouble(1,maxPrice);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                Integer ProductId=rs.getInt("ProductId");
                Integer CategoryId=rs.getInt("CategoryId");
                String ProductName=rs.getString("ProductName");
                String ProductDescription=rs.getString("ProductDescription");
                InputStream Picture=rs.getBinaryStream("Picture");
                double price=rs.getDouble("price");
                Product product=new Product(ProductId,CategoryId,ProductName,ProductDescription,Picture,price);
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return productList;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product";
        try {
            PreparedStatement pt=con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                Integer ProductId=rs.getInt("ProductId");
                Integer CategoryId=rs.getInt("CategoryId");
                String ProductName=rs.getString("ProductName");
                String ProductDescription=rs.getString("ProductDescription");
                InputStream Picture=rs.getBinaryStream("Picture");
                double price=rs.getDouble("price");
                Product product=new Product(ProductId,CategoryId,ProductName,ProductDescription,Picture,price);
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return productList;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product where ProductName=?";
        try {
            PreparedStatement pt=con.prepareStatement(sql);
            pt.setString(1,productName);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                Integer ProductId=rs.getInt("ProductId");
                Integer CategoryId=rs.getInt("CategoryId");
                String ProductName=rs.getString("ProductName");
                String ProductDescription=rs.getString("ProductDescription");
                InputStream Picture=rs.getBinaryStream("Picture");
                double price=rs.getDouble("price");
                Product product=new Product(ProductId,CategoryId,ProductName,ProductDescription,Picture,price);
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return productList;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product where ProductId=?";
        try {
            PreparedStatement pt=con.prepareStatement(sql);
            pt.setInt(1,productId);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                Integer ProductId=rs.getInt("ProductId");
                Integer CategoryId=rs.getInt("CategoryId");
                String ProductName=rs.getString("ProductName");
                String ProductDescription=rs.getString("ProductDescription");
                InputStream Picture=rs.getBinaryStream("Picture");
                double price=rs.getDouble("price");
                Product product=new Product(ProductId,CategoryId,ProductName,ProductDescription,Picture,price);
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return productList;
    }
}
