package service;

import comparator.UserComparator;
import model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherService implements UserService<Teacher> {
    private List<Teacher> teacherList;

    public TeacherService(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Teacher> getTeacherList() {
        return this.teacherList;
    }

    //@Override
    public List<Teacher> getSortedTeacherList() {
        List<Teacher> sortingList = new ArrayList<>(this.teacherList);
        sortingList.sort(new UserComparator());
        return sortingList;
    }
}
