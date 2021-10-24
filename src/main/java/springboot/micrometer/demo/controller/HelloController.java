package springboot.micrometer.demo.controller;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HelloController {

	@Timed(value = "greeting1", histogram = true, percentiles = { 0.95, 0.99 }, extraTags = { "version", "1.0" })
	@GetMapping("/hello")
	public String hello() {
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

}
