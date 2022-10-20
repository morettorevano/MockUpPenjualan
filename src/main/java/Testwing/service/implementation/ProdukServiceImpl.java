package Testwing.service.implementation;

import Testwing.dto.ProductGridDTO;
import Testwing.entity.Produk;
import Testwing.repository.ProdukRepository;
import Testwing.service.abstraction.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ProdukServiceImpl implements ProdukService {

    @Autowired
    private ProdukRepository produkRepository;

    @Override
    public Page<ProductGridDTO> getAllProduct(Pageable pageable, String name) {
        Page<ProductGridDTO> grid = produkRepository.findAllProduct(name,pageable);
//        for(ProductGridDTO newGrid : grid) {
//            if(newGrid.getDiskon()!=0){
//                Double diskonPrice = ((newGrid.getPrice()/ newGrid.getDiskon())* 100);
//                Double priceAfterDiskon = newGrid.getPrice() - diskonPrice;
//            }
//        }
        return grid;
    }

    @Override
    public ProductGridDTO getDetail(String code) {
        Optional<Produk> optionalProduk = produkRepository.findById(code);
        Produk produk = optionalProduk.get();
        ProductGridDTO detailProduk = new ProductGridDTO(
                produk.getProductCode(),
                produk.getProductName(),
                produk.getPrice(),
                produk.getDiskon(),
                produk.getDimensi(),
                produk.getUnit(),
                produk.getPicture()
        );
        return detailProduk;
    }
}
