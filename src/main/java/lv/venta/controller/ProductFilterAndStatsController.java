package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Product;
import lv.venta.service.IProductFilterAndStatsService;

@Controller
@RequestMapping("/product/filter")
public class ProductFilterAndStatsController {
//TODO uztaisīs 4 getmapping kontrolieru funkcijas - katru savai filtracijas servisa funkcijai
	
	@Autowired
	private IProductFilterAndStatsService service;
	
	@GetMapping("/price/{threshold}") //localhost:8080/product/filter/price/5.7
	public String getControllerFilterByPrice(@PathVariable(name = "threshold") float threshold,
			Model model) {
		try
		{
			ArrayList<Product> resultFromDB = service.filterByPriceLessThan(threshold);
			model.addAttribute("package", resultFromDB);
			model.addAttribute("info", "Produkti, kuru cena ir mazāka par " + threshold + " eur");
			return "show-all-products";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
		
	}
}
