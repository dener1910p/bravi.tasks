package com.example.bravi.tasks.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bravi.tasks.exception.*;
import com.example.bravi.tasks.exception.NotFoundException;
import com.example.bravi.tasks.exception.SucceededWarning;
import com.example.bravi.tasks.model.Tasks;
import com.example.bravi.tasks.reporitory.TaskRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TasksController {

	@Autowired
	TaskRepository taskRepository;
	String message;
	List<Tasks> taskList;

	// Read all tasks
	@GetMapping("/tasks")
	public List<Tasks> getAllTasks() {
		return this.taskRepository.findAll();
	}

	// Read the tasks by name
	@GetMapping("/taskByTask")
	public ResponseEntity<List<Tasks>> getAllTasks(@RequestParam("task") String taskTitle) {
		try {
			taskList = new ArrayList<Tasks>();
			taskRepository.findByTask(taskTitle).forEach(taskList::add);
			if (taskList.isEmpty()) {
				message = "The task could not be found with title: " + taskTitle;
			}
			return new ResponseEntity<>(taskList, HttpStatus.OK);
		} catch (Exception e) {
			throw new GenericError("Something went wrong and was not possible to find the task! " + message);
		}
	}

	// Create new task
	@PostMapping("/task")
	public void createTask(@RequestBody Tasks tasks) {
		taskList = new ArrayList<Tasks>();
		taskRepository.findByTask(tasks.getTask()).forEach(taskList::add);
		try {
			if (!tasks.getTask().isEmpty() || !tasks.getTask().isBlank()) {
				Tasks Tasknew = taskRepository.save(new Tasks(tasks.getTask(), tasks.getComments(),
						tasks.getDtcreation(), tasks.getDtexecution(), tasks.getStatus()));

				message = "The following task was successfully created!" + tasks.getTask();
			} else {
				message = "The task title can not be blank or empty!";
			}
		} catch (Exception e) {
			message = "Something went wrong and was not possible to insert the task! " + tasks.getTask();
		}

	}

	// Update tasks
	@PutMapping("/taskUpdate")
	public void updateTask(@RequestParam("task") String taskTitle, @RequestBody Tasks taskUpdate) {
		List<Tasks> task = taskRepository.findByTask(taskTitle);

		try {
			if (task.isEmpty()) {
				message = "Task not found!";
			} else if (taskUpdate.getStatus().equals("close")) {
				message = "This task is already finalized!";
			} else {
				Tasks t = new Tasks();
				t.setTask(taskTitle);
				t.setComments(taskUpdate.getComments());
				t.setDtexecution(taskUpdate.getDtexecution());
				t.setDtfinalization(taskUpdate.getDtfinalization());
				t.setStatus(taskUpdate.getStatus());
				t.setSpendedtime(taskUpdate.getSpendedtime());
				message = "The following task was successfully updated!" + taskTitle;
			}
		} catch (Exception e) {
			message = "Was not possible to update this task!";
		}

	}

	// Delete by Title
	@Transactional
	@DeleteMapping("/task")
	public void deleteTask(@RequestParam("task") String taskTitle) {
		try {

			taskRepository.deleteByTask(taskTitle);
			message = "The following task was successfully deleted!";
		} catch (Exception e) {
			message = "Something went wrong and was not possible to delete the task!";
		}
	}
}
