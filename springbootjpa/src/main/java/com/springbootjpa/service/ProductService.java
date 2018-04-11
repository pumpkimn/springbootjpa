package com.springbootjpa.service;

import com.springbootjpa.domain.Product;

import java.util.List;

public interface ProductService {
    // 保存 修改 产品
    void save(Product product);
    //查询产品
    List<Product> findAll();
}
