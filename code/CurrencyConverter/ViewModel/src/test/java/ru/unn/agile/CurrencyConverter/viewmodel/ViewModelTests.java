package ru.unn.agile.CurrencyConverter.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.CurrencyConverter.model.*;
import ru.unn.agile.CurrencyConverter.viewmodel.ViewModel.*;

import static org.junit.Assert.*;

public class ViewModelTests {
    private ViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ViewModel();
    }
    @After
    public void tearDown() {
        viewModel = null;
    }

    @Test
    public void canSetDefaultValues() {
        assertEquals("", viewModel.amountProperty().get());
        assertEquals(Constants.RUBLE, viewModel.fromCurrencyProperty().get());
        assertEquals(Constants.DOLLAR, viewModel.toCurrencyProperty().get());
        assertEquals("", viewModel.resultingValueProperty().get());
        assertEquals(MessageStatus.WAITING.getValue(), viewModel.messageProperty().get());
    }
    @Test
    public void canMessageWaitingFormatWithEmptyAmount() {
        viewModel.convert();
        assertEquals(MessageStatus.WAITING.getValue(), viewModel.messageProperty().get());
    }
    @Test
    public void canMessageReadyFormatWithFilledAmount() {
        setInputData();
        assertEquals(MessageStatus.READY.getValue(), viewModel.messageProperty().get());
    }
    @Test
    public void canMessageSuccessFormatAfterConvert() {
        setInputData();
        viewModel.convert();
        assertEquals(MessageStatus.SUCCESS.getValue(), viewModel.messageProperty().get());
    }
    @Test
    public void canMessageFailedFormat() {
        viewModel.amountProperty().set("one");
        assertEquals(MessageStatus.FAILED.getValue(), viewModel.messageProperty().get());
    }
    @Test
    public void canMessageFailedFormatForNegativeAmount() {
        viewModel.amountProperty().set("-78");
        assertEquals(MessageStatus.FAILED.getValue(), viewModel.messageProperty().get());
    }
    @Test
    public void canSetRUBLEFromCurrency() {
        viewModel.fromCurrencyProperty().set(Constants.RUBLE);
        assertEquals(Constants.RUBLE, viewModel.fromCurrencyProperty().get());
    }
    @Test
    public void canSetRUBLEToCurrency() {
        viewModel.toCurrencyProperty().set(Constants.RUBLE);
        assertEquals(Constants.RUBLE, viewModel.toCurrencyProperty().get());
    }
    @Test
    public void canSetDOLLARFromCurrency() {
        viewModel.fromCurrencyProperty().set(Constants.DOLLAR);
        assertEquals(Constants.DOLLAR, viewModel.fromCurrencyProperty().get());
    }
    @Test
    public void canSetDOLLARToCurrency() {
        viewModel.toCurrencyProperty().set(Constants.DOLLAR);
        assertEquals(Constants.DOLLAR, viewModel.toCurrencyProperty().get());
    }
    @Test
    public void canSetEUROFromCurrency() {
        viewModel.fromCurrencyProperty().set(Constants.EURO);
        assertEquals(Constants.EURO, viewModel.fromCurrencyProperty().get());
    }
    @Test
    public void canSetEUROToCurrency() {
        viewModel.toCurrencyProperty().set(Constants.EURO);
        assertEquals(Constants.EURO, viewModel.toCurrencyProperty().get());
    }
    @Test
    public void canSetHRYVNAFromCurrency() {
        viewModel.fromCurrencyProperty().set(Constants.HRYVNA);
        assertEquals(Constants.HRYVNA, viewModel.fromCurrencyProperty().get());
    }
    @Test
    public void canSetHRYVNAToCurrency() {
        viewModel.toCurrencyProperty().set(Constants.HRYVNA);
        assertEquals(Constants.HRYVNA, viewModel.toCurrencyProperty().get());
    }
    @Test
    public void canSetYENFromCurrency() {
        viewModel.fromCurrencyProperty().set(Constants.YEN);
        assertEquals(Constants.YEN, viewModel.fromCurrencyProperty().get());
    }
    @Test
    public void canSetYENToCurrency() {
        viewModel.toCurrencyProperty().set(Constants.YEN);
        assertEquals(Constants.YEN, viewModel.toCurrencyProperty().get());
    }
    @Test
    public void canSetFRANCFromCurrency() {
        viewModel.fromCurrencyProperty().set(Constants.FRANC);
        assertEquals(Constants.FRANC, viewModel.fromCurrencyProperty().get());
    }
    @Test
    public void canSetFRANCToCurrency() {
        viewModel.toCurrencyProperty().set(Constants.FRANC);
        assertEquals(Constants.FRANC, viewModel.toCurrencyProperty().get());
    }
    @Test
    public void checkDisabledButtonForEmptyAmount() {
        assertTrue(viewModel.convertionDisabledProperty().get());
    }
    @Test
    public void checkDisabledButtonForCorrectAmount() {
        viewModel.amountProperty().set("32");
        assertFalse(viewModel.convertionDisabledProperty().get());
    }
    @Test
    public void checkDisabledButtonForIncorrectAmount() {
        viewModel.amountProperty().set("Two");
        assertTrue(viewModel.convertionDisabledProperty().get());
    }
    @Test
    public void checkDisabledButtonForNegativeAmount() {
        viewModel.amountProperty().set("-98");
        assertTrue(viewModel.convertionDisabledProperty().get());
    }
    @Test
    public void checkDisabledButtonAfterConvert() {
        viewModel.amountProperty().set("32");
        viewModel.convert();
        assertFalse(viewModel.convertionDisabledProperty().get());
    }
    @Test
    public void convertFromRubleToDollar() {
        viewModel.amountProperty().set("125.24");
        viewModel.fromCurrencyProperty().set(Constants.RUBLE);
        viewModel.toCurrencyProperty().set(Constants.DOLLAR);
        viewModel.convert();
        assertEquals("2.0", viewModel.resultingValueProperty().get());
    }
    @Test
    public void checkTheFirstCurrencyInBox() {
        assertEquals(Constants.values()[0], viewModel.getCurrencies().get(0));
    }
    @Test
    public void checkTheSecondCurrencyInBox() {
        assertEquals(Constants.values()[1], viewModel.getCurrencies().get(1));
    }
    @Test
    public void checkTheThirdCurrencyInBox() {
        assertEquals(Constants.values()[2], viewModel.getCurrencies().get(2));
    }
    @Test
    public void checkTheForthCurrencyInBox() {
        assertEquals(Constants.values()[3], viewModel.getCurrencies().get(3));
    }
    @Test
    public void checkTheFifthCurrencyInBox() {
        assertEquals(Constants.values()[4], viewModel.getCurrencies().get(4));
    }
    @Test
    public void checkTheSixthCurrencyInBox() {
        assertEquals(Constants.values()[5], viewModel.getCurrencies().get(5));
    }
    @Test
    public void checkFirstValueFromCurrenciesProperty() {
        assertEquals(Constants.values()[0], viewModel.currenciesProperty().get().get(0));
    }
    @Test
    public void checkSecondValueFromCurrenciesProperty() {
        assertEquals(Constants.values()[1], viewModel.currenciesProperty().get().get(1));
    }
    @Test
    public void checkThirdValueFromCurrenciesProperty() {
        assertEquals(Constants.values()[2], viewModel.currenciesProperty().get().get(2));
    }
    @Test
    public void checkForthValueFromCurrenciesProperty() {
        assertEquals(Constants.values()[3], viewModel.currenciesProperty().get().get(3));
    }
    @Test
    public void checkFifthValueFromCurrenciesProperty() {
        assertEquals(Constants.values()[4], viewModel.currenciesProperty().get().get(4));
    }
    @Test
    public void checkSixthValueFromCurrenciesProperty() {
        assertEquals(Constants.values()[5], viewModel.currenciesProperty().get().get(5));
    }
    @Test
    public void checkStringResultingValue() {
        setInputData();
        viewModel.convert();
        assertEquals("125.24", viewModel.getResultingValue());
    }
    @Test
    public void checkStringMessage() {
        setInputData();
        viewModel.convert();
        assertEquals(MessageStatus.SUCCESS.getValue(), viewModel.getMessage());
    }
    @Test
    public void isButtonDisabledWithEmptyData() {
        assertTrue(viewModel.getConvertionDisabled());
    }

    public void setInputData() {
        viewModel.amountProperty().set("2");
        viewModel.fromCurrencyProperty().set(Constants.DOLLAR);
        viewModel.toCurrencyProperty().set(Constants.RUBLE);
    }
}
