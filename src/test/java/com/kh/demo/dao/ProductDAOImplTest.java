package com.kh.demo.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootTest
class ProductDAOImplTest {
@Autowired
private ProductDAO productDAO;

  @Test
  @DisplayName("등록")
  void save() {
  Product product = new Product();
  product.setPname("마우스");
  product.setQuantity(2L);
  product.setPrice(10000L);
  log.info("{}",productDAO.save(product));
  }



  @Test
  void 목록() {
    List<Product> all = productDAO.findAll();
    log.info("product={}",all);

  }






  @Test
  void 조회() {
    Optional<Product> byProductId = productDAO.findByProductId(341L);
    log.info("product={}",byProductId);


    byProductId.stream().forEach(product -> log.info(product.toString()));
  }


  @Test
  void 수정() {
    Long productId = 341L;
    Product product = new Product();
    product.setPrice(20000L);
    product.setPname("멋진마우스");
    product.setQuantity(5L);
    int affectedRow = productDAO.update(productId, product);
    Optional<Product> product1 = productDAO.findByProductId(productId);
    log.info("update={}",product1);
  }


  @Test
  void 삭제() {
    int i = productDAO.deleteByProductId(341L);
    Optional<Product> byProductId = productDAO.findByProductId(341L);
    log.info("product={}",byProductId);
  }
}