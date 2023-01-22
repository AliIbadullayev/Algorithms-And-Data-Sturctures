import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите алгоритм (0 - FIFO, 1 - LRU, 2 - OPT, 3 - CLOCK):");
        Scanner scanner = new Scanner(System.in);
        int alg = Integer.parseInt(scanner.nextLine());

        String[] pagesInArr = new String[0];

        System.out.println("Есть ли изначальные страницы памяти? 0 - нет, 1 - да");
        int started = Integer.parseInt(scanner.nextLine());





        if (started == 1) {
            System.out.println("Введите изначальные страницы в памяти:");
            String startedPages = scanner.nextLine();
            pagesInArr = startedPages.split(" ");
        }

        System.out.println("Количество кадров:");
        int frames = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите основные страницы в памяти:");
        String input = scanner.nextLine();
        String[] inputInArr = input.split(" ");


        if (alg == 0) {
            ArrayList<Integer> fifo = new ArrayList<>();

            if (started == 1) {
                for (String page : pagesInArr) {
                    fifo.add(Integer.parseInt(page));
                }
            }

            int counter = 0;
            if (started == 0) {
                int temp = 0; // количество добавленых страниц в очередь без повторений
                int arrayCounter = 0; // общий счетчик прохода по массиву
                while (temp != frames && arrayCounter < inputInArr.length) {
                    if (fifo.contains(Integer.parseInt(inputInArr[arrayCounter]))) {
                        arrayCounter++;
                        continue;
                    }
                    fifo.add(Integer.valueOf(inputInArr[arrayCounter]));
                    temp++;
                    arrayCounter++;
                }
                counter = temp;
            }
            for (String page : inputInArr) {
                if (fifo.contains(Integer.parseInt(page))) {
                    continue;
                }
                System.out.println(Arrays.toString(Arrays.stream(fifo.toArray()).toArray()));
                System.out.println("Вытеснили: " + fifo.get(0));
                counter++;
                fifo.remove(0);
                fifo.add(Integer.parseInt(page));
            }

            System.out.println(Arrays.toString(Arrays.stream(fifo.toArray()).toArray()));
            System.out.println("Де-факто, Количество замен страниц: " + counter);

        } else if (alg == 1) {
            ArrayList<Integer> lru = new ArrayList<>();
            int[] arr = Arrays.stream(inputInArr)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (started == 1) {
                for (String page : pagesInArr) {
                    lru.add(Integer.parseInt(page));
                }
            }

            int res = 0;
            for (Integer i : arr) {
                System.out.print(lru);
                if (lru.size() == frames) {
                    if (!lru.contains(i)) {
                        System.out.println("  Вытеснили - " + lru.get(lru.size() - 1));
                        lru.remove(lru.size() - 1);
                        lru.add(0, i);
                        res++;
                    } else {
                        lru.remove(i);
                        lru.add(0, i);
                        System.out.println();
                    }
                } else {
                    if (!lru.contains(i)) {
                        lru.add(0, i);
                        res++;
                    } else {
                        lru.remove(i);
                        lru.add(0, i);
                    }
                    System.out.println();
                }
            }
            System.out.println(lru);
            System.out.println("Количество замен страниц " + res);
        } else if (alg == 2) {
            int[] arr = Arrays.stream(inputInArr)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int res = 0;
            Set<Integer> opt = new HashSet<>();
            if (started == 1) {
                for (String page : pagesInArr) {
                    opt.add(Integer.parseInt(page));
                }
            }
            for (int i = 0; i < arr.length; i++) {
                if (opt.size() == frames) {
                    if (!opt.contains(arr[i])) {
                        Integer[] keys = opt.toArray(new Integer[0]);
                        int found = Integer.MAX_VALUE;
                        int maxAbsolutePos = Integer.MIN_VALUE;
                        for (Integer curr : keys) {
                            int currAbsolutePos = 0;

                            for (int j = i; j < arr.length; j++) {
                                if (curr == arr[j]) {
                                    currAbsolutePos = j - i;
                                    break;
                                }
                            }
                            if (currAbsolutePos == 0) {
                                found = curr;
                                break;
                            } else {
                                if (currAbsolutePos > maxAbsolutePos) {
                                    maxAbsolutePos = currAbsolutePos;
                                    found = curr;
                                }
                            }
                        }
                        System.out.println("Вытесняем " + found);
                        opt.remove(found);
                        opt.add(arr[i]);
                        res++;
                    } else {
                        opt.add(arr[i]);
                    }
                } else {
                    if (!opt.contains(arr[i])) {
                        res++;
                    }
                    opt.add(arr[i]);
                }
                System.out.println(opt);
            }
            System.out.println("Количество замен " + res);

        } else if (alg == 3) {
            // Clock alg
            LinkedList<Node> clock = new LinkedList<>(); // число и *
            int[] arr = Arrays.stream(inputInArr)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int result = 0;
            int arrow = 0;

            if (started == 1) {
                System.out.println("Заполняем часы изначальными данными...");
                for (String page : pagesInArr) {
                    System.out.println("Используется ли * для числа " + Integer.parseInt(page) + " (0 - нет, 1 - да)?");
                    int usedArrow = Integer.parseInt(scanner.nextLine());
                    clock.add(new Node(Integer.parseInt(page), usedArrow == 1));
                }
                System.out.println("Задайте изначальное положение стрелки (не больше кол-ва кадров, иначе 0):");
                try {
                    int userArrow = Integer.parseInt(scanner.nextLine());
                    if (userArrow <= frames) {
                        arrow = userArrow;
                    }
                } catch (Exception ignored) {
                }
            }

            for (int page : arr) {
                System.out.println("Стрелка: " + arrow);
                System.out.println(Arrays.toString(clock.toArray()));
                // Алгоритм для стрелочки
                if (clock.size() < frames) {
                    if (!clock.contains(new Node(page))) {
                        result++;
                        clock.add(new Node(page, true));
                    }
                } else {
                    if (!clock.contains(new Node(page))) {
                        boolean contains = false;
                        while (!contains) {
                            Node obj = clock.get(arrow);
                            if (obj.isStared()) {
                                clock.remove(arrow);
                                clock.add(arrow, new Node(obj.getValue(), false));
                                arrow++;
                                if (arrow == frames) {
                                    arrow = 0;
                                }
                            } else {
                                contains = true;
                                clock.remove(arrow);
                                clock.add(arrow, new Node(page, true));
                                arrow++;
                                if (arrow == frames) {
                                    arrow = 0;
                                }
                                result++;
                            }
                        }
                    } else {
                        int pos = clock.indexOf(new Node(page));
                        clock.remove(pos);
                        clock.add(pos, new Node(page, true));
                    }
                }
            }
            System.out.println(clock);
            System.out.println("Количество замен страниц CLOCK: " + result);
        } else {
            System.out.println("Выберите верный алгоритм!");
        }
    }
}


class Node {
    private int value;
    private boolean stared;

    public Node(int value, boolean stared) {
        this.value = value;
        this.stared = stared;
    }

    public Node(int value) {
        this.value = value;
        this.stared = false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isStared() {
        return stared;
    }

    public void setStared(boolean stared) {
        this.stared = stared;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value + (stared ? "*" : "");
    }
}