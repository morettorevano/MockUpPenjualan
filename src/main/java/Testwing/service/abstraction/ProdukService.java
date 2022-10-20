package Testwing.service.abstraction;

import Testwing.dto.ProductGridDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdukService {
    Page<ProductGridDTO> getAllProduct(Pageable pageable, String name);

    ProductGridDTO getDetail(String code);
}
