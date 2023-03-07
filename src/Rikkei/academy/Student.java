package Rikkei.academy;

import java.time.Year;
import java.util.Scanner;

public class Student {
    private String studentIdNumber, studentId, studentName, phone, address;

    private final String studentIdCode = "RA";
    private int age, sex;
    float html, css, javascript, avgMark;

    public Student() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentIdNumber() {
        return studentIdNumber;
    }

    public void setStudentIdNumber(String studentIdNumber) {
        this.studentIdNumber = studentIdNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHtml() {
        return html;
    }

    public void setHtml(float html) {
        this.html = html;
    }

    public float getCss() {
        return css;
    }

    public void setCss(float css) {
        this.css = css;
    }

    public float getJavascript() {
        return javascript;
    }

    public void setJavascript(float javascript) {
        this.javascript = javascript;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public void displayData() {
        int today = Year.now().getValue();
        System.out.println("\nThông tin:");
        System.out.printf("%s%-20s%s%s", "Mã sinh viên: ", mergeStudentId(), "Tên sinh viên: ", studentName);
        System.out.printf("%s%-24d%s%-20s%s%s", "\nNăm sinh: ", (today - age), "Giới tính: ", (sex == 1 ? "Nam" : sex == 2 ? "Nữ" : "Khác"), "Điện thoại: ", phone);
        System.out.printf("%s%-56s%s%f", "\nĐịa chỉ: ", address, "Điểm TB: ", calAvgMark());
    }

    public void inputStudent(int size) {
        Scanner sc = new Scanner(System.in);
        int inputSex = 0;
        String inputId = "";
        do {
            System.out.println("Nhập mã sinh viên (3 chữ số):");
            inputId = sc.nextLine();
            if (inputId.length() != 3)
                System.out.println("ID chưa đúng yêu cầu");
        } while (inputId.length() != 3);
        this.setStudentIdNumber(inputId);
        System.out.println("Nhập tên sinh viên: ");
        this.setStudentName(sc.nextLine());
        System.out.println("Nhập tuổi: ");
        this.setAge(sc.nextInt());
        do {
            System.out.println("Nhập giới tính: (Nam = 1; Nữ = 2; Khác = 3)");
            inputSex = sc.nextInt();
            if (inputSex < 1 || inputSex > 3)
                System.out.println("Giới tính không hợp lệ.");
        } while (inputSex < 1 || inputSex > 3);
        this.setSex(inputSex);
        sc.nextLine();
        System.out.println("Nhập số điện thoại: ");
        this.setPhone(sc.nextLine());
        System.out.println("Nhập địa chỉ: ");
        this.setAddress(sc.nextLine());
        System.out.println("Nhập điểm HTML: ");
        this.setHtml(sc.nextFloat());
        System.out.println("Nhập điểm CSS: ");
        this.setCss(sc.nextFloat());
        System.out.println("Nhập điểm JavaScript: ");
        this.setJavascript(sc.nextFloat());
    }

    public double calAvgMark() {
        return avgMark = (html + css + 2 * javascript) / 4;
    }

    private String mergeStudentId() {
        return studentId = studentIdCode + studentIdNumber;
    }
}
