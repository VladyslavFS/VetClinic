package org.MagicVet.model;

import java.util.Objects;

public class Dog extends Pet {
    private Size size;

    public Dog() {}
    public Dog(Size size, String name) {
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

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public enum Size {
        XS(1), S(2), M(3), L(4), XL(5), UNKNOWN(0);
        private final int value;

        Size(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
