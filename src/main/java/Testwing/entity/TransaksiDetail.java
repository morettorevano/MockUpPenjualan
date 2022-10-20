package Testwing.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class TransaksiDetail {

    @Id
    @Column(name = "TrxDetailCode",length = 15)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trxDetailCode;

//    @Column(name = "Price")
//    private BigDecimal price;

    @Column(name = "Quantity",length = 6)
    private Integer quantity;

//    UNITTT % PRICE

    @Column(name = "SubTotal",length = 10)
    private Double subTotal;

    @ManyToOne
    @JoinColumn(name = "ProductCode")
    private Produk product;

    @ManyToOne
    @JoinColumn(name = "TransaksiNumber")
    private Transaksi transaksi;

    public TransaksiDetail(Integer quantity, Double subTotal, Produk product, Transaksi transaksi) {
        this.quantity = quantity;
        this.subTotal = subTotal;
        this.product = product;
        this.transaksi = transaksi;
    }
}
