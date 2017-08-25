package com.moli.admin;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


/**
 * Created by yu.yan on 2017/7/14.
 */
public class DemoTest {
    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void manufacturerIsNull() {
        System.out.println(">>>>>>>>test");
    }

    @Test
    public void testANormal(){
        // junit
        // mockito
    }

    @Test
    public void testAException(){

    }
}
