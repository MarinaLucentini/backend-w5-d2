package marinalucentini.backend_w5_d2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import marinalucentini.backend_w5_d2.enums.OrderStatus;

import java.time.LocalTime;
import java.util.List;
@Setter
@Getter
@ToString
@AllArgsConstructor
public class Order {
    private int numberOrder;
    private List<MenuElement> menuElements;
    private OrderStatus orderStatus;
    private int numberCovered;
    private LocalTime hoursOfAcquisition;


}
