package marinalucentini.backend_w5_d2.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Runner implements CommandLineRunner {


 @Autowired
 Menu menuPizzeria;

    @Override
    public void run(String... args) throws Exception {
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
}