package www.dao;

public interface AdminDao {
    //验证身份
    public boolean checkAdmin(String username,String password);
}
