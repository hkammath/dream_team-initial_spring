package com.dreamteam.product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dreamteam.product.entity.ProductPlacementEntity;
import com.dreamteam.product.model.UpdateProductPlacmentInput;
import com.dreamteam.product.service.UpdateProductPlacementService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class UpdateProductPlacementController {

	@Autowired
	private UpdateProductPlacementService updateProductPlacementService;

	@PostMapping("/updateProductPlacement")
	public ResponseEntity<Boolean> updateProductPlacement(@RequestBody UpdateProductPlacmentInput input) {
		return ResponseEntity.ok(updateProductPlacementService.updateProductPlacement(input));
	}

	@GetMapping(value = "/export", produces = "text/csv")
	public void exportToCsv(HttpServletResponse response) throws IOException {
		// Set file name and content type
		String filename = "scheduled_report.csv";
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
		List<ProductPlacementEntity> productPlacementEntityList = updateProductPlacementService
				.fetchProductPlacementEntity();
		try (PrintWriter writer = response.getWriter()) {
			// Header
			writer.println("item_id,product_id,aisle,shelf_number,rack_number,row,column,expiry_date,product_sold_flg");

			// Data rows (replace with dynamic data if needed)
			for (ProductPlacementEntity entity : productPlacementEntityList) {
				writer.println(entity.getItemId() + "," + entity.getProductId() + "," + entity.getAisle() + ","
						+ entity.getShelfNumber() + "," + entity.getRackNumber() + "," + entity.getRowNumber() + ","
						+ entity.getColumnNumber() + "," + entity.getExpiryDate() + "," + entity.getProductSoldFlag());
			}
		}
	}

}