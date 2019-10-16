package com.keshar.restwebservices.basicsofREST.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class SomeFiltering {

	@GetMapping("/filtering")
	public MappingJacksonValue filterSomeValue() {
		SomeBean someBean = new SomeBean("value1","value2","value3");

		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("filed1","filed2");
		FilterProvider filterProvider=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue maJacksonValue=new MappingJacksonValue(someBean);
		maJacksonValue.setFilters(filterProvider);
		return maJacksonValue;
	}
}
