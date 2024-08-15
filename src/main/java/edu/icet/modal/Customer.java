package edu.icet.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private String customerId;
    private String title;
    private String name;
    private  String address;
    private String number;
    private LocalDate dob;
}
