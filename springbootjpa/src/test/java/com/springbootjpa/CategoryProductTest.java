package com.springbootjpa;

import com.springbootjpa.domain.Category;
import com.springbootjpa.domain.Product;
import com.springbootjpa.service.CategoryServiceImpl;
import com.springbootjpa.service.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryProductTest {
    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private ProductServiceImpl productService;

    // step 1;
    @Test
    public void saveCategory() {
        Category category = new Category();
        category.setName("箱包");
        category.setDescription("箱子包包");

        categoryService.save(category);
    }

    // step 2;
    @Test
    public void saveProduct() {
        Category category = categoryService.findById(3).get();

        Product product = new Product();
        product.setName("单肩女包");
        product.setPrice(100d);
        product.setDescriotion("潮流女包");
        // 设置商品与商品类别的关系
        product.setCategory(category);

        productService.save(product);
    }

    // step 3;

    @Test
    public void ProductfindAll() {
        for (Product product:productService.findAll()){
            System.out.println("搜索包名:"+product.getName() + " " +"包包描述:"+product.getDescriotion()+ " " + "种类:"+product.getCategory().getName());
        }

    }
}
