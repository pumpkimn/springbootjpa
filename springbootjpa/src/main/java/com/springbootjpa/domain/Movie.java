package com.springbootjpa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类 | 封装类 | javabean |POJO
 *
 * @author lee
 */
@Entity // 说明此类是实体类
@Table(name = "MOVIE") //说明实体类中对应的表明
public class Movie implements Serializable{

    private static final long serialVersionUID = 4170349724878989607L;
    //通过@Entity 表明是一个映射的实体类， @Id表明id， @GeneratedValue 字段自动生成
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //说明是主键 id 的值 自动增长
    private Integer id;
    // 说明类中的的属性 对应表中的字段( 字段名，长度，null)
    //@Column(name = "abc_name",length = 100,nullable = true)
    @Column
    private String name;
    @Column
    private Double price;

    // 从 数据库到前端
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @Column(name = "action_time")
    private Date actionTime;

    public Movie() {
    }

    public Movie(Integer id, String name, Double price, Date actionTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.actionTime = actionTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", actionTime=" + actionTime +
                '}';
    }
}
