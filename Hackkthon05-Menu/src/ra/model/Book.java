package ra.model;

import java.util.Scanner;

public class Book {
    private static int nextBookId = 1;
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
        this.bookId = nextBookId++;
        this.bookStatus = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sách:");
        this.bookName = scanner.nextLine();
        System.out.println("Nhập tác giả:");
        this.author = scanner.nextLine();
        System.out.println("Nhập mô tả (ít nhất 10 ký tự):");
        this.descriptions = scanner.nextLine();
        while (this.descriptions.length() < 10) {
            System.out.println("Mô tả phải có ít nhất 10 ký tự. Vui lòng nhập lại mô tả:");
            this.descriptions = scanner.nextLine();
        }
        System.out.println("Nhập giá nhập (lớn hơn 0):");
        this.importPrice = scanner.nextDouble();
        while (this.importPrice <= 0) {
            System.out.println("Giá nhập phải lớn hơn 0. Vui lòng nhập lại giá nhập:");
            this.importPrice = scanner.nextDouble();
        }
        System.out.println("Nhập giá xuất (lớn hơn 1.2 lần giá nhập):");
        this.exportPrice = scanner.nextDouble();
        while (this.exportPrice <= 1.2 * this.importPrice) {
            System.out.println("Giá xuất phải lớn hơn 1.2 lần giá nhập. Vui lòng nhập lại giá xuất:");
            this.exportPrice = scanner.nextDouble();
        }
        this.interest = (float) (this.exportPrice - this.importPrice);
    }

    public void displayData() {
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Tác giả: " + author);
        System.out.println("Mô tả: " + descriptions);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Lợi nhuận: " + interest);
        System.out.println("Trạng thái: " + (bookStatus ? "Còn hàng" : "Hết hàng"));
    }
}
