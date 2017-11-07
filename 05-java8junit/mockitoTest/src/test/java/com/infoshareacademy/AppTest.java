package com.infoshareacademy;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


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

    private App app;

    @Before
    public void init() {
        app = new App(productDao);
    }



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

        //when
        app.increasePriceOfAllProducts(10);

        //then
        // todo A2. zweryfikuj, że nie było żadnych operacji na dao używając verify
        //Mockito.verify(productDao
    }


    @Test
    public void increasePriceOfAllProducts_oneProduct_priceWasIncreasedCorrectly() {
        //given:
        // todo B1. zamokuj dao tak, żeby był jakiś produkt w bazie danych, podaj cenę (np. 100)

        //when
        app.increasePriceOfAllProducts(10);

        //then
        // todo B2. zweryfikuj, że dao zostało wywołane i cena została zwiększona do 110.

    }
    // todo B3*. przygotuj podobny test, ale z dwoma produktami.



    // todo C*: napisz test sprawdzający obniżenie ceny produktu



    @Test
    public void getCurrentPriceForProduct_productNotFound_priceIsZero() {
        //given:
        //todo D1. zamokuj dao tak, aby ser szwajcarski był niedostępny

        //when
        Integer price = app.getCurrentPriceForProduct("Ser szwajcarski");

        //then
        //todo D2. sprawdź czy cena produktu jest = 0 (napisz asercję)

    }


    // todo E - napisz pozytywny scenariusz dla metody getCurrentPriceForProduct (min dwa produkty w bazie danych, z różną ceną)
    // skup się również na odpwiednim nazwaniu metody testowej


    // todo F - napisz test dla metody getCurrentPriceForProduct w którym argument wejsciowy jest = null
    // test ma sprawdzać, że został rzucony wyjątek (IllegalArgumentException)


    //todo G * - Usuń adnotację na poziomie klasy (@RunWith(MockitoJUnitRunner.class).
    // Co należy zrobić, żeby mockito działało prawidłowo a istniejace testy nadal działały?



    // todo H * - Sprobuj pozbyć się ręcznego wstrzykiwania zależności poprzez konstruktor i wykorzystaj adnotację @InjectMocks
    // (w tym celu użyj konstruktora bez parametrów z klasy App)


}
