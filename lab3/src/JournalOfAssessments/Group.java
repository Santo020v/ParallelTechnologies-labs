package JournalOfAssessments;

import java.util.ArrayList;

public class Group {

    private String nameOfGroup;
    private ArrayList<Student> students;

    public Group(String nameOfGroup, ArrayList<Student> students){
        this.nameOfGroup = nameOfGroup;
        this.students = students;
    }

    public String getNameOfGroup(){
        return this.nameOfGroup;
    }

    public ArrayList<Student> getStudents(){
        return this.students;
    }
}