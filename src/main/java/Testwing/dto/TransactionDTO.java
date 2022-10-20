package Testwing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class TransactionDTO {

    private String trxCode;
    private Double totalPrice;
    private LocalDate date;
    private Boolean trxStatus;

}
