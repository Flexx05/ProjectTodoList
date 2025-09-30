package View;

import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.TodoListController;
import Model.ManageTodoList;
import Model.TodoList;

public class TodoListView extends JFrame {

	private static final long serialVersionUID = 1L;
	private ManageTodoList list;
	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldSearchTitle;
	private JTextField textFieldTitle;
	private JTextField textFieldDueDate;
	private JComboBox<String> comboBoxStatus;
	private JTextArea textAreaDescription;
	private JTextField textFieldId;
	private DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	/**
	 * Create the frame.
	 */
	public TodoListView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 736);
		this.list = new ManageTodoList();

		TodoListController ac = new TodoListController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(ac);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(menuOpen);

		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(ac);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(menuSave);

		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(ac);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(menuExit);

		JMenu mnNewMenu_1 = new JMenu("About");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_1);

		JMenuItem menuAboutMe = new JMenuItem("About me");
		menuAboutMe.addActionListener(ac);
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu_1.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelTodoList = new JLabel("Todo List");
		labelTodoList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelTodoList.setBounds(259, 0, 74, 24);
		contentPane.add(labelTodoList);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 582, 230);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Ti\u00EAu \u0111\u1EC1",
				"Ghi ch\u00FA", "Ng\u00E0y h\u1EBFt h\u1EA1n", "Tr\u1EA1ng th\u00E1i" }));
		scrollPane.setViewportView(table);

		JLabel labelTitleSearch = new JLabel("Tiêu đề");
		labelTitleSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelTitleSearch.setBounds(10, 33, 60, 24);
		contentPane.add(labelTitleSearch);

		JLabel labelSearchStatus = new JLabel("Trạng thái");
		labelSearchStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelSearchStatus.setBounds(310, 33, 60, 24);
		contentPane.add(labelSearchStatus);

		comboBoxStatus = new JComboBox<String>();
		comboBoxStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBoxStatus.setBounds(380, 33, 80, 24);
		contentPane.add(comboBoxStatus);

		JButton btnSearch = new JButton("Tìm");
		btnSearch.addActionListener(ac);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearch.setBounds(466, 33, 60, 24);
		contentPane.add(btnSearch);

		JButton btnCancel = new JButton("Hủy");
		btnCancel.addActionListener(ac);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancel.setBounds(532, 33, 60, 24);
		contentPane.add(btnCancel);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 68, 582, 2);
		contentPane.add(separator_1);

		JLabel labelList = new JLabel("Danh sách");
		labelList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelList.setBounds(10, 81, 80, 24);
		contentPane.add(labelList);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 361, 582, 2);
		contentPane.add(separator_1_1);

		JLabel labelInfor = new JLabel("Thông tin");
		labelInfor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelInfor.setBounds(10, 374, 80, 24);
		contentPane.add(labelInfor);

		JLabel labelTitle = new JLabel("Tiêu đề");
		labelTitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelTitle.setBounds(169, 410, 60, 24);
		contentPane.add(labelTitle);

		textFieldSearchTitle = new JTextField();
		textFieldSearchTitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldSearchTitle.setBounds(65, 33, 235, 24);
		contentPane.add(textFieldSearchTitle);
		textFieldSearchTitle.setColumns(10);

		textFieldTitle = new JTextField();
		textFieldTitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldTitle.setColumns(10);
		textFieldTitle.setBounds(227, 410, 365, 24);
		contentPane.add(textFieldTitle);

		JLabel labelDescription = new JLabel("Mô tả");
		labelDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelDescription.setBounds(10, 447, 80, 24);
		contentPane.add(labelDescription);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(94, 445, 498, 115);
		contentPane.add(scrollPane_1);

		textAreaDescription = new JTextArea();
		scrollPane_1.setViewportView(textAreaDescription);

		JLabel labelDueDate = new JLabel("Ngày hết hạn");
		labelDueDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelDueDate.setBounds(10, 575, 80, 24);
		contentPane.add(labelDueDate);

		textFieldDueDate = new JTextField();
		textFieldDueDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldDueDate.setColumns(10);
		textFieldDueDate.setBounds(94, 575, 342, 24);
		contentPane.add(textFieldDueDate);

		JPanel panel = new JPanel();
		panel.setBounds(10, 623, 582, 33);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 50, 0));

		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.addActionListener(ac);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnAdd);

		JButton btnEdit = new JButton("Chỉnh sửa");
		btnEdit.addActionListener(ac);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnEdit);

		JButton btnDelete = new JButton("Xóa bỏ");
		btnDelete.addActionListener(ac);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnDelete);

		JButton btnComplete = new JButton("Hoàn thành");
		btnComplete.addActionListener(ac);
		btnComplete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnComplete);

		JButton btnSave = new JButton("Lưu");
		btnSave.addActionListener(ac);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSave.setBounds(446, 575, 60, 24);
		contentPane.add(btnSave);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(ac);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReset.setBounds(516, 575, 76, 24);
		contentPane.add(btnReset);

		JLabel labelId = new JLabel("Id");
		labelId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelId.setBounds(10, 410, 60, 24);
		contentPane.add(labelId);

		textFieldId = new JTextField();
		textFieldId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldId.setColumns(10);
		textFieldId.setBounds(94, 410, 60, 24);
		contentPane.add(textFieldId);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 610, 582, 2);
		contentPane.add(separator_1_1_1);

		this.setTitle("Todo List");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void resetForm() {
		this.textFieldId.setText("");
		this.textFieldTitle.setText("");
		this.textAreaDescription.setText("");
		this.textFieldDueDate.setText("");
	}

	public void ExitProgram() {
		int choose = JOptionPane.showConfirmDialog(this, "Thoát chương trình", "", JOptionPane.YES_NO_OPTION);
		if (choose == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void ShowAboutMe() {
		JOptionPane.showMessageDialog(this, "Chương trình quản lý nhiệm vụ v2.0\nĐược tạo bởi Mạnh Linh");
	}

	public void CreateTodo() {
		int id = Integer.valueOf(this.textFieldId.getText());
		String title = this.textFieldTitle.getText();
		String decription = this.textAreaDescription.getText();
		LocalDate dueDate = LocalDate.parse(this.textFieldDueDate.getText(), formatDate);

		TodoList todo = new TodoList(id, title, decription, dueDate, false);

		this.AddOrEditTodo(todo);
	}

	private void AddOrEditTodo(TodoList todo) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if (!this.list.checkId(todo.getId())) {
			this.list.CreateTodo(todo);
			this.AddOneTodo(todo);
		} else {
			this.list.UpdateTodo(todo);
			int rowCount = model.getRowCount();
			for (int i = 0; i < rowCount; i++) {
				int id = Integer.valueOf(model.getValueAt(i, 0) + "");
				if (id == todo.getId()) {
					model.setValueAt(todo.getId(), i, 0);
					model.setValueAt(todo.getTitle(), i, 1);
					model.setValueAt(todo.getDescription(), i, 2);
					model.setValueAt(todo.getDueDate().format(formatDate), i, 3);
					model.setValueAt(todo.isCompleted() ? "Đã hoàn thành" : "Chưa hoàn thành", i, 4);
				}
			}
		}
		this.resetForm();
	}

	private void AddOneTodo(TodoList todo) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] { todo.getId(), todo.getTitle(), todo.getDescription(),
				todo.getDueDate().format(formatDate), todo.isCompleted() ? "Đã hoàn thành" : "Chưa hoàn thành" });
	}

	private TodoList ShowTodoSelected() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int rowSelected = table.getSelectedRow();
		int id = Integer.valueOf(model.getValueAt(rowSelected, 0) + "");
		String title = model.getValueAt(rowSelected, 1) + "";
		String description = model.getValueAt(rowSelected, 2) + "";
		LocalDate dueDate = LocalDate.parse(model.getValueAt(rowSelected, 3) + "", formatDate);
		boolean completed = model.getValueAt(rowSelected, 4).equals("Đã hoàn thành");

		TodoList todo = new TodoList(id, title, description, dueDate, completed);
		return todo;
	}

	public void GetTodoById() {
		TodoList todo = ShowTodoSelected();
		this.textFieldId.setText(todo.getId() + "");
		this.textFieldTitle.setText(todo.getTitle());
		this.textAreaDescription.setText(todo.getDescription());
		this.textFieldDueDate.setText(todo.getDueDate().format(formatDate));

	}

	public void MarkTodoComplete() {
		TodoList todo = ShowTodoSelected();
		if (todo.isCompleted()) {
			JOptionPane.showMessageDialog(this, "Công việc này bạn đã hoàn thành");
		} else {
			this.GetTodoById();

			int choose = JOptionPane.showConfirmDialog(this, "Đánh dấu công việc này đã hoàn thành?", "",
					JOptionPane.YES_NO_OPTION);
			if (choose == JOptionPane.YES_OPTION) {
				todo.setCompleted(true);
				this.AddOrEditTodo(todo);
			} else {
				this.resetForm();
			}
		}
	}

	public void DeleteTodo() {
		TodoList todo = ShowTodoSelected();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int rowSelected = table.getSelectedRow();
		int choose = JOptionPane.showConfirmDialog(this, "Xóa công việc này khỏi danh sách?", "",
				JOptionPane.YES_NO_OPTION);
		if (choose == JOptionPane.YES_OPTION) {
			this.list.RemoveTodo(todo);
			model.removeRow(rowSelected);
		}
	}

}
