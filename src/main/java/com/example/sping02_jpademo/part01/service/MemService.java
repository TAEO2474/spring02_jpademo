package com.example.sping02_jpademo.part01.service;

import java.util.List;

import com.example.sping02_jpademo.part01.dto.MemDTO;

public interface MemService {
    public List<MemDTO> getByJPQL(String name); //단순 조회
    public List<MemDTO> getByCriteria(String name);//동적 조건 조립
    public List<MemDTO> getByQueryDSL(String name);//동적 조건 조립 + 타입 안전 + 가독성
    public List<MemDTO> getByNative(String name);//복잡한 SQL or 성능 중요
    public List<MemDTO> getMemByNum(int name);//getMemByNameAndAge
    public List<MemDTO> getMemByNameAndAge(String name, int age);
    public List<MemDTO> getMemByAgeIsNotNull();
    //public int insertMemByNative(String name, int age, String loc);
    public int insertMemByNative(MemDTO memdto);
    public int updateMem(MemDTO memdto);
    public int delateMem(int num);
    
}
