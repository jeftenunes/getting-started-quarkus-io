package org.acme.getting.started.services;

import java.util.*;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookService {
    Map books = Collections.synchronizedMap(new HashMap());

    public String getBooks(Optional<Integer> parameter) {
        return String.valueOf(parameter.isPresent()
                ? books.get((Integer)parameter.get())
                : books.values()
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
    }

    public void addBook(String bookName) {
        int id = books.size() + 1;
        books.put(id, bookName);
    }
}