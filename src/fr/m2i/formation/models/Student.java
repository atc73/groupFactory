package fr.m2i.formation.models;

public class Student {
    private String name;
    private int group;
    private int studentId;
    private boolean assginedGroup;


    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public boolean isAssginedGroup() {
        return assginedGroup;
    }

    public void setAssginedGroup(boolean assginedGroup) {
        this.assginedGroup = assginedGroup;
    }

}
