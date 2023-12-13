package com.sms.shippingmanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.shippingmanagement.Entity.ShippingDetails;
import com.sms.shippingmanagement.Service.ShippingService;

@RestController
@RequestMapping("sms")
public class ShippingController {

@Autowired
ShippingService shippingService;


@GetMapping(path = "/ping")
public String testing(){
    return "RUNNING";
}

@PostMapping(path ="/load")
public String postShippingDetails(@RequestBody ShippingDetails request){
    
    String response=null;
    try {
        response = shippingService.postShippingDetails(request);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return response;
}
    
@GetMapping(path ="/load")
public List<ShippingDetails> getShippingDetails(@RequestParam String shipperId){
    
     List<ShippingDetails> responseList=null;
    try {
        responseList = shippingService.getShippingDetails(shipperId);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return responseList;
}

@GetMapping(path ="/load/{loadId}")
public ShippingDetails getShippingDetailsUsingLoadId(@PathVariable Long loadId){
    
     ShippingDetails response=null;
    try {
        response = shippingService.getShippingDetailsUsingLoadId(loadId);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return response;
}
    
@PutMapping(path ="/load/{loadId}")
public ShippingDetails updateShippingDetails(@PathVariable Long loadId,@RequestBody ShippingDetails request){
    
    ShippingDetails response=null;
    try {
        response = shippingService.updateShippingDetails(loadId,request);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return response;
}

@DeleteMapping(path ="/load/{loadId}")
public String deleteShippingDetails(@PathVariable Long loadId){
    
    String response=null;
    try {
        response = shippingService.deleteShippingDetails(loadId);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return response;
}
}
