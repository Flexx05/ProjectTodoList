package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String title, description;
	private LocalDate dueDate;
	private boolean completed;

	public Task(String title, String description, LocalDate dueDate, boolean completed) {
		LocalDate today = LocalDate.now();
		this.title = title;
		this.description = description;
		if (today.isAfter(dueDate)) {
			System.err.println("Ngày hết hạn phải trong tương lai");
		} else {
			this.dueDate = dueDate;
		}
		this.completed = completed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		LocalDate today = LocalDate.now();

		if (today.isAfter(dueDate)) {
			System.err.println("Ngày hết hạn phải trong tương lai");
		} else {
			this.dueDate = dueDate;
		}
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", dueDate=" + dueDate
				+ ", completed=" + completed + "]";
	}

}
