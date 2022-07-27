package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {

    Product product1 = new Book(1, "Ася", 1_000, "Иван Сергеевич Тургенев");
    Product product2 = new Book(2, "Князь Серебряный", 1_200, "Алексей Константинович Толстой");
    Product product3 = new Smartphone(3, "Самсунг", 15_000, "Южнокорейская группа компаний");
    Product product4 = new Smartphone(4, "Apple", 35_000, "Аиериканская корпорация");


    @Test
    public void test() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.removeById(product2.getId());


        Product[] expected = {product4, product3, product1};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }
}


