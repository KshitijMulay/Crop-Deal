package com.payment.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("DEALERSERVICE")
public interface PaymentDealerInterface {

//	@GetMapping("/dealer/profile/{id}")
//	public ResponseEntity<Optional<DealerDto>> getDealerProfileById(@PathVariable int id);
//
//	@GetMapping("/dealer/bookInfo/{book_id}")
//	public ResponseEntity<Optional<BookingDto>> getBookDetails(@PathVariable int book_id);    //need change

}
