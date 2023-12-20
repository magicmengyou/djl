package www.model;

public class Admin {
    private String adminId;
    private String adminName;
    private String adminPassword;

    public Admin() {
    }

    public Admin(String adminId, String adminName, String adminPwd) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPassword = adminPwd;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPassword;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPassword = adminPwd;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminPwd='" + adminPassword + '\'' +
                '}';
    }
}
