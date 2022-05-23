package JournalOfAssessments;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Student {

    private String nameOftudent;
    private ArrayList<Double> marks;
    private  final ReentrantLock lock = new ReentrantLock();
    private int weekCounter = 0;

    public Student(String nameOftudent){
        this.nameOftudent = nameOftudent;
        this.marks = new ArrayList<>();
    }

    public void rateSync(double mark) {
        lock.lock();
        try {
            this.marks.add(mark);
            weekCounter++;
        }finally {
            lock.unlock();
        }
    }

    public void rateAsync(double mark){
        this.marks.add(mark);
        weekCounter++;
    }

    public ArrayList<Double> getMarks(){
        return this.marks;
    }

    public String getNameOftudent(){
        return this.nameOftudent;
    }

    public double getTotalMarkSync(){
        double getMark = 0;
        lock.lock();
        try {
            getMark = this.marks.stream().mapToDouble(mark -> mark).sum();

        } finally {
            lock.unlock();
        }
        return getMark;
    }

    public double getTotalMarkAsync(){
        return this.marks.stream().mapToDouble(mark -> mark).sum();
    }

}
