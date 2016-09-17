package com.volodiachornenkyy.dartdemo.model;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Parcel
public class ExampleModel {
    String name;
    int age;

    @ParcelConstructor
    public ExampleModel(String name, int age) {
        this.name = name;
        this.age = age;
    }
}