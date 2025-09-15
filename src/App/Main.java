package App;

import java.time.LocalDate;
import java.util.Scanner;

import Model.Task;
import Service.TaskService;

public class Main {

	public static void main(String[] args) {
		int luaChon = 0;
		TaskService taskService = new TaskService();
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out.println("=========== MENU ===========\n" + "1. Thêm task\n" + "2. Hiển thị tất cả task\n"
						+ "3. Xóa task\n" + "4. Đánh dấu hoàn thành\n" + "0. Thoát\n" + "============================");
				System.out.println("Chọn chức năng: ");
				try {
					luaChon = scanner.nextInt();
					scanner.nextLine();
				} catch (Exception e) {
					System.err.println("Vui lòng nhập số");
					continue;
				}

				if (luaChon == 1) {
					System.out.println("Nhập việc cần làm: ");
					String title = scanner.nextLine();
					System.out.println("Nhập mô tả: ");
					String description = scanner.nextLine();
					System.out.println("Nhập ngày hết hạn: ");
					int day = 0;
					try {
						day = scanner.nextInt();
						if (day < 1 || day > 31) {
							System.err.println("Ngày chỉ nằm trong khoảng từ 1 đến 31");
							continue;
						}
					} catch (Exception e) {
						System.err.println("Vui lòng nhập số");
						continue;
					}
					System.out.println("Nhập tháng hết hạn: ");
					int month = 0;
					try {
						month = scanner.nextInt();
						if (month < 1 || month > 12) {
							System.err.println("Tháng chỉ nằm trong khoảng từ 1 đến 12");
							continue;
						}
					} catch (Exception e) {
						System.err.println("Vui lòng nhập số");
						continue;
					}
					System.out.println("Nhập năm hết hạn: ");
					int year = 0;
					try {
						year = scanner.nextInt();
						if (year < 1) {
							System.err.println("Năm phải bắt đầu từ 1");
						}
					} catch (Exception e) {
						System.err.println("Vui lòng nhập số");
						continue;
					}
					LocalDate dueDate = LocalDate.of(year, month, day);
					Task task = new Task(title, description, dueDate, false);
					taskService.addTask(task);
				} else if (luaChon == 2) {
					System.out.println(taskService.getAllTask());
				} else if (luaChon == 3 || luaChon == 4) {
					System.out.println("Nhập id task: ");
					int id = scanner.nextInt();
					if (luaChon == 3) {
						taskService.removeTask(id);
					} else {
						taskService.markCompleted(id);
					}
				} else if (luaChon == 0) {
					System.err.println("Đã thoát");
					return;
				} else {
					System.err.println("Không có lựa chọn phù hợp vui lòng chọn lại");
				}
			} while (luaChon != 0);
		}
	}
}
