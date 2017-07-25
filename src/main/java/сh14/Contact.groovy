package сh14

class Contact {
    def firstName
    def lastName
    def birthDate

    String toString(){
        "($firstName, $lastName, $birthDate)"
    }
    Contact contact =
            new Contact(firstName: 'Chris', lastName: 'Schaefer', birthDate: new Date())
    Contact anotherContact =
            new Contact(firstName: 42, lastName: 'Schaefer', birthDate: new Date())

    println contac
    println anotherContact

    println Contact.firstName + 42
    println anotherContact.firstName + 42

}


