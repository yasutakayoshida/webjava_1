package jp.co.systena.tigerscave.shoppingapplication.application.list;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import jp.co.systena.tigerscave.shoppingapplication.application.model.Item;

@Service
public class ListService {

	public Map<Integer, Item> getItemList(){
		Item potatochips1 = new Item(000, "コンソメパンチ", 100);
		Item potatochips2 = new Item(001, "うすしお", 200);
		Item potatochips3 = new Item(002, "九州しょうゆ", 300);

		Map<Integer, Item> itemMap = new HashMap<>();
		itemMap.put(potatochips1.getItemId(), potatochips1);
		itemMap.put(potatochips2.getItemId(), potatochips2);
		itemMap.put(potatochips3.getItemId(), potatochips3);
		return itemMap;
	}
}