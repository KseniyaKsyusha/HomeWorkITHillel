package ua.en.kosse.oksana.hillel.hw12.occurrence;

public class FindOccurrenceStructure {
    private final String name;
    private final int occurrence;

    public FindOccurrenceStructure(String name, int occurrence) {
        this.name = name;
        this.occurrence = occurrence;
    }

    public String getName() {
        return name;
    }

    public int getOccurrence() {
        return occurrence;
    }

    @Override
    public String toString() {
        return "\n\t{" +
                "name: \"" + name + '\"' +
                ", occurrence: " + occurrence +
                "}";
    }
}

