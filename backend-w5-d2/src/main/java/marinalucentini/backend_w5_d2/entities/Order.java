package marinalucentini.backend_w5_d2.entities;

import lombok.*;
import marinalucentini.backend_w5_d2.enums.OrderStatus;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@ToString
@PropertySource("application.properties")
public class Order {
    private int numberOrder;
    private List<MenuElement> menuElements;
    private OrderStatus orderStatus;
    private int numberCovered;
    private LocalTime hoursOfAcquisition;
    private double total;

    public Order(int numberOrder, List<MenuElement> menuElements, OrderStatus orderStatus, int numberCovered, LocalTime hoursOfAcquisition) {
        this.numberOrder = numberOrder;
        this.menuElements = menuElements;
        this.orderStatus = orderStatus;
        this.numberCovered = numberCovered;
        this.hoursOfAcquisition = hoursOfAcquisition;
    }
    public double total (double coperto){
   return   this.total = this.menuElements.stream().mapToDouble(MenuElement::getPrice).sum() +  coperto;
   }
}
