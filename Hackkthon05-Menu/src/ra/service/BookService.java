package ra.service;

import ra.model.Book;

public class BookService {
    private  final int MAX_BOOKS = 20;
    private  Book[] books = new Book[MAX_BOOKS];
    private  int bookCount = 0;

    public Book[] findAll(){
        return books;
    }

    public void addNewBook(Book book){
            books[bookCount] = book;
            bookCount++;
    }

    public int getBookCount() {
        return bookCount;
    }

    public int getMAX_BOOKS() {
        return MAX_BOOKS;
    }
    public void sortByProfit(){
        for (int i = 0; i < bookCount -1; i++) {
            for (int j = i+1; j <bookCount ; j++) {
                if(books[i].getInterest()>books[j].getInterest()){
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
    }
    public boolean deleteById (int id){
        int indexDelete = -1;
        for (int i = 0; i < bookCount; i++) {
            if(books[i].getBookId()==id){
                indexDelete= i;
                break;
            }
        }
        if (indexDelete == -1) {
            return false;
        }
        for (int i = indexDelete; i < bookCount-1; i++) {
            books[i] = books[i+1];
        }
        books[bookCount-1] = null;
        bookCount--;
        return true;
    }

    public Book[] searchBookByName(String name){
        Book[] bookSearch = new Book[bookCount];
        int index = 0;
        for (int i = 0; i < bookCount; i++) {
            if(books[i].getBookName().contains(name) || books[i].getDescriptions().contains(name)){
                bookSearch[index] = books[i];
                index++;
            }
        }
        return bookSearch;
    }
}
