package org.gfg.JBDL11_SpringJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findByName(String name);

    Student findByEmail(String email);

    Student findByNameAndEmail(String name, String email);

    Student findByNameOrEmail(String name, String email);


    @Query("from student s where s.name=:name and s.email=:email")
    Student findByNameAndEmailJPQL(String name, String email);


    @Query("update student s set s.name=:name where s.email=:email")
    @Modifying
    @Transactional
    int updateStudentNameByEmail(String name, String email);


    @Query("delete student s where s.email=:email")
    @Modifying
    @Transactional
    int deleteByEmail(String email);


    @Query(value = "update student set name=:name where email=:email", nativeQuery = true)
    @Modifying
    @Transactional
    int updateStudentNameByEmailNative(String name, String email);


}
