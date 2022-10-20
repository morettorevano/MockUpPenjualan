package Testwing.repository;

import Testwing.dto.TransactionDTO;
import Testwing.entity.Transaksi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransaksiRepository extends JpaRepository<Transaksi, String> {

   @Query(nativeQuery = true,value = """
           SELECT TOP 1 trx.TrxNumber
           FROM Transaksi AS trx
           ORDER BY trx.TrxNumber DESC
           """)
    String lastId();

   @Query("""
           SELECT new Testwing.dto.TransactionDTO
           (CONCAT(trx.docCode,'-',trx.TrxNumber),trx.totalPrice, trx.date, trx.trxStatus)
           FROM Transaksi as trx
           WHERE CONCAT(trx.docCode,'-',trx.TrxNumber) LIKE %:id% 
           AND trx.trxStatus = true
           """)
    Page<TransactionDTO> findAll(@Param("id") String id, Pageable pageable);
}