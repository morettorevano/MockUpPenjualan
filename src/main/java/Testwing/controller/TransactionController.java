package Testwing.controller;

import Testwing.dto.CartDTO;
import Testwing.dto.TransactionDTO;
import Testwing.entity.Produk;
import Testwing.service.abstraction.TransaksiDetailService;
import Testwing.service.abstraction.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransaksiService transaksiService;

    @Autowired
    private TransaksiDetailService detailService;

//    @RequestParam(required = true)String user,
    @GetMapping("/cart")
    public String getUserCart(
                          Authentication authentication,
                          Model model){

        String user = authentication.getName();
        List<CartDTO> userCart = detailService.getCart(user);
        model.addAttribute("cart",userCart);
//        model.addAttribute("totalPrice",totPrice);
        model.addAttribute("breadCrumbs", "Cart");
        return "transaction/trx-cart";
    }

//    @GetMapping("/addToCart")
//    public String addToCart(@RequestParam(required = true)String prodCode,
//                            Model model){
//
//        Produk produk = detailService.getProduct(prodCode);
//        CartDTO dto = new CartDTO();
//        model.addAttribute("prodCode",prodCode);
//        model.addAttribute("cart",dto);
//        model.addAttribute("product",produk);
//        model.addAttribute("breadCrumbs","Add to Cart");
//        return "transaction/cart-form";
//    }

//    @ModelAttribute("cart")CartDTO dto,

    @GetMapping("/addCart")
    public String saveCart(@RequestParam(required = true)String prodCode,
                            Authentication authentication){

        String user = authentication.getName();
//        String prodCode = dto.getProdCode();

        detailService.newTrxCart(user,prodCode);

        return "redirect:/product/index";
    }

    //        Double totPrice = detailService.getTotalPrice();
    @GetMapping("/report")
    public String report(@RequestParam(defaultValue = "")String id,
                         @RequestParam(defaultValue = "1")Integer page,
                         Model model){

        Pageable pageable = PageRequest.of(page-1, 5, Sort.by("date").descending());
        Page<TransactionDTO> grid = transaksiService.getReport(pageable, id);

        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",grid.getTotalPages());
        model.addAttribute("grid",grid);
        model.addAttribute("breadCrumbs","Report");
        return "transaction/report";
    }
}
