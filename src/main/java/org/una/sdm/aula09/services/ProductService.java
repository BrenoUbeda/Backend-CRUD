package org.una.sdm.aula09.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.sdm.aula09.domain.User;
import org.una.sdm.aula09.exceptions.UserNotFoundException;
import org.una.sdm.aula09.repositories.UserRepositoryJPA;
import org.una.sdm.aula09.services.interfaces.UserServiceAPI;

import java.util.List;

@Service
public class ProductService implements UserServiceAPI {

    @Autowired
    private ProductRepositoryJPA repositoryJPA;

    @Transactional(readOnly = true)
    public Product get(Long id){

        try {
            Product Product = repositoryJPA.findById(id).get();
            return Product;
        } catch (Exception ex) {
            throw new UserNotFoundException(String.format("Produto não existe com esse id: %s ", id));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {

        return repositoryJPA.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Product create(Product Product) {
        return repositoryJPA.save(Product);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Product Product) {
        repositoryJPA.save(Product);
    }

    @Override
    @Transactional(readOnly = false)
    public void remove(Long id) {
        repositoryJPA.deleteById(id);
    }

}
