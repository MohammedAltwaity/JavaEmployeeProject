package employee;

public class Manager extends Employee{
    private double basicWage;
    private double overtimeWage;

    public Manager(int identifier, String name, String position, int requiredWorkHours, double basicWage, double overtimeWage) {
        super(identifier,  name,  position,  requiredWorkHours);
        this.basicWage = basicWage;
        this.overtimeWage = overtimeWage;
    }

    public double getBasicWage() {
        return basicWage;
    }

    public void setBasicWage(double basicWage) {
        this.basicWage = basicWage;
    }

    public double getOvertimeWage() {
        return overtimeWage;
    }

    public void setOvertimeWage(double overtimeWage) {
        this.overtimeWage = overtimeWage;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "basicWage=" + basicWage +
                ", overtimeWage=" + overtimeWage +
                "} " + super.toString();
    }
}
