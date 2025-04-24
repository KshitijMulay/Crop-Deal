package com.notify.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "DEALERSERVICE")
public interface DealerInterface {
	@GetMapping("/dealer/emails")
	List<String> getAllDealerEmails();
}
