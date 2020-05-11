package org.launchcode.techjobs_oo;

import java.util.Objects;

public abstract class  JobFields {
    private int id;
    private static int nextId = 1;
    private String value;

    public JobFields() {
        this.id = nextId;
        nextId++;
    }

    public JobFields(String value) {
        this();
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobFields jobFields = (JobFields) o;
        return id == jobFields.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

}
