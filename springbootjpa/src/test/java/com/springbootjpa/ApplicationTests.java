package com.springbootjpa;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private MovieService movieService;
	@Test
	public void save() {
		// 有id就修改 无id增加
		Movie movie = new Movie();
		//movie.setId(1);
		movie.setName("厉害了，我的国");
		movie.setPrice(77888d);
		movie.setActionTime(new Date());

		movieService.save(movie);
	}

	/**
	 * 查询所有
	 */
	@Test
	public void findAll() {
		List<Movie> list = movieService.findAll();
		System.out.println(list);
	}

	/**
	 * id 查询
	 */
	@Test
	public void getOne() {
		Optional<Movie> movie = movieService.findByid(1);
		System.out.println(movie.get().getName()+ " "+movie.get().getPrice());
	}

	/**
	 *  删除
	 */
	@Test
	public void deleteById() {
		movieService.deleteById(1);
	}

	@Test
	public void findByMovieName() {
		for (Movie movie:movieService.findByMovieName("头号玩家")){
			System.out.println(movie.getName()+" "+movie.getPrice()+" "+movie.getActionTime());
		}
	}

	@Test
	public void findByNameLike() {
		for (Movie movie:movieService.findByNameLike("%头%")){
			System.out.println(movie.getName()+" "+movie.getPrice()+" "+movie.getActionTime());
		}
	}

	@Test
	public void findByNameNotLike() {
		for (Movie movie:movieService.findByNameNotLike("%头%")){
			System.out.println(movie.getName()+" "+movie.getPrice()+" "+movie.getActionTime());
		}
	}

	@Test
	public void findByNameAndPrice() {
		for (Movie movie:movieService.findByNameAndPrice("%厉%",888d)){
			System.out.println(movie.getName()+" "+movie.getPrice()+" "+movie.getActionTime());
		}
	}

	@Test
	public void findByActionTimeBetween() {
		Date beginDate =new Date();
		Date endDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			beginDate = sdf.parse("2018-04-08 00:00:00");
			endDate = sdf.parse("2018-04-10 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for (Movie movie:movieService.findByActionTimeBetween(beginDate,endDate)){
			System.out.println(movie.getName()+" "+movie.getPrice()+" "+movie.getActionTime());
		}
	}

}

