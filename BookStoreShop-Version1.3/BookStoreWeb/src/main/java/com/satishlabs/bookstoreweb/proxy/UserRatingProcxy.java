package com.satishlabs.bookstoreweb.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.satishlabs.bookstoreweb.dto.UserRating;
import com.satishlabs.rabbitmq.BookRatingInfo;




@FeignClient(value = "UserRatingMS", url = "http://localhost:6500")
public interface UserRatingProcxy {
	
	@GetMapping("/userrating/{userId}")
	public List<UserRating> getUserRatingByUserId(@PathVariable String userId);
	
	@GetMapping("/bookrating/{bookId}")
	public BookRatingInfo getBookRatingByBookId(@PathVariable Integer bookId);
}
