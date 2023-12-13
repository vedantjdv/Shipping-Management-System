package com.sms.shippingmanagement.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.shippingmanagement.Entity.ShippingDetails;
import com.sms.shippingmanagement.Repository.ShippingDetailsRepository;

@Service
public class ShippingService {

    @Autowired
    private ShippingDetailsRepository shippingDetailsRepository;

    public String postShippingDetails(ShippingDetails request) throws Exception {
        shippingDetailsRepository.save(request);

        return " Load details added successfully.";
    }

    public List<ShippingDetails> getShippingDetails(String shipperId) {
        List<ShippingDetails> responseList = shippingDetailsRepository.getShippingDetailsByShipperId(shipperId);
        return responseList;
    }

    public ShippingDetails getShippingDetailsUsingLoadId(Long loadId) {
        ShippingDetails response = shippingDetailsRepository.getShippingDetailsByLoadId(loadId);
        return response;
    }


    public ShippingDetails updateShippingDetails(Long loadId,ShippingDetails request) {
        ShippingDetails detailsToBeUpdated = shippingDetailsRepository.getShippingDetailsByLoadId(loadId);
        detailsToBeUpdated.setLoadingPoint(request.getLoadingPoint());
        detailsToBeUpdated.setUnloadingPoint(request.getUnloadingPoint());
        detailsToBeUpdated.setProductType(request.getProductType());
        detailsToBeUpdated.setTruckType(request.getTruckType());
        detailsToBeUpdated.setNoOfTrucks(request.getNoOfTrucks());
        detailsToBeUpdated.setWeight(request.getWeight());
        detailsToBeUpdated.setComment(request.getComment());
        detailsToBeUpdated.setShipment_date(request.getShipment_date());
        shippingDetailsRepository.save(detailsToBeUpdated);
        return detailsToBeUpdated;
    }
    
     public String deleteShippingDetails(Long loadId) {
       shippingDetailsRepository.deleteShippingDetailsById(loadId);
        return "Deleted";
    }


}
