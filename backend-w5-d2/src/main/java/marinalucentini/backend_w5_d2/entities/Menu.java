package marinalucentini.backend_w5_d2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;
@Getter
@Setter
@ToString
@AllArgsConstructor
@Component
public class Menu {
    private List<Topping> toppings;
    private List<Pizza> pizzas;
    private List<Drink> drinks;
}
