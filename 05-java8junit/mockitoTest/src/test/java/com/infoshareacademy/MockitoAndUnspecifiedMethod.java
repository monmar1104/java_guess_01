
package com.infoshareacademy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class MockitoAndUnspecifiedMethod {

    @Mock
    private ProductDao productDao;

    @Test
    public void productDao_nostubbing_collections() {
        //wszystkie metody w naszym mocku, które zwracają kolekcję, a ich zachowanie nie zostało określone (poprzez stubbing)
        // będą zwracały pustą kolekcję:

        assertThat(productDao.getAllProducts()).isEmpty();
        assertThat(productDao.getAllProductsWithPriceGreaterThan(10)).isEmpty();
        assertThat(productDao.getNCheapestProducts(1)).isEmpty();
    }

    @Test
    public void methodReturningNumber_zero() {
        // dla liczb (tutaj akurat Integer) - będzie to 0
        App app = Mockito.mock(App.class);
        assertThat(app.getCurrentPriceForProduct("test")).isEqualTo(0);
    }


    @Test
    public void methodReturningObject_null() {
        //w przypadku obiektów - null
        List<Product> products = Mockito.mock(List.class);
        assertThat(products.get(10)).isNull();

        when(products.get(11)).thenReturn(new Product());
        assertThat(products.get(11)).isNotNull();
    }

    @Test
    public void boolean_false() {
        //w przypadku zmiennych boolean - false
        List<Product> products = Mockito.mock(List.class);
        assertThat(products.isEmpty()).isFalse();
        assertThat(products.add(new Product())).isFalse();
    }




}
