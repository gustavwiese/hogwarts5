package dk.kea.dat3js.hogwarts5.common;


public interface PersonWithNames {
    String getFirstName();
    String getMiddleName();
    String getLastName();

    void setFirstName(String firstName);
    void setMiddleName(String middleName);
    void setLastName(String lastName);

     default String getFullName() {
         return firstName + " " + (middleName != null ? middleName + " " : "") + lastName;
    }

    default void setFullName(String fullName) {
        if (fullName == null) {
            return;
        } else if (fullName.isEmpty()) {
            setFirstName("");
            setMiddleName("");
            setLastName("");
        } else {
            int firstSpace = fullName.indexOf(' ');
            int lastSpace = fullName.lastIndexOf(' ');

            if (firstSpace == -1) { // No spaces, only one word
                setFirstName(fullName);
                setMiddleName("");
                // Keep lastName as it is
            } else if (firstSpace == lastSpace) { // One space, two words
                setFirstName(fullName.substring(0, firstSpace));
                setMiddleName(fullName.substring(firstSpace + 1));
                // Keep lastName as it is
            } else { // Two spaces, three words
                setFirstName(fullName.substring(0, firstSpace));
                setMiddleName(fullName.substring(firstSpace + 1, lastSpace));
                setLastName(fullName.substring(lastSpace + 1));
            }
        }
    }

    default String capitalize(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "";
        } else {
            String[] words = name.split(" ");
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
            }
            return String.join(" ", words);
        }
    }
}
