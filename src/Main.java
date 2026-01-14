import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    static void main(String[] args) {

        Customer c1 = new Customer(1L, "Aldo", 1);
        Customer c2 = new Customer(2L, "Giovanni", 2);
        Customer c3 = new Customer(3L, "Giacomo", 3);
        Customer c4 = new Customer(4L, "Giangiorgio", 4);
        Customer c5 = new Customer(5L, "Gianni", 2);

        Product p1 = new Product(1L, "pandoro", "Food", 10.00);
        Product p2 = new Product(2L, "panettone", "Food", 40.00);
        Product p3 = new Product(3L, "Lord of The Rings", "Books", 25.00);
        Product p4 = new Product(4L, "Il Simbolo Perduto", "Books", 20.00);
        Product p5 = new Product(5L, "Innesti Ossei in Implantologia", "Books", 105.00);
        Product p6 = new Product(6L, "Istologia: testo e atlante", "Books", 110.00);
        Product p7 = new Product(7L, "A", "Boys", 100.00);
        Product p8 = new Product(8L, "B", "Boys", 90.00);
        Product p9 = new Product(9L, "C", "Baby", 80.00);
        Product p10 = new Product(10L, "D", "Baby", 200.00);

        Order o1 = new Order(1L, "delivered", LocalDate.of(2021, 2, 1), LocalDate.of(2021, 4, 1), List.of(p1, p2, p5, p6, p9), c5);
        Order o2 = new Order(2L, "Placed", LocalDate.of(2021, 3, 1), LocalDate.of(2021, 4, 1), List.of(p1, p2, p3, p6), c5);
        Order o3 = new Order(3L, "delivered", LocalDate.of(2021, 2, 5), LocalDate.of(2021, 4, 1), List.of(p1, p4, p5, p6), c2);
        Order o4 = new Order(4L, "Placed", LocalDate.of(2022, 2, 1), LocalDate.of(2023, 4, 1), List.of(p1, p2, p5, p10), c3);
        Order o5 = new Order(5L, "Shipped", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 4, 1), List.of(p1, p2, p6), c4);


        List<Order> orders = new ArrayList<>();
        orders.add(o1);
        orders.add(o2);
        orders.add(o3);
        orders.add(o4);
        orders.add(o5);

        List<Customer> customers = new ArrayList<>();
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        customers.add(c5);

        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);
        products.add(p7);
        products.add(p8);
        products.add(p9);
        products.add(p10);

// 1
        List<Product> booksOver100 = products.stream()
                .filter(product -> product.getCategory() == "Books")
                .filter(product -> product.getPrice() > 100)
                .toList();

        booksOver100.forEach(product -> System.out.println(product));
        // .forEach(System.out::println);

// 2
        List<Order> ordersContainingBaby = orders.stream()
                .filter(order ->
                        order.getProducts().stream()
                                .anyMatch(product -> Objects.equals(product.getCategory(), "Baby")))
                .toList();
        ordersContainingBaby.forEach(order -> System.out.println(order));

// 3
        List<Product> boysProductMinusTen = products.stream()
                .filter(product -> Objects.equals(product.getCategory(), "Boys"))
                .map(product -> new Product(product.getId(), product.getName(), product.getCategory(), product.getPrice() * 0.9))
                .toList();

        boysProductMinusTen.forEach(product -> System.out.println(product));


// 4
    }
}
