package person_211027.model;

public class Student extends Person implements Comparable<Student>{
    private double mathScore;
    private double physicalScore;
    private double chemistryScore;

    public Student() {
    }

    public Student(String name, int age, double mathScore, double physicalScore, double chemistryScore) {
        super(name, age);
        this.mathScore = mathScore;
        this.physicalScore = physicalScore;
        this.chemistryScore = chemistryScore;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public double getPhysicalScore() {
        return physicalScore;
    }

    public void setPhysicalScore(int physicalScore) {
        this.physicalScore = physicalScore;
    }

    public double getChemistryScore() {
        return chemistryScore;
    }

    public void setChemistryScore(int chemistryScore) {
        this.chemistryScore = chemistryScore;
    }

    public double getAverageScore() {
        return (mathScore + physicalScore + chemistryScore)/3;
    }

    @Override
    public String toString() {
        return String.format("|%-8s|%-10d|%-7d|%-13f|%-13f|%-13f|%-13f|",
                getName(), getPersonalId(), getAge(), mathScore, physicalScore, chemistryScore,getAverageScore());
    }

    @Override
    public int compareTo(Student o) {
        if (getAverageScore() - o.getAverageScore() > 0) return 1;
        else if (getAverageScore() - o.getAverageScore() < 0) return -1;
        return 0;
    }
}
