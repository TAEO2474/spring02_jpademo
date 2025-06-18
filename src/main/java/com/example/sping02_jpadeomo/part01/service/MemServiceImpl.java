package com.example.sping02_jpadeomo.part01.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sping02_jpadeomo.part01.dto.MemDTO;
import com.example.sping02_jpadeomo.part01.entity.MemEntity;
import com.example.sping02_jpadeomo.part01.repository.MemRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemServiceImpl implements MemService {
	@Autowired
	private MemRepository memRepository;

	// 기본생성자
	public MemServiceImpl() {

	}

	@Override
	public List<MemDTO> getByJPQL(String name) {
		List<MemEntity> listMemEntity = memRepository.findByNameJPQL(name);
		List<MemDTO> listMemDTO = listMemEntity.stream().map(MemDTO::toDTO).collect(Collectors.toList());
		log.info("getByJPQL=>{}", listMemDTO);

		return listMemDTO;
	}

	@Override
	public List<MemDTO> getByCriteria(String name) {
		List<MemEntity> listMemEntity = memRepository.findByDynamicName(name);
		List<MemDTO> listMemDTO = listMemEntity.stream().map(MemDTO::toDTO).collect(Collectors.toList());
		log.info("findByDynamicName=>{}", listMemDTO);

		return listMemDTO;
	}

	@Override
	public List<MemDTO> getByQueryDSL(String name) {
		List<MemEntity> listMemEntity = memRepository.callNameQuery(name);
		List<MemDTO> listMemDTO = listMemEntity.stream().map(MemDTO::toDTO).collect(Collectors.toList());
		log.info("ccallNameQuery=>{}", listMemDTO);

		return listMemDTO;
	}

	@Override
	public List<MemDTO> getByNative(String name) {
		List<MemEntity> listMemEntity = memRepository.findByNameNative(name);
		List<MemDTO> listMemDTO = listMemEntity.stream().map(MemDTO::toDTO).collect(Collectors.toList());
		log.info("findByNameNative=>{}", listMemDTO);

		return listMemDTO;

	}

	@Override 
	public List<MemDTO> getMemByNum(int num) {
		List<MemEntity> listMemEntity = memRepository.findMemEntityByNumGreaterThanEqual(num);
		List<MemDTO> listMemDTO = listMemEntity.stream().map(MemDTO::toDTO).collect(Collectors.toList());
		log.info("findMemEntityByNumGreaterThanEqual=>{}", listMemDTO);

		return listMemDTO;
	}
	

	@Override
	public List<MemDTO> getMemByNameAndAge(String name, int age) {
	
		
		List<MemEntity> listMemEntity = memRepository.findMemEntityByNameAndAge(name,age);
		List<MemDTO> listMemDTO = listMemEntity.stream().map(MemDTO::toDTO).collect(Collectors.toList());
		log.info("findMemEntityByNameAndAge=>{}", listMemDTO);

		return listMemDTO;
	}
	
	@Override
	public List<MemDTO> getMemByAgeIsNotNull() {
		List<MemEntity> listMemEntity = memRepository.findMemEntityByAgeIsNotNull();
		List<MemDTO> listMemDTO = listMemEntity.stream().map(MemDTO::toDTO).collect(Collectors.toList());
		log.info("findMemEntityByAgeIsNotNull=>{}", listMemDTO);

		return listMemDTO;
	}
	
//	@Override
//	public int insertMemByNative(String name, int age, String loc) {
//		int cnt = memRepository.insertMemByNative(name, age, loc);
//		return cnt;
//	}
	
	@Override
	public int insertMemByNative(MemDTO memdto) {
		int cnt = memRepository.insertMemByNative(memdto);
		return cnt;
	}

}

