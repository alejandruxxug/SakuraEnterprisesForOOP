import classified.ShadowCommittee;
import clients.Client;
import enums.AccessLevel;
import exceptions.DuplicateUserData;
import exceptions.InvalidLogin;
import exceptions.InvalidRegistrationData;
import exceptions.InvalidUserTypeForShadowComitee;
import services.AuthService;
import classified.ShadowCommittee;
import users.*;

import java.util.Scanner;

public class Main {
    static AuthService Auth = new AuthService();
    static ShadowCommittee Shadow = new ShadowCommittee();
    static User loggedUser;
    static AccessLevel userAccessLevel;
    static boolean finishedLogin = false;
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Hello This is Sakura Enterprises, Please Identify yourself! 😊");

        int option;

        while(true){
            showLogin();
            option = Integer.parseInt(sc.nextLine());
            loggedUser = null;
            userAccessLevel = null;
            String username;
            String password;
            String email;
            String deliveryAddress;
            long telephone;

            // Login
            switch (option){
                case 1:
                    System.out.println("Enter your username");
                    username = sc.nextLine();
                    System.out.println("Enter your password");
                    password = sc.nextLine();

                    try {
                        loggedUser = Auth.login(username,password);
                        System.out.println("Login Successful");
                        finishedLogin = true;

                    } catch (InvalidLogin e) {
                        System.out.println(e.getMessage());
                    }

                break;
                    //Client registration method
                case 2:
                    System.out.println("Register your client account!");
                    System.out.println("Enter your username");
                    username = sc.nextLine();
                    System.out.println("Enter your password(It has to have more than 4 characters)");
                    password = sc.nextLine();
                    System.out.println("Enter your email");
                    email = sc.nextLine();
                    System.out.println("Enter your delivery adress");
                    deliveryAddress = sc.nextLine();
                    System.out.println("Enter your telephone number");
                    telephone = Long.parseLong(sc.nextLine());

                    try {
                        Client newClient = new Client(username,password,email,deliveryAddress,telephone);
                        Auth.addUser(newClient);
                        loggedUser = newClient;
                        System.out.println("Registraton & login Successful");
                        finishedLogin = true;

                    } catch (DuplicateUserData e) {
                        System.out.println(e.getMessage());
                    } catch (InvalidRegistrationData e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 0:
                    System.out.println("Bye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option please enter a valid option");
                    break;
            }
            // Casting to see which menu does the program take the user
            if(finishedLogin){
                //Has a client class - open client menu to purchase TODO
                if (loggedUser instanceof Client client) {
                    clientMenu();
                }
                //Product developer goes to publish products TODO
                else if (loggedUser instanceof ProductDeveloper productDeveloper) {
                    productDeveloperMenu();
                }
                //User admin can look into the shadow comittee but only if they have access privileges - allows creation of employee accounts and give them privileges if they have priviledges
                else if (loggedUser instanceof UserAdmin userAdmin) {
                    userAccessLevel = userAdmin.getAccessLevel();
                    userAdminMenu(userAccessLevel);

                }
                // Content admin has also access if they have it - also allowed to manage products
                else if (loggedUser instanceof ContentAdmin contentAdmin) {
                    userAccessLevel = contentAdmin.getEditPermissions();
                    contentAdminMenu(userAccessLevel);
                }
                // Sakura option (last because least probable to access the system) // Also give them the perspective of each user type
                else if (loggedUser instanceof Sakura sakura) {
                    sakuraMenu();
                }

            }
        }

    }

    public static void showLogin() {
        System.out.println("==========Login==========");
        System.out.println("1. Login");
        System.out.println("2. Register client account");
        System.out.println("0. Exit");
    }

    public static void clientMenu() {
        System.out.println("==========Logged in as:==========");
        System.out.println("=========="+loggedUser.getRole()+"==========");
        System.out.println("Welcome " +loggedUser.getUsername());
        System.out.println("1. Browse products");
        System.out.println("2. View the shopping cart");
        System.out.println("3. Add payment method");
        System.out.println("4. Finalize purchase");
        System.out.println("0. Exit");

    }

    public static void productDeveloperMenu() {
        System.out.println("==========Logged in as:==========");
        System.out.println("=========="+loggedUser.getRole()+"==========");
        System.out.println("Welcome " +loggedUser.getUsername());
        System.out.println("1. Create a new product");
        System.out.println("0. Logout");

    }

    public static void userAdminMenu(AccessLevel accessLevel) {
        int input;
        int inputSwitch;


        userAdminLoop:
        while(true){
            System.out.println("==========Logged in as:==========");
            System.out.println("=========="+loggedUser.getRole()+"==========");
            System.out.println("Welcome " +loggedUser.getUsername());
            System.out.println("1. Create a new employee user");
            System.out.println("2. Activate/Deactivate an employee user");
            System.out.println("3. Reset an users password");
            shadowCommitteeMenu(accessLevel);
            System.out.println("0. Logout");

            input = Integer.parseInt(sc.nextLine());

            switch (input){
                case 1:
                    System.out.println("Employee Creation");
                    System.out.println("Username: ");
                    String username = sc.nextLine();
                    System.out.println("Password: ");
                    String password = sc.nextLine();
                    System.out.println("Email: ");
                    String email = sc.nextLine();

                    System.out.println("1. for User Admin Account - 2. for Content Admin Account - 3 Product Developer");

                    inputSwitch = Integer.parseInt(sc.nextLine());

                    switch(input) {
                        case 1:
                            System.out.println("User Administration account ");
                            if (AccessLevel.ADMIN.equals(accessLevel)) {
                                System.out.println("Are they going to be a member of the shadow comitee? 1.Yes 2.Only view 3.No ");
                                inputSwitch = Integer.parseInt(sc.nextLine());
                                switch (inputSwitch) {
                                    case 1:
                                        try {
                                            UserAdmin uA = new UserAdmin(username, password, email, AccessLevel.ADMIN);
                                            Auth.addUser(uA);
                                            Shadow.addUser(uA);

                                            System.out.println("User Admin Successfully Created");
                                        } catch (InvalidRegistrationData e) {
                                            System.out.println(e.getMessage());
                                        } catch (DuplicateUserData e) {
                                            System.out.println(e.getMessage());
                                        } catch (InvalidUserTypeForShadowComitee e) {
                                            System.out.println(e.getMessage());
                                        }

                                        break;

                                    case 2:
                                        try {
                                            UserAdmin uA = new UserAdmin(username, password, email, AccessLevel.VIEW);
                                            Auth.addUser(uA);
                                            Shadow.addUser(uA);

                                            System.out.println("User Admin Successfully Created");
                                        } catch (InvalidRegistrationData e) {
                                            System.out.println(e.getMessage());
                                        } catch (DuplicateUserData e) {
                                            System.out.println(e.getMessage());
                                        } catch (InvalidUserTypeForShadowComitee e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;

                                    case 3:
                                        try {
                                            UserAdmin uA = new UserAdmin(username, password, email, AccessLevel.NOACCESS);
                                            Auth.addUser(uA);

                                            System.out.println("User Admin Successfully Created");
                                        } catch (InvalidRegistrationData e) {
                                            System.out.println(e.getMessage());
                                        } catch (DuplicateUserData e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                }

                            } else {
                                try {
                                    UserAdmin uA = new UserAdmin(username, password, email, AccessLevel.NOACCESS);
                                    Auth.addUser(uA);

                                    System.out.println("User Admin Successfully Created");
                                } catch (InvalidRegistrationData e) {
                                    System.out.println(e.getMessage());
                                } catch (DuplicateUserData e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;

                        case 2:
                            System.out.println("Content Administration account ");
                            if (AccessLevel.ADMIN.equals(accessLevel)) {
                                System.out.println("Are they going to be a member of the shadow comitee? 1.Yes 2.Only view 3.No ");
                                inputSwitch = Integer.parseInt(sc.nextLine());
                                switch (inputSwitch) {
                                    case 1:
                                        try {
                                            ContentAdmin uA = new ContentAdmin(username, password, email, AccessLevel.ADMIN);
                                            Auth.addUser(uA);
                                            Shadow.addUser(uA);

                                            System.out.println("Content Admin Successfully Created");
                                        } catch (InvalidRegistrationData e) {
                                            System.out.println(e.getMessage());
                                        } catch (DuplicateUserData e) {
                                            System.out.println(e.getMessage());
                                        } catch (InvalidUserTypeForShadowComitee e) {
                                            System.out.println(e.getMessage());
                                        }

                                        break;

                                    case 2:
                                        try {
                                            ContentAdmin uA = new ContentAdmin(username, password, email, AccessLevel.VIEW);
                                            Auth.addUser(uA);
                                            Shadow.addUser(uA);

                                            System.out.println("Content Admin Successfully Created");
                                        } catch (InvalidRegistrationData e) {
                                            System.out.println(e.getMessage());
                                        } catch (DuplicateUserData e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;

                                    case 3:
                                        try {
                                            ContentAdmin uA = new ContentAdmin(username, password, email, AccessLevel.NOACCESS);
                                            Auth.addUser(uA);

                                            System.out.println("Content Successfully Created");
                                        } catch (InvalidRegistrationData e) {
                                            System.out.println(e.getMessage());
                                        } catch (DuplicateUserData e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                }

                            } else {
                                try {
                                    ContentAdmin uA = new ContentAdmin(username, password, email, AccessLevel.NOACCESS);
                                    Auth.addUser(uA);

                                    System.out.println("User Admin Successfully Created");
                                } catch (InvalidRegistrationData e) {
                                    System.out.println(e.getMessage());
                                } catch (DuplicateUserData e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                            break;

                        case 3:
                            System.out.println("Product Developer account ");

                            String specialty = sc.nextLine();

                            try {
                                ProductDeveloper uA = new ProductDeveloper(username, password, email, specialty);
                                Auth.addUser(uA);
                                System.out.println("Product Developer Successfully Created");
                            } catch (InvalidRegistrationData e) {
                                System.out.println(e.getMessage());
                            } catch (DuplicateUserData e) {
                                System.out.println(e.getMessage());
                            }


                            break;
                    }
                break;

                case 2:
                    System.out.println("Account activation/inactivation");
                    System.out.println("Enter a username to toggle the state of the account ");
                    String user = sc.nextLine();

                break;
                case 0:
                    logout();
                    break userAdminLoop;

            }
        }
    }

    public static void contentAdminMenu(AccessLevel accessLevel) {
        System.out.println("==========Logged in as:==========");
        System.out.println("=========="+loggedUser.getRole()+"==========");
        System.out.println("Welcome " +loggedUser.getUsername());
        System.out.println("1. Create a new product");
        System.out.println("2. Edit a product");
        System.out.println("3. Update a product");
        System.out.println("4. Remove a product");
        shadowCommitteeMenu(accessLevel);

        System.out.println("0. Logout");
    }

    public static void sakuraMenu() {
        System.out.println("==========Logged in as:==========");
        System.out.println("=========="+loggedUser.getRole()+"==========");
        System.out.println("Welcome " +loggedUser.getUsername());
        System.out.println("1. Product development");
        System.out.println("2. Content Administration");
        System.out.println("3. User Administration");
        System.out.println("4. Slave Registry");
        shadowCommitteeMenu(AccessLevel.ADMIN);
        System.out.println("0. Logout");

    }

    public static void shadowCommitteeMenu(AccessLevel accessLevel) {

        switch (accessLevel) {
            case ADMIN:
                System.out.println("==========Shadow Comitee==========");
                System.out.println("11. List Members.");
                System.out.println("22. Add a member");
                System.out.println("33. Remove a member");
                System.out.println("44. Is a member?");
            break;
            case VIEW:
                System.out.println("==========Shadow Comitee==========");
                System.out.println("11. List Members.");
                break;
            default:
                break;
        }
    }


    public static void logout() {
        System.out.println("==========Logging out!==========");
        finishedLogin = false;

    }


}
