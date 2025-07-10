package com.dealer.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.dealer.model.CropWrapper;
import com.dealer.model.RatingsAndReviewsDTO;

@FeignClient("CROPSERVICE")
public interface CropInterface {

	@GetMapping("crop/allCrops")
	ResponseEntity<List<CropWrapper>> getAllCrops();

	@PutMapping("crop/book/{id}/{quantity}")
	ResponseEntity<String> bookCropByDealer(@PathVariable("id") int cropId, @PathVariable("quantity") double quantity);

	@PutMapping("crop/cancel/{id}/{quantity}")
	ResponseEntity<String> cancelCropBooking(@PathVariable("id") int cropId, @PathVariable("quantity") double quantity);

	@GetMapping("/crop/{id}")
	ResponseEntity<CropWrapper> getCropDetails(@PathVariable("id") int cropId);

	@GetMapping("crop/status/{cropId}")
	public ResponseEntity<String> getCropStatus(@PathVariable int cropId);

	@GetMapping("crop/available")
	public ResponseEntity<List<CropWrapper>> getAvailableCrops();

	@GetMapping("crop/booked")
	public ResponseEntity<List<CropWrapper>> getFullyBookedCrops();

	@GetMapping("crop/reviews")
	public ResponseEntity<List<RatingsAndReviewsDTO>> allReviews();

	@GetMapping("crop/reviews/{crop_id}")
	public ResponseEntity<List<RatingsAndReviewsDTO>> allReviewsByCropId(@PathVariable int crop_id);

	@GetMapping("crop/review/average-rating/{crop_id}")
	public ResponseEntity<String> getAverage(@PathVariable int crop_id);

}
