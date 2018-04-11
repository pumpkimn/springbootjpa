package com.springbootjpa.service;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.domain.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 业务逻辑接口
 */
public interface MovieService {

    void save(Movie movie);

    void deleteById(Integer id);

    List<Movie> findAll();

    Optional findByid(Integer id);

    List<Movie> findByMovieName(String name);

    List<Movie> findByNameLike(String name);

    List<Movie> findByNameNotLike(String name);

    List<Movie> findByNameAndPrice(String name,Double price);

    List<Movie> findByActionTimeBetween(Date beginDate, Date endDate);
    /* 全部查询 *//*
    Page<Movie> findAll(Pageable pageable);
    *//* 根据多种信息 查询模糊用户*//*
    Page<Movie> findSearch(String name,Pageable pageable);*/


}
