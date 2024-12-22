package com.jpa_mappings.course.dao;

import com.jpa_mappings.course.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}
