package patterns;

import java.util.Stack;


// разбиваем строку на символы и выполняем операцию сложение, вычитание


public class Interpreter {
    public static void main(String[] args) {

        String exp="1+2+3-4+8";
        Expresion e=new Evaluate(exp);
        System.out.println(e.Interpre(e));
    }
}

interface Expresion
{
    int Interpre(Expresion c);
}

class Number implements Expresion      // класс возвращает число
{
    int number;

    public Number(int number)
    {
        this.number=number;
    }

    @Override
    public int Interpre(Expresion c) {
        return number;
    }
}

class Plus implements Expresion           // класс сложения
{
    Expresion leftex;
    Expresion rightex;

    public Plus(Expresion leftex,Expresion rightex)
    {
        this.leftex = leftex;
        this.rightex=rightex;
    }

    @Override
    public int Interpre(Expresion c) {
        return leftex.Interpre(c)+rightex.Interpre(c);
    }
}

class Minus extends Plus
{

    public Minus(Expresion leftex, Expresion rightex)
    {
        super(leftex, rightex);
    }

    @Override
    public int Interpre(Expresion c) {
        return leftex.Interpre(c)-rightex.Interpre(c);
    }
}

class Evaluate implements Expresion   // класс реализации
{
    Expresion evaluate;

    public Evaluate(String exp)                 // конструктор
    {
        Stack<Expresion> stack=new Stack<>();
        String exprevert = new StringBuilder(exp).reverse().toString();  // реверс для сохранения чисел
        for (String e:exprevert.split("\\D"))      // убираем все знаки из строки
        {
            stack.push(new Number(Integer.parseInt(e)));          // сохраняем числа в стэк
        }
        for (String e:exp.split("\\d"))      // убираем все числа из строки
        {
            if (e.equals("+"))
            {
                stack.push(new Plus(stack.pop(), stack.pop()));        // если плюс, то сложение(new Plus)
            }
            else if(e.equals("-"))
            {
                stack.push(new Minus(stack.pop(), stack.pop()));
            }
        }
        evaluate=stack.pop();
    }

    @Override
    public int Interpre(Expresion c) {
        return evaluate.Interpre(c);
    }
}






















