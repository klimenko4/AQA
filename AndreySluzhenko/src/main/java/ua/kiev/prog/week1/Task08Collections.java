package ua.kiev.prog.week1;

import java.util.*;

public class Task08Collections {

    static class Student {
        private String name;
        private List<String> languages;

        Student(String name, List<String> languages) {
            this.name = name;
            this.languages = languages;
        }

        public String getName() {
            return name;
        }

        public List<String> getLanguages() {
            return languages;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Student{");
            sb.append("name='").append(name).append('\'');
            sb.append(", languages=").append(languages);
            sb.append('}');
            return sb.toString();
        }
    }

    // Data example
    static final List<Student> students = Arrays.asList(
            new Student("Doug Lea", Arrays.asList("Java", "C#", "JavaScript")),
            new Student("Bjarne Stroustrup", Arrays.asList("C", "C++", "Java")),
            new Student("Martin Odersky", Arrays.asList("Java", "Scala", "Smalltalk"))
    );

    /**
     * Given list of students group them by language.
     */
    public static Map<String, List<Student>> getStudentsByLanguage(List<Student> students) {
        Map<String, List<Student>> studentsPerLang = new HashMap<>();
        for (Student student : students) {
            for (String lang : student.getLanguages()) {

                List<Student> studentList = studentsPerLang.computeIfAbsent(lang, k -> new ArrayList<>());

//                List<Student> studentList = studentsPerLang.get(lang);
//
//                if (studentList == null) {
//                    studentList = new ArrayList<>();
//                }
//
                studentList.add(student);
//                studentsPerLang.put(lang, studentList);

            }
        }

        return studentsPerLang;

    }

    /**
     * Given list of students with languages, return list of unique languages.
     */
    public static List<String> getAllLanguages(List<Student> students) {
        throw new UnsupportedOperationException();
    }

    /**
     * Given list of students, remove duplicates by name.
     */
    public static List<Student> removeDuplicates(List<Student> students) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        Map<String, List<Student>> result = getStudentsByLanguage(students);
        result.forEach((k, v) -> System.out.println(k + v));
    }

}