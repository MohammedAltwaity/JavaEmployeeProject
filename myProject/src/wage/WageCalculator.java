package wage;

import employee.Employee;
import employee.Manager;

public interface WageCalculator <T extends Employee >{
    double   calculateWage(T employee);

}
