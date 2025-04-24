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

@FeignClient("CROPSERVICE")
public interface FarmerInterface {

	@GetMapping("crop/allCrops")
	public ResponseEntity<List<CropDto>> getAllCrops();

	@PostMapping("/crop/publish")
	public ResponseEntity<String> publishCrop(@RequestBody CropDto cropDto);

	@PutMapping("/crop/edit/{crop_id}")
	ResponseEntity<String> editCrop(@PathVariable("crop_id") int cropId, @RequestBody CropDto cropDto);

	@DeleteMapping("/crop/delete/{crop_id}")
	ResponseEntity<String> deleteCrop(@PathVariable("crop_id") int cropId);

	@GetMapping("/crop/farmer/{farmerId}")
	List<CropDto> getCropsByFarmer(@PathVariable("farmerId") int farmerId);

	@GetMapping("crop/status/{cropId}")
	public ResponseEntity<String> getCropStatus(@PathVariable int cropId);
	
}
