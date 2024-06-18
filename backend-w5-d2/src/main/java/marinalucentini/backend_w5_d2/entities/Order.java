package marinalucentini.backend_w5_d2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import marinalucentini.backend_w5_d2.enums.OrderStatus;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@ToString
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
    public double total (){
     return   this.total = this.menuElements.stream().mapToDouble(MenuElement::getPrice).sum() ;
    }
}
