package com.dreamteam.product.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UpdateProductPlacmentInput {

	private Integer itemId;
	private Integer productId;
	private String aisle;
	private Integer shelfNumber;
	private Integer rackNumber;
	private Integer rowNumber;
	private Integer columnNumber;
	private Integer action;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date expiryDate;

	public UpdateProductPlacmentInput() {
		// Default constructor
	}

	public UpdateProductPlacmentInput(Integer itemId, Integer productId, String aisle, Integer shelfNumber,
			Integer rackNumber, Integer rowNumber, Integer columnNumber, Integer action, Date expiryDate) {
		this.itemId = itemId;
		this.productId = productId;
		this.aisle = aisle;
		this.shelfNumber = shelfNumber;
		this.rackNumber = rackNumber;
		this.rowNumber = rowNumber;
		this.columnNumber = columnNumber;
		this.action = action;
		this.expiryDate = expiryDate;
	}

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

	public Integer getAction() {
		return action;
	}

	public void setAction(Integer action) {
		this.action = action;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}


}
