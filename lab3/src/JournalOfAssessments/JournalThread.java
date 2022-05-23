package JournalOfAssessments;

import java.util.Random;

public class JournalThread implements Runnable{

    private final Journal journal;
    private final String teacherName;
    private Random random = new Random();
    private int groupIndex = 0;


    public JournalThread(Journal journal, String teacherName){
        this.journal = journal;
        this.teacherName = teacherName;
    }

    public JournalThread(Journal journal, String teacherName, int groupIndex){
        this.journal = journal;
        this.teacherName = teacherName;
        this.groupIndex = groupIndex;
    }

    @Override
    public void run() {
        for (int i=0; i<18; i++){
            if (groupIndex != -1){
                for (Student student: journal.getGroups().get(groupIndex).getStudents()){
                    int min = 1;
                    int max = 6;
                    double mark=random.nextInt((max - min)) + min;
                    student.rateSync(mark);
                    System.out.println(Thread.currentThread().getName() +
                            "  Group - " + journal.getGroups().get(groupIndex).getNameOfGroup() + "   "
                            + this.teacherName + " rates " + student.getNameOftudent() + " - "
                            + mark + " points;   Total: " + student.getTotalMarkSync());
                }
            }
            else{
                for (Group group: journal.getGroups()){
                    for (Student student: group.getStudents()){
                        int min = 1;
                        int max = 6;
                        double mark=random.nextInt((max - min)) + min;
                        student.rateSync(mark);
                        System.out.println(Thread.currentThread().getName() +
                                "  Group - " + journal.getGroups().get(groupIndex).getNameOfGroup() + "   "
                                + this.teacherName + " rates " + student.getNameOftudent()
                                + " - " + mark + " points;   Total: " + student.getTotalMarkSync());
                    }
                }
            }
        }
    }
}
