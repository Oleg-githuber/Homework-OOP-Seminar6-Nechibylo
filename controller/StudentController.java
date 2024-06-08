package controller;

import model.Student;
import model.StudentGroup;
import view.StudentView;
import view.UserView;

public class StudentController implements UserController<Student> {
    private StudentGroup students;
    private UserView studentView = new StudentView();
    private int id;

    public StudentController(int groupID) {
        students = new StudentGroup(groupID);
        this.id = groupID;
    }

    public StudentGroup getStudents() {
        return this.students;
    }

    @Override
    public void create(String firstName, String secondName, String lastName) {
        Student student;
        if (this.students.getStudentList().isEmpty()) {
            student = new Student(0, firstName, secondName, lastName);
        } else {
            student = new Student(this.students.getStudentList().get(this.students.getStudentList().size() - 1).getStudentId() + 1,
                    firstName, secondName, lastName);
        }
        this.students.addStudent(student);
    }

    public void printStudentList() {
        System.out.printf("Группа №%d:\n", this.id);
        studentView.sendOnConsole(this.students.getStudentList());
    }
}
