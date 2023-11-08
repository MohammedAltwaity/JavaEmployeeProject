package wage;

import employee.Employee;
import employee.Manager;

public class ManagerWageCalculator implements WageCalculator<Manager>{


    @Override
    public double calculateWage(Manager manager) {
        return manager.getBasicWage()
                + manager.getOvertimeWage()* manager.getSumOvertimeHours();
    }
}
