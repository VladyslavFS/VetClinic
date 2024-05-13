package org.MagicVet.model;

import java.util.Objects;

public class Dog extends Pet {

    public static final String XS = "XS";
    public static final String S = "S";
    public static final String M = "M";
    public static final String L = "L";
    public static final String XL = "XL";
    private String size;

    public Dog() {}
    public Dog(String size, String name) {
        this.size = size;
        this.setName(name);
    }

    public Dog(int age) {
        this.setAge(age);
    }

    public Dog(String owner) {
        this.setOwnerName(owner);
    }

    @Override
    public String toString() {
        return "Dog {" +
                "\n\t\ttype='" + super.getType() + '\'' +
                ", sex='" + super.getSex() + '\'' +
                ", age='" + super.getAge() + '\'' +
                ", size='" + size + '\'' +
                ", name='" + super.getName() + '\'' +
                ", ownerName='" + super.getOwnerName() + '\'' +
                "\n\t}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(size, dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
