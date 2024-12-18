package com.dreamteam.product.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "product_placement")
public class ProductPlacementEntity {

	@Id
	@Column(name = "item_id")
	private Integer itemId;
	
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "aisle")
	private String aisle;

	@Column(name = "shelf_number", nullable = false)
	private Integer shelfNumber;
	
	@Column(name = "rack_number", nullable = false)
	private Integer rackNumber;

	@Column(name = "`row`", nullable = false)
	private Integer rowNumber;

	@Column(name = "`column`", nullable = false)
	private Integer columnNumber;

	@Column(name = "expiry_date")
	@Temporal(TemporalType.DATE)
	private Date expiryDate;

	@Column(name = "product_sold_flg", nullable = false)
	private Integer productSoldFlag;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getAisle() {
		return aisle;
	}

	public void setAisle(String aisle) {
		this.aisle = aisle;
	}

	public Integer getShelfNumber() {
		return shelfNumber;
	}

	public void setShelfNumber(Integer shelfNumber) {
		this.shelfNumber = shelfNumber;
	}

	public Integer getRackNumber() {
		return rackNumber;
	}

	public void setRackNumber(Integer rackNumber) {
		this.rackNumber = rackNumber;
	}

	public Integer getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(Integer rowNumber) {
		this.rowNumber = rowNumber;
	}

	public Integer getColumnNumber() {
		return columnNumber;
	}

	public void setColumnNumber(Integer columnNumber) {
		this.columnNumber = columnNumber;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getProductSoldFlag() {
		return productSoldFlag;
	}

	public void setProductSoldFlag(Integer productSoldFlag) {
		this.productSoldFlag = productSoldFlag;
	}

	// Getters and setters
}
