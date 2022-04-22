package com.github.wouterman.springbootbehaviorparameterization.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cake implements Candy {

  private String flavor;
  private Integer weight;
}