package konu_anlatimi;

import org.testng.annotations.DataProvider;

public class DataRepo {

    /**
     * DataProvider bu sekilde baska bir class icerisinde tanimlanabilir,
     * Bu bilgileri kullanirken Test annotations a data provider in class bilgiside verilir ayrica
     * data provider paralel testi destekler, bunun icin name bilgisinden sonra parallel = true yazilamsi gerekir
     * */
    @DataProvider(name = "userData", parallel = true)
    public Object[][] getUserData(){
        return new Object[][]{
            {"Baris", 24},
                {"Ramazan", 27},
                {"Merve", 23}
        };
    }
}
