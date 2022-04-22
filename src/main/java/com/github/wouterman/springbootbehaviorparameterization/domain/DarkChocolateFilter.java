package com.github.wouterman.springbootbehaviorparameterization.domain;

import java.util.function.Predicate;

public class DarkChocolateFilter implements Predicate<Chocolate>  {

    @Override
    public boolean test(Chocolate chocolate) {
      return chocolate.getType().equals("dark");
    }

}
