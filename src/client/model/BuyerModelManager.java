package client.model;

import shared.BookForSale;
import util.Subject;

import java.util.List;

public interface BuyerModelManager extends Subject {

    List<BookForSale> getBooks();
}
