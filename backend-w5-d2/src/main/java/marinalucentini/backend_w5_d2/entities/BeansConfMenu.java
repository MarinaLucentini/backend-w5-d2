package marinalucentini.backend_w5_d2.entities;

import marinalucentini.backend_w5_d2.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("application.properties")

public class BeansConfMenu {
    @Bean
    @Primary
    public Topping getToppingCheese(){
        return new Topping("Cheese", 0.69, 92);
    }
    @Bean
    public Topping getToppingHam() {
        return new Topping("Ham", 0.99, 35);

    }
    @Bean
    public Topping getToppingOnion(){
        return new Topping("Onions", 0.69,22);
    }
    @Bean
    public Topping getToppingPineaple(){
        return new Topping("Pineaple", 0.79, 24);
    }
    @Bean
    public Topping getToppingSalami(){
        return new Topping("Salami", 0.99, 86);
    }
    @Bean
    public List<Topping> toppingMargherita (){
        List<Topping> toppingMargherita = new ArrayList<>();
        Topping cheese = new Topping("Cheese", 0.69, 92);
        Topping tomato = new Topping("Tomato", 0, 0);
        toppingMargherita.add(cheese);
        toppingMargherita.add(tomato);
        return toppingMargherita;
    }
    @Bean
    public String nomePizza(){

        return "Pizza margherita";
    }
    @Bean
    public double pricePizza(){
        return 4.59;
    }
    @Bean
    @Primary

    public Pizza pizzaMargherita (){
        return new Pizza("Pizza margherita", 4.99, 1104,toppingMargherita());
    }
    @Bean
    public Pizza pizzaHawaiana (){
        List<Topping> toppings = new ArrayList<>();
        toppings.addAll(toppingMargherita());
        toppings.add(getToppingPineaple());
        toppings.add(getToppingHam());
        return new Pizza("Pizza Hawaiana", pizzaMargherita().getPrice() + getToppingHam().getPrice()+ getToppingPineaple().getPrice(), pizzaMargherita().getCalories()+ getToppingHam().getCalories()+ getToppingPineaple().getCalories(), toppings );
    }
    @Bean
    public Pizza pizzaSalami(){
        List<Topping> toppings = new ArrayList<>();
        toppings.addAll(toppingMargherita());
        toppings.add(getToppingSalami());
        return new Pizza("Salami Pizza", pizzaMargherita().getPrice() + getToppingSalami().getPrice(), pizzaMargherita().getCalories() + getToppingSalami().getCalories(),  toppings );
    }
    @Bean
    public Pizza pizzaDoubleCheese(){
        List<Topping> toppings = new ArrayList<>();
        toppings.addAll(toppingMargherita());
        toppings.add(getToppingCheese());
        return new Pizza("Pizza doppio formaggio", pizzaMargherita().getPrice() + getToppingCheese().getPrice(), pizzaMargherita().getCalories() + 200, toppings );
    }
    @Bean
    public Pizza pizzaOnion(){
        List<Topping> topping = new ArrayList<>();
        topping.addAll(toppingMargherita());
        topping.add(getToppingOnion());
        return new Pizza("Pizza Onion", pizzaMargherita().getPrice()+1.5, pizzaMargherita().getCalories() + 200, topping );
    }
    @Bean
    public Drink Lemonade (){
        return new Drink("Lemonade", 1.29, 128, 0.33);
    }
    @Bean
    @Primary
    public Drink Water (){
        return new Drink("Water", 1.29, 0,0.5);
    }
    @Bean
    public Drink Wine(){
        return new Drink("Wine", 7.49,607,0.75 );
    }

@Bean
@Primary
    public Table table1 (){
        return new Table(1,2);
}
@Bean
    public Table table2 (){
        return new Table(2,2);
}
@Bean
    public Table table3 (){
        return new Table(3,4);
}
@Bean
    public Table table4 (){
        return new Table(4,4);
}


@Bean
    public double coperto(@Value("${coperto.costo}")String coperto){
        return Double.parseDouble(coperto);
}

}
