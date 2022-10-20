package Testwing.controller;

import Testwing.dto.ProductGridDTO;
import Testwing.service.abstraction.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProdukController {

    @Autowired
    private ProdukService produkService;

    @GetMapping("/index")
    public String getProduct(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "")String name,
                             Model model){

        Pageable pageable = PageRequest.of(page-1, 5, Sort.by("productName"));
        Page<ProductGridDTO> grid = produkService.getAllProduct(pageable,name);

        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",grid.getTotalPages());
        model.addAttribute("grid",grid);
        model.addAttribute("breadCrumbs","Product");

        return "product/product-index";
    }

    @GetMapping("/detail")
    private String detailProduct(@RequestParam(required = true)String code,
                                 Model model){

        ProductGridDTO infoDetail = produkService.getDetail(code);
        model.addAttribute("product",infoDetail);
        String breadCrumbs = ("Detail Info: "+infoDetail.getProductName());
        model.addAttribute("breadCrumbs",breadCrumbs);

        return "product/product-detail";
    }
}
