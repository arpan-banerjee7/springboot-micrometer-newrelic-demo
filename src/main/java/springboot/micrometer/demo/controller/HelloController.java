package springboot.micrometer.demo.controller;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/rest")
public class HelloController {
	Random random = new Random();

	@Timed(value = "greeting1", histogram = true, percentiles = { 0.95, 0.99 }, extraTags = { "version", "1.0" })
	@GetMapping("/hello")
	public String hello() throws InterruptedException {
		int number = random.nextInt(700 - 50) + 50;
		Thread.sleep(number);
		return "Hello Arpan1";
	}

	@Timed(value = "greeting2", histogram = true, percentiles = { 0.95, 0.99 }, extraTags = { "version", "1.0" })
	@GetMapping("/hello2")
	public String hello2() {
		return "Hello Arpan2";
	}

	@Timed(value = "greeting3", histogram = true, percentiles = { 0.95, 0.99 }, extraTags = { "version", "1.0" })
	@GetMapping("/hello3")
	public String hello3() {
		return "Hello Arpan3";
	}

	@GetMapping("/hello4")
	public String hello4() {
		return "Hello Arpan4";
	}

	@Timed(value = "greeting5", histogram = true, percentiles = { 0.95, 0.99 }, extraTags = { "version", "1.0" })
	@GetMapping("/hello5")
	public ResponseEntity<?> hello5() {
		int number = random.nextInt(8 - 1) + 1;
		if (number == 3) {
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
