package fr.m2i.formation.javatuto;

import fr.m2i.formation.models.Group;
import fr.m2i.formation.models.Student;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //"Hugo", "Kesavan", "Lisa", "Benoit", "Fabrice", "Ségolène", "Jean-Philippe", "Victor", "Baptiste", "Maud", "Joris"


        System.out.println("Combien d'élèves voulez-vous ajouter ?");
        int nbOfStudents = scanner.nextInt();

        //Création du tableau students avec valeurs null
        Student[] studentsStart = new Student[nbOfStudents];

        //Création des étudiants avec leur nom et leur id
        for(int i = 0; i < nbOfStudents; i++) {
            System.out.println("Entrer un nom");
            String nameInput = scanner.next();
            studentsStart[i] = new Student(nameInput, i + 1);
        }

        //Randomisation de la liste des étudiants
        Student[] students = new Student[nbOfStudents];

        int Temp = nbOfStudents;
            do {
                int randomIndex = new Random().nextInt(studentsStart.length);
                if(students[randomIndex] == null) {
                    students[randomIndex] = studentsStart[Temp -1];
                    Temp--;
                }
            } while (Temp > 0);


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

        //Remplissage du groupe de trois
        if(groupOfThree.getRemainingSpots() > 0 && nbOfStudents >= 5 && !isGroupEven) {
            for(int i = 0; i < nbOfStudents; i++) {
                students[i].setGroup(nbOfEvenGroups + 1);
                groupOfThree.getStudentsInGroup().add(students[i]);
                groupOfThree.minusOneRemainingSpot();
             }
        }

        //Remplissage des groupes de deux
        for (int i = 0; i < (nbOfStudents % 2 == 0 ? nbOfStudents : (nbOfStudents - 3)); i++) {
            for (int j = 0; j < evenGroupArray.length; j++) {
                if(evenGroupArray[j].getRemainingSpots() > 0 && !students[i].isAssginedGroup()) {
                    students[i].setGroup(evenGroupArray[j].getGroupId());
                    students[i].setAssginedGroup(true);
                    evenGroupArray[j].minusOneRemainingSpot();
                }
            }
        }


        //Affichage des groupes
        for (int i = 0; i < nbOfStudents; i++) {
            System.out.println(students[i].getName() + " est dans le groupe " + students[i].getGroup());
        }


}
}
