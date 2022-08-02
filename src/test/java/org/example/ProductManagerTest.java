package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(1, "Ася", 1_000, "Иван Сергеевич Тургенев");
    Product product2 = new Book(2, "Князь Серебряный", 1_200, "Алексей Константинович Толстой");
    Product product3 = new Smartphone(3, "Самсунг", 15_000, "Южнокорейская группа компаний");
    Product product4 = new Smartphone(4, "Apple", 35_000, "Аиериканская корпорация");
    Product product5 = new Smartphone(5, "Самсунг", 25_000, "Южнокорейская группа компаний");

    @BeforeEach

    public void setup() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
    }

    @Test
    public void ShouldAddProduct() {

        Product[] actual = manager.findAll();
        Product[] expected = {product1, product2, product3, product4, product5};

        assertArrayEquals(expected, actual);
    }

    @Test


    public void ShouldSearchByProduct2() {


        Product[] actual = manager.searchBy("Самсунг");
        Product[] expected = {product5, product3};

        assertArrayEquals(expected, actual);
    }

    @Test


    public void ShouldSearchByProduct1() {


        Product[] actual = manager.searchBy("Apple");
        Product[] expected = {product4};

        assertArrayEquals(expected, actual);
    }


    @Test


    public void ShouldSearchByProduct0() {


        Product[] actual = manager.searchBy("Марта");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }
}