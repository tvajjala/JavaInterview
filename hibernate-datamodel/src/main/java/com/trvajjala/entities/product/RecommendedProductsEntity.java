package com.trvajjala.entities.product;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "RECOMMENDEDPRODUCTS")
public class RecommendedProductsEntity implements Serializable {

	private static final long serialVersionUID = -645126012724719474L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer recommendedProductId;

	@ManyToOne
	@JoinColumn(name = "productId", nullable = false)
	@ForeignKey(name = "FK_recommmendedProduct_CatalogSKU_baseProduct")
	ProductEntity product;

	@ManyToOne
	@JoinColumn(name = "recommmendedProductId", nullable = false)
	@ForeignKey(name = "FK_recommmendedProduct_CatalogSKU_recommended")
	ProductEntity recommendedProduct;

	public ProductEntity getRecommendedProduct() {
		return recommendedProduct;
	}

	public void setRecommendedProduct(ProductEntity recommendedProduct) {
		this.recommendedProduct = recommendedProduct;
	}

	public Integer getRecommendedProductId() {
		return recommendedProductId;
	}

	public void setRecommendedProductId(Integer recommendedProductId) {
		this.recommendedProductId = recommendedProductId;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

}
