class Main {
    PeopleStats peopleStats = new PeopleStats(Paths.get("śćieżka", "do", "pliku"));

    	System.out.println(String.format("Liczba osób: %d", peopleStats.count()));
	System.out.println(String.format("Liczba osób z unikalnymi nazwiskami: %d", peopleStats.countUniqueLastNames()));
}

class PeopleStats {

public long countUniqueLastNames() {
    return people.stream()
            .map(Person::getLastName)
            .distinct()
            .count();
}

public long count() {
    return people.size();
}

private final List<Person> people;

    public PeopleStats(Path inputFilePath) {
        try {
            people = Files.lines(inputFilePath)
                    .map(line -> line.split("\t"))
                    .map(chunks -> new Person(chunks[0], chunks[1]))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}

class Person {

	
    	private final String firstName;
	private final String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
	this.lastName = lastName;
    }

    	public String getFirstName() {
        return firstName;
    }
	
	 public String getLastName() {
        return lastName;
    }
}