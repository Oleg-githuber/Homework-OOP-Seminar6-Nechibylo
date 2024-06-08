package model;

public class Student extends User implements Comparable<Student>{
    private int studentId;


    // Конструктор
    public Student(int studentId, String firstName, String secondName, String lastName) {
        super(firstName, secondName, lastName);
        this.studentId = studentId;
    }

    // Геттеры
    public int getStudentId() {
        return studentId;
    }



    @Override   // Сравдение студентов по ID
    public int compareTo(Student o) {
        if(this.studentId > o.getStudentId()) return 1;
        if(this.studentId < o.getStudentId()) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Студент № %d: {%s}",
                studentId, super.toString());
    }
}
