package com.minyul.practice.grammar.enump;

import lombok.Builder;

@Builder
public class Order {

	private final OrderState state;

	public void changeShippingInfo() {
		System.out.println("상태 : " + state.isShippingChangeable());
	}
}
