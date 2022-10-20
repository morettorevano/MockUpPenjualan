package Testwing.service.abstraction;

import Testwing.dto.CartDTO;
import Testwing.entity.Produk;

import java.util.List;

public interface TransaksiDetailService {
    List<CartDTO> getCart(String user);

    Produk getProduct(String prodCode);

    void newTrx(String user, CartDTO dto,String prodCode);

    void newTrxCart(String user, String prodCode);

    Double getTotalPrice();


//    Produk getProd(String prodCode);
}
