package org.MagicVet.model;

import java.util.Objects;

public abstract class Pet {
    private HealthState healthState;
    private String type;
    private String sex;
    private int age;
    private String name;
    private String ownerName;

    @Override
    public String toString() {
        return "Pet {" +
                "\n\t\ttype='" + type + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", name='" + name + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", state of health='" + healthState + '\'' +
                "\n\t}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(type, pet.type)
                && Objects.equals(sex, pet.sex)
                && Objects.equals(age, pet.age)
                && Objects.equals(name, pet.name)
                && Objects.equals(ownerName, pet.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, ownerName);
    }

    public HealthState getHealthState() {
        return healthState;
    }

    public void setHealthState(HealthState healthState) {
        this.healthState = healthState;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public enum HealthState {
        HEALTHY(4), RECOVERING(3), INJURED(2), SICK(1), UNKNOWN(0);

        private final int value;

        HealthState(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public static HealthState fromValue(int value) {
            for (HealthState state : HealthState.values()) {
                if (state.value == value) {
                    return state;
                }
            }
            return null;
        }
    }
}
