package com.trvajjala.resteasy.webservice;

import java.util.List;

import com.triabeauty.enterprise.entities.product.vo.ProductLine;
import com.triabeauty.enterprise.entities.transactional.vo.Cart;
import com.triabeauty.enterprise.service.endpoint.remote.CartServiceRemote;
import com.triabeauty.enterprise.service.endpoint.remote.ProductCatalogServiceRemote;
import com.triabeauty.enterprise.service.locator.ServiceLocator;

public class TestService {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		/*
		 * ProductCatalogServiceRemote remote = (ProductCatalogServiceRemote)
		 * ServiceLocator .lookUp(ProductCatalogServiceRemote.class);
		 * 
		 * List<ProductLine> list = remote.getProductLines();
		 * 
		 * System.out.println(list.size());
		 */

		CartServiceRemote remote2 = (CartServiceRemote) ServiceLocator
				.lookUp(CartServiceRemote.class);

		Cart cart = remote2.getSessionCart();

		System.out.println(cart.getCartItems());
	}

}
