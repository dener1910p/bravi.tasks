package com.example.bravi.tasks.reporitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bravi.tasks.model.Tasks;

public interface TaskRepository extends JpaRepository<Tasks, String> {

	List<Tasks> findByTask(String taskTitle);

	void deleteByTask(String taskTitle);

	//Tasks save(String taskTitle, String comments, Date dtCreation, Date dtExecution, String status);
	
}
