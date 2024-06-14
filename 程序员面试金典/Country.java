/*
 *13.7 lambda 表达式。有一个名为 Country 的类，它有两种方法，一种是 getContinent()返回
该国家所在大洲，另一种是 getPopulation()返回本国人口。实现一种名为 getPopulation 
(List<Country> counties,String continent)的方法，返回值类型为 int。它能根据
指定的大洲名和国家列表计算出该大洲的人口总数。（提示：#448，#461，#464）

*/

import java.util.List;

public class Country {
    private String continent;
    private int population;

    // 构造函数
    public Country(String continent, int population) {
        this.continent = continent;
        this.population = population;
    }

    // 获取国家所在大洲
    public String getContinent() {
        return continent;
    }

    // 获取国家人口数
    public int getPopulation() {
        return population;
    }

    // 计算特定大洲的国家人口总和
    public static int getPopulation(List<Country> countries, String continent) {
        return countries.stream() // 转换成流
                        .filter(country -> country.getContinent().equals(continent)) // 过滤出指定大洲的国家
                        .mapToInt(Country::getPopulation) // 获取每个国家的人口数
                        .sum(); // 计算总和
    }

    public static void main(String[] args) {
        // 创建一些示例国家
        List<Country> countries = List.of(
            new Country("Asia", 1392730000), // 例如，中国
            new Country("Europe", 83149300), // 例如，德国
            new Country("Asia", 126476461),  // 例如，日本
            new Country("Europe", 67081000)  // 例如，法国
        );

        // 计算亚洲国家的总人口
        int population = getPopulation(countries, "Asia");
        System.out.println("Population of Asia: " + population); // 输出亚洲人口总数
    }
}
