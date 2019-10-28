package jp.co.systena.tigerscave.shoppingapplication.application.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ShoppingController {

	  @RequestMapping("/ShoppingApp")
		  public String index(HttpSession session, Model model,
                  @RequestParam(value = "item", required = false) String item) {

			    model.addAttribute("商品一覧", item);

			    return "shoppingapplication";
	  }

}

