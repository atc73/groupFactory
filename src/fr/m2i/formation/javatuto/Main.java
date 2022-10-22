package fr.m2i.formation.javatuto;

import fr.m2i.formation.models.Group;
import fr.m2i.formation.models.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //"Hugo", "Kesavan", "Lisa", "Benoit", "Fabrice", "Ségolène", "Jean-Philippe", "Victor", "Baptiste", "Maud", "Joris"


        System.out.println("Combien d'élèves voulez-vous ajouter ?");
        int nbOfStudents = scanner.nextInt();

        //Création du tableau students avec valeurs null
        Student[] students = new Student[nbOfStudents];

        //Création des étudiants avec leur nom et leur id
        for(int i = 0; i < nbOfStudents; i++) {
            System.out.println("Entrer un nom");
            String nameInput = scanner.next();
            students[i] = new Student(nameInput, i + 1);
        }


        //Les groupes sont-ils pairs ? Nombre de groupes pairs.
        int nbOfEvenGroups;
        boolean isGroupEven = nbOfStudents % 2 == 0 ? true : false;

        if (isGroupEven) {
            nbOfEvenGroups = nbOfStudents / 2;
        } else {
            nbOfEvenGroups = (nbOfStudents - 3) / 2;
        }

        //Création des groupes de deux
        Group[] evenGroupArray = new Group[nbOfEvenGroups];
        for(int i = 0; i < evenGroupArray.length; i++) {
            evenGroupArray[i] = new Group(2, 2, i + 1);
        }

        //Création du groupe de trois
        Group groupOfThree = new Group(3, 3, nbOfEvenGroups + 1);


        for(int i = 0; i < nbOfStudents; i++) {
            //Remplissage du groupe de trois
            if(groupOfThree.getRemainingSpots() > 0) {
                students[i].setGroup(nbOfEvenGroups + 1);
                groupOfThree.getStudentsInGroup().add(students[i]);
                groupOfThree.minusOneRemainingSpot();
            } else {
                //Remplissage des groupes de deux
                for(int j = 0; j < evenGroupArray.length; j++) {
                    if(evenGroupArray[j].getRemainingSpots() > 0) {
                        students[i].setGroup(evenGroupArray[j].getGroupId());
                        evenGroupArray[j].minusOneRemainingSpot();
                        evenGroupArray[j].getStudentsInGroup().add(students[i]);
                    }
                }
            }
        }


}
}
