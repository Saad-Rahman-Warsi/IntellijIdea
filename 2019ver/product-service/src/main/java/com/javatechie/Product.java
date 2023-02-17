package com.javatechie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
     private int id;
     private String name;
     private double price;
     public double getPrice()
     {
          return price;
     }
     public void setPrice(double price)
     {
          this.price=price;
     }
}
