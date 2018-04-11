package com.springbootjpa.service;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.domain.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 业务逻辑接口的实现类
 */
@Service
@Transactional //代表所有的都需要事务
public class MovieServiceImpl implements MovieService {
    // 注入 JPA 依赖
    @Autowired
    private  MovieRepository movieRepository;
    @Override
    public void save(Movie movie) {
       movieRepository.save(movie);
    }

    @Override
    public void deleteById(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> findAll() {
       return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findByid(Integer id) {
        return movieRepository.findById(id);
    }

    /**
     *  根据电影名查询
     * @param name
     * @return
     */
    @Override
    public List<Movie> findByMovieName(String name) {
        return movieRepository.findByMovieName(name);
    }

    @Override
    public List<Movie> findByNameLike(String name) {
        return movieRepository.findByNameLike(name);
    }

    @Override
    public List<Movie> findByNameNotLike(String name) {
        return movieRepository.findByNameNotLike(name);
    }

    @Override
    public List<Movie> findByNameAndPrice(String name, Double price) {
        return movieRepository.findByNameAndPrice(name,price);
    }

    @Override
    public List<Movie> findByActionTimeBetween(Date beginDate, Date endDate) {
        return movieRepository.findByActionTimeBetween(beginDate,endDate);
    }


}
