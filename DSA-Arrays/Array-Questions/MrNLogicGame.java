public class MrNLogicGame {

    // Method to sort array in descending order using Bubble Sort
    public static void bubbleSortDescending(String[] books) {
        int n = books.length;
        for (int i = 0; i < n-1 ; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compare strings lexicographically in descending order
                if (books[j].compareTo(books[j + 1]) < 0) {
                    // Swap if books[j] < books[j + 1]
                    String temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    // Method to update the array with the new book
    public static String[] updateBookArray(String[] books, String searchBook) {

        bubbleSortDescending(books);
        String newBook = "The " + searchBook;

        String[] updatedBooks = new String[books.length + 1];
        for (int i = 0; i < books.length; i++) {
            updatedBooks[i] = books[i];
        }
        updatedBooks[books.length] = newBook;

        return updatedBooks;
    }

    public static void main(String[] args) {
        String[] books = {"Java", "Python", "C++", "Html", "Ruby", "Swift"};
        String searchBook = "Java";

        // Get the updated array after sorting and adding the new book
        String[] updatedBooks = updateBookArray(books, searchBook);

        // Print the updated array
        System.out.println("Updated Array:");
        for (String book : updatedBooks) {
            System.out.print(book + " ");
        }
    }
}

