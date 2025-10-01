package Test;

import java.awt.EventQueue;

import View.TodoListView;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new TodoListView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
