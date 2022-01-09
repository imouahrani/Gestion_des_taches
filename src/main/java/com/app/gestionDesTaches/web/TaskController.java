package com.app.gestionDesTaches.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.gestionDesTaches.constantes.RoleConstante;
import com.app.gestionDesTaches.constantes.StateConstante;
import com.app.gestionDesTaches.model.Task;
import com.app.gestionDesTaches.model.User;
import com.app.gestionDesTaches.model.UserTask;
import com.app.gestionDesTaches.service.StateService;
import com.app.gestionDesTaches.service.TaskService;
import com.app.gestionDesTaches.service.UserService;
import com.app.gestionDesTaches.service.UserTaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private StateService stateService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserTaskService userTaskService;

	@GetMapping("list-tasks")
	public String listTasks(Model model, HttpServletRequest request) {
		User connectedUser = (User) request.getSession().getAttribute("userDB");

		if (connectedUser.getRole().getCode().equals(RoleConstante.ROLE_ADMIN)) {
			model.addAttribute("tasks", taskService.findAll());
		} else {
			List<Task> userTask = new ArrayList<Task>();

			for (UserTask utask : userTaskService.findByUserEmail(connectedUser.getEmail())) {
				userTask.add(utask.getTask());
			}
			model.addAttribute("tasks", userTask);
		}

		return "views/list-tasks";
	}

	@GetMapping("add-task")
	public String addTask(Model model) {
		model.addAttribute("task", new Task());
		model.addAttribute("states", stateService.findAll());
		return "views/add-task";
	}

	@PostMapping("add-task")
	public String addTaskPost(Model model, Task task) {
		if (task.getId() != null) {
//			UserTask ut = new UserTask();
//			ut.setTask(taskService.findOne(id).get());
//			model.addAttribute("userTask", ut);
//			model.addAttribute("users", userService.findAll());
//			userTask.setAssignementDate(new Date());
//			userTaskService.save(userTask);
//			return "redirect:/list-tasks";
		}

		taskService.save(task);
		return "redirect:/list-tasks";
	}

	@GetMapping("delete-task")
	public String deleteTask(@RequestParam("idTask") Long id) {
		taskService.delete(id);
		return "redirect:/list-tasks";
	}

	@GetMapping("detail-task")
	public String detailTask(@RequestParam("idTask") Long id, Model model) {
		model.addAttribute("taskDB", taskService.findOne(id).get());

		UserTask userTask = new UserTask();
		userTask.setTask(taskService.findOne(id).get());
		model.addAttribute("userTask", userTask);
		model.addAttribute("users", userService.findAll());
		return "views/detail-task";
	}

	@PostMapping("affect")
	public String affect(UserTask userTask) {

		userTask.setAssignementDate(new Date());
		userTaskService.save(userTask);
		return "redirect:/list-tasks";
	}

	@GetMapping("toDo")
	public String toDoTask(@RequestParam("idTask") Long id, Model model) {
		Task task = taskService.findOne(id).get();
		task.setState(stateService.findByCode(StateConstante.TODO));
		taskService.save(task);
		return "redirect:/home";
	}

	@GetMapping("done")
	public String doneTask(@RequestParam("idTask") Long id, Model model) {
		Task task = taskService.findOne(id).get();
		task.setState(stateService.findByCode(StateConstante.DONE));
		taskService.save(task);
		return "redirect:/home";
	}

	@GetMapping("edit-task")
	public String editTask(@RequestParam("idTask") Long id, Model model, Task task) {
		model.addAttribute("task", taskService.findOne(id).get());
		model.addAttribute("states", stateService.findAll());

		return "views/add-task";
	}
}
