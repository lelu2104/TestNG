package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Double.*;
import static org.testng.Assert.*;

public class TriangleTest {

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {-1, 5, 7},
                {4, -1, 7},
                {2, 5, -1},
                {2, -1, -1},
                {-1, -1, 7},
                {-1, -1, -1},

        };
    }

    ////•	Стороны треугольника больше нуля
    @Test(dataProvider = "data")
    public void testPartIsBiggerThanZero(double a, double b, double c) {
        Triangle tr = new Triangle(a, b, c);
        Assert.assertFalse(tr.checkTriangle());
    }

    @DataProvider
    public static Object[][] data1() {
        return new Object[][]{
                {8, 5, 7},
                {0, 0, 0},
                {1, 2, 5},
                {5, 5, 5},
        };
    }

    //Сумма двух сторон треугольника больше третьей
    @Test(dataProvider = "data1")
    public void testSumTwoPartsBigger(double q, double w, double e) {
        Triangle tr = new Triangle(q, w, e);
        Assert.assertEquals(tr.checkTriangle(), q + w > e);
        Assert.assertEquals(tr.checkTriangle(), q + e > w);
        Assert.assertEquals(tr.checkTriangle(), e + w > q);
    }

    @DataProvider
    public static Object[][] data2() {
        return new Object[][]{
                {3, 4, 5},
                {4, 5, 3},
                {5, 3, 4},
                {0, 0, 0},
                {1, 2, 5},
                {5, 5, 5},
        };
    }

    //	Когда тип треугольника - прямоугольный (проверить со всеми комбинациями катетов: ab, ac, bc)
    @Test(dataProvider = "data2")
    public void testTrRectangular(double a, double b, double c) {
        Triangle tr = new Triangle(a, b, c);
        Assert.assertEquals(tr.detectTriangle(), tr.TR_RECTANGULAR);

    }

    @DataProvider
    public static Object[][] data3() {
        return new Object[][]{
                {6, 6, 6},
                {6, 6, 3},
                {5, 6, 6},
                {0, 0, 0},
                {1, 2, 5},
                {5, 5, 5},
        };
    }

    //	Когда тип треугольника - равносторонний (если треугольник равносторонний - он не считается равнобедренным!!!)
    @Test(dataProvider = "data3")
    public void testTrEquilateral(double a, double b, double c) {
        Triangle tr = new Triangle(a, b, c);
        Assert.assertEquals(tr.detectTriangle(), tr.TR_EQUILATERAL);

    }


    @DataProvider
    public static Object[][] data4() {
        return new Object[][]{
                {5, 5, 6},
                {4, 5, 5},
                {5, 3, 4},
                {0, 0, 0},
                {1, 2, 5},
                {5, 5, 5},
        };
    }

    //	Когда тип треугольника - равнобедренный (проверить со всеми комбинациями боковых сторон: ab, ac, bc)
    @Test(dataProvider = "data4")
    public void testTrIsosceles(double a, double b, double c) {
        Triangle tr = new Triangle(a, b, c);
        Assert.assertEquals(tr.detectTriangle(), tr.TR_ISOSCELES);

    }

    @DataProvider
    public static Object[][] data5() {
        return new Object[][]{
                {5, 5, 6},
                {4, 5, 5},
                {5, 3, 4},
                {0, 0, 0},
                {1, 2, 5},
                {5, 5, 5},
        };
    }

    //	Когда тип треугольника - равнобедренный прямоугольный (проверить со всеми комбинациями катетов: ab, ac, bc)
    @Test(dataProvider = "data5")
    public void testTrIsoscelesRectangular(double a, double b, double c) {
        Triangle tr = new Triangle(a, b, c);
        Assert.assertEquals(((a == b) || (b == c) || (a == c)), ((a * a + b * b == c * c) || (a * a + c * c == b * b) || (b * b + c * c == a * a)));
    }


    @DataProvider
    public static Object[][] data6() {
        return new Object[][]{
                {5, 5, 6},
                {4, 5, 5},
                {5, 3, 4},
                {0, 0, 0},
                {1, 2, 5},
                {5, 5, 5},
        };
    }

    //	Когда тип треугольника  - обычный
    @Test(dataProvider = "data6")
    public void testTrOrdynary(double a, double b, double c) {
        Triangle tr = new Triangle(a, b, c);
        Assert.assertEquals(tr.detectTriangle(), tr.TR_ORDYNARY);

    }

    @DataProvider
    public static Object[][] data7() {
        return new Object[][]{
                {5, 5, 6},
                {4, 5, 5},
                {5, 3, 4},
                {0, 0, 0},
                {1, 2, 5},
                {5, 5, 5},
        };
    }

    //	Когда стороны - целые числа
    @Test(dataProvider = "data7")
    public void testSquare(double a, double b, double c) {
        Triangle tr = new Triangle(a, b, c);
        double p = (a + b + c) / 2;
        double expected = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        Assert.assertEquals(tr.getSquare(), expected);

    }

    @DataProvider
    public static Object[][] data8() {
        return new Object[][]{
                {5.235, 5.25, 6.258},
                {4.0, 5.0, 5.0},
                {5.255494, 3.1564, 4.165464},
                {0, 0, 0},
                {12164654.2, 2, 5.1655},
                {5.23, 5.64, 5.15164},
        };
    }

    //	Когда стороны - дробные числа
    @Test(dataProvider = "data8")
    public void testSquareDouble(double a, double b, double c) {
        Triangle tr = new Triangle(a, b, c);
        double p = (a + b + c) / 2;
        double expected = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        Assert.assertEquals(tr.getSquare(), expected);

    }

    @DataProvider
    public static Object[][] data9() {
        return new Object[][]{
                {5e50, 5e50, 6e50},
                {4000e50, 5e49, 5e51},
        };
    }

    //	При больших значениях сторон
    @Test(dataProvider = "data9")
    public void testSquareBig(double a, double b, double c) {
        Triangle tr = new Triangle(a, b, c);
        double p = (a + b + c) / 2;
        double expected = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        Assert.assertEquals(tr.getSquare(), expected);

    }

    @DataProvider
    public static Object[][] data10() {
        return new Object[][]{
                {5e-50, 5e-50, 6e-50},
                {4000e-50, 5e-49, 5e-51},
        };
    }

    //	При маленьких значениях сторон
    @Test(dataProvider = "data10")
    public void testSquareSmall(double a, double b, double c) {
        Triangle tr = new Triangle(a, b, c);
        double p = (a + b + c) / 2;
        double expected = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        Assert.assertEquals(tr.getSquare(), expected);

    }

    @DataProvider
    public static Object[][] data11() {
        return new Object[][]{
                {5e50, 5e50, 6e50},
                {4000e50, 5e49, 5e51},
        };
    }

    //	Проверить на переполнении суммы при вычислении периметра
    @Test(dataProvider = "data11")
    public void testP(double a, double b, double c) {
        Triangle tr = new Triangle(a, b, c);
        double p = (a + b + c) / 2;
        Assert.assertEquals(p, MAX_VALUE);

    }

}


//Проверить правильность входных данных:
//•	Стороны треугольника больше нуля
//•	Сумма двух сторон треугольника больше третьей
//•	Проверить на переполнение
//•	Проверить тип входных параметров
//•	Неправильное количество аргументов
//2. Проверить правильность определения типа треугольника:
//•	Когда тип треугольника - равносторонний (если треугольник равносторонний - он не считается равнобедренным!!!)
//•	Когда тип треугольника - равнобедренный (проверить со всеми комбинациями боковых сторон: ab, ac, bc)
//•	Когда тип треугольника - прямоугольный (проверить со всеми комбинациями катетов: ab, ac, bc)
//•	Когда тип треугольника - равнобедренный прямоугольный (проверить со всеми комбинациями катетов: ab, ac, bc)
//•	Когда тип треугольника  - обычный
//3.  Проверить правильность вычисления площади треугольника:
//•	Когда стороны - целые числа
//•	Когда стороны - дробные числа
//•	При больших значениях сторон (прим. в 50 степени)
//•	При маленьких значениях сторон (прим. в -50 степени)
//•	Проверить на переполнении суммы при вычислении периметра