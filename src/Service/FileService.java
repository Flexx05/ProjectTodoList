package Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import Model.Task;

public class FileService {
	public FileService() {
	}

	private File file = new File(
			"C:\\Users\\ASUS\\Documents\\workspace-spring-tools-for-eclipse-4.31.0.RELEASE\\ProjectTodoList\\src\\Data\\Data.txt");

	public void WriteTask(List<Task> tasks) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(tasks);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Task> ReadTask() {
		if (!file.exists()) {
			return null;
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			return (List<Task>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
