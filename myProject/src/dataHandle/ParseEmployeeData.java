package dataHandle;

import employee.Employee;
import employee.Manager;
import employee.Worker;

import java.util.ArrayList;
import java.util.List;

public class ParseEmployeeData {

    private List<Employee> employees = new ArrayList<>(); // a list of employees to store the data.
        //for reading the basic data
    public void parseEmployeesDataIntoObjects(String fileName) {
        List<String[]> employeesData = DataReader.readCSV(fileName);

        for (String[] row : employeesData) {
            int identifier = Integer.parseInt(row[0]);
            String name = row[1];
            String position = row[2];
            int requiredWorkHours = Integer.parseInt(row[3]);
            double wage = Double.parseDouble(row[4]);
            double overtimeWage = Double.parseDouble(row[5]);


            if ("Manager".equals(position)) {
                Manager manager = new Manager(identifier, name, position, requiredWorkHours, wage, overtimeWage);
                employees.add(manager);
            } else if ("Worker".equals(position)) {
                Worker worker = new Worker(identifier, name, position, requiredWorkHours, wage, overtimeWage);
                employees.add(worker);
            }
        }
    }
        //for reading the work hours
    public void readDailyWorkHours(String fileName) {
        List<String[]> dailyWorkHoursData = DataReader.readCSV(fileName);

        for (String[] row : dailyWorkHoursData) {
            int identifier = Integer.parseInt(row[0]);
            int workHours = Integer.parseInt(row[1]);

            // Find the corresponding employee and add work hours
            for (Employee employee : employees) {
                if (employee.getIdentifier() == identifier) {
                    employee.setSumWorkHours( workHours);
                    break;
                }
            }
        }
    }


    public    List<Employee> getEmployees() {
        return employees;
    }
}
