# Sakura Enterprises – Console App 🌸

Hi! This is a tiny console system for **Sakura Enterprises**, where different user roles log in and get different menus (clients, admins, devs... and Sakura herself obviously).

This README is just to explain how to use the part that’s already working (login + menus).

---

## How to run it 🖥️

1. Open the project in your IDE (IntelliJ, etc.).
2. Make sure the SDK is set up (Java).
3. Run the `Main` class.
4. You should see:

Hello This is Sakura Enterprises, Please Identify yourself! 😊
==========Login==========

Login

Register client account

Exit


---

## Login & registration 🔐

From the login screen you can:

- `1. Login`  
Enters with existing username + password.  
Uses `AuthService.login()`. If the data is wrong, it throws an exception and shows the error message.

- `2. Register client account`  
Creates a new `Client` with:
- username  
- password (min length)  
- email  
- delivery address  
- telephone  

If everything is OK, the client is created, added to the system and logged in directly.

- `0. Exit`  
Closes the program.

---

## Role-based menus 👥

After login, the app checks what type of user you are and sends you to a specific menu:

- `Client` → sees a **client menu** with options like:
- browse products  
- view cart  
- add payment method  
- finalize purchase  

> These options are **not fully implemented yet**. The menu is there as a structure for the shop system, but the logic is still WIP.

- `ProductDeveloper` → can create new products.

- `ContentAdmin` → can:
- create, edit, delete products  
- create categories  
- (depending on access level) see Shadow Committee options.

- `UserAdmin` → can:
- create employee users  
- activate/deactivate accounts  
- reset passwords  
- (depending on access level) manage Shadow Committee members.

- `Sakura` → the drama queen of the system:
- Can open the Product Developer, Content Admin, and User Admin menus with full power.
- Also has a menu option for **“Slave Registry”**, which is only a placeholder for now.

---

## What’s intentionally unfinished 🧩

Some things are **deliberately left as “work in progress”**: Sorry zapata for letting you down!

- The **client shopping flow** (cart, payment, checkout) is only represented in the menu, not fully coded.
- The **“Slave Registry”** under Sakura’s menu is just a reserved option for the “secret operations” part of the story, not implemented in this version.

The focus of this delivery is:
- login & registration  
- role-based access  
- product and category management  
- admin tools + Shadow Committee integration  

Future versions could plug in the full shop logic and the hidden modules.
