package com.farmer.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.farmer.model.CropDto;
import com.farmer.model.RatingsAndReviewsDTO;

@FeignClient("CROPSERVICE")
public interface CropInterface {

	@GetMapping("crop/allCrops")
	public ResponseEntity<List<CropDto>> getAllCrops();

	@PostMapping("/crop/publish")
	public ResponseEntity<String> publishCrop(@RequestBody CropDto cropDto);

	@PutMapping("/crop/edit/{crop_id}")
	ResponseEntity<String> editCrop(@PathVariable("crop_id") int cropId, @RequestBody CropDto cropDto);

	@DeleteMapping("/crop/delete/{crop_id}")
	ResponseEntity<String> deleteCrop(@PathVariable("crop_id") int cropId);

	@GetMapping("/crop/farmer/{farmerId}")
	List<CropDto> getCropsByFarmer(@PathVariable int farmerId);

	@GetMapping("crop/status/{cropId}")
	public ResponseEntity<String> getCropStatus(@PathVariable int cropId);

	@GetMapping("crop/available")
	public ResponseEntity<List<CropDto>> getAvailableCrops();

	@GetMapping("crop/booked")
	public ResponseEntity<List<CropDto>> getFullyBookedCrops();

	@GetMapping("crop/reviews")
	public ResponseEntity<List<RatingsAndReviewsDTO>> allReviews();

	@GetMapping("crop/reviews/id/{crop_id}")
	public ResponseEntity<List<RatingsAndReviewsDTO>> allReviewsByCropId(@PathVariable int crop_id);
	
	@GetMapping("crop/reviews/{crop_name}")
	public ResponseEntity<List<RatingsAndReviewsDTO>> allReviewsByCropName(@PathVariable String crop_name);

	@GetMapping("crop/review/average-rating/{crop_id}")
	public ResponseEntity<String> getAverage(@PathVariable int crop_id);
}
