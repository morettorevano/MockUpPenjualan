package Testwing.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class Transaksi {

    @Id
    @Column(name = "TrxNumber")
    private String TrxNumber;

    @Column(name = "DocumentCode")
    @Size(max = 3)
    private String docCode = "TRX";

    @Column(name = "Total",length = 10)
    private Double totalPrice;

    @Column(name = "Date",length = 10)
    private LocalDate date = LocalDate.now();

    @Column(name = "Status")
    private Boolean trxStatus;


    @ManyToOne
    @JoinColumn(name = "Username")
    private Account account;
}
