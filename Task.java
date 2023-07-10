// Задача1. Напишите программу-калькулятор, которая запрашивает 
// у пользователя два числа и выполняет операцию возведения первого числа в степень второго числа. 
// Если введены некорректные числа или происходит деление на ноль, 
// необходимо обработать соответствующие исключения и вывести информативное сообщение об ошибке.
// Важно! С использованием принципа одного уровня абстракции!
// **В этой задаче мы создаем класс PowerCalculator, который содержит метод calculatePower(), 
// выполняющий операцию возведения числа в степень. Если введено некорректное основание (ноль) и отрицательная степень,
//  выбрасывается исключение InvalidInputException.

package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task{
public static void main(String[] args) {
        try{
           int a =  getInt("Введите перое число: ");
           int b =  getInt("Введите второе число: ");
           System.out.println(calculatePower(a,b));
        } catch(InvalidInputException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    
    }


public static int getInt(String message){
    Scanner scanner = new Scanner(System.in);
    while (true) {
            try {
                System.out.println(message);
                return scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Ошибка: Введено некорректное число. Повторите ввод.");
                scanner.next(); // Очистка буфера сканера
            }
        }
    } 
    


public static double calculatePower(int a, int b) throws InvalidInputException{
    if(a<=0 ){
        throw new InvalidInputException("Число а не может быть отричательным или == 0 ");
    }
    return Math.pow(a,b);

}
}






class  InvalidInputException extends Exception{
    public  InvalidInputException(String message){
        super(message);
    }
}