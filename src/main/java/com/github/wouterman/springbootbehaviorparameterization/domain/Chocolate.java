package com.github.wouterman.springbootbehaviorparameterization.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chocolate implements Candy {

  private String type;
  private Integer weight;
}
