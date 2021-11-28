package buoi9.utils;

public class respon {
    private int maErr;
    private String err;

    public respon(int maErr, String err) {
        this.maErr = maErr;
        this.err = err;
    }

    public int getMaErr() {
        return maErr;
    }

    public void setMaErr(int maErr) {
        this.maErr = maErr;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

}
