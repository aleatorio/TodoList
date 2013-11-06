package controllers;

import models.Task;
import models.services.TaskService;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

	private static Form<Task> taskForm = Form.form(Task.class);

	public static Result index() {
		return ok(views.html.index.render(TaskService.getInstance().all(), taskForm));
	}

	public static Result tasks() {
		return ok(views.html.index.render(TaskService.getInstance().all(), taskForm));
	}

	public static Result newTask() {
		Form<Task> filledForm = taskForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.index.render(TaskService.getInstance().all(), filledForm));
		} else {
			TaskService.getInstance().create(filledForm.get());
			return redirect(routes.Application.tasks());
		}
	}

	public static Result deleteTask(Integer hash) {
		TaskService.getInstance().remove(hash);
		return redirect(routes.Application.tasks());
	}

}
