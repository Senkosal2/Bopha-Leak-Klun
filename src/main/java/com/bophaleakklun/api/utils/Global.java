package com.bophaleakklun.api.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Global {

    public static enum UserType {
        ADMIN,
        USER,
        DELIVERY,
        MERCHANT
    }

    public static enum OrderStatus{
        CANCELED,
        PENDING,
        SUCCESS, 
        FAILED
    }

    public static String encrptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public static boolean verifyPassword(String password, String hashedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, hashedPassword);
    } 

    // generic class for converting List<DTO> to List<Entity> or List<Entity> to List<DTO>
    // if ToConvert is DTO then ConvertedTo is Entity
    // if ToConvert is Entity then ConvertedTo is DTO 
    // public static <ToConvert, ConvertedTo> List<ConvertedTo> toList(
    //         List<ToConvert> sources,
    //         BiFunction<Object, ToConvert, ConvertedTo> converter,
    //         Object instance) {

    //     List<ConvertedTo> results = new ArrayList<>();
    //     for (ToConvert source : sources) {
    //         results.add(converter.apply(instance, source));  // Apply method on instance
    //     }
    //     return results;
    // }
}