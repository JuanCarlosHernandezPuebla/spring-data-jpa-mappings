package com.jpa_mappings.course.dao;

import com.jpa_mappings.course.entity.Instructor;
import com.jpa_mappings.course.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
