package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class TodoList implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String title, description;
	private LocalDate dueDate;
	private boolean completed;

	public TodoList(int id, String title, String description, LocalDate dueDate, boolean completed) {
		LocalDate today = LocalDate.now();
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(completed, description, dueDate, id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TodoList other = (TodoList) obj;
		return completed == other.completed && Objects.equals(description, other.description)
				&& Objects.equals(dueDate, other.dueDate) && id == other.id && Objects.equals(title, other.title);
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
