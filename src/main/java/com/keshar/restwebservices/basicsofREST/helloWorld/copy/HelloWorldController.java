package com.keshar.restwebservices.basicsofREST.helloWorld.copy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}


	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}

	///hello-world/path-variable/keshar
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVaiable(@PathVariable String name ) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
}
