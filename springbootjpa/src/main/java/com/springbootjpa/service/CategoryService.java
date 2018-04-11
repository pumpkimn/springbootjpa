package com.springbootjpa.service;

import com.springbootjpa.domain.Category;

import java.util.Optional;

public interface CategoryService {
    //种类增加 修改
    void save(Category category);

    //根据id查询
    Optional<Category> findById(Integer id);
}
