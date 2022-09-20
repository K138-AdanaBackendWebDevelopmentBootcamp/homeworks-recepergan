package com.rcpergan.model;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class PermanentResearcher extends Instructor {
    private int fixedSalary;


    public PermanentResearcher(String name, String address, String phoneNumber, int fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public PermanentResearcher() {

    }

    public int getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(int fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PermanentResearcher that = (PermanentResearcher) o;
        return fixedSalary == that.fixedSalary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fixedSalary);
    }

    @Override
    public String toString() {
        return "com.rcpergan.model.PermanentInstructor{" +
                "fixedSalary=" + fixedSalary +
                '}';
    }
}
