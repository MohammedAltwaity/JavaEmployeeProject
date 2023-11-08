package main;




import processor.EmployeeProcessor;
        import processor.ListFilesInRelativeDirectory;

        import java.util.Scanner;
        import java.io.File;

public class Application {


    public static void startTheApplication() {
        System.out.println("******************************************");
        System.out.println("*         Welcome to My Java App!        *");
        System.out.println("*                                        *");
        System.out.println("*           Let's get started...         *");
        System.out.println("*                                        *");
        System.out.println("******************************************");
        System.out.println();

        System.out.println("Basic data about the employees has been read from the folder employeeData in the relative path");

        // list available daily work hours files
        ListFilesInRelativeDirectory.listFilesInRelativeDirectory("src/employeeData/dailyWorkHours/");

        // Get the list of daily work hour files
        File dailyWorkHoursFolder = new File("src/employeeData/dailyWorkHours");
        File[] dailyWorkHourFiles = dailyWorkHoursFolder.listFiles();

        //we will add some validation

        if (dailyWorkHourFiles == null || dailyWorkHourFiles.length == 0) {
            System.out.println("No daily work hour files found. Please make sure files are available.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        String fileName = null;

        while (true) {
            System.out.print("Enter the file name you want to read (e.g., day1WorkHours.csv): ");
            fileName = scanner.nextLine();

            // Check if the entered file name exists
            boolean fileExists = false;
            for (File file : dailyWorkHourFiles) {
                if (file.getName().equalsIgnoreCase(fileName)) {
                    fileExists = true;
                    break;
                }
            }

            if (fileExists) {
                break; // exit the loop if a valid file name is entered
            } else {
                System.out.println("File not found. Please enter a valid file name.");
            }
        }



        // Create the EmployeeProcessor with the selected file
        EmployeeProcessor employeeProcessor = new EmployeeProcessor("src/employeeData/employees.csv", "src/employeeData/dailyWorkHours/" + fileName);
        employeeProcessor.initialize();

        System.out.println("Data loaded successfully.");
        System.out.println();

        System.out.println("current wages of employees in alphabetic order of employee name: ");
        employeeProcessor.printWagesInAlphabeticOrder();
        System.out.println("*****************************************************************************************");
        System.out.println("Print list of employees in order of missed hours (most in front)");
        employeeProcessor.printListOfEmployeesBasedOnMissedHours();
        System.out.println("*****************************************************************************************");
        employeeProcessor.calculateAndPrintCompanyPayments();
        System.out.println("*****************************************************************************************");





    }
}
