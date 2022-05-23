package JournalOfAssessments;

import java.util.ArrayList;

public class JournalMain {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<Student> studentsIT94 = it94();
        ArrayList<Student> studentsIT92 = it92();
        ArrayList<Student> studentsIT91 = it91();

        Group group1 = new Group("IT-94", studentsIT94);
        Group group2 = new Group("IT-92", studentsIT92);
        Group group3 = new Group("IT-91", studentsIT91);

        ArrayList<Group> groups = new ArrayList<>();
        groups.add(group1);
        groups.add(group2);
        groups.add(group3);

        Journal journal = new Journal(groups);

        Thread lecturer = new Thread(new JournalThread(journal, "Lecturer1"));
        Thread as1 = new Thread(new JournalThread(journal, "Assistant1", 0));
        Thread as2 = new Thread(new JournalThread(journal, "Assistant2", 1));
        Thread as3 = new Thread(new JournalThread(journal, "Assistant3", 2));

        lecturer.start();
        as1.start();
        as2.start();
        as3.start();
    }

    public static ArrayList<Student> it94(){
        ArrayList<Student> it94 = new ArrayList<>();
        String[] names = new String[]{"Santo", "Tripak", "Bilenka"};
        for (int i=0; i<names.length; i++){
            Student student= new Student(names[i]);
            it94.add(student);
        }
        return it94;
    }

    public static ArrayList<Student> it92(){
        ArrayList<Student> it92 = new ArrayList<>();
        String[] names = new String[]{"Osovuk", "Kirichishen", "Lishchishin"};
        for (int i=0; i<names.length; i++){
            Student student= new Student(names[i]);
            it92.add(student);
        }
        return it92;
    }

    public static ArrayList<Student> it91(){
        ArrayList<Student> it91 = new ArrayList<>();
        String[] names = new String[]{"Kovaleva", "Tkach", "Mayova"};
        for (int i=0; i<names.length; i++){
            Student student= new Student(names[i]);
            it91.add(student);
        }
        return it91;
    }
}
