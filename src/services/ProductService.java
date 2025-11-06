package services;

import exceptions.DuplicateProduct;
import exceptions.DuplicateUserData;
import exceptions.MatchingCategoryNotFound;
import products.Category;
import products.Product;
import users.Sakura;

import java.util.ArrayList;

public class ProductService {
    static ProductService instance;

    public static ArrayList<Product> Products = new ArrayList<>();
    public static ArrayList<Category> Categories = new ArrayList<>();

    private ProductService() {
        Category c1 = new Category("Erectile disfunction", "helps it get it up");
        Categories.add(c1);
        Products.add(new Product("Vitafer", "Viagra :)) ", 24000, 200, c1));
    }

    public Category searchCategory(String name) throws MatchingCategoryNotFound {
        for (Category c : Categories){
            if (name.toLowerCase().equals(c.getName())){
                return c;
            }
        }
        throw new RuntimeException("Category not found");
    }

    public Product seachProduct(String name) throws MatchingCategoryNotFound {
        for (Product p : Products){
            if (name.toLowerCase().equals(p.getName())){
                return p;
            }
        }
        throw new RuntimeException("Product not found");
    }


    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    public void addProduct(Product p) throws DuplicateProduct {
        for (Product product : Products){
            if (product.getName().equals(p.getName())){
                throw new DuplicateProduct("Product with that exact name already exists");
            }
        }
        Products.add(p);
    }

}



