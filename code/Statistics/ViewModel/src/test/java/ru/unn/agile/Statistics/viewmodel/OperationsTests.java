package ru.unn.agile.Statistics.viewmodel;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static ru.unn.agile.Statistics.viewmodel.ViewModel.DEFAULT_DELTA;
import static ru.unn.agile.Statistics.viewmodel.ViewModel.Status.SUCCESS;


public class OperationsTests extends Core {
    @After
    public void checkPersistentParameters() {
        assertEquals(DEFAULT_DELTA, vm().getDelta());
        assertStatusIs(SUCCESS);
        assertTrue(vm().isCalculateButtonEnabled());
    }

    @Test
    public void canCalculateDefaultOperation() {
        fillInputFields();
        vm().calculate();
    }



    @Test
    public void canCalculateExpectedValue() {
        fillInputFields();
        vm().setOperation(Operation.EV);
        vm().calculate();

        assertEquals(TEST_RESULT_EV, vm().getResult());
    }

    @Test
    public void canCalculateVariance() {
        fillInputFields();
        vm().setOperation(Operation.VAR);
        vm().calculate();

        assertEquals(TEST_RESULT_VAR, vm().getResult());
    }

    @Test
    public void canCalculateFirstInitialMoment() {
        fillInputFields();
        vm().setOperation(Operation.IM);
        vm().setMomentOrder("1");
        vm().calculate();

        assertEquals(TEST_RESULT_IM1, vm().getResult());
    }

    @Test
    public void canCalculateSecondInitialMoment() {
        fillInputFields();
        vm().setOperation(Operation.IM);
        vm().setMomentOrder("2");
        vm().calculate();

        assertEquals(TEST_RESULT_IM2, vm().getResult());
    }
}
