package com.example.sping02_jpadeomo.part01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sping02_jpadeomo.part01.dto.MemDTO;
import com.example.sping02_jpadeomo.part01.service.MemService;

@RestController
public class MemController {
	@Autowired
	private MemService memService;
///////////////////////////////////////////////////////////////////////////////////////////////////////	
	//기본생성자
	public MemController () {
		
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////	
	//http://localhost:8090/mem/홍길동 (포스트맨)
	//http://localhost:8090/mem/%ED%99%8D%EA%B8%B8%EB%8F%99 (유니코드로 변경된 주소)
	@GetMapping(value ="/mem/{name}")
	public ResponseEntity<List<MemDTO>> getListName(@PathVariable("name") String name){

		// return ResponseEntity.ok().body(memService.getByJPQL(name)); 
		//return ResponseEntity.ok().body(memService.getByCriteria(name));
		//return ResponseEntity.ok().body(memService.getByNative(name));
		return ResponseEntity.ok().body(memService.getByQueryDSL(name));
		
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////	
	@GetMapping(value ="/mem/num/{num}")
	public ResponseEntity<List<MemDTO>> getListNum(@PathVariable("num") int num){
		return ResponseEntity.ok().body(memService.getMemByNum(num));
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	// http://localhost:8090/mem/namenum/홍길동/10
		@GetMapping(value="/mem/namenum/{name}/{age}")
		ResponseEntity<List<MemDTO>> getListNameAge(@PathVariable("name") String name,@PathVariable("age")  int age){
			return ResponseEntity.ok().body(memService.getMemByNameAndAge(name,age));
		}	

///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// http://localhost:8090/mem/age
	@GetMapping(value ="/mem/age")
	public ResponseEntity<List<MemDTO>> getListAge(){
		return ResponseEntity.ok().body(memService.getMemByAgeIsNotNull());
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////	
	//{"name": "하정우", "age": 45, "loc": "충남"}
	// http://localhost:8090/mem
	@PostMapping(value="/mem")
	public ResponseEntity<Integer> insertMemByNative(@RequestBody MemDTO mem){
		//return ResponseEntity.ok().body(memService.insertMemByNative(mem.getName(),mem.getAge(),mem.getLoc()));
		return ResponseEntity.ok().body(memService.insertMemByNative(mem));
	}
	
}//end class
