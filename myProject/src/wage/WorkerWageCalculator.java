package wage;

import employee.Worker;

public class WorkerWageCalculator implements WageCalculator<Worker>{

    @Override
    public double calculateWage(Worker worker) {
        return (worker.getHourlyWage()*worker.getHourlyWage())  +
                (worker.getSumOvertimeHours()*worker.getHourlyWage())*(1 + worker.getOverTimePercentage()/100.0);
    }
}
