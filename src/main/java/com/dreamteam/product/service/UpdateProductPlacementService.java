package com.dreamteam.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamteam.product.entity.ProductPlacementEntity;
import com.dreamteam.product.model.UpdateProductPlacmentInput;
import com.dreamteam.product.repository.ProductPlacementRepository;

@Service
public class UpdateProductPlacementService {

	private ProductPlacementRepository productPlacementRepository;

	@Autowired
	public UpdateProductPlacementService(ProductPlacementRepository productPlacementRepository) {
		this.productPlacementRepository = productPlacementRepository;
	}

	public Boolean updateProductPlacement(UpdateProductPlacmentInput input) {
		System.out.println(input.getExpiryDate().toString());
		if (productPlacementRepository.existsById(input.getItemId())) {
			productPlacementRepository.updatePositionForExistingProduct(input.getAction(), input.getAisle(),
					input.getRackNumber(), input.getExpiryDate(), input.getShelfNumber(), input.getRowNumber(),
					input.getColumnNumber(), input.getItemId());
			return Boolean.TRUE;
		} else {
			ProductPlacementEntity entity = mapProductPlacementEntity(input);
			productPlacementRepository.save(entity);
			return Boolean.TRUE;
		}
	}
	
	public List<ProductPlacementEntity> fetchProductPlacementEntity() {
		List<ProductPlacementEntity> finalProductPlacementEntityList = new ArrayList<>();
		List<ProductPlacementEntity> productPlacementEntityList = productPlacementRepository.findAll();
		for (ProductPlacementEntity entity : productPlacementEntityList) {
			if (entity.getProductSoldFlag().equals(1)) {
				// delete row
				productPlacementRepository.deleteById(entity.getItemId());
			}
			else {
				finalProductPlacementEntityList.add(entity);
			}
		}
		return finalProductPlacementEntityList;
	}
	
	public ProductPlacementEntity mapProductPlacementEntity(UpdateProductPlacmentInput input) {
		ProductPlacementEntity entity = new ProductPlacementEntity();
		entity.setItemId(input.getItemId());
		entity.setProductId(input.getProductId());
		entity.setAisle(input.getAisle());
		entity.setShelfNumber(input.getShelfNumber());
		entity.setRackNumber(input.getRackNumber());
		entity.setRowNumber(input.getRowNumber());
		entity.setColumnNumber(input.getColumnNumber());
		entity.setExpiryDate(input.getExpiryDate());
		entity.setProductSoldFlag(input.getAction());
		return entity;
	}

}
