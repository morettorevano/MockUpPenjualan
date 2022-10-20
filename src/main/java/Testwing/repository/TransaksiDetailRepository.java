package Testwing.repository;

import Testwing.dto.CartDTO;
import Testwing.entity.Account;
import Testwing.entity.TransaksiDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransaksiDetailRepository extends JpaRepository<TransaksiDetail, Integer> {

    @Query("""
            SELECT new Testwing.dto.CartDTO
            (acc.username, pd.productCode, pd.productName, pd.unit,
            td.quantity, pd.price, td.subTotal, trx.totalPrice)
            FROM TransaksiDetail as td
                JOIN td.transaksi as trx
                JOIN td.product as pd
                JOIN trx.account as acc
            WHERE :user = trx.account
            AND trx.trxStatus = false
            """)
    List<CartDTO> findCart(@Param("user") Account user);
}