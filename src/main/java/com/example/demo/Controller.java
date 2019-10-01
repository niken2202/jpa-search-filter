package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/")
public class Controller {
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Repository repo;
	
	@RequestMapping("/getall")
	public List<User> getall(){
		return repo.findAll();
	}
	@RequestMapping("/search")
	public Page<User> search(@RequestBody List<SearchCriteria> filters,
			@RequestParam int page, @RequestParam int size 
			){
		
		System.out.println("hwehe"+java.util.Arrays.toString(filters.toArray()));
		  List<Specification> specs = filters.stream().map(UserSpecification::new)
				  .collect(Collectors.toList());
		  System.out.println(specs.size());
		  Specification result =specs.get(0);
	               
		for (int i=1;i<specs.size();i++) {
			result =Specification.where(result)
            .and(specs.get(i));
			
		}
		return repo.findAll(result, PageRequest.of(page, size));
		
	}
}
