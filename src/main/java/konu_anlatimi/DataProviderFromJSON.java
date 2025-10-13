package konu_anlatimi;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class DataProviderFromJSON {

    @DataProvider(name = "jsonData")
    public Object[][] getDataFromJson(){

        // JSON dan veriler okundu
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"Seyma", 28});
        data.add(new Object[]{"Merve", 27});
        data.add(new Object[]{"Taha", 29});

        return data.toArray(new Object[0][0]);
    }
}
