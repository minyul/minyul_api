package com.minyul.practice.grammar.enump;

public class EnumMain {

	public static void main(String[] args) {

		// 상태 : true
		Order order = Order.builder()
						.state(OrderState.DELIVERING)
						.build();
		order.changeShippingInfo();

		// 상태 : false
		Order order1 = Order.builder()
						.state(OrderState.PREPARING)
						.build();
		order1.changeShippingInfo();
	}
}
