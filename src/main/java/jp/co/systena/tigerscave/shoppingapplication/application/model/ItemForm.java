package jp.co.systena.tigerscave.shoppingapplication.application.model;

import javax.validation.constraints.Size;

public class ItemForm {

	 @Size(max=10)         // 入力最大長
	  private String item;

	  public String getItem() {
	    return this.item;
	  }
	  public void setName(String item) {
	    this.item = item;
	  }
	}

