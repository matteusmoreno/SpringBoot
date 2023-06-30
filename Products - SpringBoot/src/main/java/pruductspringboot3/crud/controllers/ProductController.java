package pruductspringboot3.crud.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pruductspringboot3.crud.domain.product.*;

import java.net.URI;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity postProduct(@RequestBody @Valid ProductsPostDto product, UriComponentsBuilder uriBuilder) {
        var thisProduct = new Product(product);
        repository.save(thisProduct);

        var uri = uriBuilder.path("/product/{id}").buildAndExpand(thisProduct.getId()).toUri();

        return ResponseEntity.created(uri).body(new ProductsListDto(thisProduct));
    }

    @GetMapping
    public ResponseEntity<Page<ProductsListDto>> getAllProducts(@PageableDefault(size = 5, sort = {"id"}) Pageable data) {
        var page = repository.findAllByStatusTrue(data).map(ProductsListDto::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Valid ProductsUpdateDto product) {
        var thisProduct = repository.getReferenceById(product.id());
        thisProduct.updateInfos(product);

        return ResponseEntity.ok(new ProductsListDto(thisProduct));
    }

//    @DeleteMapping("/{id}")
//    @Transactional
//    public ResponseEntity deleteProduct(@PathVariable Long id) {
//        repository.deleteById(id);
//        return ResponseEntity.noContent().build();
//
//    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inactiveProduct(@PathVariable Long id) {
        var thisProduct = repository.getReferenceById(id);
        thisProduct.inactivate();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity productDetails(@PathVariable Long id) {
        var thisProduct = repository.getReferenceById(id);

        return ResponseEntity.ok(new ProductsListDto(thisProduct));


    }
}
