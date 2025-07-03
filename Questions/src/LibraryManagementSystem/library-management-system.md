```text
                         +---------------------+
                         |      Library        |  << Facade >>
                         +---------------------+
                         | - books: List<Book> |
                         | - members: List<Member> |
                         | - loans: List<Loan> |
                         +---------------------+
                         | +addBook()          |
                         | +removeBook()       |
                         | +registerMember()   |
                         | +borrowBook()       |
                         | +returnBook()       |
                         +---------------------+
                                   |
       +---------------------------+-----------------------------+
       |                                                         |
+---------------+                                      +----------------+
|     Book      |                                      |    Member      |
+---------------+                                      +----------------+
| - isbn        |                                      | - id           |
| - title       |                                      | - name         |
| - author      |                                      | - contactInfo  |
| - year        |                                      | - activeLoans  |
| - available   |                                      +----------------+
+---------------+                                              |
                                                               |
                                               +---------------+
                                               |
                                        +---------------+
                                        |     Loan       |
                                        +---------------+
                                        | - id          |
                                        | - book: Book  |
                                        | - member: Member|
                                        | - borrowDate  |
                                        | - dueDate     |
                                        | - returnDate  |
                                        +---------------+

                             +-------------------+
                             |     Librarian     |
                             +-------------------+
                             | - id              |
                             | - name            |
                             +-------------------+
                             | +manageBooks()    |
                             | +manageMembers()  |
                             +-------------------+

```