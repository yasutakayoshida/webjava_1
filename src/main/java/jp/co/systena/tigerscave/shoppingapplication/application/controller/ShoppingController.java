package jp.co.systena.tigerscave.shoppingapplication.application.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jp.co.systena.tigerscave.shoppingapplication.application.list.ListForm;
import jp.co.systena.tigerscave.shoppingapplication.application.list.ListService;
import jp.co.systena.tigerscave.shoppingapplication.application.model.Cart;
import jp.co.systena.tigerscave.shoppingapplication.application.model.Item;
import jp.co.systena.tigerscave.shoppingapplication.application.model.Order;

public class ShoppingController {

	@Autowired
	HttpSession session;                  // セッション管理
	@RequestMapping(value = "/index", method = RequestMethod.GET) // URLとのマッピング
	public ModelAndView index(HttpSession session, ModelAndView mav,
			@RequestParam(name = "name", required = false) String name) {

		mav.addObject("items", new ListService().getItemList());

		mav.setViewName("index");
		// Viewのテンプレート名を返す
		//return "index";
		return mav;
	}

	@RequestMapping(value="/Cart", method = RequestMethod.POST)  // URLとのマッピング
	public ModelAndView order(ModelAndView mav, @Valid ListForm listForm, BindingResult bindingResult, HttpServletRequest request) {

		// セッション取得
		Cart cart = (Cart) session.getAttribute("Cart");
		if (cart == null) {
			cart = new Cart();
		}

		Map<String, Item> cartList = new HashMap<String, Item>();
		Map<Integer, Item> itemList = new ListService().getItemList();


		Order order = new Order();
		order.setId(listForm.getId());
		cart.addOrder(order);


		//cartListへ追加
		int i = 0;
		for (Order cartItem : cart.getOrderList()) {
			cartList.put(String.valueOf(cartItem.getId()), itemList.get(String.valueOf(cartItem.getId())));
			i++;
		}

		// セッション保存、テンプレートitemsに代入
		mav.addObject("items",cartList);
		session.setAttribute("cartList", cart);

		//mav.addObject("listForm",listForm);

		mav.setViewName("Cart");
		return mav;
	}

}
