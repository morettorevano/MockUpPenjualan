package Testwing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CartDTO {

    private String username;
    private String prodCode;
    private String prodName;
    private String unit;
    private Integer quantity;
    private Double price;
    private Double subTotal;
    private Double totalPrice;


}
