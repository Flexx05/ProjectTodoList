package Model;

import java.util.ArrayList;

public class ManageTodoList {
	private ArrayList<TodoList> listTodo;
	private String choose;

	public ManageTodoList() {
		this.listTodo = new ArrayList<>();
		this.choose = "";

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
		this.listTodo.remove(todo);
		this.listTodo.add(todo);
	}
}
