package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.ManageTodoList;
import View.TodoListView;

public class TodoListController implements ActionListener {
	private TodoListView view;
	private ManageTodoList model;

	public TodoListController(TodoListView view) {
		this.model = new ManageTodoList();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Lưu")) {
			this.view.CreateTodo();
		} else if (cmd.equals("Reset") || cmd.equals("Thêm mới")) {
			this.view.resetForm();
			if (cmd.equals("Thêm mới")) {
				this.model.setChoose(cmd);
			}
		} else if (cmd.equals("Chỉnh sửa")) {
			this.view.GetTodoById();
		} else if (cmd.equals("Xóa bỏ")) {
			this.view.DeleteTodo();
		} else if (cmd.equals("Hoàn thành")) {
			this.view.MarkTodoComplete();
		} else if (cmd.equals("Tìm")) {
			this.view.SearchTodo();
		} else if (cmd.equals("Hủy")) {
			this.view.ResetSearchValue(true);
		} else if (cmd.equals("Open")) {
			this.view.HandleOpenFile();
		} else if (cmd.equals("Save")) {
			this.view.HandleSaveFile();
		} else if (cmd.equals("Exit")) {
			this.view.ExitProgram();
		} else if (cmd.equals("About me")) {
			this.view.ShowAboutMe();
		}
	}

}
