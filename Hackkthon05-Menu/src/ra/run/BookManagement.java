package ra.run;

import ra.model.Book;
import ra.service.BookService;

import java.util.Arrays;
import java.util.Scanner;

public class BookManagement {
    private static final BookService bookService = new BookService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
             System.out.println(
                    "****************JAVA-HACKATHON-05-BASIC-MENU*************** \n" +
                    "" +
                    "1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách\n" +
                    "2. Hiển thị thông tin tất cả sách trong thư viện\n" +
                    "3. Sắp xếp sách theo lợi nhuận tăng dần\n" +
                    "4. Xóa sách theo mã sách\n" +
                    "5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả\n" +
                    "6. Thay đổi thông tin sách theo mã sách\n" +
                    "7. Thoát \n"+ "hãy nhập  lưa chọn : ");
             choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addNewBooks(scanner);
                    break;
                case 2:
                    displayAllBooks();
                    break;
                case 3:
                    sortBooks();
                    break;
                case 4:
                    deleteBook(scanner);
                    break;
                case 5:
                    searchBooks(scanner);
                    break;
                case 6:
//                    editBook(scanner);
                    break;
                case 7:
                    System.out.println("Thoát khỏi chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn của bạn  không hợp lệ. Vui lòng chọn lại　.");
            }
        } while (choice != 7);
    }

    private static void addNewBooks(Scanner scanner) {
        System.out.print("Nhập số lượng sách cần thêm: ");
        int numBooks = scanner.nextInt();
        scanner.nextLine();

        if (bookService.getBookCount() + numBooks > bookService.getMAX_BOOKS()) {
            System.out.println("Không thể thêm nhiều sách hơn. Đã đạt công suất tối đa.");
            return;
        }

        for (int i = 0; i < numBooks; i++) {
            Book book = new Book();
            System.out.println("Nhập thông tin cho Sách" + (i + 1) + ":");
            book.inputData();
            bookService.addNewBook(book);
        }

        System.out.println("Thêm " + numBooks + " sach thành công");
    }

    private static void displayAllBooks() {
        if (bookService.getBookCount() == 0) {
            System.out.println("Không có sách trong thư viện.");
            return;
        }

        System.out.println("Danh sách sách trong thư viện:");
        for (int i = 0; i < bookService.getBookCount(); i++) {
            System.out.println("------------------");
            bookService.findAll()[i].displayData();
        }
    }

    private static void sortBooks() {
        if (bookService.getBookCount() == 0) {
            System.out.println("Không có sách trong thư viện.");
            return;
        }
        bookService.sortByProfit();
        System.out.println("đã sắp xếp");
    }

    private static void deleteBook(Scanner scanner) {
        if (bookService.getBookCount() == 0) {
            System.out.println("không có sach trong thư viên");
            return;
        }

        System.out.print("Nhập id sách cần xoá ");
        int bookId = scanner.nextInt();
         boolean check = bookService.deleteById(bookId);
         if (check) {
             System.out.println(" sách có  id " + bookId + " đã xoá thành công.");
         }else {
             System.out.println("Không tìm thấy id");
         }
    }

    private static void searchBooks(Scanner scanner) {
        if (bookService.getBookCount() == 0) {
            System.out.println("không có sách trong thư viên");
            return;
        }

        System.out.print("Nhập truy vấn tìm kiếm (tên hoặc mô tả): ");
         scanner.nextLine();
        String query = scanner.nextLine();

        System.out.println("Kết quả tìm kiếm:\n");
        boolean found = false;
        Book[] listSearch = bookService.searchBookByName(query);
        for (int i = 0; i < listSearch.length; i++) {
            if(listSearch[i]!=null){
                listSearch[i].displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có sách phù hợp với truy vấn tìm kiếm.");
        }
    }

//    private static void editBook(Scanner scanner) {
//        if (bookCount == 0) {
//            System.out.println("không có sách trong thư viên");
//            return;
//        }
//
//        System.out.print("Nhập ID sách để sửa đổi: ");
//        int bookId = scanner.nextInt();
//        scanner.nextLine();
//
//        int bookIndex = findBookIndexById(bookId);
//        if (bookIndex == -1) {
//            System.out.println("sách không tôn tại");
//            return;
//        }
//
//        System.out.println("Sửa đổi cuốn sách với ID " + bookId + ":");
//        books[bookIndex].displayData();
//        System.out.println("Nhập thông tin mới:");
//
//        books[bookIndex].inputData();
//
//        System.out.println("Thông tin sách sửa đổi thành công.");
//    }
//
//    private static int findBookIndexById(int bookId) {
//        for (int i = 0; i < bookCount; i++) {
//            if (books[i].getBookId() == bookId) {
//                return i;
//            }
//        }
//        return -1;
//    }
}
