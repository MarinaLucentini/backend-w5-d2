package marinalucentini.backend_w5_d2;

import marinalucentini.backend_w5_d2.entities.Menu;
import marinalucentini.backend_w5_d2.entities.Topping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Collectors;

@SpringBootApplication
public class BackendW5D2Application {

	public static void main(String[] args) {


		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BackendW5D2Application.class);
		Menu menuPizzeria = context.getBean(Menu.class);
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
		context.close();



		SpringApplication.run(BackendW5D2Application.class, args);
	}

}
