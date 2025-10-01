package Model;

import java.util.ArrayList;

public class ManageTodoList {
	private ArrayList<TodoList> listTodo;
	private String choose;
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ManageTodoList() {
		this.listTodo = new ArrayList<>();
		this.choose = "";
		this.fileName = "";

	}

	public ArrayList<TodoList> getListTodo() {
		return listTodo;
	}

	public void setListTodo(ArrayList<TodoList> listTodo) {
		this.listTodo = listTodo;
	}

	public String getChoose() {
		return choose;
	}

	public void setChoose(String choose) {
		this.choose = choose;
	}

	public void CreateTodo(TodoList todo) {
		this.listTodo.add(todo);
	}

	public void RemoveTodo(TodoList todo) {
		this.listTodo.remove(todo);
	}

	public void UpdateTodo(TodoList todo) {
		for (int i = 0; i < this.listTodo.size(); i++) {
			if (listTodo.get(i).getId() == todo.getId()) {
				listTodo.set(i, todo);
				return;
			}
		}
		this.CreateTodo(todo);
	}

	public boolean checkId(int id) {
		for (TodoList todoList : listTodo) {
			if (todoList.getId() == id) {
				return true;
			}
		}
		return false;
	}
}
