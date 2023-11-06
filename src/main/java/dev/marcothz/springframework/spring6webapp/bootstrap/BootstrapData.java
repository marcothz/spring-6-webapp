package dev.marcothz.springframework.spring6webapp.bootstrap;

import dev.marcothz.springframework.spring6webapp.domain.Author;
import dev.marcothz.springframework.spring6webapp.domain.Book;
import dev.marcothz.springframework.spring6webapp.domain.Publisher;
import dev.marcothz.springframework.spring6webapp.repositories.AuthorRepository;
import dev.marcothz.springframework.spring6webapp.repositories.BookRepository;
import dev.marcothz.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("978-0321125217");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("978-0764558313");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        Publisher addison = new Publisher();
        addison.setName("Addison-Wesley Professional");
        addison.setAddress("221 River Street ");
        addison.setCity("Hoboken");
        addison.setState("NJ");
        addison.setZipCode("07030");

        Publisher addisonSaved = publisherRepository.save(addison);

        Publisher wrox = new Publisher();
        wrox.setName("Wrox Press");
        wrox.setAddress("111 River Street ");
        wrox.setCity("Hoboken");
        wrox.setState("NJ");
        wrox.setZipCode("07030");

        Publisher wroxSaved = publisherRepository.save(wrox);

        dddSaved.setPublisher(addisonSaved);
        noEJB.setPublisher(wroxSaved);

        bookRepository.save(dddSaved);
        bookRepository.save(noEJB);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
