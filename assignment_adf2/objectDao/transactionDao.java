package assignment_adf2.objectDao;

public interface transactionDao {
    public void transactionTheoAcc(String matk, String beginTime, String endTime);

    public void transactionTheoCus(String maKH, String beginTime, String endTime);

    public boolean xuatFile(String month, String year);

}
