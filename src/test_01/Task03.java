package test_01;

import java.util.*;

/**
 * Source:      Task03.java
 * Created:     08.12.2017
 * Project:     Practice-DSA
 * <p>
 * {@code Task01} 3. В компании epam проводятся N курсов. Каждый с датой начала и конца.
 * Вы решили пройти как можно больше из них, но не можете проходить одновременно 2 курса.
 * Напишите программу выбора максимального числа курсов, которые вы можете пройти.
 *
 * Сложность foo(..) -> O(N^3*log(N))
 * Сложность foo1(..) -> O(N*log(N))
 *
 * @author dialekz
 */
public class Task03 {

    private static class Course {
        Date start;
        Date end;
    }

    private static class Node {
        int step = 0;
        Node previous = null;
        final Course value;
        LinkedList<Node> nextCourses = new LinkedList<>();

        Node(Course value) {
            this.value = value;
        }
    }

    private static class Graph {
        LinkedList<Node> nodes = new LinkedList<>();

        void add(Course course) {
            Node node = new Node(course);

            for (Node n : nodes) {
                if (n.value.end.before(course.start)) {
                    n.nextCourses.add(node);
                } else if (course.end.before(n.value.start)) {
                    node.nextCourses.add(n);
                }
            }

            for (int i = 0; i < nodes.size(); i++) {
                if (nodes.get(i).value.start.after(course.start)) {
                    nodes.add(i, node);
                    return;
                }
            }
            nodes.add(node);
        }
    }

    private static LinkedList<Node> foo(List<Course> courses) {
        Graph graph = new Graph();
        for (Course course : courses) {
            graph.add(course);
        }

        int step = 0;

        List<Node> current = new LinkedList<>(graph.nodes);
        Set<Node> next = new TreeSet<>();
        Node last = new Node(null), curr;

        while (true) { // N
            step++;
            for (Node node : current) { // N
                last = node;
                for (Node nextCourse : node.nextCourses) { // N - 1
                    if (nextCourse.step < step) {
                        nextCourse.step = step;
                        nextCourse.previous = node;
                        next.addAll(nextCourse.nextCourses); // log(N)
                    }
                }
            }

            if (next.isEmpty())
                break;

            current.clear();
            current.addAll(next);
            next.clear();
        }

        LinkedList<Node> result = new LinkedList<>();

        while (last.previous != null) {
            result.addFirst(last);
            last = last.previous;
        }

        return result;
    }

    private static LinkedList<Course> foo1(List<Course> courses) {

        courses.sort(Comparator.comparing(c -> c.start));

        LinkedList<Course> result = new LinkedList<>();
        result.add(courses.get(0));

        for (Course course : courses) {
            if (result.getLast().end.before(course.start)) {
                result.add(course);
            } else if (result.getLast().end.after(course.end)) {
                result.removeLast();
                result.add(course);
            }
        }

        return result;
    }

}
