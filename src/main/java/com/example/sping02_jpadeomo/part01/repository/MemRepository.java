package com.example.sping02_jpadeomo.part01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.sping02_jpadeomo.part01.dto.MemDTO;
import com.example.sping02_jpadeomo.part01.entity.MemEntity;

@Repository
public interface MemRepository extends JpaRepository<MemEntity,Integer>,MemRepositoryCustom {
	
	//JPQL
	@Query(value="Select m From MemEntity m WHERE m.name = :name")
	List<MemEntity> findByNameJPQL(@Param("name")String name);
	
	//Native Query
	@Query(value="SELECT * FROM mem WHERE name = :name", nativeQuery=true)
	List<MemEntity> findByNameNative (@Param("name") String name);
	
	//Named Query
	@Query(name="MemEntity.findExpensive")
	List<MemEntity> callNameQuery (@Param("name") String name);
	
	// 쿼리 메소드: find + Entity(생략가능) + By + 변수////////////////////////////
	// WHERE num >=?1
	List<MemEntity>findMemEntityByNumGreaterThanEqual(int num);
	
	//WHERE name='홍길동' and age=10
	List<MemEntity>findMemEntityByNameAndAge(String name, int age);
	
	//WHERE age IS NULL
	List<MemEntity>findMemEntityByAgeIsNotNull();
	
	// Native Query : Insert, Update, Delate
	@Modifying
	@Transactional
//	@Query(value = "INSERT INTO mem(num,name, age, loc) VALUES(mem_num_seq.nextval,:name, :age, :loc)", nativeQuery = true)
//	int insertMemByNative(@Param("name") String name, @Param("age") Integer age, @Param("loc")String loc);
	
	@Query(value = "INSERT INTO mem(num,name, age, loc) VALUES(mem_num_seq.nextval,:#{#memDTO.name}, :#{#memDTO.age}, :#{#memDTO.loc})", nativeQuery = true)
	int insertMemByNative(@Param("memDTO") MemDTO memDTO); 
	//JPQL : Update, Delete
	//중요:  jPQL에서 Insert를 제공안함.
}
