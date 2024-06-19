package marinalucentini.backend_w5_d2.entities;

import marinalucentini.backend_w5_d2.BackendW5D2Application;
import marinalucentini.backend_w5_d2.enums.OrderStatus;
import marinalucentini.backend_w5_d2.enums.TableStatus;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Runner implements CommandLineRunner {

    private void printMenu (){
        System.out.println("Menu pizzeria");
        System.out.println("Pizzas");

        menuPizzeria.getPizzas().forEach(el->{
            String pizzeIngredients =  el.getIngredients().stream().map(Topping::getName).collect(Collectors.joining(","));
            System.out.println("Nome:" +el.getName()+
                    " prezzo: " + el.getPrice()+
                    " calorie: " + el.getCalories()+
                    " ingredienti: " + "(" + pizzeIngredients + ")");;
        });
        System.out.println("Toppins");
        menuPizzeria.getToppings().forEach(el->
                System.out.println( el.getName() + " calorie "+ el.getCalories()+ " prezzo " + el.getPrice()));
        System.out.println("Drinks");
        menuPizzeria.getDrinks().forEach(el-> System.out.println(
                el.getName() + "(" + el.getQuantity() + "L)" + " prezzo " + el.getPrice() + " calorie " + el.getCalories()
        ));
    }
//    private void printListTable(){
//        Table table1 = context.getBean("table1", Table.class);
//        Table table2 = context.getBean("table2", Table.class);
//        Table table3 = context.getBean("table3", Table.class);
//        Table table4 = context.getBean("table4", Table.class);
//        List<Table> listaTavoli = new ArrayList<>();
//        listaTavoli.add(table1);
//        listaTavoli.add(table2);
//        listaTavoli.add(table3);
//        listaTavoli.add(table4);
//        System.out.println();
//        listaTavoli.forEach(el->{
//            String ordersElement =  el.getOrders().stream().map(elements-> {
//                        String elementsInfo = elements.getMenuElements().stream().map(element -> {
//                            if (element instanceof Pizza) {
//                                Pizza pizza = (Pizza) element;
//                                String ingredients = pizza.getIngredients().stream()
//                                        .map(Topping::getName)
//                                        .collect(Collectors.joining(", "));
//                                return "Pizza: " + pizza.getName() + " (Ingredienti: " + ingredients + ")";
//                            } else if (element instanceof Drink) {
//                                Drink drink = (Drink) element;
//                                return "Drink: " + drink.getName();
//                            } else if (element instanceof Topping) {
//                                Topping topping = (Topping) element;
//                                return "Topping: " + topping.getName();
//
//
//                            }
//                            return element.getName();
//
//                        }).collect(Collectors.joining(", "));
//                        return "Ordine" + elements.getNumberOrder() + ":" + elementsInfo;
//                    }).collect(Collectors.joining(","));
//
//
//
//            System.out.println("Tavolo numero: " + el.getNumberTable() + " stato tavolo " + el.getTableStatus() + " Ordini: " + el.getOrders()
//
//
//            );
//        });
//    }



@Autowired
Menu menuPizzeria;
    @Value("${coperto.costo}")
    private double copertoCosto;
    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BackendW5D2Application.class);
        Table table1 = context.getBean("table1", Table.class);

       Pizza pizza = context.getBean("pizzaMargherita", Pizza.class);
       Drink water = context.getBean("Water", Drink.class);
       Topping topping = context.getBean(Topping.class);
        System.out.println(pizza.getName());
        System.out.println(water.getName());
        System.out.println(topping.getName());


        Order order = new Order(1, Arrays.asList(pizza, water, topping), OrderStatus.IN_PROGRESS, 2, LocalTime.of(20, 30));


        table1.setTableStatus(TableStatus.BUSY);

        table1.setOrders(Arrays.asList(order));

        System.out.println(table1);
        double totalPrice = order.total(copertoCosto);
        System.out.println("Total Price: " + totalPrice);

      printMenu();
//printListTable();
    }


}