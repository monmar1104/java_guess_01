package com.infoshareacademy;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class AppTest {

    private static final Product WHISKY = newProduct("whisky", 90);
    private static final Product RUM = newProduct("rum",60);

    private static Product newProduct(String name, Integer price) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        return p;
    }

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private App app = new App();

    @Test
    public void listAllProductsAndPrices_1productOnly_correctListening() {
        //given
        when(productDao.getAllProducts()).thenReturn(products(WHISKY));
        //when
        String out = app.listAllProductsAndPrices();

        //then
        assertThat(out).isNotEmpty();
        assertThat(out).isEqualTo("whisky 90\n");
    }

    @Test
    public void listAllProductsAndPrices_2products_correctListening() {
        //given
        when(productDao.getAllProducts()).thenReturn(products(WHISKY, RUM));
        //when
        String out = app.listAllProductsAndPrices();

        //then
        assertThat(out).contains("whisky 90");
        assertThat(out).contains("rum 60");
        assertThat(out).hasLineCount(2);
        assertThat(out).endsWith("\n");
    }

    private List<Product> products(Product ... product) {
        List<Product> output = new ArrayList<Product>();

        for (Product p : product) {
            output.add(p);
        }
        return output;
    }


    @Test
    public void increasePriceOfAllProducts_noProducts_noActions() {
        //given:
        //todo A1. zamokuj dao tak, żeby zasymulować brak produktów
        when(productDao.getAllProducts()).thenReturn(products());
        //when
        app.increasePriceOfAllProducts(10);

        //then
        // todo A2. zweryfikuj, że nie było żadnych operacji na dao używając verify
        verify(productDao, never()).updatePrice(any(Product.class), anyInt());
    }


    @Test
    public void increasePriceOfAllProducts_oneProduct_priceWasIncreasedCorrectly() {
        //given:
        // todo B1. zamokuj dao tak, żeby był jakiś produkt w bazie danych, podaj cenę (np. 100)
        Product WODA = newProduct("Woda sodowa", 10);
        when(productDao.getAllProducts()).thenReturn(products(WODA));
        //when
        app.increasePriceOfAllProducts(10);

        //then
        // todo B2. zweryfikuj, że dao zostało wywołane i cena została zwiększona do 110.
        verify(productDao).updatePrice(WODA,11);
    }

    @Test
    public void increasePriceOfAllProducts_twoProducts_priceWasIncreasedCorrectly() {
        //given:
        // todo B3*. przygotuj podobny test, ale z dwoma produktami.
        Product WODA = newProduct("Woda sodowa", 10);
        Product WINO = newProduct("Wino marki wino", 20);
        when(productDao.getAllProducts()).thenReturn(products(WODA, WINO));
        //when
        app.increasePriceOfAllProducts(10);
        //then
        verify(productDao).updatePrice(WODA,11);
        verify(productDao).updatePrice(WINO,22);
    }


    @Test
    public void increasePriceOfAllProducts_twoProducts_priceWasDecreaseCorrectly() {
        //given:
        // todo C*: napisz test sprawdzający obniżenie ceny produktu
        Product WODA = newProduct("Woda sodowa", 10);
        Product WINO = newProduct("Wino marki wino", 20);
        when(productDao.getAllProducts()).thenReturn(products(WODA, WINO));
        //when
        app.increasePriceOfAllProducts(-10);
        //then
        verify(productDao).updatePrice(WODA,9);
        verify(productDao).updatePrice(WINO,18);
    }


    @Test
    public void getCurrentPriceForProduct_productNotFound_priceIsZero() throws EntityNotFoundException {
        //given:
        //todo D1. zamokuj dao tak, aby ser szwajcarski był niedostępny
        when(productDao.getProductWithName("Ser szwajcarski")).thenThrow(new EntityNotFoundException());
        //when
        Integer price = app.getCurrentPriceForProduct("Ser szwajcarski");

        //then
        //todo D2. sprawdź czy cena produktu jest = 0 (napisz asercję)
        assertThat(price).isEqualTo(0);

    }

    // todo E - napisz pozytywny scenariusz dla metody getCurrentPriceForProduct (min dwa produkty w bazie danych, z różną ceną)
    // skup się również na odpwiednim nazwaniu metody testowej
    @Test
    public void getCurrentPriceForProduct_twoProducts_differentPrice() throws EntityNotFoundException {
        //given:
        // todo E - napisz pozytywny scenariusz dla metody getCurrentPriceForProduct (min dwa produkty w bazie danych, z różną ceną)
        Product WODA = newProduct("Woda sodowa", 10);
        Product WINO = newProduct("Wino marki wino", 20);
        when(productDao.getProductWithName(WODA.getName())).thenReturn(WODA);
        when(productDao.getProductWithName(WINO.getName())).thenReturn(WINO);

        //when
        Integer waterPrice = app.getCurrentPriceForProduct("Woda sodowa");
        Integer winePrice = app.getCurrentPriceForProduct("Wino marki wino");

        //then
        assertThat(waterPrice).isEqualTo(10);
        assertThat(winePrice).isEqualTo(20);

    }

    // todo F - napisz test dla metody getCurrentPriceForProduct w którym argument wejsciowy jest = null
    // test ma sprawdzać, że został rzucony wyjątek (IllegalArgumentException)
    @Test(expected = IllegalArgumentException.class)
    public void getCurrentPriceForProduct_nullArg_exceptionReturned() {
        app.getCurrentPriceForProduct(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getCurrentPriceForProduct_nullArg_exceptionReturnedWithCorrectMessage() {
        try{
            app.getCurrentPriceForProduct(null);

            fail("metoda w tym teście powinna rzucić wyjątek, a nie rzuciła");
        } catch( IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("productName can not be null!");
            throw e;
        }
    }

}
