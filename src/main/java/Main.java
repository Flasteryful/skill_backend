
import model.Student;
import model.University;
import service.Reader;

public class Main {
    public static void main(String[] args) {

        for (Student student : Reader.readStudent()) {
            System.out.println(student);
        }
        for (University university : Reader.readUniversity()) {
            System.out.println(university);
        }

    }
}
