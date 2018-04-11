package com.springbootjpa;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}

