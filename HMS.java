//importing the java utility package to use Scanner and other utilities
import java.util.*;
// Hospital Management System Class
class HospitalManagementSystem {
    //MAIN MATHOD
    public static void main(String[] args) 
    {
        // Display welcome message
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║      WELCOME TO HOSPITAL MANAGEMENT SYSTEM!   ║");        
        System.out.println("╚═══════════════════════════════════════════════╝");
        Scanner sc = new Scanner(System.in);
        // Array to store patient records
        HMS[] patientArray = new HMS[1000];
        int Initial_patient = 0; // Tracks the number of patients added
        int choice = 0; // Stores user menu choice
        int Initial_password = 1234; // Default password for authentication
        int count = 0; // Tracks the number of incorrect password attempts
        boolean c = true; // Flag for loop control
        HMS obj = new HMS(); // Object of the HMS class for function calls
        int check=0;//No Of Patient In The System
        //Color codes for presentation
        String RESET = "\u001B[0m";
String CYAN = "\u001B[36m";
String BLUE = "\033[38;5;153m";
String GREEN = "\u001B[32m";
// ANSI escape code for red
 String RED = "\033[31m";
        do 
        {
            // Password verification
            System.out.println("PLEASE ENTER SYSTEM'S PASSWORD");
            int password =sc.nextInt();
            //no of incorrect parsword attemps increase
            count++;
            if (password == Initial_password)
             {
                // If password is correct, display menu
                do {
                    //Show available functionalities
                    System.out.println("\u001B[34m-------AVAILABLE OPTIONS-------\u001B[0m");
                    System.out.println(BLUE + "1. ADD PATIENT" + RESET);
                    System.out.println(BLUE + "2. BOOK APPOINTMENT" + RESET);
                    System.out.println(BLUE + "3. SEARCH FOR PATIENT DETAILS" + RESET);
                    System.out.println(BLUE + "4. VIEW DOCTOR DETAILS" + RESET);
                    System.out.println(BLUE + "5. INVOICE AND RECEIPT MANAGEMENT" + RESET);
                    System.out.println(BLUE + "6. VIEW STAFF DETAILS" + RESET);
                    System.out.println(BLUE + "7. LOGOUT" + RESET);                    
					System.out.println("\u001B[34m---------------------------\u001B[0m");
                    System.out.print("ENTER YOUR CHOICE : ");
                    //Storing user's choice in choice variable
                    choice = sc.nextInt();
                    // Menu options
                    switch (choice) 
                    {
                        case 1:
                            // Add Patient Details
                            for (int i = Initial_patient; i < (Initial_patient + 1); i++) {
                                System.out.println("------- ENTER DETAILS OF PATIENT " + (i + 1) + " ---------");
                                check++;
                                patientArray[i] = new HMS();
                                patientArray[i].setPatientDetails();
                            }
                            System.out.println("\u001B[32mPATIENT ADDED SUCCESSFULLY\u001B[0m");
                            Initial_patient++;
                            break;
                        case 2:
                        //Book Appointment.
                        if(check>=1)
                        {
                            obj.Book_Appointment(Initial_patient,patientArray);
                        }
                        //If there is no patient.
                        else
                        {
                         System.out.println(RED + "NO PATIENT FOUND IN THE SYSTEM" + RESET);
                        }
                            break;
                        case 3:
                            // Search for Patient Details.
                            if(check>=1)
                        {
                            obj.Search_Patient(patientArray, Initial_patient);
                        }
                        //If there is no patient.
                        else
                        {
                         System.out.println(RED + "NO PATIENT FOUND IN THE SYSTEM" + RESET);
                        }
                            break;
                        case 4:
                            // Display Doctor Details.
                            obj.Doctor_Details();
                            break;
                        case 5:
                            // Invoice and Receipt Management.
                            if(check>=1)
                        {
                            obj.Bill_Payment(patientArray, Initial_patient);
                        }
                        //If there is no patient.
                        else
                        {
                         System.out.println(RED + "NO PATIENT FOUND IN THE SYSTEM" + RESET);

                        }  
                            break;              
                        case 6:
                            // Display Staff Details.
                            System.out.println("NUMBER OF DOCTORS ARE 100");
                            System.out.println("NUMBER OF NURSES ARE 500");
                            System.out.println("NUMBER OF CLEANING STAFF ARE 1000");
                            break;
                        case 7:
                            // Exit the application.
                            System.out.println("LOGOUT");
                            break;
                        default:
                            // Handle invalid menu options entered.
                            System.out.println(RED +"INVALID CHOICE ENTERED" +RESET);
                    }
                } while (choice != 7);
                // Thank the user for using system after exiting.
                System.out.println("---------THANK YOU FOR USING HOSPITAL MANAGEMENT SYSTEM--------");
                break;
            } 
            else if (count != 3) 
            {
                // Handle incorrect password attempts
                System.out.println(RED +"INCORRECT PASSWORD ENTERED"+RESET);
            } 
            else if (count == 3) 
            {
                // Restrict access after 3 failed attempts
                System.out.println(RED +"YOUR SYSTEM HAS BEEN LOCKED DUE TO MANY WRONG ATTEMPTS"+RESET);
            }
        } 
        while (count != 3);
    }
}
// HMS class handles patient data and other related functionalities
class HMS {
    // Patient details
    String name,diseases;
    int age;
    long Mobile_no,Aadhar_no;
	boolean appointment_status=false;
	boolean appointmentBooked = false; 
    //Color codes for presentation.
     String RESET = "\u001B[0m";
String CYAN = "\u001B[36m";
String BLUE = "\033[38;5;153m";
String GREEN = "\u001B[32m";
// ANSI escape code for red
 String RED = "\033[31m";
    Scanner sc = new Scanner(System.in);
    // Method to set patient details
    void setPatientDetails() {
        //Prompting user to enter their details
        System.out.println("ENTER NAME OF THE PATIENT");
        name = sc.nextLine();
        System.out.println("ENTER DISEASES OF THE PATIENT");
        diseases = sc.nextLine();
        System.out.println("ENTER AGE OF THE PATIENT");
        age = sc.nextInt();
        System.out.println("ENTER MOBILE NUMBER OF THE PATIENT");
		Mobile_no = sc.nextLong();
		String s1=Mobile_no+"";
		boolean mobile_number=true;
		 while (mobile_number)
         {
            s1 = Mobile_no + "";
            if (s1.length()==10 && (s1.startsWith("7") || s1.startsWith("8") || s1.startsWith("9"))) 
			{
				mobile_number=false;
			}
			else
			{
				System.out.println("ENTER VALID MOBILE NUMBER");
				Mobile_no = sc.nextLong();
			}	
		 }	
		System.out.println("ENTER AADHAR NUMBER OF THE PATIENT");
		Aadhar_no=sc.nextLong();
        String s2 = Aadhar_no + "";
		boolean valid=true;
			while(valid){
				s2 = Aadhar_no + "";
				if(s2.length()!=12){
					System.out.println(RED+"ENTER VALID AADHAR NUMBER!"+RESET);
					Aadhar_no=sc.nextLong();
				}
				else{
					valid=false;
				}
			}
	}
    //Method to display patient details
    void get() 
    {
        System.out.println("NAME OF THE PATIENT IS : " + name);
        System.out.println("DISEASES OF THE PATIENT IS : " + diseases);
        System.out.println("AGE OF THE PATIENT IS : " + age);
        System.out.println("MOBILE NUMBER OF THE PATIENT IS : " + Mobile_no);
		System.out.println("AADHAR NUMBER OF THE PATIENT IS: " + Aadhar_no);
    }
    // Method to search for a patient by Aadhar number
    void Book_Appointment(int x , HMS[] a)
    {
		boolean checkchoice=false;
        System.out.println("ENTER AADHAR NUMBER OF THE PATIENT");
        long AddharNumberEnter=sc.nextLong();
        String DoctorName;
        int i;
        boolean na=true;
        int choice1=0;
        for(i=0; i<x; i++)
        {
            if(AddharNumberEnter==a[i].Aadhar_no)
            {
			 if (a[i].appointmentBooked) {
                    System.out.println(RED+"APPOINTMENT ALREADY BOOKED FOR THIS PATIENT."+RESET);
                    return;
                }
				else
				{
                na=false;
				int year, month, day, hour, minute;
    
                // Validating date (Year = 2025, valid month and day)
                System.out.print("Enter Appointment Month (MM): ");
                month = sc.nextInt();
                boolean m1=true;
                while (m1) {
                    if (month < 1 || month > 12) {
                        System.out.println(RED +"INVALID MONTH! PLEASE ENTER A VALUE BETWEEN 1 AND 12."+RESET);
                        System.out.print("Enter Appointment Month (MM): ");
                        month = sc.nextInt();
                        continue;
                    }
                    else
                    {
                        m1=false;
                    }
                }
                    System.out.print("Enter Appointment Day (DD): ");
                    day = sc.nextInt();
                    boolean m2=true;
                    // Validating the day based on the month
                    while(m2)
                    {
                    if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day >= 1 && day <= 31)) {
                        m2=false;
                        break;
                    } else if ((month == 4 || month == 6 || month == 9 || month == 11) && (day >= 1 && day <= 30)) {
                        m2=false;
                        break;
                    } else if (month == 2 && (day>=1 && day<=28)) {
                        m2=false;
                            break;
                    } else {
                        System.out.println(RED+"INVALID DAY! PLEASE ENTER A VALID DAY FOR THE SELECTED MONTH."+RESET);
                        System.out.print("Enter Appointment Day (DD): ");
                        day = sc.nextInt();
                        continue;
                    }
                }
				String appointmentDate = day +"-"+ month +"-" + "2025";
    
                // Validating time (between 9:00 AM and 9:00 PM)
                System.out.print("Enter Appointment Hour (HH - 24-hour format): ");
                hour = sc.nextInt();
                boolean check_hours=true;
                while (check_hours) {
                    if (hour <9 || hour >= 21) {
                        System.out.println(RED+"DOCTORS ARE AVAILABLE ONLY BETWEEN 09:00 AM AND 09:00 PM. PLEASE ENTER A VALID TIME."+RESET);
                        System.out.print("Enter Appointment Hour (HH - 24-hour format): ");
                        hour = sc.nextInt();
                        continue;
                    }
                    else
                    {
                        check_hours=false;
                        break;
                    }
                }
                System.out.print("Enter Appointment Minutes (MM): ");
                minute = sc.nextInt();
                boolean check_minutes=true;
                while(check_minutes)
                {
                    if (minute < 0 || minute >= 60) 
                    {
                        System.out.println(RED+"INVALID MINUTES! PLEASE ENTER A VALUE BETWEEN 0 AND 59."+RESET);
                        System.out.print("Enter Appointment Minutes (MM): ");
                        minute = sc.nextInt();
                        continue;
                    }
                    else
                    {
                        check_minutes=false;
                        break;
                    }
                }
                String appointmentTime = String.format("%02d:%02d", hour, minute);
				do{
                System.out.println("SELECT DOCTOR");
                System.out.println("1. PEDIATRICIAN");
        System.out.println("2. PHYSICIANS");
        System.out.println("3. GYNECOLOGIST");
        System.out.println("4. DENTIST");
        System.out.println("5. ORTHOPAEDIC");
        System.out.println("6. OTHERS");
        System.out.print("ENTER CHOICE : ");
        int choice = sc.nextInt();
        switch (choice) 
        {
            case 1:
            //Pediatrician
            System.out.println("AVAILABLE PEDIATRICIAN");
            System.out.println("-----DOCTOR 1-----");
            System.out.println("NAME        : DR.NUPUR THAKKAR");
            System.out.println("SPECIALITY  : PEDIATRIC SURGERY ");
            System.out.println("-----DOCTOR 2-----");
            System.out.println("NAME        : DR.ASTHA PATEL");
            System.out.println("SPECIALITY  : ADOLESCENT MEDICINE ");
            System.out.println("ENTER DOCTOR PREFERENCE");
            choice1=sc.nextInt();
			checkchoice=true;
            switch (choice1)
            {
                case 1 :
                System.out.println("PATIENTS'S NAME : "+a[i].name);
                System.out.println("PATIENT'S DISEASES : "+a[i].diseases);
                System.out.println("APPOINTMENT TIME : "+appointmentTime);
                System.out.println("APPOINTMENT DATE : "+appointmentDate);
                System.out.println("NAME OF THE DOCTOR : DR.NUPUR THAKKAR");
                System.out.println(GREEN+"APPOINTENT BOOKED SUCCESSFULLY"+RESET);
                break; 
                case 2 :
                System.out.println("PATIENTS'S NAME : "+a[i].name);
                System.out.println("PATIENT'S DISEASES : "+a[i].diseases);
                System.out.println("APPOINTMENT TIME : "+appointmentTime);
                System.out.println("APPOINTMENT DATE : "+appointmentDate);
                System.out.println("NAME OF THE DOCTOR : DR.ASTHA PATEL");
                System.out.println(GREEN+"APPOINTENT BOOKED SUCCESSFULLY"+RESET);
                break;
                default : System.out.println("DOCTOR NOT FOUND");
            }
            break;
            case 2 :
            //Physicians
            System.out.println("AVAILABLE PHYSICIAN");
            System.out.println("-----DOCTOR 1-----");
            System.out.println("NAME        : DR.PREXA UPADHYAY");
            System.out.println("SPECIALITY  : FAMILY MEDICINE ");
            System.out.println("-----DOCTOR 2-----");
            System.out.println("NAME        : DR.DIPAK RATHOD");
            System.out.println("SPECIALITY  : INTERNAL MEDICINE ");
            System.out.println("ENTER DOCTOR PREFERENCE");
            choice1=sc.nextInt();
			checkchoice=true;
            switch (choice1)
            {
                case 1 :
                System.out.println("PATIENTS'S NAME : "+a[i].name);
                System.out.println("PATIENT'S DISEASES : "+a[i].diseases);
                System.out.println("APPOINTMENT TIME : "+appointmentTime);
                System.out.println("APPOINTMENT DATE : "+appointmentDate);
                System.out.println("NAME OF THE DOCTOR : DR.PREXA UPADHYAY");
                System.out.println(GREEN+"APPOINTENT BOOKED SUCCESSFULLY"+RESET);
                break; 
                case 2 :
                System.out.println("PATIENTS'S NAME : "+a[i].name);
                System.out.println("PATIENT'S DISEASES : "+a[i].diseases);
                System.out.println("APPOINTMENT TIME : "+appointmentTime);
                System.out.println("APPOINTMENT DATE : "+appointmentDate);
                System.out.println("NAME OF THE DOCTOR : DR.DIPAK RATHOD");
                System.out.println(GREEN+"APPOINTENT BOOKED SUCCESSFULLY"+RESET);
                break;
                default : System.out.println(RED+"DOCTOR NOT FOUND"+RESET);
            }
            break;
            case 3 :
            //Gynecologist
            System.out.println("AVAILABLE GYNECOLOGIST");
            System.out.println("-----DOCTOR 1-----");
            System.out.println("NAME        : DR.KOMAL LANGALIYA");
            System.out.println("SPECIALITY  : GYNECOLOGIC ONCOLOGISTS ");
            System.out.println("-----DOCTOR 2-----");
            System.out.println("NAME        : DR.ISHA MEDDIRATTA");
            System.out.println("SPECIALITY  : FETAL MEDICINE SPECIALISTS ");
            System.out.println("ENTER DOCTOR PREFERENCE");
            choice1=sc.nextInt();
			checkchoice=true;
            switch (choice1)
            {
                case 1 :
                System.out.println("PATIENTS'S NAME : "+a[i].name);
                System.out.println("PATIENT'S DISEASES : "+a[i].diseases);
                System.out.println("APPOINTMENT TIME : "+appointmentTime);
                System.out.println("APPOINTMENT DATE : "+appointmentDate);
                System.out.println("NAME OF THE DOCTOR : DR.KOMAL LANGALIYA");
                System.out.println(GREEN+"APPOINTENT BOOKED SUCCESSFULLY"+RESET);
                break;   
                case 2 :
                System.out.println("PATIENTS'S NAME : "+a[i].name);
                System.out.println("PATIENT'S DISEASES : "+a[i].diseases);
                System.out.println("APPOINTMENT TIME : "+appointmentTime);
                System.out.println("APPOINTMENT DATE : "+appointmentDate);
                System.out.println("NAME OF THE DOCTOR : DR.ISHA MEDDIRATTA");
                System.out.println(GREEN+"APPOINTENT BOOKED SUCCESSFULLY"+RESET);
                break;
                default : System.out.println("DOCTOR NOT FOUND");
            }
            break;
            case 4 :
            //Dentist
            System.out.println("AVAILABLE DENTIST");
            System.out.println("-----DOCTOR 1-----");
            System.out.println("NAME        : DR.PARTH THAKKAR");
            System.out.println("SPECIALITY  : ORAL SURGEON");
            System.out.println("-----DOCTOR 2-----");
            System.out.println("NAME        : DR.TUSHAR THAKAR");
            System.out.println("SPECIALITY  : PROSTHODONTIC ");
            System.out.println("ENTER DOCTOR PREFERENCE");
            choice1=sc.nextInt();
			checkchoice=true;
            switch (choice1)
            {
                case 1 :
                System.out.println("PATIENTS'S NAME : "+a[i].name);
                System.out.println("PATIENT'S DISEASES : "+a[i].diseases);
                System.out.println("APPOINTMENT TIME : "+appointmentTime);
                System.out.println("APPOINTMENT DATE : "+appointmentDate);
                System.out.println("NAME OF THE DOCTOR : DR.PARTH THAKKAR");
                System.out.println(GREEN+"APPOINTENT BOOKED SUCCESSFULLY"+RESET);
                break; 
                case 2 :
                System.out.println("PATIENTS'S NAME : "+a[i].name);
                System.out.println("PATIENT'S DISEASES : "+a[i].diseases);
                System.out.println("APPOINTMENT TIME : "+appointmentTime);
                System.out.println("APPOINTMENT DATE : "+appointmentDate);
                System.out.println("NAME OF THE DOCTOR : DR.TUSHAR THAKAR");
                System.out.println(GREEN+"APPOINTENT BOOKED SUCCESSFULLY"+RESET);
                break;
                default : System.out.println("DOCTOR NOT FOUND");
            }
            break;
            case 5 :
            //Orthopaedic
            System.out.println("AVAILABLE ORTHOPAEDIC");
            System.out.println("-----DOCTOR 1-----");
            System.out.println("NAME        : DR.KHUSHBOO SHAH");
            System.out.println("SPECIALITY  : HAND SURGERY ");
            System.out.println("-----DOCTOR 2-----");
            System.out.println("NAME        : DR.UTBAN MAVLI");
            System.out.println("SPECIALITY  : FOOT AND ANKLE REPLACEMENT SURGERY ");
            System.out.println("ENTER DOCTOR PREFERENCE");
            choice1=sc.nextInt();
			checkchoice=true;
            switch (choice1)
            {
                case 1 :
                System.out.println("PATIENTS'S NAME : "+a[i].name);
                System.out.println("PATIENT'S DISEASES : "+a[i].diseases);
                System.out.println("APPOINTMENT TIME : "+appointmentTime);
                System.out.println("APPOINTMENT DATE : "+appointmentDate);
                System.out.println("NAME OF THE DOCTOR : DR.KHUSHBOO SHAH");
                System.out.println(GREEN+"APPOINTENT BOOKED SUCCESSFULLY"+RESET);
                break; 
                case 2 :
                System.out.println("PATIENTS'S NAME : "+a[i].name);
                System.out.println("PATIENT'S DISEASES : "+a[i].diseases);
                System.out.println("APPOINTMENT TIME : "+appointmentTime);
                System.out.println("APPOINTMENT DATE : "+appointmentDate);
                System.out.println("NAME OF THE DOCTOR : DR.UTBAN MAVLI");
                System.out.println(GREEN+"APPOINTENT BOOKED SUCCESSFULLY"+RESET);
                break;
                default : System.out.println(RED+"DOCTOR NOT FOUND"+RESET);
            }
            break;
            case 6 :
            //Others
            System.out.println("OTHER AVAILABLE DOCTORS  ");
            System.out.println("-----DOCTOR 1-----");
            System.out.println("NAME        : DR.HETVI PATEL");
            System.out.println("SPECIALITY  : NEUROLOGIST ");
            System.out.println("-----DOCTOR 2-----");
            System.out.println("NAME        : DR.VED PATEL");
            System.out.println("SPECIALITY  : DERMATOLOGIST ");
            System.out.println("ENTER DOCTOR PREFERENCE");
            choice1=sc.nextInt();
			checkchoice=true;
            switch (choice1)
            {
                case 1 :
                System.out.println("PATIENTS'S NAME : "+a[i].name);
                System.out.println("PATIENT'S DISEASES : "+a[i].diseases);
                System.out.println("APPOINTMENT TIME : "+appointmentTime);
                System.out.println("APPOINTMENT DATE : "+appointmentDate);
                System.out.println("NAME OF THE DOCTOR : DR.HETVI PATEL");
                System.out.println(GREEN+"APPOINTENT BOOKED SUCCESSFULLY"+RESET);
                break; 
                case 2 :
                System.out.println("PATIENTS'S NAME : "+a[i].name);
                System.out.println("PATIENT'S DISEASES : "+a[i].diseases);
                System.out.println("APPOINTMENT TIME : "+appointmentTime);
                System.out.println("APPOINTMENT DATE : "+appointmentDate);
                System.out.println("NAME OF THE DOCTOR : DR.VED PATEL");
                System.out.println(GREEN+"APPOINTENT BOOKED SUCCESSFULLY"+RESET);
                break;
                default : System.out.println(RED+"DOCTOR NOT FOUND"+RESET);
            }
            break;
            //Handle incorrect disease entered
            default : System.out.println(RED+"INVALID CHOICE"+RESET);
        }
        }
		while(checkchoice!=true);
		}
		a[i].appointmentBooked = true;
		a[i].appointment_status=true;
    }
		}
    if(na)
    {
        System.out.println(RED+"PATIENT NOT FOUND"+RESET);
    }
}
    void Search_Patient(HMS[] a, int b) 
    {
        HMS obj=new HMS();
        int x=b;
        System.out.println("ENTER AADHAR NUMBER OF THE PATIENT YOU WANT TO SEARCH");
        Long AADHAR_NO= sc.nextLong();
        boolean na = true;
        for (int i = 0; i < b; i++) 
        {
            if (AADHAR_NO.equals(a[i].Aadhar_no)) 
            {
                System.out.println("-----------PATIENT DETAILS-----------");
                na = false;
                a[i].get();
            }
        }
        if (na) 
        {
            //Handle incorrect patient search
            System.out.println(RED+"PATIENT NOT FOUND"+RESET);
        }
    }
    // Method to calculate billing and payment
    void Bill_Payment(HMS[] a, int b)
     {
        int cost = 0;
        HMS obj=new HMS();
        int x=b;
        int Doctor_consultancy = 0;
        boolean na = true;
        System.out.println("ENTER AADHAR CARD NUMBER OF THE PATIENT YOU WANT TO SEARCH");
        Long AADHAR_NO = sc.nextLong();    
        for (int i = 0; i < b; i++) 
        {
            if (AADHAR_NO.equals(a[i].Aadhar_no)) 
            {
				if(a[i].appointment_status==true)
				{
					 na = false;
                System.out.println("PATIENT'S NAME: " + a[i].name);
                System.out.println("PATIENT'S DISEASES: " + a[i].diseases);
                // Room type menu
                System.out.println("----ROOM TYPE----");
                System.out.println("1. SPECIAL PREMIUM");
                System.out.println("(ROOM : INR 5000/DAY) (DOCTOR CONSULTANT = INR 1000/DAY)");
                System.out.println("2. SPECIAL");
                System.out.println("(ROOM : INR 4000/DAY) (DOCTOR CONSULTANT = INR 900/DAY)");
                System.out.println("3. SINGLE");
                System.out.println("(ROOM : INR 3000/DAY) (DOCTOR CONSULTANT = INR 800/DAY)");
                System.out.println("4. TWIN SHARING");
                System.out.println("(ROOM : INR 3000/DAY) (DOCTOR CONSULTANT = INR 800/DAY)");
                System.out.println("5. TRIPLE SHARING");
                System.out.println("(ROOM : INR 1000/DAY) (DOCTOR CONSULTANT = INR 600/DAY)");
                System.out.println("6. ICU");
                System.out.println("(ROOM : INR 10000/DAY) (DOCTOR CONSULTANT = INR 2000/DAY)");
                System.out.println("7. VENTILATOR");
                System.out.println("(ROOM : INR 15000/DAY) (DOCTOR CONSULTANT = INR 3000/DAY)");
                int choice1 = sc.nextInt();
                switch (choice1) 
                {
                    case 1:
                    //Special Premium
                        cost = 5000;
                        Doctor_consultancy = 1000;
                        break;
                    case 2:
                    //Special
                        cost = 4000;
                        Doctor_consultancy = 900;
                        break;
                    case 3:
                    //Single
                        cost = 3000;
                        Doctor_consultancy = 800;
                        break;
                    case 4:
                    //Twin Sharing
                        cost = 2000;
                        Doctor_consultancy = 700;
                        break;
                    case 5:
                    //Triple Sharing
                        cost = 1000;
                        Doctor_consultancy = 600;
                        break;
                    case 6:
                    //ICU
                        cost = 10000;
                        Doctor_consultancy = 2000;
                        break;
                    case 7:
                    //Ventilator
                        cost = 15000;
                        Doctor_consultancy = 3000;
                        break;
                        //Handel the invalid choice entered
                    default:
                        System.out.println(RED+"INVALID CHOICE ENTERED"+RESET);
                }
                // Collect other billing details
                System.out.println("ENTER TREATMENT COST");
                int Treatment_cost = sc.nextInt();
                System.out.println("ENTER MEDICATION COST");
                int Medication_Cost = sc.nextInt();
                System.out.println("ENTER NUMBER OF DAYS");
                int No_days = sc.nextInt();
                System.out.println("TREATMENT COST IS : "+Treatment_cost);
                System.out.println("ROOM CHARGES IS : "+cost*No_days);
                System.out.println("MEDICATION COST IS : "+Medication_Cost);
                System.out.println("DOCTOR FEES IS : "+Doctor_consultancy*No_days);
                // Calculate total cost
                int Total_Amount = (cost * No_days) + Treatment_cost + (Doctor_consultancy*No_days) + Medication_Cost;
                //Print the invoice for a patient
                System.out.println("TOTAL AMOUNT: " + Total_Amount);
				}
                //If the patient is found the na will become false
				else
				{
					na=false;
					System.out.println("APPOINTMENT NOT BOOKED FOR THE PATIENT");
				}
            }
        }
        //na=true the mobile no. searched for the patient is no found
        if (na) {
            System.out.println(RED+"PATIENT NOT FOUND"+RESET);
        }
    }
    // Method to display doctor details
    void Doctor_Details() {
        System.out.println("LIST");
        System.out.println("1. PEDIATRICIAN");
        System.out.println("2. PHYSICIANS");
        System.out.println("3. GYNECOLOGIST");
        System.out.println("4. DENTIST");
        System.out.println("5. ORTHOPAEDIC");
        System.out.println("6. OTHERS");
        System.out.print("ENTER CHOICE : ");
        int choice = sc.nextInt();
        switch (choice) 
        {
            case 1:
            //Pediatrician
            System.out.println("AVAILABLE PEDIATRICIAN");
            System.out.println("-----DOCTOR 1-----");
            System.out.println("NAME        : DR.NUPUR THAKKAR");
            System.out.println("SPECIALITY  : PEDIATRIC SURGERY ");
            System.out.println("-----DOCTOR 2-----");
            System.out.println("NAME        : DR.ASTHA PATEL");
            System.out.println("SPECIALITY  : ADOLESCENT MEDICINE ");
            break;
            case 2 :
            //Physicians
            System.out.println("AVAILABLE PHYSICIAN");
            System.out.println("-----DOCTOR 1-----");
            System.out.println("NAME        : DR.PREXA UPADHYAY");
            System.out.println("SPECIALITY  : FAMILY MEDICINE ");
            System.out.println("-----DOCTOR 2-----");
            System.out.println("NAME        : DR.DIPAK RATHOD");
            System.out.println("SPECIALITY  : INTERNAL MEDICINE ");
            break;
            case 3 :
            //Gynecologist
            System.out.println("AVAILABLE GYNECOLOGIST");
            System.out.println("-----DOCTOR 1-----");
            System.out.println("NAME        : DR.KOMAL LANGALIYA");
            System.out.println("SPECIALITY  : GYNECOLOGIC ONCOLOGISTS ");
            System.out.println("-----DOCTOR 2-----");
            System.out.println("NAME        : DR.ISHA MEDDIRATTA");
            System.out.println("SPECIALITY  : FETAL MEDICINE SPECIALISTS ");
            break;
            case 4 :
            //Dentist
            System.out.println("AVAILABLE DENTIST");
            System.out.println("-----DOCTOR 1-----");
            System.out.println("NAME        : DR.PARTH THAKKAR");
            System.out.println("SPECIALITY  : ORAL SURGEON");
            System.out.println("-----DOCTOR 2-----");
            System.out.println("NAME        : DR.TUSHAR THAKAR");
            System.out.println("SPECIALITY  : PROSTHODONTIC ");
            break;
            case 5 :
            //Orthopaedic
            System.out.println("AVAILABLE ORTHOPAEDIC");
            System.out.println("-----DOCTOR 1-----");
            System.out.println("NAME        : DR.KHUSHBOO SHAH");
            System.out.println("SPECIALITY  : HAND SURGERY ");
            System.out.println("-----DOCTOR 2-----");
            System.out.println("NAME        : DR.UTBAN MAVLI");
            System.out.println("SPECIALITY  : FOOT AND ANKLE REPLACEMENT SURGERY ");
            break;
            case 6 :
            //Others
            System.out.println("OTHER AVAILABLE DOCTORS  ");
            System.out.println("-----DOCTOR 1-----");
            System.out.println("NAME        : DR.HETVI PATEL");
            System.out.println("SPECIALITY  : NEUROLOGIST ");
            System.out.println("-----DOCTOR 2-----");
            System.out.println("NAME        : DR.VED PATEL");
            System.out.println("SPECIALITY  : DERMATOLOGIST ");
            break;
            //Handle incorrect disease entered
            default : System.out.println(RED+"INVALID CHOICE"+RESET);
        }
    }
}