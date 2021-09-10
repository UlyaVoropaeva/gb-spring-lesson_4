package ru.gb.dao;


import org.springframework.stereotype.Repository;
import ru.gb.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    public void saveOrUpdate(Product product) {
        if (product.getId() == null) {
            entityManager.persist(product);
        }
        entityManager.merge(product);
    }
    public boolean save(Long productId) {
        Product product = findById(productId);
        if (product == null) {
            return false;
        }
        save(product);
        return true;
    }

    public  Product update (Long id, Product product){
        Product original = findById(id);
        if(original != null){
            original.setName(product.getName());
            product.setPrice(product.getPrice());
            entityManager.merge(original);
        }
        return  original;
    }


    public List<Product> findAll() {
        List<Product> resultList = entityManager
                .createQuery("select p from Product as p", Product.class)
                .getResultList();
        return resultList;
    }


    public void deleteById(Long id) {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            entityManager.remove(product);
        }
    }
}
