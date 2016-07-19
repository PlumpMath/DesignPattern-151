package com.tomchen.designpattern;

import com.tomchen.designpattern.rent.Mediator;
import com.tomchen.designpattern.rent.Tenant;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        Tenant tenant = new Tenant(1,10000);
        Mediator mediator = new Mediator();
        tenant.rentRoom(mediator);
    }
}