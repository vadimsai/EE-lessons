package patterns;

import java.util.Scanner;

// обработчик контролеров для быстрой передачи нужного контроллера


public class FrontController {
    public static void main(String[] args) {

        try (Scanner s=new Scanner(System.in))
        {  while (s.hasNext())
        {String n=s.nextLine();   // входящий запрос
            new Thread()         // отдельный поток запускаем
            {
                @Override
                public void run() {
                   new DispatcherServlet().procer(n);   // обрабатываем запрос
                }
            } .start();
        }}
    }
}

class DispatcherServlet
    {
         void procer(String s)
        {
            switch (s) {
                case "home":
                    new HomeController().Show();break;
                case "user":
                    new UserController().Show();break;
                default: new DeleteController().Show();
            }
        }
    }

class HomeController
{
    void Show()
    {
        System.out.println("home page");
    }
}

class UserController
{
    void Show()
    {
        System.out.println("user page");
    }
}

class DeleteController
{
    void Show()
    {
        System.out.println("error");
    }
}
