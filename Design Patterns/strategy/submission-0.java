class Person {
    public String lastName;
    public int age;
    public boolean isMarried;

    public Person(String lastName, int age, boolean isMarried) {
        this.lastName = lastName;
        this.age = age;
        this.isMarried = isMarried;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public boolean isMarried() {
        return isMarried;
    }
}

interface PersonFilter {
    public boolean apply(Person person);
}

class AdultFilter implements PersonFilter {
    public boolean apply(Person person) { return person.age >= 18; }
}

class SeniorFilter implements PersonFilter {
    public boolean apply(Person person) { return person.age >= 65; }
}

class MarriedFilter implements PersonFilter {
    public boolean apply(Person person) { return person.isMarried; }
}

class PeopleCounter {
    public PersonFilter filter;

    public void setFilter(PersonFilter filter) {
        this.filter = filter;
    }

    public int count(List<Person> people) {
        int answer = 0;
        for (Person person : people) if (filter.apply(person)) answer++;
        return answer;
    }
}
