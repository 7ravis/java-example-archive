package com.example.springbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bushel {
    /*
     * as long as this class gets component scanned, the @Component annotation will
     * create a bean for this class. creating a bean in the config class is probably
     * preferred because as written this only works well if there is one Bushel bean
     * and one Apple bean.
     */

    /*
     * if there is more than one Apple bean, the @Autowired annotation will cause
     * will a Bushel bean to be created for each Apple bean type. this is a problem
     * since you will not be able to retrieve the Bushel beans by name nor by class.
     * I tried matching a bean name up with the variable name to avoid this, but it
     * still threw an exception.
     */
    @Autowired
    private Apple apple;

    public Bushel(Apple apple) {
	this.apple = apple;
    }

    public Apple getApple() {
	return apple;
    }
}
