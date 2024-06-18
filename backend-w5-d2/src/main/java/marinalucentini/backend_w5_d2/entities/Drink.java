package marinalucentini.backend_w5_d2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@ToString
public class Drink extends MenuElement {
private double quantity;

    public Drink(String name, double price, int calories, double quantity) {
        super(name, price, calories);
        this.quantity = quantity;
    }
}
