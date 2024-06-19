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

        double totalPrice = order.total(copertoCosto);
        System.out.println("Total Price: " + totalPrice);



        System.out.println("Tavolo n: " + table1.getNumberTable() + " State: " + table1.getTableStatus() + " Numero Massimo persone: " + table1.getMaxPerson() + " Ordini: " );

        table1.getOrders().forEach(el->{
            String elementOrderName=
                    el.getMenuElements().stream().map(MenuElement::getName).collect(Collectors.joining(","));
            String elementOrderPrice =
                    el.getMenuElements().stream().map(menuElement->
                            String.valueOf(menuElement.getPrice())).collect(Collectors.joining(","));
            System.out.println(elementOrderName +" "+ elementOrderPrice+ " Totale: " + el.total(copertoCosto));
        });


        printMenu();

    }


}