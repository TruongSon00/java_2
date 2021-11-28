package sanpham;

public class productException extends Exception {
    static String message;

    public productException(String mes) {
        message = mes;

    }

    @Override
    public String toString() {

        return message;
    }

}
