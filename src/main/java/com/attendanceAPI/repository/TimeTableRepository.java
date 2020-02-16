package com.attendanceAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.attendanceAPI.models.TimeTable;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {

	


}
