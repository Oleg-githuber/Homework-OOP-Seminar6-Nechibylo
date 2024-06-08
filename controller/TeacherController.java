package controller;

import model.Teacher;
import service.TeacherService;
import view.TeacherView;
import view.UserView;

import java.util.ArrayList;
import java.util.List;

public class TeacherController implements UserController<Teacher> {
    private List<Teacher> teacherList = new ArrayList<>();
    private UserView teacherView = new TeacherView();

    // Конструктор
    public TeacherController(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    // Геттер
    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    // Добавление учителя в список
    @Override
    public void create(String firstName, String secondName, String lastName) {
        Teacher teacher = null;
        if (this.teacherList.isEmpty()) {
            this.teacherList.add(new Teacher(0, firstName, secondName, lastName));
        } else {
            teacher = new Teacher(this.teacherList.get(this.teacherList.size() - 1).getTeacherID() + 1,
                    firstName, secondName, lastName);
            this.teacherList.add(teacher);
        }

    }

    // Вывод списка учителей в консоль
    public void printStudentList() {
        System.out.println("Список учителей:");
        teacherView.sendOnConsole(this.teacherList);
    }

    // Редактирование списка учителей
    public void editTeacher(int id, String firstName, String secondName, String lastName) {
        this.teacherList.get(id).setFirstName(firstName);
        this.teacherList.get(id).setSecondName(secondName);
        this.teacherList.get(id).setLastName(lastName);
    }

    // Сортировка по ФИО
    public List<Teacher> sortTeacherList() {
        TeacherService teacherService = new TeacherService(teacherList);
        return teacherService.getSortedTeacherList();
    }

    // Перегруженый метод для вывода, например, отсортированного списка
    public void printStudentList(List<Teacher> sortTeacherList) {
        System.out.println("Список учителей:");
        teacherView.sendOnConsole(sortTeacherList);
    }
}
