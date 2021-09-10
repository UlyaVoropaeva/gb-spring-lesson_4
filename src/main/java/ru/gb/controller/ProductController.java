package ru.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gb.dao.ProductDao;
import ru.gb.domain.Product;


import java.util.List;

@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {


    private ProductDao productDao;

    public ProductController(ProductDao productDao){
        this.productDao =productDao;
    }

    @GetMapping()
    @ResponseBody
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @GetMapping( "/{id}")
    @ResponseBody
    public Product findById(@PathVariable Long id) throws Exception {

        return productDao.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws Exception {
        productDao.deleteById(id);
    }

    @PostMapping()
    @ResponseBody
    public List<Product> save(@RequestBody Product product) {
        productDao.saveOrUpdate(product);
        return productDao.findAll();

    }
}