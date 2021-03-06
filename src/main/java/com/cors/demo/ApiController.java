package com.cors.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:3000")

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	AppDataRepo repo;

	@GetMapping("/allData")
	public List<AppData> getData() {
		List<AppData> foundData;
		foundData = new ArrayList<>();
		foundData.addAll(repo.findAll());
		foundData.toArray();

		return foundData;
	}

	@PostMapping("/postData")
	public ResponseEntity<AppData> postData(@RequestBody AppData data) {
		
		AppData createdPost = repo.save(data);
		System.out.println("post successful");
		return ResponseEntity.ok(createdPost);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<AppData> deleteData(@PathVariable(value = "id") Integer id) {

		Optional<AppData> data = repo.findById(id);

		if (data == null) {
			return ResponseEntity.notFound().header("AppData", "noting found").build();
		} else {
			repo.deleteById(id);
		}
		return ResponseEntity.ok().build();
	}

}
