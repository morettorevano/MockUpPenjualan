package Testwing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class ProductGridDTO {

    private String productCode;

    private String productName;

    private Double price;

    private Double diskon;

    private String dimensi;

    private String unit;

    private String picture;

    private Double priceAfterDiskon;

    public ProductGridDTO(String productCode, String productName, Double price, Double diskon, String dimensi, String unit, String picture) {
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.diskon = diskon;
        this.dimensi = dimensi;
        this.unit = unit;
        this.picture = picture;
    }

    public void setPriceAfterDiskon(Double priceAfterDiskon) {
        if(getDiskon() != null){
            Double diskonPrice = ((getPrice()/ getDiskon())* 100);
            Double finalPrice = getPrice() - diskonPrice;

            this.priceAfterDiskon = finalPrice;
        }else this.priceAfterDiskon = priceAfterDiskon;
    }

}
