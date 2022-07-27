package org.example;

public class ProductRepository {


        private Product [] products = new Product[0];





        public void save(Product product) {
            Product[] tmp = new Product[products.length + 1];

            for (int i = 0; i < products.length; i++) {

                tmp[i] = products[i];
            }
            tmp[tmp.length - 1] = product;
            products = tmp;
        }

    public void removeById(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product Product :
              products  ) {
            if (Product.getId() !=  id) {
                tmp[copyToIndex] = Product;

                copyToIndex++;

            }
            products  = tmp;
        }
    }
        public Product[] findAll() {
              Product [] tmp = new Product [products.length ];

              for (int i = 0; i < products.length; i++) {

                 tmp [i] = products  [products.length - 1 - i];
              }
              return tmp;
             }

            //  return products;
        }






