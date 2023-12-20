package www.model;

public class Emp {
   private int eid;
   private String ename;
   private String pwd;
   private String sex;
   private String bir;
   private String phone;
   private String rzdate;
   private String job;
   private Double bsal;
   private Double fsal;
   private Dept dept;
   private int deptno;

   @Override
   public String toString() {
      return "Emp{" +
              "eid=" + eid +
              ", ename='" + ename + '\'' +
              ", pwd='" + pwd + '\'' +
              ", sex='" + sex + '\'' +
              ", bir='" + bir + '\'' +
              ", phone='" + phone + '\'' +
              ", rzdate='" + rzdate + '\'' +
              ", job='" + job + '\'' +
              ", bsal=" + bsal +
              ", fsal=" + fsal +
              ", dept=" + dept +
              ", deptno=" + deptno +
              '}';
   }

   public int getEid() {
      return eid;
   }

   public void setEid(int eid) {
      this.eid = eid;
   }

   public String getEname() {
      return ename;
   }

   public void setEname(String ename) {
      this.ename = ename;
   }

   public String getPwd() {
      return pwd;
   }

   public void setPwd(String pwd) {
      this.pwd = pwd;
   }

   public String getSex() {
      return sex;
   }

   public void setSex(String sex) {
      this.sex = sex;
   }

   public String getBir() {
      return bir;
   }

   public void setBir(String bir) {
      this.bir = bir;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getRzdate() {
      return rzdate;
   }

   public void setRzdate(String rzdate) {
      this.rzdate = rzdate;
   }

   public String getJob() {
      return job;
   }

   public void setJob(String job) {
      this.job = job;
   }

   public Double getBsal() {
      return bsal;
   }

   public void setBsal(Double bsal) {
      this.bsal = bsal;
   }

   public Double getFsal() {
      return fsal;
   }

   public void setFsal(Double fsal) {
      this.fsal = fsal;
   }

   public Dept getDept() {
      return dept;
   }

   public void setDept(Dept dept) {
      this.dept = dept;
   }

   public int getDeptno() {
      return deptno;
   }

   public void setDeptno(int deptno) {
      this.deptno = deptno;
   }

   public Emp() {
   }

   public Emp(int eid, String ename, String pwd, String sex, String bir, String phone, String rzdate, String job, Double bsal, Double fsal, Dept dept, int deptno) {
      this.eid = eid;
      this.ename = ename;
      this.pwd = pwd;
      this.sex = sex;
      this.bir = bir;
      this.phone = phone;
      this.rzdate = rzdate;
      this.job = job;
      this.bsal = bsal;
      this.fsal = fsal;
      this.dept = dept;
      this.deptno = deptno;
   }
}
