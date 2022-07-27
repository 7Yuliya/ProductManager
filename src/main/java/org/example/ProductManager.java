package org.example;

public class ProductManager {
    private org.example.ProductRepository repo;
    public ProductManager(org.example.ProductRepository repo){

            this.repo = repo;

        }
        public void add(Product product) {
            repo.save(product);
        }
            public Product[] findAll(){
                Product[] all = repo.findAll();
                Product [] reversed = new Product[all.length];


                for (int i = 0; i < reversed.length; i++) {

                    reversed [i] = all [all.length - 1 - i];
                }

                return reversed;
            }




    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product: repo.findAll()) {
            if (matches(product, text)) {
                // "добавляем в конец" массива result продукт product
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {

                    tmp [i] = result [ i];
                }
                tmp[tmp.length - 1] = product;
                    result = tmp;
                }
        }
                return result;
    }


    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }

}
