package com.payment.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("CROPSERVICE")
public interface PaymentCropInterface {

//	@GetMapping("/crop/{id}")
//	public ResponseEntity<Optional<CropDto>> getCropDetailsById(@PathVariable int id);

}
