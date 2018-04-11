package com.springbootjpa.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 *  持久层：由 JPA 管理
 */
//JpaRepository<T,ID> T 是实体， ID 是主键
public interface MovieRepository extends JpaRepository<Movie,Integer>{
    // 包含了一般的增删改查

    // hql：hibernate Query Language:hibeinate 查询语言 - 类名 + 属性名  Mysql 则是 表明 对应属性名
    //                                      :name 是下面 传入参数
    @Query(value = "select m from Movie m where m.name=:name")
    List<Movie> findByMovieName(@Param("name")String name);

    // 模式查询 包含 name的数据
    List<Movie> findByNameLike(String name);
    // 模式查询 不包含 name的数据
    List<Movie> findByNameNotLike(String name);

    // 条件查询不包含 name 并 price 价格相等的电影
    List<Movie> findByNameAndPrice(String name,Double price);

    List<Movie> findByActionTimeBetween(Date beginDate,Date endDate);
   /* @Query("select id,name,price,action_time  from Movie u where u.name=:name")
    List<Movie> findByName1(@Param("name") String name);

    @Query("select m from Movie m where m.name like %?1% or m.price like %?1% or m.actionTime like %?1% or m.id=?1")
    Page<Movie> findSearch(String query, Pageable pageable);*/
}
