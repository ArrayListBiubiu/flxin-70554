package juc.tool;


/**
 * 枚举
 */
public enum MyCountry__03 {

    ONE(1,"齐国"),TWO(2,"楚国"),THREE(3,"燕国"),FOUR(4,"韩国"),FIVE(5,"赵国"),SIX(6,"魏国");


    private Integer id;

    private String countryName;

    MyCountry__03(Integer id, String countryName) {
        this.id = id;
        this.countryName = countryName;
    }

    public static MyCountry__03 method(int index) {
        MyCountry__03[] myArray = MyCountry__03.values();
        for (MyCountry__03 element : myArray) {
            if (index == element.getId()) {
                return element;
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }
}
