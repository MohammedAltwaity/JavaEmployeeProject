package employee;

public class Worker extends Employee{
    private  double hourlyWage;
    private  double overTimeWagePercentage;

    public Worker(int identifier, String name, String position, int requiredWorkHours, double hourlyWage, double overTimeWagePercentage) {
        super(identifier,  name,  position,  requiredWorkHours);
        this.hourlyWage = hourlyWage;
        this.overTimeWagePercentage = overTimeWagePercentage;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public double getOverTimePercentage() {
        return overTimeWagePercentage;
    }

    public void setOverTimePercentage(double overTimePercentage) {
        this.overTimeWagePercentage = overTimePercentage;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "hourlyWage=" + hourlyWage +
                ", overTimeWagePercentage=" + overTimeWagePercentage +
                "} " + super.toString();
    }
}
