package com.example.homwework03.model;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class VisitingResearcher extends Instructor{

    private int hourlySalarly;

    public VisitingResearcher(String name, String address, String phoneNumber, int hourlySalarly) {
        super(name, address, phoneNumber);
        this.hourlySalarly = hourlySalarly;
    }

    public VisitingResearcher() {

    }

    public int getHourlySalarly() {
        return hourlySalarly;
    }

    public void setHourlySalarly(int hourlySalarly) {
        this.hourlySalarly = hourlySalarly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VisitingResearcher that = (VisitingResearcher) o;
        return hourlySalarly == that.hourlySalarly;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hourlySalarly);
    }

    @Override
    public String toString() {
        return "com.rcpergan.model.VisitingResearcher{" +
                "hourlySalarly=" + hourlySalarly +
                '}';
    }
}
