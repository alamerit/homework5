import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        stack();
        System.out.println("**************************************");
        queue();
        System.out.println("**************************************");
        queuePriority();

        System.out.println("Задание 2");
        System.out.println(reverseByStack("   Упер дед репу "));

        System.out.println("Задание 3 Deque ");
        taskFree();


    }

    private static void taskFree() {
        ArrayDeque<String> states = new ArrayDeque<String>();
        // стандартное добавление элементов
        states.add("Germany");
        states.addFirst("France"); // добавляем элемент в самое начало
        states.push("Great Britain"); // добавляем элемент в самое начало
        states.addLast("Spain"); // добавляем элемент в конец коллекции
        states.add("Italy");

        // получаем первый элемент без удаления
        String sFirst = states.getFirst();
        System.out.println(sFirst);     // Great Britain
        // получаем последний элемент без удаления
        String sLast = states.getLast();
        System.out.println(sLast);      // Italy

        System.out.printf("Queue size: %d \n", states.size());  // 5

        // перебор коллекции
        while(states.peek()!=null){
            // извлечение c начала
            System.out.println(states.pop());
        }
    }


    public static String reverseByStack(String s) {
        Stack<Character> st = new Stack<Character>();
        for (Character character : s.toCharArray()) {
            st.add(character);
        }
        StringBuilder sb = new StringBuilder();
        while (st.size() > 0) {
            sb.append(st.pop());
        }
        return sb.toString();
    }



    private static void queuePriority() {

        Queue<Integer> integerPriorityQueue = new PriorityQueue<>(7);
        Random rand = new Random();
        for(int i=0; i<7; i++){
            integerPriorityQueue.add(new Integer(rand.nextInt(100)));
        }
        for(int i=0;i<7;i++){
            Integer in = integerPriorityQueue.poll();
            System.out.println("Обрабатываем Integer:"+in);
        }


        Queue<Customer> customerPriorityQueue = new PriorityQueue<>(7, idComparator);
        addDataToQueue(customerPriorityQueue);

        pollDataFromQueue(customerPriorityQueue);
    }


    public static Comparator<Customer> idComparator = new Comparator<Customer>(){

        @Override
        public int compare(Customer c1, Customer c2) {
            return  (c1.getId() - c2.getId());
        }
    };

    // служебный метод добавления элементов в очередь
    private static void addDataToQueue(Queue<Customer> customerPriorityQueue) {
        Random rand = new Random();
        for(int i=0; i<7; i++){
            int id = rand.nextInt(100);
            customerPriorityQueue.add(new Customer(id, "Pankaj "+id));
        }
    }

    //служебный метод для обработки данных очереди
    private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue) {
        while(true){
            Customer cust = customerPriorityQueue.poll();
            if(cust == null) break;
            System.out.println("Обработка клиента с id=" + cust.getId());
        }
    }





    private static void queue() {
        Queues myQueue = new Queues(5);
        myQueue.insert(10);
        myQueue.insert(20);
        myQueue.insert(30);
        myQueue.insert(40);
        myQueue.insert(50);

        myQueue.remove();
        myQueue.remove();
        myQueue.remove();

        myQueue.insert(60);

        while (!myQueue.isEmpty()) {
            int n = myQueue.remove();
            System.out.println("Elem: " + n);
        }
    }




    private static void stack() {
        Cat barsik = new Cat("Барсик", 4);
        Cat murzik = new Cat("Мурзик", 6);
        Cat vaska = new Cat("Васька", 9);

        Stack<Cat> catStack = new Stack<>();
        catStack.push(barsik);
        catStack.push(murzik);
        catStack.push(vaska);

        System.out.println( "Текущий стек: " + catStack);
        System.out.println( "Брысь " + catStack.pop());
        System.out.println("Кто последний? " + catStack.peek().toString());
        System.out.println( "Брысь " + catStack.pop());
        System.out.println( "Кто последний? " + catStack.peek().toString());
        System.out.println( "Брысь " + catStack.pop());
        System.out.println( "Никого? " + catStack.empty());

        try {
            System.out.println("Кто последний? " + catStack.peek().toString());

        }catch (EmptyStackException e)
        {
            System.out.println("Пустой стек. Некого прогонять");
        }
        System.out.println( "Текущий стек: " + catStack);
    }



}


