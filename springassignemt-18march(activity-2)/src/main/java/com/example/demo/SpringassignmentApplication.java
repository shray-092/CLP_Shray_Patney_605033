package com.example.demo;

import com.example.demo.entity.Trainee;
import com.example.demo.service.TraineeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpringassignmentApplication implements CommandLineRunner {

    @Autowired
    private TraineeService service;

    public static void main(String[] args) {
        SpringApplication.run(SpringassignmentApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Insert");
            System.out.println("2. Display All");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    Trainee t = new Trainee();

                    System.out.print("Enter Name: ");
                    t.setTraineeName(sc.next());

                    System.out.print("Enter Domain: ");
                    t.setTraineeDomain(sc.next());

                    System.out.print("Enter Location: ");
                    t.setTraineelocation(sc.next());

                    Trainee saved = service.serviceinsert(t);
                    System.out.println("Inserted ID: " + saved.getTraineeId());
                    break;

                case 2:
                    List<Trainee> list = service.servicedisplay();
                    list.forEach(x -> System.out.println(
                            x.getTraineeId() + " " +
                            x.getTraineeName() + " " +
                            x.getTraineeDomain() + " " +
                            x.getTraineelocation()
                    ));
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();

                    Trainee ut = new Trainee();

                    System.out.print("Enter New Name: ");
                    ut.setTraineeName(sc.next());

                    System.out.print("Enter New Domain: ");
                    ut.setTraineeDomain(sc.next());

                    System.out.print("Enter New Location: ");
                    ut.setTraineelocation(sc.next());

                    Trainee updated = service.serviceupdate(uid, ut);

                    if (updated != null)
                        System.out.println("Updated Successfully");
                    else
                        System.out.println("Not Found");
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int did = sc.nextInt();

                    Trainee deleted = service.servicedelete(did);

                    if (deleted != null)
                        System.out.println("Deleted: " + deleted.getTraineeName());
                    else
                        System.out.println("Not Found");
                    break;

                case 5:
                    System.out.println("Exit...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}