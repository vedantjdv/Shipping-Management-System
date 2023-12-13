package com.sms.shippingmanagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

@Table(name = "shipping_details",schema = "shipping")
public class ShippingDetails {
    
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loading_point")
    private String loadingPoint;

    @Column(name = "unloading_point")
    private String unloadingPoint;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "truck_type")
    private String truckType;

    @Column(name = "no_of_trucks")
    private int noOfTrucks;

    @Column(name = "weight")
    private int weight;

    @Column(name = "comment")
    private String comment;

    @Column(name = "shipper_id")
    private String shipperId;

    @Column(name = "shipment_date")
    private String shipment_date;

}