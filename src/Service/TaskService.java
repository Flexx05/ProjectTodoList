package Service;

import java.util.ArrayList;
import java.util.List;

import Model.Task;

public class TaskService {
	private ArrayList<Task> taskArr = new ArrayList<>();
	private FileService fileService = new FileService();
	private int id = 1;

	public TaskService() {
	}

	public void addTask(Task task) {
		task.setId(id++);
		this.taskArr.add(task);
		fileService.WriteTask(taskArr);
		System.out.println("Thêm thành công");
	}

	public void removeTask(int id) {
		taskArr.removeIf(task -> task.getId() == id);
		fileService.WriteTask(taskArr);
		System.out.println("Xóa thành công");
	}

	public void markCompleted(int id) {
		for (Task task : taskArr) {
			if (task.getId() == id) {
				task.setCompleted(true);
			}
		}
		fileService.WriteTask(taskArr);
		System.out.println("Đánh dấu thành công");
	}

	public List<Task> getAllTask() {
		return fileService.ReadTask();
	}

}
