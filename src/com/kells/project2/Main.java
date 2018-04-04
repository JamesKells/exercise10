package com.kells.project2;


import java.util.*;


    interface Book{
        void view();
        void select();
    }

    class Person {
        private String personEmail, personName;

        public Person() {
        }

        public Person(String email, String name) {
            System.out.println("Your name is " + name + " and your email is " + email);
            personEmail = email;
            personName = name;

        }

        public  String getPersonEmail() {
            return personEmail;
        }

        public String getPersonName() {
            return personName;
        }
    }

    class Contact extends Person{
        private List<String> contact = new ArrayList<>();
        private String personContact;

        public Contact(String email, String name, String number) {
            super(email, name);
            personContact = number;
        }

        public  String getPersonContact() {
            return personContact;
        }

        public List getContact() {

            contact.add(getPersonEmail());
            contact.add(getPersonContact());
            return contact;
        }
    }

    class Address implements Book{
        private HashMap<String, List> book = new HashMap<>();
        private List<String> keys = new ArrayList<>();

        public Address(){

        }
        public void save(List contact, String name) {
            book.put(name, contact);
            keys.add(name);
        }

        public void view() {
            boolean valid = false;
            int s = 0;
            for (String i : keys){
                System.out.println("Name: " + keys.get(s) + ", Address: " + book.get(keys.get(s)).get(0) + ", Number: " + book.get(keys.get(s)).get(1));
                Scanner scan = new Scanner(System.in);
                String exit;
                System.out.println("Press enter to continue");
                exit = scan.nextLine();
                valid = true;
                s++;
            }

            if (valid == false){
                String exit;
                Scanner scan = new Scanner(System.in);
                System.out.println("No Emails to view(Press enter to continue).");
                exit = scan.nextLine();
            }
        }

        public void select() {
            Scanner scan = new Scanner(System.in);
            String choice = "", exit;
            int condtion = 1;

            if (keys.size() == 0) {
                System.out.println("No Emails to view(Press enter to continue).");
                exit = scan.nextLine();

            } else {
                while (condtion != 0) {
                    scan = new Scanner(System.in);
                    System.out.println("Type in the name of a person who's email you want or push enter without typing anything to stop");
                    choice = scan.nextLine();

                    if (choice.equals("")) {
                        condtion = 0;
                    } else {
                        if (book.get(choice) != null) {
                            System.out.println(choice + "'s email: " + book.get(choice).get(0) + ", " + choice + "'s number: " + book.get(choice).get(1));
                        } else {
                            System.out.println("Try again");
                            scan = new Scanner(System.in);
                            System.out.println(choice + " is not a valid user (Press enter to continue).");
                            exit = scan.nextLine();
                            choice = " ";
                        }
                    }

                }
            }
        }

        public boolean check(boolean check, String name, String number) {
            if (book.size() > 0) {
                if (book.containsKey(name)) {
                    check = false;
                    System.out.println("The name " + name + " is already taken");
                } else if (book.containsValue(number)) {
                    check = false;
                    System.out.println("The number " + number + " is already taken");
                }

            }
            return check;
        }
    }