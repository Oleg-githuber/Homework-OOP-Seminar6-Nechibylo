package model;

public class Teacher extends User implements Comparable<Teacher>{
    private int teacherID;
    public Teacher(int id, String firstName, String secondName, String lastName) {
        super(firstName, secondName, lastName);
        this.teacherID = id;
    }

    public int getTeacherID() {
        return this.teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    @Override
    public int compareTo(Teacher o) {
        if(this.teacherID > o.getTeacherID()) return 1;
        if(this.teacherID < o.getTeacherID()) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Учитель № %d: {%s}",
                this.teacherID, super.toString());
    }
}
