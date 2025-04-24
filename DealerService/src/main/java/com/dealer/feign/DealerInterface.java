package com.dealer.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.dealer.model.CropWrapper;

@FeignClient("CROPSERVICE")
public interface DealerInterface {

	@GetMapping("crop/allCrops")
	ResponseEntity<List<CropWrapper>> getAllCrops();

	@PutMapping("crop/book/{id}/{quantity}")
	ResponseEntity<String> bookCropByDealer(@PathVariable("id") int cropId, @PathVariable("quantity") double quantity);

	@PutMapping("crop/cancel/{id}/{quantity}")
	ResponseEntity<String> cancelCropBooking(@PathVariable("id") int cropId, @PathVariable("quantity") double quantity);

//	HttpEntity<List<Dealer>> getCropDetails(int cropId);

	@GetMapping("/crop/{id}")
	ResponseEntity<CropWrapper> getCropDetails(@PathVariable("id") int cropId);
}
