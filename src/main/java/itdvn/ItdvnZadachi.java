package itdvn;



import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.*;
import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ItdvnZadachi {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, CloneNotSupportedException, XMLStreamException, ParserConfigurationException, SAXException, JAXBException, InterruptedException {


 /*       List<String> list = new ArrayList<>();
        boolean sort= false;
      do{
            Scanner scanner = new Scanner(System.in);
            String string=scanner.nextLine();
            if(string.equals("end"))
            {
                sort= true;
                for(String e:list)
                {
                    System.out.println(e);
                }
                System.out.println(" Вы ввели: end ");
            }
            else {
                list.add(string);
                sort= false;
            }
        }while (!sort);
     */

 /*       List<String> list2 = new ArrayList<>();
        byte a=5;
        int b=0;
        while (a>b)
        {
            Scanner scanner=new Scanner(System.in);;
            String s=scanner.nextLine();
            list2.add(s+" "+s);
           // BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
           // list2.add(bufferedReader.readLine());
           // bufferedReader.close();
            b++;
        }
        for (String s : list2) {
            System.out.println(s);
        }
  */



  /*     BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));// вводим число
       int d= Integer.parseInt(bufferedReader.readLine()); // сохраняем число, чтобы в цекле вместо size
        bufferedReader.close();
        List<Integer> list3=new LinkedList<>();
        for (int i = 0; i < d; i++)  // идем по цикл колличество d
        {
            list3.add(d);
        }

        for (Integer s : list3) {
            System.out.println(s);
        }
*/


/*
        EnumMap<City,String> map=new EnumMap<City,String>(City.class);
        map.put(CHICAGO,"Sigal");
        map.put(City.CALIFORNIA,"Novikov");
        map.put(City.MAIKOP,"Nothing");

        System.out.println(map.get(CALIFORNIA)); // получим значение по ключу

        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
        String c = bufferedReader1.readLine();
        bufferedReader1.close();
            switch (c)
            {
                case "Chicago":
                    System.out.println(map.get(CHICAGO));
                    break;
                case "California":
                    System.out.println(map.get(CALIFORNIA));
                    break;
                case "Maykop":
                    System.out.println(map.get(MAIKOP));
                    break;
                default:
                    System.out.println("Неверный город");
            }
*/

/*
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("newFile.txt"),"UTF-8"));// создается файл в директории
        String c="SAI SAI RAM  SAI BABA AUM";
        bufferedWriter.write(c); // записываем в файл
        bufferedWriter.close();

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\it\\IdeaProjects\\HrProject\\newFile.txt"))); // читаем из файла в буфер
        String s=bufferedReader.readLine(); // передаем в переменную данные из буфера
        System.out.println(s);
        bufferedReader.close();


        OutputStream outputStream=new FileOutputStream("arrayFile.txt");  // создаем и записываем в файл
        int[] a = new int[10];
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {  // заполняем случайными числами
            a[i] = random.nextInt(100);
        }
        boolean flag = false;
        while (!flag) {         // сортируем
            flag = true;
            for (int i = 0; i < a.length - 1; i++) {
                int t;
                if (a[i] < a[i + 1]) {
                    t = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = t;
                    flag = false; } }
                }
        for (int i = 0; i < a.length; i++) {
            outputStream.write(a[i]);         // записываем в файл
        }

        FileInputStream inputStreamReader=new FileInputStream("arrayFile.txt"); // чтение из файла
        int s=inputStreamReader.available();
        for (int i = 0; i < s; i++) {
            System.out.println(inputStreamReader.read()+" "); // читаем из файла
        }
 */

        // String

/*
        String c="Каждая строка, создаваемая с помощью оператора new или с помощью литерала (заключённая в\n" +
                "двойные апострофы)является объектом класса mhj.\n" +
                "Особенностью объекта класса String является то, что его значение не может быть изменено после\n" +
                "создания объекта при помощи какого-либо метода класса, так как любое изменение строки приводит к\n" +
                "созданию нового объекта.\n" +
                "Классы StringBuilder и StringBuffer являются “близнецами” и по своему предназначению близки к классу\n" +
                "String, но, в отличие от последнего, содержимое и размеры объектов классов StringBuilder и StringBuffer\n" +
                "можно изменять.\n" +
                "Основным и единственным отличием StringBuilder от StringBuffer является потокобезопасность\n" +
                "последнего.\n" +
                "С помощью соответствующих методов и конструкторов объекты классов StringBuffer, StringBuilder и\n" +
                "String можно преобразовывать друг в друга.\n" +
                "Конструктор класса StringBuffer (также, как и StringBuilder) может принимать в качестве параметра\n" +
                "объект String.";

        String[] s=c.split("\\.");

      //  В каждом предложении текста поменять местами первое слово с последним, не изменяя длины
      //  предложения.
        for (int i = 0; i < s.length; i++) {
            String[] b=s[i].split(" ");
            String t=b[b.length-1];
            b[b.length-1]=b[0];
            b[0]=t;
            StringBuilder builder = new StringBuilder();
            for (String current : b) {
                builder.append(current+" ");
            }
            String newtext = builder.toString();
            System.out.println(newtext);
        }

        String s1=c.substring(0,c.length()/2);
        System.out.println(s1);
        System.out.println(c.length());

        String s2=c.substring(c.length()/2);
        System.out.println(s2);

       // Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них
        boolean flag = false;
        while (!flag) {         // сортируем
            flag = true;
            for (int i = 0; i < s.length - 1; i++) {
                String t;
                if (s[i].length() < s[i + 1].length()) {
                    t = s[i + 1];
                    s[i + 1] = s[i];
                    s[i] = t;
                    flag = false;
                }
            }
        }
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
*/



/*
    Scanner scanner=new Scanner(System.in);
    String s=scanner.nextLine();
    Scanner scanner1=new Scanner(System.in);
    String l=scanner1.nextLine();
        String r="^[a-zA-Z0-9]+$";
        Pattern pattern=Pattern.compile(r);
        Matcher m=pattern.matcher(s);
        boolean b=m.matches();
        System.out.println(b);
        if(!b) { System.out.println("логин не верен"); }else { System.out.println("Вы зарегистрированны");}
        String r1="^[1-9]\\d{1,2}$";
        Pattern pattern1=Pattern.compile(r1);
        Matcher m1=pattern.matcher(l);
        boolean b1=m.matches();
        System.out.println(b);
        if(!b) { System.out.println("пароль не верен"); }else { System.out.println("пароль верный");}

*/

        //Напишите шуточную программу «Дешифратор», которая бы в текстовом файле могла бы заменить все
        //предлоги на слово «Java».
      /*  String c = "And she is, I may say, a very persistent person";
        String a=c.replaceAll("([^A-Za-z0-9])([a-z]{1,2}+)([^A-Za-z0-9])"," JAVA ");
        System.out.println(a);
        Pattern pattern2 = Pattern.compile("([^A-Za-z0-9])([a-z]{1,2}+)([^A-Za-z0-9])");
        Matcher m2 = pattern2.matcher(c);

        while (m2.find()) {
            System.out.println(m2.group(2));
        }*/


//        Напишите программу, которая будет выводить всю информацию о классе, пользователь сам выбирает, какой
//        именно класс интересует
      /*  Scanner scanner = new Scanner(System.in);

        String s = (char) 27 + "[31m"; // красный цвет
        String s1 = (char) 27 + "[34m"; // синий цвет
        String s2 = (char) 27 + "[30m";
        String s3 = (char) 27 + "[32m";

        Class<?> clas = UserJdbc.class;
        int mod = clas.getModifiers(); // получаем модификатор класса
        if (Modifier.isPrivate(mod)) {
            System.out.println("модификатор доступа класса: private " + mod);
        }
        if (Modifier.isPublic(mod)) {
            System.out.println("модификатор доступа класса: public " + mod);
        }
        Field[] fields = clas.getFields();
        fields = clas.getDeclaredFields();
        for (Field e : fields) {
            Class<?> typef = e.getType();
            System.out.println(s + "Поле: " + e.getName() + ", Тип данных:" + typef.getName());
        }
        Constructor<?>[] constructors = clas.getConstructors();
        for (Constructor<?> e : constructors) {
            Class<?>[] type = e.getParameterTypes();
            for (Class<?> e2 : type) {
                System.out.println(s1 + "Тип данных принимаемого значения конструктора: " + e2.getName());
            }
        }
        Method[] methods = clas.getMethods();
        for (Method e : methods) {
            System.out.println(s2 + "Metod name: " + e.getName() + ", Type return metod: " + e.getReturnType().getName());
            Class<?>[] type = e.getParameterTypes();
            for (Class<?> e2 : type) {
                System.out.println("Тип данных принимаемого значения метода: " + e2.getName() + "\n");
            }
        }*/

//        Создать свою аннотацию используя аннотацию @Repeteable с Java 8, вызвать дважды аннотацию подтягивая
//        разные параметры выполнить сложение 2-х чисел.
//        @MathAnno(num1 = 50)
//        @MathAnno(num2 = 100)
//        public void mathSum(int num1, int num2)
       /* ItdvnZadachi itdvnZadachi = new ItdvnZadachi();
        Class<?> clasZ = ItdvnZadachi.class;
        Method m = clasZ.getMethod("mathSum", String.class, String.class);
        MyAnotCalc[] anotCalc = m.getAnnotationsByType(MyAnotCalc.class);
        itdvnZadachi.mathSum((anotCalc[0].value()), (anotCalc[1].value()));*/




//        Написать калькулятор с использованием аннотаций, аннотация передает 2 параметра.
      /*  Class<?> cl = ItdvnZadachi.class;
        Method method = cl.getMethod("Calc", int.class, int.class);
        Calc calc = method.getAnnotation(Calc.class);
        Calc(calc.n(), calc.n2());*/




//        Создайте класс Animal
//        Опишите в нем 3 различных поля, создайте конструктор, методы.
//        Создайте файл и выполните сериализацию объекта Animal.
//        и вывести на экран.
      /*  Animal animal=new Animal("SAI","BABA","AUM");
        File file= new File("C:\\Users\\it\\IdeaProjects\\HrProject\\src\\main\\java\\zadachi\\animalzadach.txt");


        try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)))
        {
            oos.writeObject(animal);

            Animal animal1= (Animal) ois.readObject();
            System.out.println(animal1);
        }*/


//        Создайте класс Car.
//        Опишите в нем 3 различных поля включая статические поля, создайте конструктор, методы.
//        Посредством Java создайте файл и выполните сериализацию объекта Animal используя интерфейс
//        Externalizable.
       /* Car car=new Car("MAHA","PREMA",777);

        try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
             ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file)))
        {
             oos.writeObject(car);

             Car car1= (Car) ois.readObject();
            System.out.println(car1);
            System.out.println("static: "+Car.speed);
        }*/




//        Создайте класс Car.
//        Опишите в нем 3 различных поля, создайте конструктор, методы.
//        Выполните поверхностное клонирования объекта Car.
        /*Cars cars=new Cars("start","stop",999);
        Cars clonCars= (Cars) cars.clone();
        System.out.println(cars+"\nПоверхностный клон: "+ clonCars);
        clonCars.setGo("much");
        clonCars.setStop("no");
        clonCars.setSpeed(777);
        System.out.println( "Глубокий клон: "+ clonCars);*/


//        Создать класс Bird.
//        Создать 3 поля (static, final и transient), методы, конструктор.
//        Клонировать объект используя глубокое клонирование через сериализацию
      /* Bird bird=new Bird("low");
        ByteArrayOutputStream baos=null;
        ByteArrayInputStream bais=null;
        ObjectOutputStream oos=null;
        ObjectInputStream ois=null;
        try{
            baos=new ByteArrayOutputStream();
            oos=new ObjectOutputStream(baos);
            oos.writeObject(bird);
            System.out.println(bird);
            bais=new ByteArrayInputStream(baos.toByteArray());
            ois=new ObjectInputStream(bais);
            Bird bird1= (Bird) ois.readObject();
            System.out.println(bird1);
        }finally {
            if(baos!=null) { baos.flush();baos.close();}
            if (bais!=null) { bais.close(); }
            if (oos!=null) { oos.flush();oos.close(); }
            if (ois!=null) { ois.close(); }
        }*/


//        Создать класс Animal и Eagle.
//        Создать 3 поля в классе Animal, Eagle должен наследовать класс Animal.
//        Клонировать объект Eagle.
     /*  Eagl eagl=new Eagl(1,new Animal("LOVE","VERY","MUCH"));
        ByteArrayOutputStream baos=null;
        ByteArrayInputStream bais=null;
        ObjectOutputStream oos=null;
        ObjectInputStream ois=null;
        try{
            baos=new ByteArrayOutputStream();
            oos=new ObjectOutputStream(baos);
            oos.writeObject(eagl);
            System.out.println(eagl);
            bais=new ByteArrayInputStream(baos.toByteArray());
            ois=new ObjectInputStream(bais);
            Eagl eagl1= (Eagl) ois.readObject();
            eagl1.animal.cat="AUM";
            System.out.println(eagl1);
        }finally {
            if(baos!=null) { baos.flush();baos.close();}
            if (bais!=null) { bais.close(); }
            if (oos!=null) { oos.flush();oos.close(); }
            if (ois!=null) { ois.close(); }
        }
*/

//        Создать класс AnimalParser xmlzadach.xml.
//        Вывести в консоль name, breed всех котов используя любой из рассматриваемых ранее парсеров
     /*   DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document=builder.parse(new File("C:\\Users\\it\\IdeaProjects\\HrProject\\src\\main\\java\\zadachi\\xmlzadach.xml"));
        Element root=document.getDocumentElement();
        NodeList node=root.getChildNodes();
        for(int i=0;i<node.getLength();i++)
        {
            Node node1=node.item(i);
            if (node1.getNodeType()==Node.ELEMENT_NODE)
            {
                Element element= (Element) node1;
                System.out.println(element.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue());
                System.out.println(element.getElementsByTagName("breed").item(0).getChildNodes().item(0).getNodeValue());
            }
        }*/


//        Создайте класс, используя SAXParser и  JAXB, в котором опишите иерархию XML файла.
//        Необходимо, чтобы проект создавал XML файл и строил дерево (город, название улицы, дом). В городе
//        используйте аттрибут(например, <city size=”big>Kiev</city>)
       /* Cityy cityy=new Cityy();
        cityy.setSize("big"); cityy.setValue("Chicago");
        AllCity city=new AllCity(cityy,"First-Green",5);
        File file2=new File("C:\\Users\\it\\IdeaProjects\\HrProject\\src\\main\\java\\zadachi\\xmlparsing\\city.xml");
        JAXBContext jaxbContext=JAXBContext.newInstance(AllCity.class);
        Marshaller marshaller=jaxbContext.createMarshaller();// объект класса Marshaller, чтобы трансформировать
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true); // читабильное форматирование
        marshaller.marshal(city,file2); // Записываем в файл
        marshaller.marshal(city,System.out);// Записываем в консоль

        Unmarshaller unmarshaller=jaxbContext.createUnmarshaller(); // Читаем из файла
        city= (AllCity) unmarshaller.unmarshal(file2);
        System.out.println("JAXB Unmarshaller: "+city+"\n");


        File file1=new File("C:\\Users\\it\\IdeaProjects\\HrProject\\src\\main\\java\\zadachi\\xmlparsing\\city.xml");
        SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
        SAXParser saxParser=saxParserFactory.newSAXParser();
        DefaultHandler defaultHandler=new DefaultHandler() {
            boolean All = false;

            @Override // вызывается когда SAXParser натыкается на начало тега
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equalsIgnoreCase("city")||qName.equalsIgnoreCase("house")||
                        qName.equalsIgnoreCase("street")) // если имя тега street, то тег начался
                {
                    All=true;
                }
            }

            @Override// вызывается когда SAXParser считывает текст между тегами
            public void characters(char[] ch, int start, int length) throws SAXException {

                if (All) // Если отметили что имя тега street, то считываем текст
                {
                    System.out.println("SAX: "+new String(ch,start,length)+"\n");
                    All=false;
                }
            }
        };
        saxParser.parse(file1,defaultHandler);*/



//        Создайте классы Currency, Parser, Main
//        Подключиться к NBU API(https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json)
//        и вывести в консоль 3 валюты на выбор
    /*    URL url=new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");
        ObjectMapper mapper=new ObjectMapper();
        Currency[] curren=mapper.readValue(url,Currency[].class);
        for (Currency e : curren) {
            if (e.getAbr().equals("AUD")||e.getAbr().equals("CAD")||e.getAbr().equals("CZK"))
            {System.out.println(e);}
        }*/


        

//        Создать строку с содержимым в формате JSON (к примеру): Страна: Украина, город: Киев, улица: Крещатик.
//        Строку обработать и записать в JSON файл, используя Jackson и GSON библиотеку.
       /* File file=new File("C:\\Users\\it\\IdeaProjects\\HrProject\\src\\main\\java\\zadachi\\jsonzadach.json");
        ObjectMapper mapper1=new ObjectMapper();
        Jscountry jscountry=mapper1.readValue(file,Jscountry.class);// получил из файла
        System.out.println(jscountry);
        jscountry.setCountry("USA");
        jscountry.setCity("CHICAGO");
        jscountry.setStreet("FiRST STREET");

        mapper1.writeValue(file,jscountry); // записали новые значения


        Gson gson=new Gson();
        JsonElement element=new JsonParser().parse(new FileReader(file));// парсим файл
        Jscountry jscountry1=gson.fromJson(element,Jscountry.class);// читаем
        System.out.println(jscountry1);
        jscountry1.setCountry("USA");
        jscountry1.setCity("CALIFORNIA");
        jscountry1.setStreet("SEVEN STREET");
        String s=gson.toJson(jscountry1);
        Files.write(Paths.get("C:\\Users\\it\\IdeaProjects\\HrProject\\src\\main\\java\\zadachi\\jsonzadach.json"),s.getBytes(), StandardOpenOption.CREATE);
*/



//        Создать 2 произвольных класса с полями и методами.
//        Необходимо синхронизировать методы этих классов между собой, т.е. чтобы выводило на экран значения
//        друг за другом (1 класс, 2 класс, 1, 2 и т.д.).
       /* Incr incr=new Incr();
        FirstThread first=new FirstThread(incr);  // должен быть общий монитор у обоих потоков поэтому в классе Incr реализуем методы с работой и передаем их в run() классов
        SecondThread second=new SecondThread(incr);
        first.start();
        second.start();*/



//        Задержка потока.
//        Необходимо создать 3 потока, каждых из этих потоков запустить (например: main, second, first), и когда эти
//        потоки успешно отработают – вывести на экран сообщение (завершение потом first, second и main).
        /*MyThread1 thread1=new MyThread1();
        MyThread2 thread2=new MyThread2();
        MyThread3 thread3=new MyThread3();
        thread1.start();
        thread2.start();
        thread3.start();
        Inter inter=new Inter();
        inter.t(thread1,thread2,thread3);*/



//        Демонстрация приоритетов.
//        Создать 2 класса PriorityRunner и PriorityThread.
//        Запустить 3 потока с приоритетами (min, max, norm).
//        При помощи цикла for выведем на экран значения от 1 до 50 и укажем, какой именно поток данную операцию
//        делает.
       /* PriorityThread thread1=new PriorityThread("MAX"); // каждый поток выводит 50 значений
        PriorityThread thread2=new PriorityThread("MIN");
        PriorityThread thread3=new PriorityThread("NORM");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread3.setPriority(Thread.NORM_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();*/



//        Создайте поток-демон и выведите про него как можно больше информации.
       /* DaemonThread thread=new DaemonThread();
        DaemonThread thread1=new DaemonThread();
        thread.setDaemon(true);
        thread1.start();
        thread.start();
        System.out.println(thread.getName()+thread.getId()+thread.getState()+thread.getPriority()+thread.getThreadGroup()+thread.getContextClassLoader());
*/


//        Создать 2 класса. Реализовать взаимную блокировку(deadlock) этих классов. И разблокировку.
      /*  UnBlock unBlock=new UnBlock();
        BlockTh blockTh=new BlockTh(unBlock);
        BlockTh2 blockTh2=new BlockTh2(unBlock);
        blockTh.start();
        blockTh2.start();
        blockTh.setT1(blockTh2);
        blockTh2.setT2(blockTh);*/




     //   Напишите основные арифметические действия калькулятора, используя лямбда-выражения
       /* Calculator sum= (a, b) -> { return a+b; };
        Calculator umn= (a, b) -> { return a*b; };
        Calculator del= (a, b) -> { return a/b; };
        Calculator min= (a, b) -> { return a-b; };
        int s=sum.toDo(111,666);
        int u=umn.toDo(111,333);
        int d=del.toDo(333,111);
        int m=min.toDo(666,111);
        System.out.println(s+" "+u+" "+d+" "+m);*/



//        Создать список и заполнить рандомными числами 10 ячеек, нужно вывести сумму квадратов всех элементов
//        списка. Мы используем метод map() для возведения в квадрат каждого элемента, а потом применяем метод
//        reduce() для свертки всех элементов в одно число.
        List<Integer> list=new ArrayList<>();
        Random r=new Random();
        for (int i = 0; i < 10; i++) {
            list.add(r.nextInt(100));
        }
        //list.stream().map(e->e=r.nextInt(100)).map(e->Math.pow(e,2)).forEach(System.out::println);
        double m=list.stream().map(e->Math.pow(e,2)).reduce((a,b)->a+b).get();
        System.out.println(m);



    }

    public <T> void gen(){} // дженерик метод

    @FunctionalInterface
    interface Calculator
    {
        int toDo(int a,int b);
    }




    @Target({ElementType.FIELD,ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface MyAnot { MyAnotCalc[] value();}

    @Repeatable(MyAnot.class)
    @interface MyAnotCalc {String value(); }

    @MyAnotCalc( value = "5")
    @MyAnotCalc(value = "15")
    public void mathSum(String num1, String num2) throws NoSuchMethodException {

        System.out.println("Сумма: "+Integer.parseInt(num1)+Integer.parseInt(num2));
    }




    @Target({ElementType.FIELD,ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface Calc{int n() default 0; int n2() default 0;}

    @Calc(n=10,n2 = 2)
    public static void Calc(int n, int n2)
    {

        System.out.println("Разность: "+(n-n2));
        System.out.println("Деление: "+n/n2);
        System.out.println("Произведение: "+n*n2);
        System.out.println("Сумма: "+n+n2);
    }

private static class Bird implements Serializable
{
    public final String song;
    private static String run;
    private transient String runs;

    public Bird(String runs) {
        this.song=" LOVE ";
        this.runs=runs;
        run=runs;
    }

    public Bird() { // вместо конструктора без параметров т.к. его использует при копировании
        this.song = " LOVE ";
        this.runs=null;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "song=" + song +
                ", runs='" + runs + '\'' +
                '}';
    }
}




 private static class Car implements Externalizable
 {
    private String drive;
    private String stop;
    private static int speed;
    private int speedSeria;

     public Car() {
     }


     public Car(String drive, String stop, int speedSeria) {
         this.drive = drive;
         this.stop = stop;
         this.speedSeria = speedSeria;
         speed=speedSeria;
     }

     @Override
     public void writeExternal(ObjectOutput out) throws IOException {
         out.writeObject(drive);
         out.writeObject(stop);
         out.writeInt(speedSeria);
     }

     @Override
     public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
         drive= (String) in.readObject();
         stop= (String) in.readObject();
         speedSeria=in.readInt();

     }

     @Override
     public String toString() {
         return "Car{" +
                 "drive='" + drive + '\'' +
                 ", stop='" + stop + '\'' +
                 ", speedSeria=" + speedSeria +
                 '}';
     }
 }


public static class Eagl extends Animal implements Serializable
{
    private int id;
    private Animal animal;

    public Eagl() {
    }

    public Eagl(int id,Animal animal) {
        this.id=id;
        this.animal=animal;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Eagl{" +
                "id=" + id +
                ", animal=" + animal +
                '}';
    }
}


 public static class Animal implements Serializable
    {
        private String cat;
        private String dog;
        private String bird;

        public Animal() {
        }

        public Animal(String cat, String dog, String bird) {
            this.cat = cat;
            this.dog = dog;
            this.bird = bird;
        }

        public String getCat() {
            return cat;
        }

        public void setCat(String cat) {
            this.cat = cat;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "cat='" + cat + '\'' +
                    ", dog='" + dog + '\'' +
                    ", bird='" + bird + '\'' +
                    '}';
        }
    }



}


class Cars implements Cloneable
{
    private String go;
    private String stop;
    private int speed;

    public Cars() {
    }

    public Cars(String go, String stop, int speed) {
        this.go = go;
        this.stop = stop;
        this.speed = speed;
    }

    public void setGo(String go) {
        this.go = go;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Cars{" +
                "go='" + go + '\'' +
                ", stop='" + stop + '\'' +
                ", speed=" + speed +
                '}';
    }
}


enum City  // для EnumMap
{
    CHICAGO("Chicago"), CALIFORNIA("California"), MAIKOP("Maykop");

    City(String chicago) {
    }
}

