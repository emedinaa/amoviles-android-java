package com.emedinaa.java.entity;

public class PersonEntity {

    private int id;
    private String name;
    private String lastname;
    private String dni;

    public PersonEntity() {
    }

    public PersonEntity(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public PersonEntity(String dni) {
        this.dni = dni;
    }

    public PersonEntity(int id, String name, String lastname, String dni) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
    }

    //métodos de acceso
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
