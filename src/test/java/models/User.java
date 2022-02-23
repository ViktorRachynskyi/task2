package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    String firstName;
    String lastName;
    String email;
    String sex;
    String phone;
    String year;
    String month;
    String day;
    String subject;
    String hobby;
    String photo;
    String address;
    String state;
    String city;
}
