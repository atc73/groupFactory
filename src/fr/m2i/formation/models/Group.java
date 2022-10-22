package fr.m2i.formation.models;

import java.util.ArrayList;

public class Group {
    private ArrayList<Student> studentsInGroup = new ArrayList<>();
    private int groupSize;
    private int remainingSpots;
    private int groupId;

    public Group(int groupSize, int remainingSpots, int groupId) {
        this.groupSize = groupSize;
        this.remainingSpots = remainingSpots;
        this.groupId = groupId;
    }

    public ArrayList<Student> getStudentsInGroup() {
        return studentsInGroup;
    }

    public void setStudentsInGroup(ArrayList<Student> studentsInGroup) {
        this.studentsInGroup = studentsInGroup;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public int getRemainingSpots() {
        return remainingSpots;
    }

    public void setRemainingSpots(int remainingSpots) {
        this.remainingSpots = remainingSpots;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void minusOneRemainingSpot() {
        this.remainingSpots--;
    }

    public void showList() {
        System.out.println(studentsInGroup.toString());
    }
}
