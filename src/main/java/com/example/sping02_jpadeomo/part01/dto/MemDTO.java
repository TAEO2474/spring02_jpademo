package com.example.sping02_jpadeomo.part01.dto;

import com.example.sping02_jpadeomo.part01.entity.MemEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemDTO {
	private int num;
	private String name;
	private int age;
	private String loc;


	
		//MemDTO => MemEntity 변경을 위한 코드
		public MemEntity toEntity() {
			return MemEntity.builder()
					.num(num)
					.name(name)
					.age(age)
					.loc(loc)
					.build();
		}//end  toEntity()


		
		//MemEntity => MemDTO 변경을 위한 코드 
		public static MemDTO toDTO(MemEntity memEntity) {
			return MemDTO.builder()
					.num(memEntity.getNum())
					.name(memEntity.getName())
					.age(memEntity.getAge())
					.loc(memEntity.getLoc())
					.build();
		}
}//END class





