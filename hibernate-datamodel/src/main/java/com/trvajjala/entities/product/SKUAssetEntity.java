package com.trvajjala.entities.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.trvajjala.entities.constants.ImageType;
import com.trvajjala.entities.constants.MIMEType;

@Entity
@Table(name = "SKUASSETS")
public class SKUAssetEntity implements Serializable {

	private static final long serialVersionUID = -8647432383783534405L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer assetId;

	private Integer imageWidth;

	private Integer imageHeight;

	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private ImageType imageType;

	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private MIMEType mimeType;

	@Column(length = 100, nullable = false)
	private String imageName;

	@Column(length = 225, nullable = false)
	private String imagePath;

	@Column(length = 50)
	private String imageResolution; // widthXheight?

	@Column(length = 100)
	private String imageAltText;

	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}

	public Integer getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(Integer imageWidth) {
		this.imageWidth = imageWidth;
	}

	public Integer getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(Integer imageHeight) {
		this.imageHeight = imageHeight;
	}

	public ImageType getImageType() {
		return imageType;
	}

	public void setImageType(ImageType imageType) {
		this.imageType = imageType;
	}

	public MIMEType getMimeType() {
		return mimeType;
	}

	public void setMimeType(MIMEType mimeType) {
		this.mimeType = mimeType;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImageResolution() {
		return imageResolution;
	}

	public void setImageResolution(String imageResolution) {
		this.imageResolution = imageResolution;
	}

	public String getImageAltText() {
		return imageAltText;
	}

	public void setImageAltText(String imageAltText) {
		this.imageAltText = imageAltText;
	}

}
