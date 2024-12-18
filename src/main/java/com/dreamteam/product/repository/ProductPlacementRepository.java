package com.dreamteam.product.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dreamteam.product.entity.ProductPlacementEntity;

@Repository
public interface ProductPlacementRepository extends JpaRepository<ProductPlacementEntity, Integer> {

	List<ProductPlacementEntity> findByProductId(Integer productId);
	
	@Modifying
	@Transactional
	@Query("UPDATE ProductPlacementEntity p SET p.productSoldFlag = :productSoldFlag, p.expiryDate = :expiryDate, p.aisle = :aisle, "
			+ "p.shelfNumber = :shelfNumber, p.rackNumber = :rackNumber, p.rowNumber = :rowNumber, p.columnNumber = :columnNumber where p.itemId = :itemId")
	int updatePositionForExistingProduct(@Param("productSoldFlag") Integer productSoldFlag,
			@Param("aisle") String aisle, @Param("rackNumber") Integer rackNumber,
			@Param("expiryDate") Date expiryDate, @Param("shelfNumber") Integer shelfNumber,
			@Param("rowNumber") Integer rowNumber, @Param("columnNumber") Integer columnNumber, @Param("itemId") Integer itemId);

}