package com.lugew.datastructure.java.array.study;

public class ClassDataArray {
    private Person[] array;
    private int elements;

    public ClassDataArray(int maxElements) {
        this.array = new Person[maxElements];
        this.elements = 0;
    }

    public Person find(String searchKey) {
        int j;
        for (j = 0; j < elements; j++) {
            if (array[j].getFirstName().equals(searchKey)) {
                break;
            }
        }
        if (j == elements) {
            return null;
        }
        return array[j];
    }

    public void insert(String first, String last, int age) {
        array[elements++] = new Person(first, last, age);
    }

    public boolean delete(String value) {
        int j;
        for (j = 0; j < elements; j++) {
            if (value.equals(array[j].getFirstName())) {
                break;
            }
        }
        if (j == elements) {
            return false;
        } else {
            for (int i = j; i < elements; i++) {
                array[i] = array[i + 1];
            }
            elements--;
            return true;
        }
    }

    public void display() {
        for (int i = 0; i < elements; i++) {
            array[i].displayPerson();
        }
    }

    public static void main(String[] args) {
        ClassDataArray classDataArray = new ClassDataArray(100);
        classDataArray.insert("Evans", "Patty", 24);
        classDataArray.insert("Smith", "Lorraine", 37);
        classDataArray.insert("Yee", "Tom", 43);
        classDataArray.insert("Adams", "Henry", 63);
        classDataArray.insert("Hashimoto", "Sato", 21);
        classDataArray.insert("Stimson", "Henry", 29);
        classDataArray.insert("Velasquez", "Jose", 72);
        classDataArray.insert("Lamarque", "Henry", 54);
        classDataArray.insert("Vang", "Minh", 22);
        classDataArray.insert("Creswell", "Lucinda", 18);
        classDataArray.display();

        String searchName = "Stimson";
        Person found = classDataArray.find(searchName);
        if (found != null) {
            System.out.println("Found ");
            found.displayPerson();
        } else {
            System.out.println("Can't find " + searchName);
        }
        System.out.println("Deleting Smith,Yee,and Creswell");
        classDataArray.delete("Smith");
        classDataArray.delete("Yee");
        classDataArray.delete("Creswell");

        classDataArray.display();
        
    }
}
