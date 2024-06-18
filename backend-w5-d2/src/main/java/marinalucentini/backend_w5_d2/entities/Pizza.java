package marinalucentini.backend_w5_d2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString

@Setter
@Getter
public class Pizza extends MenuElement {
private List<Topping> ingredients;

    public Pizza(String name, double price, int calories, List<Topping> ingredients) {
        super(name, price, calories);
        this.ingredients = ingredients;
    }
}
