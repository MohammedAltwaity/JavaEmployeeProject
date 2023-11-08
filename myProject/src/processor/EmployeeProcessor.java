package processor;

import dataHandle.ParseEmployeeData;
import employee.Employee;
import employee.Manager;
import employee.Worker;
import wage.ManagerWageCalculator;
import wage.WageCalculator;
import wage.WorkerWageCalculator;

import java.util.ArrayList;
import java.util.Collections;

import java.util.Comparator;
import java.util.List;

public class EmployeeProcessor {
    private List<Employee> employees;

    public EmployeeProcessor(String employeeDataFile, String dailyWorkHoursFile) {
        loadEmployeeData(employeeDataFile,dailyWorkHoursFile );
        readDailyWorkHours(dailyWorkHoursFile);


    }

    public void initialize() {
        calculateOvertimeHours();
        calculateMissedHours();
        calculateAndPrintCompanyPayments();
    }

    private void loadEmployeeData(String employeeDataFile, String dailyWorkHoursFile) {
        ParseEmployeeData parser = new ParseEmployeeData();
        parser.parseEmployeesDataIntoObjects(employeeDataFile);
        parser.readDailyWorkHours(dailyWorkHoursFile);
        employees = parser.getEmployees();

    }

    private void readDailyWorkHours(String dailyWorkHoursFile) {
        ParseEmployeeData parser = new ParseEmployeeData();
        parser.readDailyWorkHours(dailyWorkHoursFile);
    }

    private void calculateOvertimeHours() {
        for (Employee employee : employees) {
            int workedHours = employee.getSumWorkHours();
            int requiredHours = employee.getRequiredWorkHours();

            if (workedHours > requiredHours) {
                int overtimeHours = workedHours - requiredHours;
                employee.setSumOvertimeHours(overtimeHours);
            } else {
                // reset the sum of overtime hours if not applicable
                employee.setSumOvertimeHours(0);
            }
        }
    }


    private void calculateMissedHours() {
        for (Employee employee : employees) {
            int workedHours = employee.getSumWorkHours();
            int requiredHours = employee.getRequiredWorkHours();

            if (workedHours < requiredHours) {
                int missedHours = requiredHours - workedHours;
                employee.setMissedHours(missedHours);
            } else {
                employee.setMissedHours(0);
            }
        }
    }






    private void calculateWages() {
        WorkerWageCalculator workerWageCalculator = new WorkerWageCalculator();
        ManagerWageCalculator managerWageCalculator = new ManagerWageCalculator();
        for (Employee employee : employees) {
                if(employee instanceof Manager){

                        managerWageCalculator.calculateWage((Manager) employee);
                } else if(employee instanceof Worker){
                        workerWageCalculator.calculateWage((Worker) employee);
                }

        }

        }




        public void printAllData(){
        for(Employee employee: employees){
            System.out.println(employee.toString());
        }
        }


    

        public void printWagesInAlphabeticOrder() {
            employees.sort(Comparator.comparing(Employee::getName));
            WorkerWageCalculator workerWageCalculator = new WorkerWageCalculator();
            ManagerWageCalculator managerWageCalculator = new ManagerWageCalculator();
            for (Employee employee : employees) {
                System.out.println("Employee Name: " + employee.getName());
                System.out.println("Position: " + employee.getPosition());
                System.out.println("Identifier: " + employee.getIdentifier());

                if (employee instanceof Manager) {
                    Manager manager = (Manager) employee;
                    double wage = managerWageCalculator.calculateWage(manager);
                    System.out.println("Current Wage: $" + wage);
                } else if (employee instanceof Worker) {
                    Worker worker = (Worker) employee;
                    double wage = workerWageCalculator.calculateWage(worker);
                    System.out.println("Current Wage: $" + wage);
                }

                System.out.println();
            }


        }


        public void printListOfEmployeesBasedOnMissedHours(){
            Collections.sort(employees, Comparator.comparing(Employee::getMissedHours).reversed());
            for (Employee employee : employees) {
                System.out.println("Employee Name: " + employee.getName());
                System.out.println("Missed Hours: " + employee.getMissedHours());
                System.out.println("Identifier: " + employee.getIdentifier());
                System.out.println();
            }


        }



        public void calculateAndPrintCompanyPayments() {

            double totalWage = 0.0;
            double totalOvertimeWage = 0.0;
            double totalLoss = 0.0;

            for (Employee employee : employees) {
                if (employee instanceof Manager) {
                    Manager manager = (Manager) employee;
                    double basicWage = manager.getBasicWage();
                    double overtimeWage = manager.getOvertimeWage();
                    int overtimeHours = manager.getSumOvertimeHours();
                    int requiredHours = manager.getRequiredWorkHours();

                    double wage = basicWage + (overtimeWage * overtimeHours);
                    totalWage += wage;

                    if (overtimeHours > 0) {
                        totalOvertimeWage += (overtimeWage * overtimeHours);
                    }

                    if (requiredHours > manager.getSumWorkHours()) {
                        totalLoss += (basicWage/(30*8)) * (requiredHours - manager.getSumWorkHours());
                    }
                } else if (employee instanceof Worker) {
                    Worker worker = (Worker) employee;
                    double hourlyWage = worker.getHourlyWage();
                    double overtimeWagePercentage = worker.getOverTimePercentage();
                    int overtimeHours = worker.getSumOvertimeHours();
                    int requiredHours = employee.getRequiredWorkHours();

                    double wage = (worker.getRequiredWorkHours() * hourlyWage)
                            + (overtimeHours * hourlyWage * (1 + overtimeWagePercentage / 100.0));
                    totalWage += wage;

                    if (overtimeHours > 0) {
                        totalOvertimeWage += (overtimeHours * hourlyWage * (1 + overtimeWagePercentage / 100.0));
                    }
                    if(requiredHours > employee.getSumWorkHours()){
                        totalLoss += hourlyWage*(employee.getRequiredWorkHours() - employee.getSumWorkHours());
                    }
                }
            }

            System.out.println("Total Normal Wage: $" + totalWage);
            System.out.println("Total Overtime Wage: $" + totalOvertimeWage);
            System.out.println("Total Loss: $" + totalLoss);
            System.out.println("Total Payment: $" + (totalWage + totalOvertimeWage - totalLoss));
        }




}
