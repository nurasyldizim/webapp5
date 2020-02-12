package com.webapp5.webapp5.bootstrap;

import com.webapp5.webapp5.model.Author;
import com.webapp5.webapp5.model.Book;
import com.webapp5.webapp5.repositories.AuthorRepository;
import com.webapp5.webapp5.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
        Author nura = new Author("Nurasyl", "Dizim");
        Book dd = new Book("The path of Abay", "1234", "Almaty Times");
        nura.getBooks().add(dd);
        dd.getAuthors().add(nura);

        authorRepository.save(nura);
        bookRepository.save(dd);


        //
        Author dima = new Author("Dima", "Uncle");
        Book aa = new Book("Stories", "4321", "Kazakh Times");
        dima.getBooks().add(aa);
        aa.getAuthors().add(dima);

        authorRepository.save(dima);
        bookRepository.save(aa);


    }

}
