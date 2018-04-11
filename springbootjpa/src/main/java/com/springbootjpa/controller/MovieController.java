package com.springbootjpa.controller;


import com.springbootjpa.domain.Movie;
import com.springbootjpa.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api")
public class MovieController {
    @Autowired
    private MovieService movieService;


    /**
     *  查询所有 http://127.0.0.1:8086/api/list
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Movie> getMovie(){
        return movieService.findAll();
    }

    /**
     *  id 查询 http://127.0.0.1:8086/api/movie/2
     * @param id
     * @return
     */
    @RequestMapping(value = "/movie/{id}",method = RequestMethod.GET)
    public Optional<Movie> findById(@PathVariable("id")Integer id){
        Optional<Movie> movie = movieService.findByid(id);
        return movie;
    }


}
