package Online_Exam;		
/*	OASIS INFOBYTE INTERNSHIP TASK - 2 : ONLINE EXAMINITION
	Submitted by - Shraddha Ghawalkar.	(JAVA Programmer)	 
----------------------------------------------------------------------------------------------------------------------------------------------------- */
/*
--> Run main.java
--> Username - user23
--> Password - user@123
------------------------------------------------------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------TASK - 2 : ONLINE EXAMINITION JAVA PROGRAMMING--------------------------------------------------------*/

//import the packages
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

//Declaring interfaces
interface User {
    void login(String username, String password);
    void logout();
}

interface TakeExam {
    void takeExam();
}
interface Updatepass {
	void updatePassword();
}

//Implementing the User, TakeExam, Updatepass interfaces in a class named main
public class main implements User, TakeExam, Updatepass{
    private String sname;
    private String srollNo;
    private String sbranch;
    private String sclass;
    private String ssubject;
    public int scoreJv = 0;
    public int scorePy = 0;
    String username;
    String password;
    
    public static void main(String[] args) {
        main obj = new main();
        obj.showMenu();
    }
    
// Implementing the showMenu method 
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\t   *** Online Examination ***");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t   -: Home :-");
        System.out.println("-------------------------------------------------------------------------------");
 

        System.out.println("\n1. Login");
        System.out.println("2. Exit");
        System.out.print("\nEnter choice :");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("\n-------------------------------------------------------------------------------");

        switch(choice) {
            case 1:
                System.out.println("\t\t\t\t   -: Login :-");
                System.out.println("-------------------------------------------------------------------------------");

                System.out.print("\nEnter username: ");
                String username = scanner.next();
                System.out.print("Enter password: ");
                String password = scanner.next();
                login(username, password);
                System.out.println("-------------------------------------------------------------------------------");
                break;
            case 2:
                System.out.println("\n-------------------------------------------------------------------------------");
                System.out.println("\t\t\t\t    Thank You!");
                System.out.println("-------------------------------------------------------------------------------");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                showMenu();
                break;
        }
    }
    
// Implementing the login method from the User interface
    public void login(String username, String password) {
        if(username.equals("user23") && password.equals("user@123")) {
            System.out.println("\nLogin successful!");
            System.out.println("\n-------------------------------------------------------------------------------");
            System.out.println("\t\t\t\t   -: Welcome :-");
            System.out.println("-------------------------------------------------------------------------------");

            System.out.println("\n1. Update Profile");
            System.out.println("2. Update Password");
            System.out.println("3. Take Exam");
            System.out.print("\nEnter choice :");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    updateProfile();
                    break;
                case 2:
                    updatePassword();
                case 3:
                    takeExam();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    login(username, password);
                    break;
            }
        }
        else {
            System.out.println("Incorrect username or password, please try again.");
            showMenu();
        }
    }
    
// Implementing the updateProfile method
    public void updateProfile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n-------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t   -: Update profile :-");
        System.out.println("-------------------------------------------------------------------------------");

        System.out.print("\nName: ");
        String name = scanner.next();
        
        System.out.print("Roll number: ");
        String rollNumber = scanner.next();
        
        System.out.print("Branch: ");
        String branch = scanner.next();
 
        System.out.print("Class: ");
        String classInfo = scanner.next();
        
        System.out.print("Subject: ");
        String subject = scanner.next();
        
        // Save the profile information in instance variables
        this.sname = name;
        this.srollNo = rollNumber;
        this.sbranch = branch;
        this.sclass = classInfo;
        this.ssubject = subject;
        
        System.out.print("\nConfirm details?	y/n\n");
        String con = scanner.next();
        if(con.equals("y")) {
        	System.out.println("\nProfile updated successfully...");
        	
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("\t\t\t\t   -: Profile Information :-");
            System.out.println("-------------------------------------------------------------------------------");

        	System.out.println("\nName: " + name);
        	System.out.println("Roll number: " + rollNumber);
        	System.out.println("Address: " + sbranch);
        	System.out.println("Class: " + classInfo);
        	System.out.println("Subject: " + subject + "\n");
        }else {
        	System.out.println("\nProfile update canceled...");
        }
        logout();
    }
    
// Implementing the updatePassword method from the Updatepass interface
    public void updatePassword() {
    	Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter old password: ");
        String oldPassword = scanner.nextLine();
        
        if (oldPassword.equals(password)) {
         
           System.out.print("Enter new password: ");
           String newPassword = scanner.nextLine();
          
           password = newPassword;
          
           System.out.println("Password updated successfully!");
        } else {
           System.out.println("Incorrect password. Password not updated.");
        }
    }

// Implementing the takeExam method from the TakeExam interface
	public void takeExam() {
    		System.out.println("\n-------------------------------------------------------------------------------");
    	    Scanner scanner = new Scanner(System.in);
    	    System.out.println("\nSelect a programming language:");
    	    System.out.println("\n1. JAVA");
    	    System.out.println("2. Python");
            System.out.print("\nEnter choice :");
    	    int choice = scanner.nextInt();
    	    scanner.nextLine();
    	    switch(choice) {
    	        case 1:
    	    		System.out.println("\n================================================================================");
    	        	System.out.println(" 📌 Be Ready.. The exam will start in 10 sec!");
    	    		System.out.println("================================================================================");

    	        	try {
    	        	    Thread.sleep(10000);
    	        	} catch (InterruptedException e) {
    	        	    e.printStackTrace();
    	        	}

    	        	Timer timerJv = new Timer();
    	        	TimerTask taskJv = new TimerTask() {
    	        	    int remainingTimeJv = 120000;		 // 2 mins in milliseconds
    	        	    int previousTimeJv = remainingTimeJv;

    	        	    public void run() {
    	        	        if (remainingTimeJv == 0) {
    	        	            timerJv.cancel();
    	        	    		System.out.println("\n-------------------------------------------------------------------------------");
    	        	            System.out.println("\t\t\t⌛ Time is up! Exam is auto-submitted.");
    	        	    		System.out.println("-------------------------------------------------------------------------------");

    	        	            System.out.println("Score: " + scoreJv + "/20");
    	        	            
    	        	            logout();
    	        	        } else {
    	        	            if (previousTimeJv - remainingTimeJv >= 60000 || previousTimeJv == remainingTimeJv) {
    	        	                int remainingTimeInSeconds = (int) remainingTimeJv / 1000;
    	        	                System.out.println("\t\t\t\t\t\t\t ⏱️ Time remaining: " + remainingTimeInSeconds + " sec");
    	        	                previousTimeJv = remainingTimeJv;
    	        	            }
    	        	            remainingTimeJv -= 2000; 		// reduce timer by 2 seconds
    	        	        }
    	        	    }
    	        	};
    	        	timerJv.scheduleAtFixedRate(taskJv, 0, 2000);

    	            System.out.println("\n\t\t\t\t   -: JAVA Exam :-");
    	    		System.out.println("\n-------------------------------------------------------------------------------");

    	            System.out.println("1. Which of the following is not a primitive data type in Java ?");
    	            System.out.println("\n1. int " + "\n" + "2. double" + "\n" + "3. boolean" + "\n" + "4. string");
    	            System.out.print("\nYour Answer :");
    	            String answer1 = scanner.nextLine();
    	            if (answer1.equals("4")) {
    	                scoreJv += 2;
    	            }
    	            System.out.println("\n2. Which of the following is the correct syntax to declare a variable in Java?");
    	            System.out.println("\n1. int variableName;" + "\n" + "2. variableType variableName;" + "\n" + "3. variableName variableType;" + "\n" + "4. variableName = variableType;");
    	            System.out.print("\nYour Answer :");
    	            String answer2 = scanner.nextLine();
    	            if (answer2.equals("1")) {
    	                scoreJv += 2;
    	            }
    	            System.out.println("\n3. Which of the following is used to read input from the user in Java?");
    	            System.out.println("\n1. console.log()" + "\n" + "2. System.out.println()" + "\n" + "3. Scanner.nextLine()" + "\n" + "4. Math.random()");
    	            System.out.print("\nYour Answer :");
    	            String answer3 = scanner.nextLine();
    	            if (answer3.equals("3")) {
    	                scoreJv += 2;
    	            }
    	            System.out.println("\n4. What is the output of the following code?");
    	            System.out.println("int x = 5;\r\n"
    	            		+ "System.out.println(x++);");
    	            System.out.println("\n1. 7" + "\n" + "2. 6" + "\n" + "3. 8" + "\n" + "4. 5");
    	            System.out.print("\nYour Answer :");
    	            String answer4 = scanner.nextLine();
    	            if (answer4.equals("4")) {
    	                scoreJv += 2;
    	            }
    	            System.out.println("\n5. What is the output of the following code?");
    	            System.out.println("int x = 5;\r\n"
    	            		+ "System.out.println(++x);");
    	            System.out.println("\n1. 0 " + "\n" + "2. 1 " + "\n" + "3. 5 " +"\n" + "4. 6");
    	            System.out.print("\nYour Answer :");
    	            String answer5 = scanner.nextLine();
    	            if (answer5.equals("4")) {
    	                scoreJv += 2;
    	            }
    	            System.out.println("\n6. Which of the following loops is used to execute a block of code a fixed number of times?");
    	            System.out.println("\n1. for loop " + "\n" + "2. while loop " + "\n" + "3. do-while loop" +"\n" + "4. if statement");
    	            System.out.print("\nYour Answer :");
    	            String answer6 = scanner.nextLine();
    	            if (answer6.equals("1")) {
    	                scoreJv += 2;
    	            }
    	            System.out.println("\n7. Which of the following is not a logical operator in Java?");
    	            System.out.println("\n1.  && " + "\n" + "2. || " + "\n" + "3. !" +"\n" + "4.  &");
    	            System.out.print("\nYour Answer :");
    	            String answer7 = scanner.nextLine();
    	            if (answer7.equals("4")) {
    	                scoreJv += 2;
    	            }
    	            System.out.println("\n8. What is the output of the following code?");
    	            System.out.println("String name = \"John\";\r\n"
    	            		+ "System.out.printf(\"Hello %s!\", name);");
    	            System.out.println("\n1. Hello John! " + "\n" + "2. Runtime Error " + "\n" + "3. Hello John " + "\n" + "4. Hello John!!!");
    	            System.out.print("\nYour Answer :");
    	            String answer8 = scanner.nextLine();
    	            if (answer8.equals("1")) {
    	                scoreJv += 2;
    	            }
    	            System.out.println("\n9. Which of the following is a subclass of Exception in Java?");
    	            System.out.println("\n1. RuntimeException. " + "\n" + "2. Error " + "\n" + "3. Throwable " +"\n"+ "4. Throws");
    	            System.out.print("\nYour Answer :");
    	            String answer9 = scanner.nextLine();
    	            if (answer9.equals("1")) {
    	                scoreJv += 2;
    	            }
    	            System.out.println("\n10. What is the purpose of the static keyword in Java?");
    	            System.out.println("\n1. to create a new instance of a class " + "\n" + "2. to declare a method or variable that belongs to the class, rather than an instance of the class " + "\n" + "3. to restrict access to a class or method " +"\n" + "4. to make a method or variable visible to other classes in the same package ");
    	            System.out.print("\nYour Answer :");
    	            String answer10 = scanner.nextLine();
    	            if (answer10.equals("2")) {
    	                scoreJv += 2;
    	            }
    	            
    	            timerJv.cancel();
    	    		System.out.println("\n================================================================================");
    	            System.out.println("Exam completed!");
    	            System.out.println("Your JAVA Exam Score: " + scoreJv + "/20");
    	    		System.out.println("================================================================================");

    	            logout();
    	            scanner.close();
    	            break;
    	            
    	        case 2:
    	    		System.out.println("\n================================================================================");
    	        	System.out.println(" 📌 Be Ready.. The exam will start in 10 sec!");
    	    		System.out.println("================================================================================");

    	        	try {
    	        	    Thread.sleep(10000);
    	        	} catch (InterruptedException e) {
    	        	    e.printStackTrace();
    	        	}

    	        	Timer timerPy = new Timer();
    	        	TimerTask taskPy = new TimerTask() {
    	        	    int remainingTimePy = 120000; // 2 mins in milliseconds
    	        	    int previousTimePy = remainingTimePy;

    	        	    public void run() {
    	        	        if (remainingTimePy == 0) {
    	        	            timerPy.cancel();
    	        	            System.out.println("\n-------------------------------------------------------------------------------");
    	        	            System.out.println("\t\t\t⌛ Time is up! Exam is auto-submitted.");
    	        	    		System.out.println("-------------------------------------------------------------------------------");
    	        	            System.out.println("Score: " + scorePy + "/20");
    	        	            
    	        	            logout();
    	        	        } else {
    	        	            if (previousTimePy - remainingTimePy >= 60000 || previousTimePy == remainingTimePy) {
    	        	                int remainingTimeInSeconds = (int) remainingTimePy / 1000;
    	        	                System.out.println("\t\t\t\t\t\t\t ⏱️ Time remaining: " + remainingTimeInSeconds + " sec");
    	        	                previousTimePy = remainingTimePy;
    	        	            }
    	        	            remainingTimePy -= 2000; // reduce timer by 2 seconds
    	        	        }
    	        	    }
    	        	};
    	        	timerPy.scheduleAtFixedRate(taskPy, 0, 2000);

    	        	System.out.println("\n\t\t\t\t   -: Python Exam :-");
        	    	System.out.println("\n-------------------------------------------------------------------------------");

    	        	System.out.println("\n1. Which of the following is not a built-in data type in Python?");
    	        	System.out.println("\n1. int" + "\n" + "2. float" + "\n" + "3. list" + "\n" + "4. char");
        	        System.out.print("\nYour Answer :");
    	        	String answerPy1 = scanner.nextLine();
    	        		if (answerPy1.equals("4")) {
        	                scorePy += 2;
    	        		}
    	        	System.out.println("\n2. What is the correct way to declare and initialize a list in Python?");
    	        	System.out.println("\n1. list myList = [1, 2, 3]" + "\n" + "2. myList = [1, 2, 3]" + "\n" + "3. error" + "\n" + "4. array myList = [1, 2, 3]");
        	        System.out.print("\nYour Answer :");
    	        		String answerPy2 = scanner.nextLine();
    	        		if (answerPy2.equals("2")) {
        	                scorePy += 2;
    	        		}
    	        	System.out.println("\n3. Which of the following is used to read input from the user in Python?");
    	        	System.out.println("\n1. input()" + "\n" + "2. console.log()" + "\n" + "3. print()" + "\n" + "4. read()");
        	        System.out.print("\nYour Answer :");
    	        		String answerPy3 = scanner.nextLine();
    	        		if (answerPy3.equals("1")) {
        	                scorePy += 2;
    	        		}
    	        	System.out.println("\n4. What is the output of the following code?");
    	        	System.out.println("x = 5\r\n"
    	        				+ "x += 1\r\n"
    	        				+ "print(x)");
    	        	System.out.println("\n1. 1" + "\n" + "2. 6" + "\n" + "2. 3" + "\n" + "4. 4");
        	        System.out.print("\nYour Answer :");
    	        	String answerPy4 = scanner.nextLine();
    	        		if (answerPy4.equals("2")) {
        	                scorePy += 2;
    	        		}
    	        	System.out.println("\n5. Which of the following loops is used to execute a block of code as long as a condition is true?");
    	        	System.out.println("\n1. for loop" + "\n" + "2. while loop" + "\n" + "3. do-while loop" + "\n" + "4. if statement");
        	        System.out.print("\nYour Answer :");
    	        		String answerPy5 = scanner.nextLine();
    	        		if (answerPy5.equals("2")) {
        	                scorePy += 2;
    	        		}
    	        	System.out.println("\n6. Which of the following is not a logical operator in Python?");
    	        	System.out.println("\n1. and" + "\n" + "2. or" + "\n" + "3. not" + "\n" + "4. &");
        	        System.out.print("\nYour Answer :");
    	        		String answerPy6 = scanner.nextLine();
    	        		if (answerPy6.equals("4")) {
        	                scorePy += 2;
    	        		}
    	        	System.out.println("\n7. Which of the following is used to read input from the user in Python?What is the output of the following code?");
    	        	System.out.println("name = \"Rhony\"\r\n"
    	        				+ "print(\"Hello, {}!\".format(name))");
    	        	System.out.println("\n1. Hello, John!" + "\n" + "2. Hello, Rhony!" + "\n" + "3. print()" + "\n" + "4. Error");
        	        System.out.print("\nYour Answer :");
    	        		String answerPy7 = scanner.nextLine();
    	        		if (answerPy7.equals("2")) {
        	                scorePy += 2;
    	        		}
    	        	System.out.println("\n8. Which of the following is not a Python built-in exception?");
    	        	System.out.println("\n1. ValueError" + "\n" + "2. TypeError" + "\n" + "3. KeyboardInterrupt" + "\n" + "4. NullPointerException.");
        	        System.out.print("\nYour Answer :");
    	        		String answerPy8 = scanner.nextLine();
    	        		if (answerPy8.equals("4")) {
        	                scorePy += 2;
    	        		}
    	        	System.out.println("\n9. What is the purpose of the pass keyword in Python?");
    	        	System.out.println("\n1. input()" + "\n" + "2. console.log()" + "\n" + "3. print()12345" + "\n" + "4. read()");
        	        System.out.print("\nYour Answer :");
    	        		String answerPy9 = scanner.nextLine();
    	        		if (answerPy9.equals("1")) {
        	                scorePy += 2;
    	        		}
    	        	System.out.println("\n10. Which of the following is used to read input from the user in Python?");
    	        	System.out.println("\n1. to create a new instance of a class" + "\n" + "2. to declare a method or variable that belongs to the class, rather than an instance of the class" + "\n" + "3.  to skip over a block of code that does nothing" + "\n" + "4. to make a method or variable visible to other classes in the same package");
        	        System.out.print("\nYour Answer :");
    	        		String answerPy10 = scanner.nextLine();
    	        		if (answerPy10.equals("3")) {
        	                scorePy += 2;
    	        		}
    	        		timerPy.cancel();
        	    	System.out.println("\n================================================================================");
    	        	System.out.println("Exam completed!");
    	        	System.out.println("Your Python Exam Score: " + scorePy + "/20");
        	    	System.out.println("================================================================================");

        	    		logout();
    	        		break;
    	        	default:
    	        	System.out.println("Invalid option!");
    	        		break;
    	            }
    	            

    }
    
// Implementing the logout method from the User interface
    public void logout() {
        System.out.println("Logout successful!");
        System.out.println("\n\t\t\t\t    Thank You!");
		System.out.println("\n-------------------------------------------------------------------------------");
        showMenu();
    }

}

