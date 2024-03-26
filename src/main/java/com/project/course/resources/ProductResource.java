package com.project.course.resources;

import com.project.course.entities.Product;
import com.project.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    private final ProductService service;

    @Autowired
    public ProductResource(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = service.findAll();
        return ResponseEntity.ok().body(products);
    }

    /* Este método é responsável por lidar com solicitações GET para recuperar informações de um produto com um ID
     * específico. Ele chama um serviço para realizar a operação de busca, encapsula o resultado em uma resposta HTTP
     * e a retorna ao cliente. */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long id) {
        Optional<Product> object = service.findById(id);
        return ResponseEntity.ok().body(object);
    }


}
