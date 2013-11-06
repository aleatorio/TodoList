package models.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Task;

public class TaskService {

	private static TaskService instance;
	private Map<Integer, Task> allTasks;

	private TaskService() {
		allTasks = new HashMap<Integer, Task>();
	}

	public static TaskService getInstance() {
		if (instance == null) {
			instance = new TaskService();
		}
		return instance;
	}

	public List<Task> all() {
		return new ArrayList<Task>(allTasks.values());
	}

	public void create(Task newTask) {
		allTasks.put(newTask.hashCode(), newTask);
	}

	public void remove(Integer hash) {
		allTasks.remove(hash);
	}
}
