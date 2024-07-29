package vn.edu.likelion.project.day19072024.model;


public class Attendance {

  private String id;
  private java.sql.Date createdDate;
  private String isAttendance;
  private String studentId;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public java.sql.Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(java.sql.Date createdDate) {
    this.createdDate = createdDate;
  }


  public String getIsAttendance() {
    return isAttendance;
  }

  public void setIsAttendance(String isAttendance) {
    this.isAttendance = isAttendance;
  }


  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

}
