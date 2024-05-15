package org.una.sdm.aula09.services.interfaces;

import org.una.sdm.aula09.domain.User;

import java.util.List;

public interface ProductServiceAPI {

    public Product get(Long id);

    public List<Product> findAll();

    public Product create(Product product);

    public void update(Product product);

    public void remove(Long id);
}
