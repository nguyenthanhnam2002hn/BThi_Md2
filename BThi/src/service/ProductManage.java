package service;

import model.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManage {
    private List<Product> products;
    private final Scanner scanner;

    public ProductManage() {
        products = new ArrayList<>();
        scanner = new Scanner(System.in);

    }

    public void changeIndexProduct() {
        Product.INDEX = products.get(products.size() -1).getId();
    }

    public void loadListProduct(List<String[]> productList) {
        for (String[] string : productList) {
            String name = string[1];
            double price = Double.parseDouble(string[2]);
            int quantity = Integer.parseInt(string[3]);
            String description = string[4];
            Product product = new Product(name, price, quantity, description);
            products.add(product);
        }
        if (!products.isEmpty()) {
            changeIndexProduct();
        }
    }

    public void creatProduct() {
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số lượng: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("rivew : ");
        String description = scanner.nextLine();
        products.add(new Product(name, price, quantity, description));
    }

    public Product findById() {
        System.out.println("Nhập id: ");
        int id = Integer.parseInt((scanner.nextLine()));
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void updateProduct() {
        if (!products.isEmpty()) {
            displayProduct();
            Product product = findById();
            if (product != null) {
                System.out.println("Nhập tên mới: ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) {
                    product.setName(name);
                }
                System.out.println("Nhập giá mới:");
                String stringPrice = scanner.nextLine();
                double price;
                if (stringPrice.isEmpty()) {
                    price = product.getPrice();
                } else {
                    price = Double.parseDouble(stringPrice);
                }
                product.setPrice(price);
                System.out.println("Nhập số lượng mới: ");
                String stringQuantity = scanner.nextLine();
                int quantity;
                if (stringQuantity.isEmpty()) {
                    quantity = product.getQuantity();
                } else {
                    quantity = Integer.parseInt(stringQuantity);
                }
                product.setQuantity(quantity);
                System.out.println("Nhập rivew mới: ");
                String description = scanner.nextLine();
                if (!description.isEmpty()) {
                    product.setDescription(description);
                }
                System.out.println("Chỉnh thành công!!!");
            } else {
                System.out.println("Sản phẩm không tồn tại!!!");
            }
        } else {
            System.out.println("sản phẩm không tồn tại!!!");
        }

    }

    public void deleteProduct() {
        if (!products.isEmpty()) {
            displayProduct();
            Product product = findById();
            if (product != null) {
                System.out.println("Enter 1 to delete: ");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    products.remove(product);
                    System.out.println("Remove successfully");
                }

            } else {
                System.out.println("Product not exist!!!");
            }
        } else {
            System.out.println("Product not exist!!!");
        }

    }

    public void sortPriceAsc() {
        if (!products.isEmpty()) {
            products.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o1.getPrice() - o2.getPrice());
                }
            });
            System.out.println("Sort successfully");
        } else {
            System.out.println("Product not exist!!!");
        }
    }

    public void sortPriceDesc() {
        if (!products.isEmpty()){
            products.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o2.getPrice() - o1.getPrice());
                }
            });
            System.out.println("Sort successfully");
        } else {
            System.out.println("Product not exist!!!");
        }

    }

    public Product findPriceMax() {
        if (!products.isEmpty()) {
            double priceMax = products.get(0).getPrice();
            int indexMax = 0;
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getPrice() >priceMax) {
                    priceMax = products.get(i).getPrice();
                    indexMax = i;
                }
            }
            return products.get(indexMax);
        } else {
            System.out.println("Product not exist!!!");
        }
        return null;
    }

    public void displayProduct() {
        if (!products.isEmpty()) {
            for (Product product : products) {
                System.out.println(product);
            }
        } else {
            System.out.println("Product not exist!!!");
        }

    }

    public List<Product> listProduct() {
        return products;
    }

}