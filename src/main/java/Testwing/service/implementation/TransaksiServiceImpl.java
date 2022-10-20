package Testwing.service.implementation;

import Testwing.dto.CartDTO;
import Testwing.dto.TransactionDTO;
import Testwing.entity.Produk;
import Testwing.repository.TransaksiDetailRepository;
import Testwing.repository.TransaksiRepository;
import Testwing.service.abstraction.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransaksiServiceImpl implements TransaksiService {

    @Autowired
    private TransaksiRepository transaksiRepository;


    @Override
    public Page<TransactionDTO> getReport(Pageable pageable, String id) {
        Page<TransactionDTO> grid = transaksiRepository.findAll(id,pageable);
        return grid;
    }
}
