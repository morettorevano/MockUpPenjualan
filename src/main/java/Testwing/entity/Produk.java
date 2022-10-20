package Testwing.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Produk {
    @Id
    @Column(name = "ProductCode")
    private String productCode;

    @Column(name = "ProductName",length = 30)
    private String productName;

    @Column(name = "Price",length = 6)
    private Double price;

    @Column(name = "Discount",length = 6)
    private Double diskon;

    @Column(name = "Dimension",length = 50)
    private String dimensi;

    @Column(name = "Unit",length = 5)
    private String unit;

//    @Column(name = "Discontinued")
//    private Boolean discontinued = false;

    @Column(name = "Picture")
    private String picture;
}
