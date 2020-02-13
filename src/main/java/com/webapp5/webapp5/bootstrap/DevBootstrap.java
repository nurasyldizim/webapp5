package com.webapp5.webapp5.bootstrap;

import com.webapp5.webapp5.model.Author;
import com.webapp5.webapp5.model.Book;
import com.webapp5.webapp5.model.Publisher;
import com.webapp5.webapp5.repositories.AuthorRepository;
import com.webapp5.webapp5.repositories.BookRepository;
import com.webapp5.webapp5.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher pub = new Publisher("Azamat", "Almaty");
        publisherRepository.save(pub);

        //Eric
        Author nura = new Author("Nurasyl", "Dizim");
        Book dd = new Book("The path of Abay", "1234", pub);
        nura.getBooks().add(dd);
        dd.getAuthors().add(nura);

        authorRepository.save(nura);
        bookRepository.save(dd);


        //
        Publisher pub2 = new Publisher("Abil", "Astana");
        publisherRepository.save(pub2);

        Author dima = new Author("Dima", "Uncle");
        Book aa = new Book("Stories", "4321", pub2);
        dima.getBooks().add(aa);
        aa.getAuthors().add(dima);

        authorRepository.save(dima);
        bookRepository.save(aa);


    }

}
