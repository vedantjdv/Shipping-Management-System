package com.sms.shippingmanagement.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sms.shippingmanagement.Entity.ShippingDetails;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ShippingDetailsRepository extends  JpaRepository<ShippingDetails, Long>{
    
    @Query(value = "select * from shipping.shipping_details sd where shipper_id = :shipper_id", nativeQuery = true)
    public List<ShippingDetails> getShippingDetailsByShipperId(@Param("shipper_id") String shipper_id);

    @Query(value = "select * from shipping.shipping_details sd where id = :id", nativeQuery = true)
    public ShippingDetails getShippingDetailsByLoadId(@Param("id") Long id);


    @Modifying
    @Query(value = "delete from shipping.shipping_details sd where sd.id = :id", nativeQuery = true)
    void deleteShippingDetailsById(@Param("id") Long id);
}
