package dataProvider;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class dataprovider {

    @DataProvider(name = "filter-checkbox")
    public Object[][] dp(){
        return new Object[][] { {"GoodForKids","CA:San_Francisco::Outer_Sunset"},
                                {"RestaurantsGoodForGroups","CA:San_Francisco::Inner_Richmond"},
                                {"GoodForMeal.dinner","CA:San_Francisco::Stonestown"}   };
    }

}
