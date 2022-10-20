package Testwing.service.implementation;

import Testwing.dto.CartDTO;
import Testwing.entity.Account;
import Testwing.entity.Produk;
import Testwing.entity.Transaksi;
import Testwing.entity.TransaksiDetail;
import Testwing.repository.AccountRepository;
import Testwing.repository.ProdukRepository;
import Testwing.repository.TransaksiDetailRepository;
import Testwing.repository.TransaksiRepository;
import Testwing.service.abstraction.TransaksiDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransaksiDetailServiceImpl implements TransaksiDetailService {

    @Autowired
    private TransaksiDetailRepository detailRepository;

    @Autowired
    private TransaksiRepository trxRepository;

    @Autowired
    private ProdukRepository produkRepository;

    @Autowired
    private AccountRepository accRepo;

    @Override
    public List<CartDTO> getCart(String user) {
        Optional<Account> accOptional = accRepo.findById(user);
        Account account = accOptional.get();
        List<CartDTO> cart = detailRepository.findCart(account);

        return cart;
    }

    @Override
    public Produk getProduct(String prodCode) {
        Optional<Produk> optionalProduk = produkRepository.findById(prodCode);
        Produk produk = optionalProduk.get();
        return produk;
    }

    @Override
    public void newTrx(String user, CartDTO dto,String prodCode) {

        Optional<Account> acc = accRepo.findById(user);
        Account account = acc.get();
        Optional<Produk> prod = produkRepository.findById(prodCode);
        Produk produk = prod.get();

        String lastId = trxRepository.lastId();
        var format = Long.parseLong(lastId);
        var sumId = format+1;
        var trxId = String.format("%03d",sumId);
        System.out.println(trxId);

        Transaksi newTrx = new Transaksi(
                trxId,
                "TRX",
                produk.getPrice(),
                LocalDate.now(),
                false,
                account
        );
        trxRepository.save(newTrx);

        var subTotal = (produk.getPrice()* dto.getQuantity());
        TransaksiDetail newDetail = new TransaksiDetail(
                dto.getQuantity(),
                subTotal,
                produk,
                newTrx
        );
        detailRepository.save(newDetail);

    }

    @Override
    public void newTrxCart(String user, String prodCode) {
        Optional<Account> acc = accRepo.findById(user);
        Account account = acc.get();
        Optional<Produk> prod = produkRepository.findById(prodCode);
        Produk produk = prod.get();

        String lastId = trxRepository.lastId();
        var format = Long.parseLong(lastId);
        var sumId = format+1;
        var trxId = String.format("%03d",sumId);
        System.out.println(trxId);

        Transaksi newTrx = new Transaksi(
                trxId,
                "TRX",
                produk.getPrice(),
                LocalDate.now(),
                false,
                account
        );
        trxRepository.save(newTrx);


        TransaksiDetail newDetail = new TransaksiDetail(
                1,
                produk.getPrice(),
                produk,
                newTrx
        );
        detailRepository.save(newDetail);
        var subTotal = (produk.getPrice()* newDetail.getQuantity());
    }

    @Override
    public Double getTotalPrice() {
        return null;
    }

}
