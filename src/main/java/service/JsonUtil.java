package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Student;
import model.University;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class JsonUtil {
    private JsonUtil() {
    }

    public static String StudentSerialize(Student student) {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(student);
    }

    public static String UniversitySerialize(University university) {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(university);
    }

    public static Student StudentDeserialize(String student) {
        return new Gson()
                .fromJson(student, Student.class);
    }

    public static University UniversityDeserialize(String university) {
        return new Gson()
                .fromJson(university, University.class);
    }

    public static String StudentListSerialize(List<Student> student) {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(student);
    }

    public static String UniversityListSerialize(List<University> university) {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(university);
    }

    public static List<Student> StudentListDeserialize(String student) {
        return new Gson().fromJson(student, new TypeToken<Collection<Student>>() {
        }.getType());
    }

    public static List<University> UniversityListDeserialize(String university) {
        return new Gson().fromJson(university, new TypeToken<Collection<University>>() {
        }.getType());
    }
}
