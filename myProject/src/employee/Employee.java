package employee;

public class Employee {
    private int identifier;
    private String name;
    private String position;
    private int requiredWorkHours;
    private int sumWorkHours;
    private int missedHours;
    private int sumOvertimeHours;




    public Employee(int identifier, String name, String position, int requiredWorkHours) {
        this.identifier = identifier;
        this.name = name;
        this.position = position;
        this.requiredWorkHours = requiredWorkHours;

    }


    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getRequiredWorkHours() {
        return requiredWorkHours;
    }

    public void setRequiredWorkHours(int requiredWorkHours) {
        this.requiredWorkHours = requiredWorkHours;
    }

    public int getSumWorkHours() {
        return sumWorkHours;
    }

    public void setSumWorkHours(int sumWorkHours) {
        this.sumWorkHours = sumWorkHours;
    }

    public int getMissedHours() {
        return missedHours;
    }

    public void setMissedHours(int missedHours) {
        this.missedHours = missedHours;
    }

    public int getSumOvertimeHours() {
        return sumOvertimeHours;
    }

    public void setSumOvertimeHours(int sumOvertimeHours) {
        this.sumOvertimeHours = sumOvertimeHours;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "identifier=" + identifier +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", requiredWorkHours=" + requiredWorkHours +
                ", sumWorkHours=" + sumWorkHours +
                ", missedHours=" + missedHours +
                ", sumOvertimeHours=" + sumOvertimeHours +
                '}';
    }
}
