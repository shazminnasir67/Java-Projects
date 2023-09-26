

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProjectFMS {

        static Scanner sc = new Scanner(System.in);
        //RESET
        public static final String RESET = "\033[0m";
        // Bold
        public static final String BLACK_BOLD = "\033[1;30m";  // BLACK

        public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
        public static final String RED_BRIGHT = "\033[0;91m";    // RED
        public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
        public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
        public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
        public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
        public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
        public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

        public static int[] MainScreen() {
            System.out.println(BLUE_BRIGHT+"           ************************************************************************************************************");
            System.out.println("           ************************************************************************************************************"+RESET);
            System.out.printf("%n");
            System.out.println(ANSI_BLUE_BACKGROUND+WHITE_BRIGHT+"                          ✈      WELCOME         TO       FLIGHT     MANAGEMENT       SYSTEM      "+RESET);
            System.out.println("                               ");
            System.out.println(BLUE_BRIGHT+"           ************************************************************************************************************");
            System.out.println("           ************************************************************************************************************"+RESET);


            System.out.printf("%n                                      1- Admin %n                                      2- User %n       ");

            int num = 0;
            String strInput;
            boolean valid = false;
            Scanner sc1 = new Scanner(System.in);
            while (valid == false) {
                System.out.printf(YELLOW_BRIGHT+"%n            Enter serial number in which you are interested :"+RESET);
                strInput = sc1.nextLine();
                try {
                    num = Integer.parseInt(strInput);
                    if (num == 1 || num == 2) {
                        valid = true;
                    } else {
                        System.out.println(RED_BRIGHT+"           please enter a valid serial number between 1 and 4 :"+RESET);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(RED_BRIGHT+"           Error - please enter a valid serial number  :"+RESET);
                }
            }
            int Adminserial = 0;
            if (num == 1) {
                System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
                System.out.println("            Do you want to login as a admin ");
                System.out.printf("%n                     1- Yes %n                     2- No %n       ");
                String adminInput;
                boolean valid1 = false;
                Scanner sc = new Scanner(System.in);
                System.out.printf(YELLOW_BRIGHT+"%n            Enter serial number in which you are interested :"+RESET);
                adminInput = sc.nextLine();
                while (valid1 == false) {

                    try {
                        Adminserial = Integer.parseInt(adminInput);
                        if (Adminserial == 1 || Adminserial == 2) {
                            valid1 = true;
                        } else {
                            System.out.println(RED_BRIGHT+"           please enter a valid serial number between 1 and 4 "+RESET);
                            adminInput = sc.nextLine();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(RED_BRIGHT+"           Error - please enter a valid serial number  "+RESET);
                        adminInput = sc.nextLine();
                    }
                }
            }
            int Userserial = 0;
            if (num == 2) {
                System.out.printf("%n                    1- Create new account %n                    2- Login %n       ");
                String UserInput;
                boolean valid2 = false;
                Scanner sc = new Scanner(System.in);
                System.out.printf(YELLOW_BRIGHT+"%n          Enter serial number in which you are interested :"+RESET);
                UserInput = sc.nextLine();
                while (valid2 == false) {

                    try {
                        Userserial = Integer.parseInt(UserInput);
                        if (Userserial == 1 || Userserial == 2) {
                            valid2 = true;
                        } else {
                            System.out.println(RED_BRIGHT+"           please enter a valid serial number between 1 and 2 :"+RESET);
                            UserInput = sc.nextLine();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(RED_BRIGHT+"           Error - please enter a valid serial number  :"+RESET);
                        UserInput = sc.nextLine();
                    }
                }
            }
            int[] Serials = {Adminserial, Userserial};
            return Serials;
        }

        public static void Registeration() {

            String email = getemail();
            String password = getpassword();
           // System.out.println(password);
            String[] Name = getname();
            String firstname = Name[0];
            String lastname = Name[1];
            String gender = Name[2];
            //System.out.println(firstname + lastname + gender);
            String dob = getdob();
            int age = getAge(dob);
           // System.out.println(age);
            String mobno = getmobilenumber();
           // System.out.println(mobno);
            String address = getAddress();
           // System.out.println(address);
            String cnic = getcnic();
            //System.out.println(cnic);
            try {
                getcsv(firstname, lastname, email, password, gender, mobno, address, cnic, age);
            } catch (IOException e) {

            }
        }

        public  static  int loginscreen(){
            int Loginserial = 0;
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);

            System.out.printf(YELLOW_BRIGHT+"%n                  1- Veiw Information %n                  2- Bookings %n                  3-Flight Status %n                  4- Cancellation %n            5-Exit"+RESET);

            String Input = null;
            boolean valid3 = false;
            Scanner sc3 = new Scanner(System.in);
            System.out.printf(YELLOW_BRIGHT+"%n           Enter serial number in which you are interested :"+RESET);
            Input = sc3.nextLine();
            while (valid3 == false) {
                try {
                    Loginserial = Integer.parseInt(Input);
                    if (Loginserial >= 1 && Loginserial <= 5) {
                        valid3 = true;
                    } else {
                        System.out.println(RED_BRIGHT+"          please enter a valid serial number between 1 and 4 :"+RESET);
                        Input = sc3.nextLine();
                    }
                } catch (NumberFormatException e) {
                    System.out.println(RED_BRIGHT+"           Error - please enter a valid serial number  :"+RESET);
                    Input = sc3.nextLine();
                }
            }return Loginserial;

        }

        public static void Bookings() {

            String[] data = Flights();
            String origin_country = data[0];
            String destination_country = data[1];
            int trip = Integer.parseInt(data[2]);
            int adultseats = Integer.parseInt(data[3]);
            int childseats = Integer.parseInt(data[4]);
            int seatclass = Integer.parseInt(data[5]);
            int row = Integer.parseInt(data[6]);

            String[] fares = Fares(origin_country, destination_country, trip, adultseats, childseats, seatclass, row);
            String flightno = fares[0];
            String TRIP = fares[1];
            String priceperseat = (fares[2]);


            int seats = adultseats + childseats;

//
            System.out.println(GREEN_BRIGHT+"\n           Do yo want to proceed further ? ");
            System.out.println("                       1-yes" +
                    "                                  2-NO"+RESET);
            String strInput;
            int choice = 0;
            boolean valid = false;
            Scanner input2 = new Scanner(System.in);
            try {

                while (valid == false) {

                    strInput = input2.nextLine();

                    choice = Integer.parseInt(strInput);
                    if (choice == 1 || choice == 2) {
                        valid = true;
                    } else {
                        System.out.println(RED_BRIGHT+"           please enter a valid serial number either 1 or 2 :"+RESET);
                    }

                }

                if (choice == 2) {
                    Exit();
                }
                 else {
                    passengersinfo(flightno, adultseats, childseats, origin_country, destination_country, TRIP, priceperseat);
                }

            } catch (NumberFormatException e) {

            }

        }

        //E-MAIL IS A PRIMARY KEY
        public static  boolean StringValidation(String password) {
            boolean valid = false;
            int numofletter=0;
            int numofdigit=0;
            if(password.length()<=25 ){
                for(int i =0 ; i<password.length();i++){
                    char ch = password.charAt(i);
                    if(Character.isLetter(ch)||Character.isDigit(ch)|| password.contains("@")|| password.contains(".")){
                        if(Character.isDigit(ch)){
                            numofdigit++;

                        }
                        else{
                             numofletter++;

                        }
                    }else{
                        System.out.println("Donot contains letters or digits only ");
                        break;
                    }
                }
            }else{
                System.out.println(" Length is not valid ");}
            if(numofdigit>=2 && numofletter>=4){
                valid = true ;
            }else{
                valid = false;
            }
            return valid;
        }
        public static String getemail() {
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            Scanner sc = new Scanner(System.in);
            System.out.println("           <<<<<<<<Let's take your credentials >>>>>>>");
            boolean valid = false;
            System.out.println("           Enter your Email address :");
            System.out.printf("           ------format should  be xyz@gmail.com %n           > ");
            String email = null;
            try {

                while (valid == false) {
                    email = sc.nextLine();
                    boolean value = StringValidation(email);

                    if (value == true) {
                        boolean found=false;
                        if (email.contains("@gmail.com")) {
                           // System.out.println("in loop");
                            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv"));
                            for (String line : lines) {
                                String[] result = line.split(",");
                                for (int i = 0; i < result.length; i++) {
                                   // System.out.println(result[2]);
                                    if ((result[i].equals(email ))) {
                                        System.out.println(GREEN_BRIGHT+"This  E-mail is already registered Try another one "+RESET);
                                        sc.nextLine();
                                        valid = false;
                                        found = true;
                                        break;
                                    } else {
                                        found = false;
                                    }
                                }
                                if (found == true) {
                                    break;
                                }
                            }
                            if (found == false) {
                                valid = true;

                            }

                        }else {
                            System.out.println(RED_BRIGHT+"           Enter a valid format of your E-mail "+RESET);
                        }
                    } else {
                        System.out.println(RED_BRIGHT+"         Email is Not Valid  "+RESET);
                    }
                }
            } catch (Exception e) {
            }

            return email;
        }

       // REMEMBER YOUR PASSWORD YOU CAN CHANGE IT AS WELL
        public static String getpassword() {
            Scanner sc = new Scanner(System.in);
            System.out.println(PURPLE_BRIGHT+"======================================================="+RESET);
            boolean valid = false;
            System.out.println("           Enter your new Password :");
//        System.out.printf("----your password should  be minimun 8 characters and " +
//                "include at least 1 character,digit and letters  %n> ");
            String password = null;
            while (valid == false) {
                password = sc.next();
                int x = password.length();
                if (x >= 8 && x < 20) {
                    while (valid == false) {
                        System.out.println("           Confirm password :");
                        String confirmPassword = sc.next();
                        if (confirmPassword.equals(password)) {
                            valid = true;
                        } else {
                            System.out.println(RED_BRIGHT+"           Please retype exact password "+RESET);
                        }
                    }
                } else {
                    System.out.println(RED_BRIGHT+"           Length must be at least 8 "+RESET);
                }

            }

            return password;
        }

        // PHONE NUMBER TAKEN AS WITHOUT DASHES SO BE CAREFUL
        public static String getmobilenumber() {
            Scanner sc = new Scanner(System.in);
            System.out.println(PURPLE_BRIGHT+"=============================================================="+RESET);
            System.out.println("           Enter your mobile number please :");
            String mobilenumber = sc.next();
            int i = 0;
            while (mobilenumber.length() != 11 || i != mobilenumber.length()) {
                char x = mobilenumber.charAt(i);
                i++;
                if (!(Character.isDigit(x))) {
                    System.out.println(RED_BRIGHT+"           Please Enter your valid mobile number :"+RESET);
                    mobilenumber = sc.next();
                    i = 0;
                }

                if (mobilenumber.length() != 11) {
                    System.out.println(RED_BRIGHT+"           Lenght must not exceed 11 "+RESET);
                    mobilenumber = sc.next();

                }
            }
            return mobilenumber;
        }

        //FIRST NAME LAST NAME AND GENDER

        public static String[] getname() {
            System.out.println(PURPLE_BRIGHT+"====================================================="+RESET);
            System.out.println("           <<<<< Your personal  details >>>>");
            Scanner sc = new Scanner(System.in);
            System.out.println("           Enter your First name as per passport :");
            String firstName = sc.next();
            int i = 0;
            while (!(firstName.length() <= 11) || i != firstName.length()) {
                char x = firstName.charAt(i);
                i++;
                if (!(Character.isAlphabetic(x))) {
                    System.out.println(RED_BRIGHT+"           Your name should only contain letters:"+RESET);
                    firstName = sc.next();
                    i = 0;
                }
                if (!(firstName.length() <= 12)) {
                    System.out.println(RED_BRIGHT+"           error - Your name length should me maximum 11 leters "+RESET);
                    firstName = sc.next();
                }
            }System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            System.out.println("           Enter your Last name as per passport :");
            String lastName = sc.next();
            int j = 0;
            while (!(lastName.length() <= 11) || j != lastName.length()) {
                char x = lastName.charAt(j);
                j++;
                if (!(Character.isAlphabetic(x))) {
                    System.out.println(RED_BRIGHT+ "           Your name should only contain letters:"+RESET);
                    lastName = sc.next();
                    j = 0;
                }
                if (!(lastName.length() <= 12)) {
                    System.out.println(RED_BRIGHT+"           error - Your name length should me maximum 11 leters "+RESET);
                    lastName = sc.next();
                }
            }System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            System.out.println("           <<<<<<<Gender>>>>>> ");
            Scanner sc1 = new Scanner(System.in);
            boolean valid = false;
            String gender = "";
            while (valid == false) {
                System.out.println("           Enter Male or Female :");
                gender = sc1.nextLine();
                if (gender.toLowerCase().equals("male")) {
                    valid = true;
                } else if (gender.toLowerCase().equals("female")) {
                    valid = true;
                } else {
                    System.out.println(RED_BRIGHT+"           Please enter your gender again >"+RESET);
                }
            }
            String[] namegender = new String[3];
            namegender[0] = firstName;
            namegender[1] = lastName;
            namegender[2] = gender;


            return namegender;
        }

        //DATE MUST BE ENTER THAT MATCHES THE FORMAT
       //SOME VALIDATION OF PARSE IS LEFT

        public static String getdob() {
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            boolean format = false;
            Scanner sc = new Scanner(System.in);
            String dob;
            do {
                System.out.println("           Please Enter your Date of birth in format (DD/MM/YYYY)");
                dob = sc.nextLine();
                try {
                    Date date = new SimpleDateFormat("dd/mm/yyyy").parse(dob);
                    System.out.println("           Your date of birth is " + dob);
                    format = true;
                } catch (ParseException | DateTimeException e) {
                    System.out.println(RED_BRIGHT+"           Please Enter your valid date of birth "+RESET);
                }
            } while (!(format));


            return dob;
        }

        // AGE CAN BE CANCULATED AUTOMATICALLY

        public static int getAge(String dob) throws DateTimeException {
            int years = 0;
            try {

                LocalDate today = LocalDate.now();
                String[] DOB = dob.split("/");
                int date = Integer.parseInt(DOB[0]);
                int month = Integer.parseInt(DOB[1]);
                int year = Integer.parseInt(DOB[2]);
                var dOB = LocalDate.of(year, month, date);
                years = Period.between(dOB, today).getYears();
            } catch (Exception e) {
            }
            return years;
        }
         public static String getAddress() {
        System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
        Scanner sc = new Scanner(System.in);
        int num, num1;
        boolean valid = false;
        String streetno = null;
        String houseno = null;
        while (valid == false) {
            System.out.println("           Enter street number :");
            streetno = sc.nextLine();
            System.out.println("           Enter House/flat number :");
            houseno = sc.nextLine();
            try {
                num = Integer.parseInt(streetno);
                num1 = Integer.parseInt(houseno);

                if ((num >= 1) && (num <= 200) && (num1 >= 1) && (num1 <= 200)) {
                    valid = true;
                } else {
                    System.out.println(RED_BRIGHT+"           Enter between range 1-200"+RESET);
                }

            } catch (NumberFormatException e) {
                System.out.println(RED_BRIGHT+"          Error - please enter a valid street number and house number  :"+RESET);
            }
        }
        String city = null;
        String country = null;
        try {
            System.out.println(YELLOW_BRIGHT+"           Enter city :");

            boolean format = true;
            while (format==true) {
                city = sc.nextLine();
                for (int i = 0; i < city.length(); i++) {
                    char x = city.charAt(i);
                    if ((Character.isAlphabetic(x)) && city.length() <= 10) {
                        if (i == city.length() - 1) {
                            format = false;
                        }
                    }
                    else {
                        System.out.println(RED_BRIGHT + "           Enter valid city :" + RESET);
                        break;
                    }
                } if (format==false){
                    break;
                }
            }
            System.out.println("           Enter country :"+RESET);
            while (format==false){
                country = sc.nextLine();
                for (int i = 0; i < country.length(); i++) {
                    char x = country.charAt(i);
                    if ((Character.isAlphabetic(x)) && country.length() <= 10) {

                        if (i==country.length()-1){
                            format=true;

                        }

                    }else {
                        System.out.println(RED_BRIGHT+"           Enter valid country :"+RESET);
                        sc.nextLine();
                        break;
                    }
                }if (format==true){
                    break;
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(RED_BRIGHT+"           please Enter your valid address :"+RESET);
        }

        return streetno.concat("," + houseno + "," + city + "," + country);
    }

        //CNIC IS A PRIMARY KEY SO ALWAYS ENTER NON REGISTERED CNIC NUMBER WITHOUT DASHES
        public static String getcnic() {
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            Scanner sc = new Scanner(System.in);
            String cnic = null;
            boolean format = false;

            while (format == false) {
                System.out.println("           Enter your CNIC please without dashes : ");
                cnic = sc.nextLine();
                if (cnic.length() == 13) {
                    boolean loop = false;
                    for (int i = 0; i < cnic.length(); i++) {
                        char x = cnic.charAt(i);
                        if (Character.isDigit(x)) {
                            loop = true;
                        }
                    }
                    if (loop == true) {
                        List<String> lines = null;
                        try {
                            lines = Files.readAllLines(Paths.get("D:\\Bookings.csv"));
                        } catch (Exception e) {

                        }
                        boolean found = true;
                        for (String line : lines) {
                            String[] result = line.split(",");
                            for (int i = 0; i < result.length; i++) {
                                if ((result[i].equals("\"" + cnic + "\""))) {
                                    System.out.println(GREEN_BRIGHT+"           This  CNIC is already registered Try another one :"+RESET);
                                    format = false;
                                    found = true;
                                    break;
                                } else {
                                    found = false;
                                }
                            }
                            if (found == true) {
                                break;

                            }
                        }
                        if (found == false) {
                            format = true;

                        }

                    }

                }
            }

            return cnic;
        }

        public static void getcsv(String firstname, String lastname, String email, String password, String gender, String mobno, String address, String cnic, int age) throws IOException {
            try {
                File file = new File("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv");
                if (file.createNewFile()) {
                    String header = "FirstName,LastName,Email,Password,Gender,Contact no,Address,Cnic,Age";
                    List<String[]> listinfo = new ArrayList<String[]>();
                    String[] s = {firstname, lastname, email, password, gender, mobno, address, cnic, String.valueOf(age)};
                    listinfo.add(s);

                    FileWriter fw = new FileWriter(file, true);
                    fw.append(header);
                    fw.append("\n");
                    CSVWriter csv = new CSVWriter(fw);
                    csv.writeAll(listinfo);
                    csv.close();
                    fw.close();
                } else {
                    List<String[]> listinfo = new ArrayList<String[]>();
                    String[] s = {firstname, lastname, email, password, gender, mobno, address, cnic, String.valueOf(age)};
                    listinfo.add(s);
                    FileWriter fw = new FileWriter(file, true);
                    CSVWriter csv = new CSVWriter(fw);

                    csv.writeAll(listinfo);
                    csv.close();
                    fw.close();
                }

            } catch (IOException e) {
               // e.printStackTrace();
            }
        }

        public static String [] Login() {
            String email = null;
            String password = null;
            try {
                System.out.println("           To Login Enter your Email :");
                Scanner sc = new Scanner(System.in);
                System.out.printf("           ------format should  be xyz@gmail.com %n> ");
                boolean valid = false;
                email = null;
                while (valid == false) {
                    email = sc.next();
                    int x = email.length();
                    if (x < 25) {
                        if (email.contains("@gmail.com")) {
                            valid = true;
                        } else {
                            System.out.println("           Enter a valid format of your E-mail :");
                        }
                    } else {
                        System.out.println("           Length must not exceed than 20 :");
                    }
                }
                boolean valid2 = false;
                System.out.println("           Enter  your  Password :");
                password = null;
                password = sc.next();

                boolean notfound = false;
                List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv"));
                for (String line : lines) {
                    line = line.replace("\"", "");
                    String[] result = line.split(",");

                    if ((result[2].equals(email)) && (result[3].equals(password))) {
                        System.out.println("           logged on");
                        System.out.println("            ");
                        for (int i =0;i<17;i++){
                            try{Thread.sleep(400);}catch(InterruptedException e){}
                            System.out.print("*");
                        }
                        notfound = false;
                        break;
                    } else {
                        notfound = true;
                    }
                }

                if (notfound) {
                    System.out.println("           Did you forget your password ?:");
                    Scanner sc1 = new Scanner(System.in);
                    boolean valid3 = false;
                    String choice = "";
                    while (valid3 == false) {
                        System.out.println("           Enter Yes or NO :");
                        choice = sc1.nextLine();
                        if (choice.toLowerCase().equals("yes")) {
                            valid3 = true;
                        } else if (choice.toLowerCase().equals("no")) {
                            valid3 = true;
                        } else {
                            System.out.println("           Please enter your choice again >");
                        }
                    }
                    if (choice.equalsIgnoreCase("yes")) {
                        updatecsv();
                    } else {
                        Login();

                    }
                }
            } catch (IOException e) {
            }
            String[] cred = {email, password};
            return cred;
        }

        public static void updatecsv() {
            Scanner sc = new Scanner(System.in);
            System.out.println("           Enter your registered email for verificaton :");
            String veremail = sc.nextLine();
            try {
                List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv"));
                int coulumn = 3;
                int row = 0;
                int count = 0;
                String newpassword = null;
                for (String line : lines) {
                    line = line.replace("\"", "");
                    String[] result = line.split(",");
                    count++;
                    for (int i = 0; i < result.length; i++) {
                        if (result[i].equals(veremail)) {
                            System.out.println("           Enter your CNIC for verification");
                            String cnic = sc.nextLine();
                            System.out.println(result[i + 8]);
                            if (result[i + 8].equals(cnic)) {
                                newpassword = getpassword();
                                row = --count;

                            } else {
                                System.out.println("Pardon! CNIC not found");
                            }
                        }
                    }

                }
                System.out.println(row);
                System.out.println(coulumn);
                if ((newpassword != null)) {

                    String filepath = "C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv";
                    File inputfile = new File(filepath);
                    CSVReader reader = new CSVReader(new FileReader(inputfile));
                    List<String[]> csvbody = reader.readAll();
                    csvbody.get(row)[coulumn] = newpassword;
                    reader.close();
                    CSVWriter writer = new CSVWriter(new FileWriter(inputfile));
                    writer.writeAll(csvbody);
                    System.out.println("           UPDATED");
                    for (int i =0;i<10;i++){
                        try{Thread.sleep(500);}catch(InterruptedException e){}
                        System.out.print("*");
                    }
                    writer.flush();
                    writer.close();
                }

            } catch (IOException | CsvException e) {
            }
        }

        public static int regions() {
            System.out.println("           Which continent you want to land-in :");
            System.out.printf("%n                                 1-   Asia  " +
                    "%n                                  2-   Africa " +
                    "%n                                  3-   North America " +
                    "%n                                  4-   Middle East " +
                    "%n                                  5-   Europe " +
                    "%n                                  6 -  EXIT    " );

            int serial1 = 0;
            String strInput1;
            boolean valid1 = false;
            System.out.println("          Enter serial number in which you are interested :");
            strInput1 = sc.next();
            while (valid1 == false) {

                try {
                    serial1 = Integer.parseInt(strInput1);

                    if (serial1==6) {
                        Exit();
                        break;
                    }
                    if (serial1 >= 1 && serial1 <= 5) {
                            valid1 = true;
                    }

                     else {
                        System.out.println("           please enter a valid serial number between  1 and 6 ");
                        strInput1 = sc.nextLine();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("           Error - please enter a valid serial number");
                    strInput1 = sc.nextLine();
                }

            }
            return serial1;
        }

        public static int Asia(int serial1) {
            int serial2 = 0;
            if (serial1 == 1) {
                System.out.println("           Which country you want to land-in :");
                System.out.printf("%n                                  1-   UAE  " +
                        "%n                                  2-   CHINA " +
                        "%n                                  3-   JAPAN " +
                        "%n                                  4-   MALAYSIA " +
                        "%n                                  5-   PAKISTAN " +
                        "%n                                  6-   MALDIVES  " +
                        "%n                                  7-   SINGAPORE" +
                        "%n                                  8-   NEPAL  " +
                        "%n                                  9-   Back to the continents ");
                Scanner sc3 = new Scanner(System.in);
                serial2 = 0;
                String strInput2;
                boolean valid2 = false;
                System.out.println();

                while (valid2 == false) {
                    System.out.println("           Enter serial number 1 to type country or 9 to Back screen :");
                    strInput2 = sc3.nextLine();
                    try {
                        serial2 = Integer.parseInt(strInput2);
                        if (serial2==9){
                            Exit();
                            break;
                        }
                        if (serial2 == 1) {
                            valid2 = true;
                        }
                        else {
                            System.out.println("           Enter number  1 or 9 ");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("           Error - please enter a valid serial number");
                    }

                }

            }
            return serial2;

        }

        public static int Africa(int serial1) {
            int serial3 = 0;
            if (serial1 == 2) {
                System.out.println("           Which country you want to land-in :");
                System.out.printf("%n                                  1-   MOROCCO  " +
                        "%n                                  2-   SUDAN " +
                        "%n                                  3-   ZIMBABWE " +
                        "%n                                  4-   LIBYA " +
                        "%n                                  5-   SOUTH AMERICA " +
                        "%n                                  6-   KENYA " +
                        "%n                                  7-   Back to the continents");
                Scanner sc4 = new Scanner(System.in);


                serial3 = 0;
                String strInput2;
                boolean valid2 = false;

                while (valid2 == false) {
                    System.out.println("            Enter serial number 1 to type country or 9 to Back screen :");
                    strInput2 = sc4.nextLine();
                    try {
                        serial3 = Integer.parseInt(strInput2);
                        if (serial3==7){
                            Exit();
                            break;
                        }
                        if (serial3 == 1 ) {
                            valid2 = true;
                        } else {
                            System.out.println("           please enter a valid serial number  1 or 7 :");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("           Error - please enter a valid serial number");
                    }
                }
            }
            return serial3;
        }

        public static int NorthAmerica(int serial1) {
            int serial4 = 0;
            if (serial1 == 3) {
                System.out.println("           Which country you want to land-in :");

                System.out.printf("%n                                  1-   CANADA  " +
                        "%n                                  2-   MEXICO " +
                        "%n                                  3-   UNITED STATES " +
                        "%n                                  4-   GREEN LAND " +
                        "%n                                  5-   AUSTRALIA " +
                        "%n                                  6-   Back to the continents ");
                Scanner sc5 = new Scanner(System.in);

                serial4 = 0;
                String strInput2;
                boolean valid2 = false;
                System.out.println("           Enter serial number 1 to type country or 6 to Back screen :");
                strInput2 = sc5.nextLine();
                while (valid2 == false) {

                    try {
                        serial4 = Integer.parseInt(strInput2);
                        if (serial4==6){
                            Exit();
                            break;
                        }
                        if (serial4 == 1 ) {

                            valid2 = true;
                        } else {
                            System.out.println("           Enter number between 1 and  6 ");
                            strInput2 = sc5.nextLine();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("           Error - please enter a valid serial number");
                        strInput2 = sc5.nextLine();
                    }
                }
            }
            return serial4;
        }

        public static int MiddleEast(int serial1) {
            int serial5 = 0;
            if (serial1 == 4) {
                System.out.println("           Which country you want to land-in :");

                System.out.printf("%n                                  1-   Saudia Arabia  " +
                        "%n                                  2-   TURKEY " +
                        "%n                                  3-   EGYPT " +
                        "%n                                  4-   KUWAIT " +
                        "%n                                  5-   QATAR " +
                        "%n                                  6-   Iran" +
                        "%n                                  7-   Back to the continents ");
                Scanner sc5 = new Scanner(System.in);
                serial5 = 0;
                String strInput2;
                boolean valid2 = false;
                System.out.println("           Enter serial number 1 to type country or 7 to Back screen :");
                strInput2 = sc5.next();
                while (valid2 == false) {
                    try {
                        serial5 = Integer.parseInt(strInput2);
                        if (serial5==7){
                            Exit();
                            break;
                        }
                        if (serial5 == 1 ) {

                            valid2 = true;
                        } else {
                            System.out.println("            Please enter a valid serial number  1 or 7 :");
                            strInput2 = sc5.nextLine();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("           Error - please enter a valid serial number");
                        strInput2 = sc5.nextLine();
                    }
                }
            }
            return serial5;
        }

        public static int Europe(int serial1) {
            int serial6 = 0;
            if (serial1 == 5) {
                System.out.println("           Which country you want to land-in :");

                System.out.printf("%n                                  1-   GERMANY  " +
                        "%n                                  2-   ITALY " +
                        "%n                                  3-   GREECE " +
                        "%n                                  4-   BELGIUM " +
                        "%n                                  5-   HUNGRY " +
                        "%n                                  6-   IRELAND" +
                        "%n                                  7-   SPAIN " +
                        "%n                                  8-   DENMARK" +
                        "%n                                  9-   EXIT ");
                Scanner sc5 = new Scanner(System.in);
                serial6 = 0;
                String strInput2;
                boolean valid2 = false;
                System.out.println("           Enter serial number 1 to type country or 9 to Back screen :");
                strInput2 = sc5.next();
                while (valid2 == false) {

                    try {
                        serial6 = Integer.parseInt(strInput2);
                        if (serial6 == 9){
                            Exit();
                            break;
                        }
                        if (serial6 == 1 ) {

                            valid2 = true;
                        } else {
                            System.out.println("           please enter a valid serial number  1 or 9 :");
                            strInput2 = sc5.nextLine();
                        }
                    } catch (Exception e) {
                        System.out.println("           Error - please enter a valid serial number");
                        strInput2 = sc5.nextLine();
                    }
                }
            }
            return serial6;
        }

        public static String[] Flights() {
            String[] values = new String[0];

            boolean notfound = false;
            try {
                int row = 0;
                String destination = null;
                String origin_country = null;
                while (notfound == false) {
                    System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
                    System.out.println("                    |||||||||||||   FROM   |||||||||||||");
                    origin_country = sc.next();
                    System.out.println("                    ||||||||||||||   TO   ||||||||||||||");
                    destination = sc.next();
                    List<String> lines = Files.readAllLines(Paths.get("Schedule.csv"));
                    for (String line : lines) {
                        line = line.replace("\"", "");
                        String[] result = line.split(",");
                        for (int i = 0; i < result.length; i++) {
                            if ((result[i].equals(origin_country)) && (result[i + 1].equals(destination))) {
                                System.out.println("found");
                                notfound = true;
                                break;
                            } else {
                                notfound = false;
                            }
                        }
                        row++;
                        if (notfound == true) {
                            notfound = true;
                            break;
                        }
                    }
                    if (notfound == false) {
                        System.out.println("           Enter Again >");
                    }

                }System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
                System.out.println("                   |||||||||||||   TRIP   |||||||||||||");

                System.out.printf("%n                                  1-   ONE WAY  " +
                        "%n                                  2-   RETURN ");

                String strInput2;
                int serialnum = 0;
                boolean valid2 = false;
                Scanner input = new Scanner(System.in);
                while (valid2 == false) {

                    System.out.println("\n           Enter serial number in which you are interested :");
                    strInput2 = input.nextLine();
                    try {
                        serialnum = Integer.parseInt(strInput2);
                        if (serialnum == 1 || serialnum == 2) {
                            valid2 = true;
                        } else {
                            System.out.println(RED_BRIGHT + "           PLEASE! enter a valid serial number either 1 or 2 " + RESET);
                        }
                    } catch (Exception e) {

                    }
                }
                int adultseats = 0;
                String strInput3;
                boolean valid3 = false;
                System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
                while (valid3 == false) {

                    System.out.println("           Enter the number of adult seats you want to reserve :");
                    strInput3 = input.nextLine();
                    try {
                        adultseats = Integer.parseInt(strInput3);
                        if (adultseats >= 0 && adultseats <= 9) {
                            valid3 = true;
                        } else {
                            System.out.println(RED_BRIGHT + "            PLEASE! enter a valid seats  maximum can be 9 " + RESET);
                        }
                    } catch (NumberFormatException e) {
                    }

                }
                int childseats = 0;

                if (adultseats != 9) {
                    String strInput4;
                    boolean valid4 = false;
                    System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);

                    while (valid4 == false) {

                        System.out.println("            Enter the number of child seats you want to reserve :");
                        strInput4 = input.nextLine();

                        try {
                            childseats = Integer.parseInt(strInput4);
                            if (childseats >= 0 && childseats <= (9 - adultseats)) {
                                valid4 = true;
                            } else {
                                System.out.println(RED_BRIGHT + "          PLEASE! Enter a valid seats  maximum child seats  can be " + (9 - adultseats) + RESET);
                            }

                        } catch (Exception e) {

                        }
                    }
                }System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
                System.out.println("                  |||||||||||||||||    CLASS     ||||||||||||||||");
                System.out.printf("%n                                  1-   ECONOMY CLASS  " +
                        "%n                                  2-   BUSINESS/First CLASS ");

                String strInput5;
                int serialNum = 0;
                boolean valid5 = false;
                Scanner input2 = new Scanner(System.in);
                while (valid5 == false) {

                    System.out.println("\n           Enter a serial number in which you are interested :");
                    strInput5 = input2.nextLine();
                    try {
                        serialNum = Integer.parseInt(strInput5);
                        if (serialNum == 1 || serialNum == 2) {
                            valid5 = true;
                        } else {
                            System.out.println("           PLEASE! enter a valid serial number either 1 or 2 :");
                        }
                    } catch (NumberFormatException e) {
                        throw new RuntimeException(e);
                    }
                }
                values = new String[]{origin_country, destination, String.valueOf(serialnum), String.valueOf(adultseats), String.valueOf(childseats), String.valueOf(serialNum), String.valueOf(row)};

            } catch (Exception e) {

            }

            return values;
        }

        public static String[] Fares(String origin_country, String destination_country, int trip, int adultseats, int childseats, int seatclass, int row) {
            String[] fares = new String[0];
            row--;
            try {
                String filepath = "C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv";
                File inputfile = new File(filepath);
                CSVReader reader = new CSVReader(new FileReader(inputfile));
                List<String[]> csvbody = reader.readAll();

                String arrival_time = csvbody.get(row)[2].replace("\"", "");
                String depart_time = csvbody.get(row)[3].replace("\"", "");
                String Date = csvbody.get(row)[4].replace("\"", "");
                String flightno = csvbody.get(row)[5].replace("\"", "");

                reader.close();
                double totalprice = 0;
                double priceofone = 0;
                int totalseats = adultseats + childseats;
                if (trip == 1 && seatclass == 1) {

                    long price = 130000;

                    int increment = (int) (Math.random() * 40) + 10;
                    priceofone = price + (price * (increment / 100.0));
                    totalprice = totalseats * (price + (price * (increment / 100.0)));

                }
                if (trip == 1 && seatclass == 2) {
                    long price = 150000;
                    int increment = (int) (Math.random() * 40) + 30;
                    priceofone = price + (price * (increment / 100.0));
                    totalprice = totalseats * (price + (price * (increment / 100.0)));
                }
                if (trip == 2 && seatclass == 1) {
                    long price = 130000;

                    int increment = (int) (Math.random() * 40) + 10;
                    priceofone = 2 * (price + (price * (increment / 100.0)));
                    totalprice = 2 * (totalseats * (price + (price * (increment / 100.0))));
                }
                if (trip == 2 && seatclass == 2) {
                    long price = 150000;
                    int increment = (int) (Math.random() * 40) + 20;
                    priceofone = 2 * (price + (price * (increment / 100.0)));
                    totalprice = 2 * (totalseats * (price + (price * (increment / 100.0))));
                }
                String Trip = null;
                if (trip == 1) {
                    Trip = "Economy";
                } else if (trip == 2) {
                    Trip = "Business/First";

                }
                System.out.printf("|---------------------------------------------------------------------------------------------|" +
                        "\n|                                                                       |---------------------|" +
                        "\n|    %5s           %s             %5s                    |   %-5s           |" +
                        "\n|                                                                       |  PKR " + totalprice + "       |" +
                        "\n|                                                                       |---------------------|" +
                        "\n|---------------------------------------------------------------------------------------------|", arrival_time, Date, depart_time, Trip);

                fares = new String[]{flightno, Trip, String.valueOf(priceofone)};
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return fares;
        }

        public static void bookingcsv(String[] info) {
            String flightno = info[0];
            String firstname = info[1];
            String lastname = info[2];
            String gender = info[3];
            int age = Integer.parseInt(info[4]);
            String cnic = info[5];
            String passportnumber = info[6];
            String nationality = info[7];
            String expiry = info[8];
            String origin = info[9];
            String dest = info[10];
            String Trip = info[11];
            String totalseats = info[13];
            String priceperseat = (info[12]);


            try {
                File file = new File("C:\\Users\\HOME\\IdeaProjects\\FMS\\Bookings.csv");
                if (file.createNewFile()) {
                    String header = "Flight no,FirstName,LastName,Gender,Age,CNIC NO,Passport No,Nationality,Expiry Date of Passport,Origin,Destination,Trip Class,Ticket Price,Seat No";
                    List<String[]> listinfo = new ArrayList<String[]>();
                    String seatno = seatnum(flightno, origin, dest, totalseats);
                    String[] s = {flightno, firstname, lastname, gender, String.valueOf(age), cnic, passportnumber, nationality, expiry, origin, dest, Trip, String.valueOf(priceperseat), seatno};
                    listinfo.add(s);

                    FileWriter fw = new FileWriter(file, true);
                    fw.append(header);
                    fw.append("\n");
                    CSVWriter csv = new CSVWriter(fw);
                    csv.writeAll(listinfo);
                    csv.close();
                    fw.close();
                } else {
                    List<String[]> listinfo = new ArrayList<String[]>();
                    String seatNO = seatnum(flightno, origin, dest, totalseats);

                    String[] s = {flightno, firstname, lastname, gender, String.valueOf(age), cnic, passportnumber, nationality, expiry, origin, dest, Trip, priceperseat, seatNO};
                    listinfo.add(s);
                    System.out.println("           YOUR RECORD HAS BEEN ADDED");
                    FileWriter fw = new FileWriter(file, true);
                    CSVWriter csv = new CSVWriter(fw);

                    csv.writeAll(listinfo);
                    csv.close();
                    fw.close();
                }

            } catch (IOException e) {
                //e.printStackTrace();
            }
        }

        public static String[] passengersinfo(String flightno, int adultseats, int childseats, String origin_country, String destination, String TRIP, String priceperseat) {

            String[] info = new String[0];
            for (int j = 1; j <= (adultseats + childseats); j++) {
                System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
                System.out.println("           <<<<<<<<PASSENGERS DETAILS>>>>>>>>>>>");
                System.out.println("                    FOR  PASSENGER " + j);
                String[] Name = getname();
                String firstname = Name[0];
                String lastname = Name[1];
                String gender = Name[2];
                String cnic = getcnic();
                String dob = getdob();
                int age = getAge(dob);
                Scanner sc = new Scanner(System.in);
                String passportnumber = null;
                boolean format = true;

                while (format) {
                    System.out.println("           Enter your passport number please :");
                    System.out.println("           IN A FORMAT FIRST 2 LETTERS & 7 DIGITS :");
                    passportnumber = sc.nextLine();
                    if (passportnumber.length() == 9) {
                        for (int i = 2; i < passportnumber.length(); i++) {
                            char c = passportnumber.charAt(i);
                            if (Character.isLetter(passportnumber.charAt(0)) && Character.isLetter(passportnumber.charAt(1)) && Character.isDigit(passportnumber.charAt(i))) {
                                if (i == 8) {
                                    try {
                                        boolean found = true;
                                        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Bookings.csv"));
                                        for (String line : lines) {
                                            line = line.replace("\"", "");
                                            String[] result = line.split(",");
                                            for (int k = 0; k < result.length; k++) {
                                                if ((result[k].equals(passportnumber))) {
                                                    System.out.println("           Someone is already registered with the same passport number Try another one :");
                                                    format = false;
                                                    found = true;
                                                    break;
                                                } else {
                                                    found = false;
                                                }
                                            }
                                            if (found == true) {
                                                break;
                                            }
                                        }
                                        if (found == false) {
                                            format = true;
                                        }
                                    } catch (Exception e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("           Please Enter a valid Passport number Check again >");
                    }
                }
                boolean format1 = false;
                String expiry;
                do {
                    System.out.println("           Please Enter your passport Date of expiry in format (DD/MM/YYYY)");
                    expiry = sc.nextLine();
                    try {
                        Date date = new SimpleDateFormat("dd/mm/yyyy").parse(expiry);
                        System.out.println("           Your passport date of expiry is " + expiry);
                        String dateParts[] = expiry.split("/");
                        // Getting day, month, and year
                        // from date
                        String day = dateParts[0];
                        String month = dateParts[1];
                        String year = dateParts[2];
                        if ((Integer.parseInt(year) > 2022) && Integer.parseInt(month) <= 12 && Integer.parseInt(day) <= 31) {
                            format1 = true;
                        }
                    } catch (ParseException e) {
                        System.out.println("           Please Enter your valid passport date of expiry ");
                    }
                } while (!(format1));
                System.out.println("");
                System.out.println("           Enter your Nationality as per passport :");
                String nationality = sc.nextLine();
                int i = 0;
                while (!(nationality.length() <= 16) || i != nationality.length()) {
                    char x = nationality.charAt(i);
                    i++;
                    if (!(Character.isAlphabetic(x))) {
                        System.out.println("           Your country should only contain letters:");
                        nationality = sc.next();
                        i = 0;
                    }
                    if (!(nationality.length() <= 12)) {
                        System.out.println("           Error - Your nationality length should me maximum of 20 leters ");
                        nationality = sc.next();
                    }
                }
                info = new String[]{flightno, firstname, lastname, gender, String.valueOf(age), cnic, passportnumber, nationality, expiry, origin_country, destination, TRIP, String.valueOf(priceperseat), String.valueOf(adultseats + childseats)};
                bookingcsv(info);
            }
            return info;
        }

        public static String seatnum(String flightnum, String origin, String destination, String totalseats) {

            String seats;
            String seatnum = null;
            boolean avaialable = false;
            CSVReader reader = null;
            try {
                List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv"));
                String filepath = "C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv";
                File inputfile = new File(filepath);
                reader = new CSVReader(new FileReader(inputfile));
                List<String[]> csvbody = reader.readAll();
                int count = 0;
                for (String line : lines) {
                    line = line.replace("\"", "");
                    String[] result = line.split(",");
                    if ((result[0].equals(origin)) && (result[1].equals(destination)) && result[5].equals(flightnum)) {

                        seats = csvbody.get(count)[6];
                        if (Integer.parseInt(seats) > 0) {
//                        avaialable = true;
                            String newseat = String.valueOf(Integer.parseInt(seats) - Integer.parseInt(totalseats));
                            //System.out.println("found");
                            csvbody.get(count)[6] = newseat;
                            reader.close();
                            CSVWriter writer = new CSVWriter(new FileWriter(inputfile));
                            writer.writeAll(csvbody);
                            writer.flush();
                            writer.close();

                            break;
                        }
                    }
                    count++;
                }

                List<String> Line = null;
                try {
                    Line = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Bookings.csv"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                int c = 0;
                for (String list : Line) {
                    list = list.replace("\"", "");
                    String[] result1 = list.split(",");
                    System.out.println(result1[0]);
                    String filepath1 = "C:\\Users\\HOME\\IdeaProjects\\FMS\\Bookings.csv";
                    File inputfile1 = new File(filepath1);
                    CSVReader reader1 = null;
                    if (result1[0].equals(flightnum)) {
                        try {
                            reader1 = new CSVReader(new FileReader(inputfile1));
                            List<String[]> csvbody1 = reader1.readAll();
                            String seatprev = (csvbody1.get(c)[13]);
                            String sub = seatprev.substring(1);
                            int seatpnew = Integer.parseInt(sub) + 1;
                            seatnum = "A".concat(String.valueOf(seatpnew));
                            //System.out.println("Changed");
                            reader1.close();
                            CSVWriter writer = new CSVWriter(new FileWriter(inputfile1));
                            writer.writeAll(csvbody1);
                            writer.flush();
                            writer.close();
                        } catch (IOException | CsvException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        seatnum = "A" + 1;
                        //System.out.println("           NOT FOUND");
                    }
                    c++;
                }


            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            return seatnum;
        }

        public static boolean adminlogin() {
            Scanner sn = new Scanner(System.in);
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            System.out.println("           <<<<<<<<<<ADMIN Login>>>>>>>");
            //System.out.println("Enter username of the admin");
            // String username = sn.nextLine();
            // System.out.println("Enter password of the admin");
            // String pass = sn.nextLine();
            int k = 0;
            boolean value =false;
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            while (k == 0) {
                System.out.println("           Enter username of the admin");
                String username = sn.nextLine();
                System.out.println("           Enter password of the admin");
                String pass = sn.nextLine();
                if (username.equals("admin") && pass.equals("admin")) {
                    k = 1;
                    System.out.println("          Login Successfull");
                    value = true;

                    break;
                } else {
                    System.out.println("           unsuccessfull");

                    k = 0;
                }
            }
            return value ;
        }

        public static int checknumber() {
            Scanner sn = new Scanner(System.in);
            int num;
            while (true) {
                try {
                    //System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
                    System.out.println("           Enter Choice");
                    num = sn.nextInt();
                    if (num > 0 && num < 6) {
                        return num;
                    } else {
                        System.out.println("           Invalid Input !");
                    }
                } catch (Exception e) {
                    System.out.println("           Invalid Input ! Enter Again");
                    // System.out.println("Enter again");
                    sn.nextLine();
                }
            }
        }

        public static void updatefirstname() {
            Scanner sn = new Scanner(System.in);

            int count = 0;
            String s = "";
            try {
                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    s = Files.readAllLines(Paths.get("Login23.csv")).get(x);
                    count++;


                }
            } catch (Exception e) {
                //System.out.println("A");
            }

           // System.out.println("           Value of count = " + count);
            String[] dataarray = new String[count];
            String nic = getcnic();
            //   Scanner sn = new Scanner(System.in);

            // String firstname = sn.next();


            String s1 = "";
            String s2 = "";
            String s3 = "";
            String s4 = "";
            String s5 = "";
            try {System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
                System.out.println("           Enter New First name");

                String firstName = sn.next();
                int i = 0;
                while (!(firstName.length() <= 11) || i != firstName.length()) {
                    char x = firstName.charAt(i);
                    i++;
                    if (!(Character.isAlphabetic(x))) {
                        System.out.println("           Your name should only contain letters:");
                        firstName = sn.next();
                        i = 0;
                    }
                    if (!(firstName.length() <= 12)) {
                        System.out.println("           error - Your name length should me maximum 11 leters ");
                        firstName = sn.next();
                    }
                }
                boolean check1 = false;

                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    check1 = Files.readAllLines(Paths.get("Login23.csv")).get(x).contains(nic);
                    //System.out.println(nic);
                    s1 = Files.readAllLines(Paths.get("Login23.csv")).get(x);
                    if (check1) {
                        s2 = s1.substring(0, s1.indexOf(",") + 1);
                        s3 = s1.substring(s1.indexOf(","));
                        s4 = firstName + s3;
                        //     System.out.println("s4 ="+s4);
                        dataarray[x] = s4;

                    } else {


                        dataarray[x] = s1;
                    }
                }
            } catch (Exception e) {
              //  System.out.println("B");
            }

//            for (String elements : dataarray) {
//                System.out.println(elements);
//            }

     try{
         FileWriter fw = new FileWriter("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv");
         BufferedWriter bw = new BufferedWriter(fw);
         for (String element : dataarray) {
             bw.write(element);
             bw.newLine();
         }
         bw.close();
     } catch (Exception e) {
         //System.out.println("A4");
     }
        }

        public static void updatelastname() {
            Scanner sn = new Scanner(System.in);

            int count = 0;
            String s = "";
            try {
                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    s = Files.readAllLines(Paths.get("Login23.csv")).get(x);
                    count++;


                }
            } catch (Exception e) {
                //System.out.println("A");
            }

            //System.out.println("Value of count = " + count);
            String[] dataarray = new String[count];
            String nic = getcnic();
            //   Scanner sn = new Scanner(System.in);

            // String firstname = sn.next();


            String s1 = "";
            String s2 = "";
            String s3 = "";
            String s4 = "";
            String s5 = "";
            String s6 = "";
            try {System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
                System.out.println("           Enter New Last name");

                String lastName = sn.next();
                int i = 0;
                while (!(lastName.length() <= 11) || i != lastName.length()) {
                    char x = lastName.charAt(i);
                    i++;
                    if (!(Character.isAlphabetic(x))) {
                        System.out.println("           Your name should only contain letters:");
                        lastName = sn.next();
                        i = 0;
                    }
                    if (!(lastName.length() <= 12)) {
                        System.out.println("           error - Your name length should me maximum 11 leters ");
                        lastName = sn.next();
                    }
                }
                boolean check1 = false;

                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    check1 = Files.readAllLines(Paths.get("Login23.csv")).get(x).contains(nic);
                    //System.out.println(nic);
                    s1 = Files.readAllLines(Paths.get("Login23.csv")).get(x);
                    if (check1) {
                        s2 = s1.substring(0, s1.indexOf(",") + 1);
                        s3 = s1.substring(s1.indexOf(",") + 1);
                        s4 = s3.substring(0, s3.indexOf(",") + 1);
                        s5 = s3.substring(s3.indexOf(","));
                        s6 = s2 + lastName + s5;
                        //     System.out.println("s4 ="+s4);
                        dataarray[x] = s6;
                    } else {
                        dataarray[x] = s1;
                    }
                }
            } catch (Exception e) {
                //System.out.println("B");
            }

//    for (String elements : dataarray) {
//        System.out.println(elements);
//    }
            try {
                FileWriter fw = new FileWriter("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv");
                BufferedWriter bw = new BufferedWriter(fw);
                for (String element : dataarray) {
                    bw.write(element);
                    bw.newLine();
                }
                bw.close();
            } catch (Exception e) {
                //System.out.println("A4");
            }
        }

        public static void updatecontactno() {
            Scanner sn = new Scanner(System.in);

            int count = 0;
            String s = "";
            try {
                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    s = Files.readAllLines(Paths.get("Login23.csv")).get(x);
                    count++;


                }
            } catch (Exception e) {
                System.out.println("A");
            }

           // System.out.println("Value of count = " + count);
            String[] dataarray = new String[count];
            String nic = getcnic();
            //   Scanner sn = new Scanner(System.in);
            // String firstname = sn.next();
            String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "", s6 = "", s7 = "", s8 = "", s9 = "", s10 = "", s11 = "", s12 = "";
            String s13 = "", s14 = "", s15 = "";
            try {System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
                System.out.println("           Enter New contact no :");
                String contactno = sn.nextLine();
                boolean check1 = false;
                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    check1 = Files.readAllLines(Paths.get("Login23.csv")).get(x).contains(nic);
                    //System.out.println(nic);
                    s1 = Files.readAllLines(Paths.get("Login23.csv")).get(x);
                    if (check1) {
                        s2 = s1.substring(0, s1.indexOf(",") + 1);
                        s3 = s1.substring(s1.indexOf(",") + 1);
                        s11 = s3.substring(0, s3.indexOf(",") + 1);
                        s4 = s3.substring(s3.indexOf(",") + 1);
                        s12 = s4.substring(0, s4.indexOf(",") + 1);
                        s5 = s4.substring(s4.indexOf(",") + 1);
                        s13 = s5.substring(0, s5.indexOf(",") + 1);
                        s6 = s5.substring(s5.indexOf(",") + 1);
                        s14 = s6.substring(0, s6.indexOf(",") + 1);
                        s7 = s6.substring(s6.indexOf(",") + 1);
                        s8 = s7.substring(0, s7.indexOf(",") + 1);
                        s9 = s7.substring(s7.indexOf(","));
                        s15 = s2 + s11 + s12 + s13 + s14 + contactno + s9;
                        // System.out.println(s10);
                        dataarray[x] = s15;
                    } else {
                        dataarray[x] = s1;
                    }
                }
            } catch (Exception e) {
               // System.out.println("B");
            }

//      for (String elements : dataarray) {
//          System.out.println(elements);
//      }
            try {
                FileWriter fw = new FileWriter("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv");
                BufferedWriter bw = new BufferedWriter(fw);
                for (String element : dataarray) {
                    bw.write(element);
                    bw.newLine();
                }
                bw.close();
            } catch (Exception e) {
                //System.out.println("A4");
            }


        }

        public static void updateage() {
            Scanner sn = new Scanner(System.in);

            int count = 0;
            String s = "";
            try {
                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    s = Files.readAllLines(Paths.get("Login23.csv")).get(x);
                    count++;


                }
            } catch (Exception e) {
                //System.out.println("A");
            }

           // System.out.println("Value of count = " + count);
            String[] dataarray = new String[count];
            String nic = getcnic();
            //   Scanner sn = new Scanner(System.in);

            // String firstname = sn.next();


            String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "", s6 = "";
            try {System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
                System.out.println("           Enter new age");
                int age = sn.nextInt();
                boolean check1 = false;

                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    check1 = Files.readAllLines(Paths.get("Login23.csv")).get(x).contains(nic);
                    //System.out.println(nic);
                    s1 = Files.readAllLines(Paths.get("Login23.csv")).get(x);
                    if (check1) {
                        s2 = s1.substring(0, s1.lastIndexOf(",") + 1);
                        s3 = s2 + age;
                        dataarray[x] = s3;
                    } else {
                        dataarray[x] = s1;
                    }
                }
            } catch (Exception e) {
                //System.out.println("B");
            }

            for (String elements : dataarray) {
                System.out.println(elements);
            }
            try {
                FileWriter fw = new FileWriter("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv");
                BufferedWriter bw = new BufferedWriter(fw);
                for (String element : dataarray) {
                    bw.write(element);
                    bw.newLine();
                }
                bw.close();
            } catch (Exception e) {
               // System.out.println("A4");
            }
        }
        public static void avaiable_flight() {
        Scanner sn = new Scanner(System.in);
        //  String dep_country = "";
        try {
            //   Scanner sn = new Scanner (System.in);
            String depart_country = "";
            int j = 0;
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            while (j == 0) {
                System.out.println("           Enter the country from where you want to depart");
                depart_country = sn.nextLine();
                if (depart_country.length() <= 10) {
                    int i = 0;
                    while (i < depart_country.length()) {
                        char x = depart_country.charAt(i);
                        if (!(Character.isAlphabetic(x))) {
                            System.out.println("           Enter the valid country from where you want to depart");
                            j = 0;
                            break;
                        } else {
                            j = 1;
                        }
                        i++;
                    }
                } else {
                    System.out.println("           Enter the valid country from where you want to depart");
                }
            }
            String destin_country = "";
            int k = 0;
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            while (k == 0) {

                System.out.println("           Enter the destination country");
                destin_country = sn.nextLine();
                if (destin_country.length() <= 16) {
                    int i = 0;
                    while (i < destin_country.length()) {
                        char x = destin_country.charAt(i);
                        if (!(Character.isAlphabetic(x))) {
                            System.out.println("          Enter valid destination country");
                            k = 0;
                            break;
                        } else
                            k = 1;

                        i++;
                    }
                } else
                    System.out.println("           Enter valid destination country");
            }System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            int v = 0;
            while (v == 0) {
                List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv"));
                for (String line : lines) {
                    line = line.replace("\"","");
                    //  System.out.println(line);
                    String[] result = line.split(",");

                    for (int i = 0; i < result.length; i++) {

                        if ((result[i].equals(depart_country)) && (result[++i].equals(destin_country)) && (Integer.parseInt(result[6])!=0)) {
                            System.out.println("           Yes Flight is avaliable at :");
                            System.out.println("           Departure Time is " + result[++i].replace('"', ' ') + "\n" + "Arrvial Time is " + result[++i].replace('"', ' ') + "\n" + "Date is " + result[++i].replace('"', ' '));
                            v = 1;
                            break;
                        } else {
                            v = 2;
                        }
                    }if(v==1){
                        break ;
                    }
                }
            }
            if (v == 1) {
                System.out.println("");
            }
            if (v == 2) {
                System.out.println("           Sorry Flight is not avaliable");

            } else {
                System.out.println("");
            }

        } catch (IOException e) {
            //System.out.println(e);
        }
    }
        public static void updategender() {
            Scanner sn = new Scanner(System.in);

            int count = 0;
            String s = "";
            try {
                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    s = Files.readAllLines(Paths.get("Login23.csv")).get(x);
                    count++;


                }
            } catch (Exception e) {
                //System.out.println("A");
            }

          //  System.out.println("Value of count = " + count);
            String[] dataarray = new String[count];
            String nic = getcnic();
            //   Scanner sn = new Scanner(System.in);

            // String firstname = sn.next();
            String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "", s6 = "", s7 = "", s8 = "", s9 = "", s10 = "", s11 = "", s12 = "";
            String s13 = "", s14 = "", s15 = "";
            try {
                boolean valid = false;
                String gender = "";
                System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
                while (valid == false) {
                    System.out.println("           Enter Male or Female :");
                    gender = sn.nextLine();
                    if (gender.toLowerCase().equals("male")) {
                        valid = true;
                    } else if (gender.toLowerCase().equals("female")) {
                        valid = true;
                    } else {
                        System.out.println("           Please enter your gender again >");
                    }
                }

                boolean check1 = false;

                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    check1 = Files.readAllLines(Paths.get("Login23.csv")).get(x).contains(nic);
                    //System.out.println(nic);
                    s1 = Files.readAllLines(Paths.get("Login23.csv")).get(x);
                    if (check1) {
                        s2 = s1.substring(0, s1.indexOf(",") + 1);
                        s3 = s1.substring(s1.indexOf(",") + 1);
                        s11 = s3.substring(0, s3.indexOf(",") + 1);
                        s4 = s3.substring(s3.indexOf(",") + 1);
                        s12 = s4.substring(0, s4.indexOf(",") + 1);
                        s5 = s4.substring(s4.indexOf(",") + 1);
                        s13 = s5.substring(0, s5.indexOf(",") + 1);
                        s6 = s5.substring(s5.indexOf(",") + 1);
                        s14 = s6.substring(0, s6.indexOf(",") + 1);
                        s7 = s6.substring(s6.indexOf(","));
                        s15 = s2 + s11 + s12 + s13 + gender + s7;
                        dataarray[x] = s15;
                    } else {
                        dataarray[x] = s1;
                    }
                }
            } catch (Exception e) {
               // System.out.println("B");
            }

//        for (String elements : dataarray) {
//            System.out.println(elements);
//        }
            try {
                FileWriter fw = new FileWriter("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv");
                BufferedWriter bw = new BufferedWriter(fw);
                for (String element : dataarray) {
                    bw.write(element);
                    bw.newLine();
                }
                bw.close();
            } catch (Exception e) {
                //System.out.println("A4");
            }
        }

        public static void update_origin() {

            Scanner input = new Scanner(System.in);
            int count1 = 0;
            String s6 = " ";
            try {
                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    s6 = Files.readAllLines(Paths.get("Schedule.csv")).get(x);
                    count1++;
                }
            } catch (Exception e) {
               // System.out.println("A1");
            }
            //System.out.println("Value of count is " + count1);

            String[] origin_array = new String[count1];

            Scanner sn = new Scanner(System.in);
            String origin_country = "";
            int k = 0;System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            while (k == 0) {

                System.out.println("          Enter the origin country");
                origin_country = sn.nextLine();
                if (origin_country.length() <= 16) {
                    int i = 0;
                    while (i < origin_country.length()) {
                        char x = origin_country.charAt(i);
                        if (!(Character.isAlphabetic(x))) {
                            System.out.println("            Enter valid origin country ");
                            k = 0;
                            break;
                        } else
                            k = 1;

                        i++;
                    }

                } else
                    System.out.println("            Enter valid origin country ");
            }


//                System.out.print("Enter the name of the destination you want to add: ");
//                String dest2 = input.next();
            //  Scanner sn = new Scanner (System.in);


            String dest1 = "";
            int j = 0;System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            while (j == 0) {

                System.out.println("            Enter the destination country of that origin flight");
                dest1 = sn.nextLine();
                if (dest1.length() <= 10) {
                    int i = 0;
                    while (i < dest1.length()) {
                        char x = dest1.charAt(i);
                        if (!(Character.isAlphabetic(x))) {
                            System.out.println("            Enter the valid destination country of that origin flight");
                            j = 0;
                            break;
                        } else {
                            j = 1;
                        }
                        i++;
                    }
                } else {
                    System.out.println("            Enter the valid destination country of taht origin flight");
                }
            }System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);

            System.out.println("            Enter Arrival Time of the Flight");
            String t = sn.nextLine();
            int a = 0;
            while (a == 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
                sdf.setLenient(false);
                try {
                    Date d = sdf.parse(t);
                    String s3 = sdf.format(d);
                    System.out.println("            Valid Format");
                    a = 1;
                    break;
                } catch (ParseException e) {
                    a = 1;
                    System.out.println("            Invalid format");
                    System.out.println("            Enter arrival time again");
                    t = sn.nextLine();
                    a = 0;
                }

            }


            String dest2 = "";
            int q = 0;System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            while (q == 0) {

                System.out.println("            Enter the origin country which you want to add");
                dest2 = sn.nextLine();
                if (dest2.length() <= 10) {
                    int i = 0;
                    while (i < dest2.length()) {
                        char x = dest2.charAt(i);
                        if (!(Character.isAlphabetic(x))) {
                            System.out.println("            Enter the valid origin country which you want to replace");
                            q = 0;
                            break;
                        } else {
                            q = 1;
                        }
                        i++;
                    }
                } else {
                    System.out.println("            Enter the valid origin country");
                }
            }
            String s1 = " ";
            String s2 = " ";
            String s3 = " ";
            String s4 = " ";
            boolean check1 = false;
            boolean check2 = false;
            boolean check3 = false;

            try {
                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\Malik Basim\\IdeaProjects\\Project\\Schedule.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    check1 = Files.readAllLines(Paths.get("Schedule.csv")).get(x).contains(origin_country);
                    check2 = Files.readAllLines(Paths.get("Schedule.csv")).get(x).contains(t);
                    check3 = Files.readAllLines(Paths.get("Schedule.csv")).get(x).contains(dest1);
                    s1 = Files.readAllLines(Paths.get("Schedule.csv")).get(x);
                    if (check1 & check2 & check3) {
                        s2 = s1.substring(0, s1.indexOf(","));
                        s3 = s1.substring(s1.indexOf(","));
                        s4 = s2.replace(origin_country, dest2) + s3;
                        // System.out.println(s4);
                        origin_array[x] = s4;
                    } else {
                        origin_array[x] = s1;
                    }
                }
            } catch (Exception e) {
                //System.out.println("A2");
            }

//                for (String element : origin_array){
//                        System.out.println(element);
//                }


            try {
                FileWriter fw = new FileWriter("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv");
                BufferedWriter out = new BufferedWriter(fw);
                for (String element : origin_array) {
                    out.write(element);
                    out.newLine();
                }
                out.close();
            } catch (Exception e) {
               // System.out.println("A4");
            }
        }
        public static void delete() {
        int count = 0;
        String s = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv"));
            for (int x = 0; br.readLine() != null; x++) {
                s = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv")).get(x);
                count++;
            }
            //System.out.println("Value of count is " + s);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        count -= 1;
        String[] data = new String[count];
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
        System.out.println("            Entering data of the flight you want to delete");
        String origin = origincountry();
        String destin = Destination_country();
        String arrival = Arrival_time();
        String s1 = "";
        String s2 = "";
        String s3 = "";
        boolean check1 = false;
        boolean check2 = false;
        boolean check3 = false;
        int index = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv"));
            for (int x = 0; br.readLine() != null; x++) {
                check1 = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv")).get(x).contains(origin);
                check2 = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv")).get(x).contains(destin);
                check3 = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv")).get(x).contains(arrival);
                s1 = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv")).get(x);

                if (check1 && check2 && check3) {

                } else {
                    data[index] = s1;
                    index++;
                }
            }
//        for (String elements : data){
//            System.out.println(elements);
//        }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        try {
            FileWriter fw = new FileWriter("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            for (String elements : data) {
                bw.write(elements);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public static void deletelogin() {
        int count = 0;
        String s = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv"));
            for (int x = 0; br.readLine() != null; x++) {
                s = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv")).get(x);
                count++;
            }
            //System.out.println("Value of count is " + count);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        count -= 1;
        String[] data = new String[count];
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
        System.out.println("            Enter the CNIC of the customer whose data you want to delete");
        String cn = getcnic();
        String s1 = "";
        String s2 = "";
        String s3 = "";
        boolean check1 = false;

        int index = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv"));
            for (int x = 0; br.readLine() != null; x++) {
                check1 = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv")).get(x).contains(cn);

                s1 = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv")).get(x);

                if (check1) {

                } else {
                    data[index] = s1;
                    index++;
                }
            }
//        for (String elements : data){
//            System.out.println(elements);
//        }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        try {
            FileWriter fw = new FileWriter("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            for (String elements : data) {
                bw.write(elements);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
        public static int checknumber6() {
        Scanner sn = new Scanner(System.in);
        int num;
        while (true) {
            try {System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
                System.out.println("            Enter Choice");
                num = sn.nextInt();
                if (num > 0 && num < 7) {
                    return num;
                } else {
                    System.out.println("            Invalid Input !");
                }
            } catch (Exception e) {
                System.out.println("            Invalid Input ! Enter Again");
                // System.out.println("Enter again");
                sn.nextLine();
            }
        }
    }
        public static int checknumber2() {
        Scanner sn = new Scanner(System.in);
        int num;
        while (true) {
            try {
                //System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
                System.out.println("            Enter Choice");
                num = sn.nextInt();
                if (num > 0 && num < 4) {
                    return num;
                } else {
                    System.out.println("            Invalid Input !");
                }
            } catch (Exception e) {
                System.out.println("            Invalid Input ! Enter Again");
                // System.out.println("Enter again");
                sn.nextLine();
            }
        }
    }
        public static void update_destintion() {
            Scanner input = new Scanner(System.in);
            int count1 = 0;
            String s6 = " ";
            try {
                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    s6 = Files.readAllLines(Paths.get("Schedule.csv")).get(x);
                    count1++;
                }
            } catch (Exception e) {
               // System.out.println("A1");
            }
            //System.out.println("Value of count is " + count1);
            String[] origin_array = new String[count1];
            Scanner sn = new Scanner(System.in);
            String dest1 = "";
            int j = 0;System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            while (j == 0) {
                System.out.println("            Enter the destination country which you want to replace");
                dest1 = sn.nextLine();
                if (dest1.length() <= 10) {
                    int i = 0;
                    while (i < dest1.length()) {
                        char x = dest1.charAt(i);
                        if (!(Character.isAlphabetic(x))) {
                            System.out.println("            Enter the valid country which you want to replace");
                            j = 0;
                            break;
                        } else {
                            j = 1;
                        }
                        i++;
                    }
                } else {
                    System.out.println("            Enter the valid country where you want to replace");
                }
            }
            String dest2 = "";
            int l = 0;System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            while (l == 0) {
                System.out.println("            Enter the origin country of that destination country ");
                dest2 = sn.nextLine();
                if (dest2.length() <= 10) {
                    int i = 0;
                    while (i < dest2.length()) {
                        char x = dest2.charAt(i);
                        if (!(Character.isAlphabetic(x))) {
                            System.out.println("            Enter the origin country of that destination country");
                            l = 0;
                            break;
                        } else {
                            l = 1;
                        }
                        i++;
                    }
                } else {
                    System.out.println("            Enter the origin country of that destination country");
                }
            }
            // Scanner sn = new Scanner (System.in);
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            System.out.println("            Enter Arrival Time of the Flight");
            String t = sn.nextLine();
            int a = 0;
            while (a == 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
                sdf.setLenient(false);

                try {
                    Date d = sdf.parse(t);
                    String s3 = sdf.format(d);
                    System.out.println("            Valid Format");
                    a = 1;
                    break;
                } catch (ParseException e) {
                    a = 1;
                    System.out.println("            Invalid format");
                    System.out.println("            Enter arrival time again");
                    t = sn.nextLine();
                    a = 0;
                }

            }
            String dest3 = "";
            int r = 0;System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            while (r == 0) {

                System.out.println("            Enter the new destination ");
                dest3 = sn.nextLine();
                if (dest3.length() <= 10) {
                    int i = 0;
                    while (i < dest3.length()) {
                        char x = dest3.charAt(i);
                        if (!(Character.isAlphabetic(x))) {
                            System.out.println("            Enter valid new destination");
                            r = 0;
                            break;
                        } else {
                            r = 1;
                        }
                        i++;
                    }
                } else {
                    System.out.println("            Enter valid new destination");
                }
            }

            String s1 = " ";
            String s2 = " ";
            String s3 = " ";
            String s4 = " ";
            String s5 = "";
            boolean check1 = false;
            boolean check2 = false;
            boolean check3 = false;
            try {
                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    check1 = Files.readAllLines(Paths.get("Schedule.csv")).get(x).contains(dest1);
                    check2 = Files.readAllLines(Paths.get("Schedule.csv")).get(x).contains(dest2);
                    check3 = Files.readAllLines(Paths.get("Schedule.csv")).get(x).contains(t);
                    s1 = Files.readAllLines(Paths.get("Schedule.csv")).get(x);
                    if (check1 & check2 & check3) {
                        s2 = s1.substring(0, s1.indexOf(","));
                        s3 = s1.substring(s1.indexOf(","));
                        //s4 = s3.substring(0,s3.indexOf(","));
                        s5 = s3.substring(s3.indexOf(","));
                        s6 = s2 + s3.replace(dest1, dest3);
                        //   System.out.println(s6);

                        origin_array[x] = s6;
                    } else {
                        origin_array[x] = s1;
                    }
                }
            } catch (Exception e) {
                //System.out.println("A2");
            }
//                for (String element : origin_array) {
//                        System.out.println(element);
//                }

            try {
                FileWriter fw = new FileWriter("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv");
                BufferedWriter out = new BufferedWriter(fw);
                for (String element : origin_array) {
                    out.write(element);
                    out.newLine();
                }
                out.close();
            } catch (Exception e) {
                //System.out.println("A4");
            }
        }

        public static String origincountry() {
            Scanner sn = new Scanner(System.in);
            String origin_country = "";
            int k = 0;System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            while (k == 0) {

                System.out.println("            Enter the origin country");
                origin_country = sn.nextLine();
                if (origin_country.length() <= 16) {
                    int i = 0;
                    while (i < origin_country.length()) {
                        char x = origin_country.charAt(i);
                        if (!(Character.isAlphabetic(x))) {
                            System.out.println("            Enter valid origin country");
                            k = 0;
                            break;
                        } else
                            k = 1;

                        i++;
                    }

                } else
                    System.out.println("            Enter valid origin country");
            }


            return
                    origin_country;
        }

        public static String Destination_country() {
            Scanner sn = new Scanner(System.in);
            String destination = "";
            int j = 0;System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            while (j == 0) {
                System.out.println("            Enter the country where you want to go");
                destination = sn.nextLine();
                if (destination.length() <= 10) {
                    int i = 0;
                    while (i < destination.length()) {
                        char x = destination.charAt(i);
                        if (!(Character.isAlphabetic(x))) {
                            System.out.println("            Enter the valid country where you want to go");
                            j = 0;
                            break;
                        } else {
                            j = 1;
                        }
                        i++;
                    }
                } else {
                    System.out.println("            Enter the valid country where you want to go");
                }
            }
            return
                    destination;
        }
        public static void updateaddress() {
        Scanner sn = new Scanner(System.in);

        int count = 0;
        String s = "";
        try {
            BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv"));
            for (int x = 0; rd.readLine() != null; x++) {
                s = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv")).get(x);
                count++;


            }
        } catch (Exception e) {
          //  System.out.println("A");
        }

       // System.out.println("Value of count = " + count);
        String[] dataarray = new String[count];
        String nic = getcnic();
        //   Scanner sn = new Scanner(System.in);
        // String firstname = sn.next();
        String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "", s6 = "", s7 = "", s8 = "", s9 = "", s10 = "", s11 = "", s12 = "";
        String s13 = "", s14 = "", s15 = "", s16 ="", s17="" ,s18="";
        try {System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            System.out.println("            Enter New address :");
            String address = getAddress();
            boolean check1 = false;
            BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv"));
            for (int x = 0; rd.readLine() != null; x++) {
                check1 = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv")).get(x).contains(nic);
                //System.out.println(nic);
                s1 = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv")).get(x);
                if (check1) {
                    s2 = s1.substring(0, s1.indexOf(",") + 1);
                    s3 = s1.substring(s1.indexOf(",") + 1);
                    s11 = s3.substring(0, s3.indexOf(",") + 1);
                    s4 = s3.substring(s3.indexOf(",") + 1);
                    s12 = s4.substring(0, s4.indexOf(",") + 1);
                    s5 = s4.substring(s4.indexOf(",") + 1);
                    s13 = s5.substring(0, s5.indexOf(",") + 1);
                    s6 = s5.substring(s5.indexOf(",") + 1);
                    s14 = s6.substring(0, s6.indexOf(",") + 1);
                    s7 = s6.substring(s6.indexOf(",") + 1);
                    s8 = s7.substring(0, s7.indexOf(",") + 2);
                    s9 = s7.substring(s7.indexOf(",")+2);
                    s10 = s9.substring(0,s9.indexOf('"'));
                    s16 = s7.substring(s7.indexOf('"')+1,s7.lastIndexOf('"')+1);
                    s17 = s16.substring(s16.indexOf('"')); // cnic
                    s18 = s7.substring(s7.lastIndexOf(",")); // age
                    s15 = s2 + s11 + s12 + s13 + s14 +s8+address+s17+s18;

                    dataarray[x] = s15;
                } else {
                    dataarray[x] = s1;
                }
            }
        } catch (Exception e) {
           // System.out.println("B");
        }

//      for (String elements : dataarray) {
//          System.out.println(elements);
//      }
        try {
            FileWriter fw = new FileWriter("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            for (String element : dataarray) {
                bw.write(element);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
           // System.out.println("A4");
        }


    }
        public static String Departure_time() {
            Scanner sn = new Scanner(System.in);
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            System.out.println("            Enter Departure Time of the FLight");
            String time = sn.nextLine();
            int z = 0;
            while (z == 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
                sdf.setLenient(false);
                try {
                    Date d = sdf.parse(time);
                    String s2 = sdf.format(d);
                    System.out.println("            Valid Format");
                    z = 1;
                    break;
                } catch (Exception e) {
                    z = 1;
                    System.out.println("            Invalid format");
                    System.out.println("            Enter Departure time again");
                    time = sn.nextLine();
                    z = 0;
                }
            }
            return
                    time;
        }

        public static String Arrival_time() {
            Scanner sn = new Scanner(System.in);
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            System.out.println("            Enter Arrival Time of the Flight");
            String time1 = sn.nextLine();
            int a = 0;
            while (a == 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
                sdf.setLenient(false);
                try {
                    Date d = sdf.parse(time1);
                    String s3 = sdf.format(d);
                    System.out.println("            Valid Format");
                    a = 1;
                    break;
                } catch (Exception e) {
                    a = 1;
                    System.out.println("            Invalid format");
                    System.out.println("            Enter arrival time again");
                    time1 = sn.nextLine();
                    a = 0;
                }
            }
            return
                    time1;
        }

        public static String date() {
            Scanner sn = new Scanner(System.in);
            String dat = "";
            Scanner sc = new Scanner(System.in);
            boolean format = false;
            String dob;
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            do {
                System.out.println("            Enter the date of flights schedule");
                dat = sn.next();
                try {
                    Date date = new SimpleDateFormat("dd/mm/yyyy").parse(dat);
                    format = true;
                } catch (ParseException e) {
                    System.out.println("            Please enter valid date ");
                }
            } while (!(format));

            System.out.println(dat);
            return
                    dat;
        }

        public static void update_Departure_Time() {
            Scanner input = new Scanner(System.in);
            int count1 = 0;
            String s6 = " ";
            try {
                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    s6 = Files.readAllLines(Paths.get("Schedule.csv")).get(x);
                    count1++;
                }
            } catch (Exception e) {
               // System.out.println("A1");
            }
           // System.out.println("Value of count is " + count1);

            String[] origin_array = new String[count1];
            Scanner sn = new Scanner(System.in);

            String origin = "";
            int k = 0;
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            while (k == 0) {

                System.out.println("            Enter the origin country");
                origin = sn.nextLine();
                if (origin.length() <= 16) {
                    int i = 0;
                    while (i < origin.length()) {
                        char x = origin.charAt(i);
                        if (!(Character.isAlphabetic(x))) {
                            System.out.println("            Enter valid origin country");
                            k = 0;
                            break;
                        } else
                            k = 1;

                        i++;
                    }

                } else
                    System.out.println("            Enter valid origin country");
            }

            String destination = "";
            int j = 0;
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            while (j == 0) {

                System.out.println("            Enter the destination country of that flight");
                destination = sn.nextLine();
                if (destination.length() <= 10) {
                    int i = 0;
                    while (i < destination.length()) {
                        char x = destination.charAt(i);
                        if (!(Character.isAlphabetic(x))) {
                            System.out.println("            Enter the destination country of that flight");
                            j = 0;
                            break;
                        } else {
                            j = 1;
                        }
                        i++;
                    }
                } else {
                    System.out.println("            Enter the valid destination country");
                }
            }

            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            System.out.println("            Enter Departure Time of the FLight");
            String time = sn.nextLine();
            int z = 0;
            while (z == 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
                sdf.setLenient(false);

                try {
                    Date d = sdf.parse(time);
                    String s2 = sdf.format(d);
                    System.out.println("            Valid Format");
                    z = 1;
                    break;
                } catch (Exception e) {
                    z = 1;
                    System.out.println("            Invalid format");
                    System.out.println("            Enter Departure time again");
                    time = sn.nextLine();
                    z = 0;
                }

            }
//                System.out.print("Enter the new arrival time write am or pm: ");
//                String arrival_time2 = input.nextLine();
            String s1 = " ";
            String s2 = " ";
            String s3 = " ";
            String s4 = " ";
            String s5 = " ";
            String s7 = " ";
            boolean check1 = false;
            boolean check2 = false;

            try {
                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    check1 = Files.readAllLines(Paths.get("Schedule.csv")).get(x).contains(origin);
                    check2 = Files.readAllLines(Paths.get("Schedule.csv")).get(x).contains(destination);
                    s1 = Files.readAllLines(Paths.get("Schedule.csv")).get(x);
                    if (check1 & check2) {
                        System.out.println(s1);
                        s2 = s1.substring(0, s1.indexOf(",") + destination.length() + 2);
                        System.out.println(s2);
                        s3 = s1.substring(s1.indexOf(",") + destination.length() + 2);
                        System.out.println(s3);
                        s4 = s3.substring(0, s3.indexOf(","));
                        s5 = s3.replace(s4, time);
                        s6 = s2 + s5;

                        origin_array[x] = s6;
                    } else {
                        origin_array[x] = s1;
                    }
                }
            } catch (Exception e) {
                //System.out.println("A2");
            }
//                for (String element : origin_array) {
//                        System.out.println(element);
//                }
            try {
                FileWriter fw = new FileWriter("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv");
                BufferedWriter out = new BufferedWriter(fw);
                for (String element : origin_array) {
                    out.write(element);
                    out.newLine();
                }
                out.close();
            } catch (Exception e) {
               // System.out.println("A4");
            }
        }

        public static void getSchedule(String origin_country, String destin_country, String depart_time, String arrival_time, String date) {
            try {
                File file = new File("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv");
                if (file.createNewFile()) {
                    String header = "Origin_Country,Destination_Country,Departure_Time,Arrival_Time,Date";
                    List<String[]> listinfo = new ArrayList<String[]>();
                    String[] s = {origin_country, destin_country, depart_time, arrival_time, date};
                    listinfo.add(s);
                    FileWriter fw = new FileWriter(file, true);
                    fw.append(header);
//                fw.append("\n");
                    CSVWriter csv = new CSVWriter(fw);
                    csv.writeAll(listinfo);
                    csv.close();
                    fw.close();
                } else {
                    List<String[]> listinfo = new ArrayList<String[]>();
                    String[] s = {origin_country, destin_country, depart_time, arrival_time, date};
                    listinfo.add(s);
                    FileWriter fw = new FileWriter(file, true);
                    // fw.append("\n");
                    CSVWriter csv = new CSVWriter(fw);
                    csv.writeAll(listinfo);
                    csv.close();
                    fw.close();
                }

            } catch (Exception e) {
                //e.printStackTrace();
            }
        }

        public static void update_Arrival_Time() {
            Scanner sn = new Scanner(System.in);
            int count1 = 0;
            String s6 = " ";
            try {
                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    s6 = Files.readAllLines(Paths.get("Schedule.csv")).get(x);
                    count1++;
                }
            } catch (Exception e) {
                //System.out.println("A1");
            }
           // System.out.println("Value of count is " + count1);
            String[] origin_array = new String[count1];
            String origin = "";
            int k = 0;
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            while (k == 0) {
                System.out.println("            Enter the origin country");
                origin = sn.nextLine();
                if (origin.length() <= 16) {
                    int i = 0;
                    while (i < origin.length()) {
                        char x = origin.charAt(i);
                        if (!(Character.isAlphabetic(x))) {
                            System.out.println("            Enter valid origin country");
                            k = 0;
                            break;
                        } else
                            k = 1;

                        i++;
                    }

                } else
                    System.out.println("            Enter valid origin country");
            }
            String destination = "";
            int j = 0;

            while (j == 0) {

                System.out.println("            Enter the destination country of that flight");
                destination = sn.nextLine();
                if (destination.length() <= 10) {
                    int i = 0;
                    while (i < destination.length()) {
                        char x = destination.charAt(i);
                        if (!(Character.isAlphabetic(x))) {
                            System.out.println("            Enter the destination country of that flight");
                            j = 0;
                            break;
                        } else {
                            j = 1;
                        }
                        i++;
                    }
                } else {
                    System.out.println("            Enter the valid destination country");
                }
            }
            System.out.println("            Enter Arrival Time of the Flight");
            String time1 = sn.nextLine();
            int a = 0;
            while (a == 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
                sdf.setLenient(false);

                try {
                    Date d = sdf.parse(time1);
                    String s3 = sdf.format(d);
                    System.out.println("            Valid Format");
                    a = 1;
                    break;
                } catch (Exception e) {
                    a = 1;
                    System.out.println("            Invalid format");
                    System.out.println("            Enter arrival time again");
                    time1 = sn.nextLine();
                    a = 0;
                }

            }
//                System.out.print("Enter the new arrival time write am or pm: ");
//                String arrival_time2 = input.nextLine();
            String s1 = " ";
            String s2 = " ";
            String s3 = " ";
            String s4 = " ";
            String s5 = " ";
            String s7 = " ";
            boolean check1 = false;
            boolean check2 = false;
            try {
                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    check1 = Files.readAllLines(Paths.get("Schedule.csv")).get(x).contains(origin);
                    check2 = Files.readAllLines(Paths.get("Schedule.csv")).get(x).contains(destination);
                    s1 = Files.readAllLines(Paths.get("Schedule.csv")).get(x);
                    if (check1 & check2) {
                        s2 = s1.substring(0, s1.indexOf(",") + destination.length() + 2);
                        s3 = s1.substring(s1.indexOf(",") + destination.length() + 2);
                        s4 = s3.substring(s3.indexOf(",") + 1);
                        s5 = s3.replace(s4, time1);
                        s6 = s1.substring(s1.lastIndexOf(","));
                        s7 = s2 + s5 + s6;

                        origin_array[x] = s7;
                    } else {
                        origin_array[x] = s1;
                    }
                }
            } catch (Exception e) {
                //System.out.println("A2");
            }
            for (String element : origin_array) {
                System.out.println(element);
            }
            try {
                FileWriter fw = new FileWriter("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv");
                BufferedWriter out = new BufferedWriter(fw);
                for (String element : origin_array) {
                    out.write(element);
                    out.newLine();
                }
                out.close();
            } catch (Exception e) {
               // System.out.println("A4");
            }
        }

        public static void veiwdetails(String email, String password) {
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);

            List<String> lines = null;
            try {
                lines = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv"));
            } catch (Exception e) {

            }
            int row =0;
            int count = 0;
            boolean found = false;
            for (String line : lines) {

                line = line.replace("\"", "");
                String[] result = line.split(",");
                if (count==0){

                }else {
                    if (result[2].equals(email)&&result[3].equals(password)) {
                        row = count;
                        found = true;
                        break;
                    } else {
                        found = false;
                    }
                }count++;
            }if (found==true) {
                System.out.println(row);
                String filepath = "C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv";
                File inputfile = new File(filepath);
                CSVReader reader = null;
                List<String[]> csvbody = null;
                try {
                    reader = new CSVReader(new FileReader(inputfile));
                    csvbody = reader.readAll();
                    System.out.println("FirstName\t|LastName\t|Email\t\t\t\t|Password\t\t|Gender\t|Contact no\t\t|Address\t\t\t\t|Cnic\t\t|Age\n");
                    for (int i = 0; i < 9; i++) {
                        String details = csvbody.get(row)[i].replace("\"", "");
                        System.out.printf("%-14s   |", details);
                    }
                    reader.close();
                } catch (Exception e) {

                }
            }

        }
         public static void admin(boolean value) throws IOException {
        if (value) {
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            System.out.println("            Welcome Admin");
            System.out.println("            Which file you want to access");
            System.out.println("            1: For Customer File\n            2: For Flights file\n           3: Back to Main Screan");
            int numb = checknumber2();
            if (numb == 1) {
                System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
                System.out.println("            *****Customer File*****");
                System.out.println("            1: Add Data\n            2: Edit Data\n            3: Delete Data\n            4: View all Data\n            5: Back to main admin");
                int number = checknumber();
                if (number == 1) {
                    String email = getemail();
                    System.out.println(email);
                    String password = getpassword();
                   // System.out.println(password);
                    String[] Name = getname();
                    String firstname = Name[0];
                    String lastname = Name[1];
                    String gender = Name[2];
                   // System.out.println(firstname + lastname + gender);
                    String dob = getdob();
                    int age = getAge(dob);
                    //System.out.println(age);
                    String mobno = getmobilenumber();
                    //System.out.println(mobno);
                    String address = getAddress();
                   // System.out.println(address);
                    String cnic = getcnic();
                    //System.out.println(cnic);
                    getcsv(firstname, lastname, email, password, gender, mobno, address, cnic, age);
                }
                if (number == 2) {
                    System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
                    System.out.println("            1: Edit First name\n            2:  Edit Last name\n            3:  Edit Gender\n           4:  Edit contactno\n            5:  Edit Age\n          6: Edit Address");
                    int numb1 = checknumber6();
                    if (numb1 == 1) {
                        updatefirstname();
                    }
                    if (numb1 == 2) {
                        updatelastname();

                    }
                    if (numb1 == 3) {
                        updategender();
                    }
                    if (numb1 == 4) {
                        updatecontactno();
                    }
                    if (numb1 == 5) {
                        updateage();

                    }
                    if(numb1==6){
                        updateaddress();
                    }
                }
                if (number == 3) {
                    deletelogin();
                }
                if (number == 4) {
                    String s = "";
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv"));
                        for (int x = 0; br.readLine() != null; x++) {
                            s = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Login23.csv")).get(x);
                            System.out.println(s.replace('"', ' '));
                        }
                    } catch (Exception e) {
                       // System.out.println("Something wrong");
                    }

                }
                if (number == 5) {
                    admin(value);
                }
            }
            if (numb == 2) {
                System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
                System.out.println("            Enter the option you want to select :");
                System.out.println("            1:  Add flight\n            2:  view all flights\n            3: edit flight records\n           4: Delete Flight\n           5: Back to main admmin");
                int number = checknumber();
                if (number == 1) {
                    String origin = origincountry();
                    String destin = Destination_country();
                    String depart = Departure_time();
                    String arrival =Arrival_time();
                    String date = date();
                    getSchedule(origin, destin, depart, arrival, date);
                }
                if (number == 2) {
                    File file = new File("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv");

                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    int x = 0;
                    while (br.readLine() != null) {

                        String temp = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv")).get(x);
                        System.out.println((temp).replace('"', ' '));
                        x++;
                    }
                    admin(value);
                }
                if (number == 3) {
                    System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
                    System.out.println("            1: for origin_country\n         2: for Destination_country\n            3: for Departure_time\n         4: for Arrival_time \n          5: for Date");
                    int num = checknumber();
                    if (num == 1) {
                        System.out.println("            *******Updating Origin Country ***********");
                        update_origin();
                    }
                    if (num == 2) {
                        System.out.println("            *******Updating Destination Country*******");
                        update_destintion();
                    }
                    if (num == 3) {
                        System.out.println("            *********Updating Departure time************");
                        update_Departure_Time();
                    }
                    if (num == 4) {
                        System.out.println("            **********Updating arrival time************");
                        update_Arrival_Time();
                    }
                    if (num == 5) {
                        System.out.println("                ***********Updating Date************");
                        update_Date();
                    }
                }
                if (number == 4) {
                    delete();
                }


                if (number == 5) {
                    admin(value);
                }
            }
            if(numb == 3){
                MainScreen();
            }
        }
    }


        public static void update_Date() {
            Scanner sn = new Scanner(System.in);
            int count1 = 0;
            String s6 = " ";
            try {
                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    s6 = Files.readAllLines(Paths.get("Schedule.csv")).get(x);
                    count1++;
                }
            } catch (Exception e) {
                //System.out.println("A1");
            }
            //System.out.println("Value of count is " + count1);
            String[] origin_array = new String[count1];
            String origin = "";
            int k = 0;
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            while (k == 0) {
                System.out.println("            Enter the origin country");
                origin = sn.nextLine();
                if (origin.length() <= 16) {
                    int i = 0;
                    while (i < origin.length()) {
                        char x = origin.charAt(i);
                        if (!(Character.isAlphabetic(x))) {
                            System.out.println("            Enter valid origin country");
                            k = 0;
                            break;
                        } else
                            k = 1;
                        i++;
                    }
                } else
                    System.out.println("            Enter valid origin country");
            }
            String destination = "";
            int j = 0;
            while (j == 0) {
                System.out.println("            Enter the destination country of that flight");
                destination = sn.nextLine();
                if (destination.length() <= 10) {
                    int i = 0;
                    while (i < destination.length()) {
                        char x = destination.charAt(i);
                        if (!(Character.isAlphabetic(x))) {
                            System.out.println("            Enter the destination country of that flight");
                            j = 0;
                            break;
                        } else {
                            j = 1;
                        }
                        i++;
                    }
                } else {
                    System.out.println("            Enter the valid destination country");
                }
            }

            String dat = "";
            Scanner sc = new Scanner(System.in);
            boolean format = false;
            String dob;
            do {
                System.out.println("            Enter the date of flights schedule");
                dat = sn.next();
                try {
                    Date date = new SimpleDateFormat("dd/mm/yyyy").parse(dat);
                    format = true;
                } catch (ParseException e) {
                    System.out.println("            Please enter valid date ");
                }
            } while (!(format));

            System.out.println(dat);
//                System.out.print("Enter the new arrival time write am or pm: ");
//                String arrival_time2 = input.nextLine();

            String s1 = " ";
            String s2 = " ";
            String s3 = " ";
            String s4 = " ";
            String s5 = " ";
            String s7 = " ";
            boolean check1 = false;
            boolean check2 = false;

            try {
                BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\Malik Basim\\IdeaProjects\\Project\\Schedule.csv"));
                for (int x = 0; rd.readLine() != null; x++) {
                    check1 = Files.readAllLines(Paths.get("Schedule.csv")).get(x).contains(origin);
                    check2 = Files.readAllLines(Paths.get("Schedule.csv")).get(x).contains(destination);
                    s1 = Files.readAllLines(Paths.get("Schedule.csv")).get(x);
                    if (check1 & check2) {
                        s2 = s1.substring(0, s1.lastIndexOf(",") + 1);
                        s3 = s1.substring(s1.lastIndexOf(",") + 1);
                        s4 = s2 + dat;
                        origin_array[x] = s4;
                    } else {
                        origin_array[x] = s1;
                    }
                }
            } catch (Exception e) {
                    // System.out.println("A2");
            }

//                for (String element : origin_array) {
//                        System.out.println(element);
//                }
            try{
                FileWriter fw = new FileWriter("C:\\Users\\HOME\\IdeaProjects\\FMS\\Schedule.csv");
                BufferedWriter out = new BufferedWriter(fw);
                for (String element: origin_array){
                    out.write(element);
                    out.newLine();
                }
                out.close();
            }catch (Exception e){
               // System.out.println("A4");
            }
        }

        public static void Cancellation() {
        String flno = null;
        boolean format = true;
            System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);

        while (format) {
            System.out.println("            Enter your flight number please :");
            System.out.println("            IN A FORMAT FIRST 2 LETTERS & 3 DIGITS :");
            flno = sc.nextLine();
            if (flno.length() == 5) {
                for (int i = 2; i < flno.length(); i++) {
                    char c = flno.charAt(i);
                    if (Character.isLetter(flno.charAt(0)) && Character.isLetter(flno.charAt(1)) && Character.isDigit(flno.charAt(i))) {
                        if (i == 4) {
                            format = false;
                            break;
                        }
                    }
                }
            } else {
                System.out.println("               ERROR-");
            }
        }

        String cnic = null;
        boolean format1 = false;
        while (format1 == false) {

            System.out.println("            Enter your CNIC please : ");
            cnic = sc.next();
            if (cnic.length() == 13) {
                boolean loop = false;
                for (int i = 0; i < cnic.length(); i++) {
                    char x = cnic.charAt(i);
                    if (Character.isDigit(x)) {
                        loop = true;
                    } else {
                        sc.nextLine();
                        loop = false;
                        break;
                    }
                }
                if (loop == true) {
                    format1 = true;
                    break;
                }
            }
        }
        sc.nextLine();

        String PN = null;
        boolean formatofPN = true;

        while (formatofPN) {
            System.out.println("            Enter your passport number please :");
            System.out.println("            IN A FORMAT FIRST 2 LETTERS & 7 DIGITS :");
            PN = sc.nextLine();
            if (PN.length() == 9) {
                for (int i = 2; i < PN.length(); i++) {
                    char c = PN.charAt(i);
                    if (Character.isLetter(PN.charAt(0)) && Character.isLetter(PN.charAt(1)) && Character.isDigit(PN.charAt(i))) {
                        if (i==8){
                            formatofPN = false;
                            break;
                        }
                    }
                }
            }else {
                System.out.println("            LENGTH MUST NOT EXCEED !");
            }
        }

        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("C:\\Users\\HOME\\IdeaProjects\\FMS\\Bookings.csv"));
        } catch (Exception e) {

        }
        double Calfee = 0.23;
        boolean found = false;
        int count = 0;
        int choice = 0;
        for (String line : lines) {
            line = line.replace("\"", "");
            String[] result = line.split(",");
            double refundable = 0;
            try {
                System.out.println(result[0] + "" + (result[5]) + "" + result[6]);

                if ((result[0].equals(flno)) && (result[5].equals(cnic)) && result[6].equals(PN)) {
                    System.out.println("            FOUND\"\uD83D\uDE00\"");
                    found=true;
                    refundable =  (Integer.parseInt(result[12]))-((Integer.parseInt(result[12]) * (Calfee)));


                    System.out.println("            ------------------------------------------------------------" +
                            "\n             TOTAL PAID  " + result[12] + "                                  " +
                            "\n             CANCELLATION FEE " + (Integer.parseInt(result[12]) * Calfee) + "           " +
                            "\n             REFUNDABLE AMOUNT " + refundable + "                              " +
                            "\n             -------------------------------------------------------------");
                    System.out.println("            DO YOU WANT TO CANCEL YOUR BOOKING ?");
                    System.out.println("                      1-yes" +
                            "                                 2-NO");
                    String strInput;
                    boolean valid = false;
                    Scanner input2 = new Scanner(System.in);
                    System.out.println("\n          Enter serial number in which you are interested :");
                    strInput = input2.nextLine();
                    while (valid == false) {

                        choice = Integer.parseInt(strInput);
                        if (choice == 1 || choice == 2) {
                            valid = true;
                        } else {
                            System.out.println("            please enter a valid serial number either 1 or 2 :");
                            strInput = input2.nextLine();
                        }

                    }
                    if (choice == 1 || choice == 2) {
                        break;
                    }
                }

            }catch (Exception e) {
            }
            count++;

        }if (found==false){
                System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
            System.out.println("            Sorry ! Your record not found ");
            System.out.println("            IT SEEMS ! YOU'VE NOT BOOKED YOUR TICKET YET ....");
            System.out.println("            HURRY UP ... GO GRAB YOUR TICKET NOW!");
        }
        if (choice == 1) {
            List<String[]> csvbody = null;
            CSVReader reader = null;
            try {
                String filepath = "C:\\Users\\HOME\\IdeaProjects\\FMS\\Bookings.csv";
                File inputfile = new File(filepath);
                reader = new CSVReader(new FileReader(inputfile));
                csvbody = reader.readAll();
                csvbody.remove(count);

                reader.close();
                CSVWriter writer = new CSVWriter(new FileWriter(inputfile));
                writer.writeAll(csvbody);
                System.out.println("            UPDATED");
                writer.flush();
                writer.close();
            } catch (Exception e) {
                System.out.println();
            }
        }else if (choice==2){
            System.out.println("            THANK YOU FOR YOUR VISIT ");

        }
    }

        public static void Exit(){
        int choice = 0;
        String strInput2;
        boolean valid = false;
        System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
        System.out.println("\n          Are You sure You want to exit?");
        System.out.println("\n                1-Yes " +
                "                             2- No");

            strInput2 = sc.next();

        while (valid == false) {
            sc.nextLine();
            try {
                choice = Integer.parseInt(strInput2);
                if (choice == 1  ) {
                    System.out.println("            THANK YOU FOR YOUR VISIT !");
                    System.out.println(PURPLE_BRIGHT+"           ====================================================="+RESET);
                    break;
                }else if (choice==2){
                    MainScreen();
                    break;
                } else {
                    System.out.println("            please enter a valid serial number  1 or 2 :");
                    strInput2 = sc.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("            Error - please enter a valid serial number");
                strInput2 = sc.nextLine();
            }
        }
    }


        public static void main(String[] args) {
            int[] serial = MainScreen();
            int Adminserial = serial[0];
            int Userserial = serial[1];
            if (Adminserial == 1) {
                try {
                    boolean value = adminlogin();
                    admin(value);
                }catch (Exception e){

                }
            }String email=null;
            String password = null;
            if (Userserial == 1) {
                Registeration();
                String [] cred = Login();
                email = cred[0];
                password = cred[1];
            }if (Userserial == 2) {
                String[] cred = Login();
                email = cred[0];
                password = cred[1];
            }int Loginserial = 0;
            if (Userserial== 1|| Userserial==2) {
                Loginserial = loginscreen();
            }



            if (Loginserial==1){
                veiwdetails(email,password);
                Exit();
            }

            int serial1 = 0;
            int serial2 = 0;
            int serial3 = 0;
            int serial4 = 0;
            int serial5 = 0;
            int serial6 = 0;
            if (Loginserial == 2) {
                serial1 = regions();
                serial2 = Asia(serial1);
                serial3 = Africa(serial1);
                serial4 = NorthAmerica(serial1);
                serial5 = MiddleEast(serial1);
                serial6 = Europe(serial1);
            }
            if (Loginserial == 4) {
                //cancellation
                Cancellation();
                Exit();
            }
            if (Loginserial == 3) {
                //Flight status
                avaiable_flight();
                Exit();
            }if(Loginserial==5){
                Exit();
            }
//
            if ( serial2 == 1 || serial3 == 1 || serial4 == 1 || serial5 == 1 || serial6 == 1) {
                Bookings();
                Exit();
            }


        }
    }

