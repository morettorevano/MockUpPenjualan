package Testwing.service.abstraction;

import Testwing.dto.CartDTO;
import Testwing.dto.TransactionDTO;
import Testwing.entity.Produk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransaksiService {

    Page<TransactionDTO> getReport(Pageable pageable, String id);
}
