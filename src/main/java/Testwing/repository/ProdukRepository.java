package Testwing.repository;

import Testwing.dto.ProductGridDTO;
import Testwing.entity.Produk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdukRepository extends JpaRepository<Produk, String> {

    @Query("""
            SELECT new Testwing.dto.ProductGridDTO
            (pro.productCode, pro.productName, pro.price, pro.diskon, pro.dimensi, pro.unit,pro.picture)
            FROM Produk as pro
            WHERE pro.productName LIKE %:name%
            """)
    Page<ProductGridDTO> findAllProduct(@Param("name") String name,
                                        Pageable pageable);
}