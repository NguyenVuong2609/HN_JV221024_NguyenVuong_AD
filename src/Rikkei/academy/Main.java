package Rikkei.academy;

import java.time.Year;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        int size = 0;
        Student[] studentsArray = new Student[200];
        boolean formStatus = false;
        do {
            System.out.println("\n****************HACKATHON-JAVA-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập số sinh viên và nhập thông tin cho các sinh viên");
            System.out.println("2. In thông tin các sinh viên đang quản lý");
            System.out.println("3. Sắp xếp các sinh viên theo điểm trung bình tăng dần");
            System.out.println("4. Nhập vào tên sinh viên và tìm kiếm sinh viên theo tên");
            System.out.println("5. Thống kê số sinh viên nam, nữ đang quản lý");
            System.out.println("6. In ra thông tin các sinh viên xếp loại giỏi và trung bình ");
            System.out.println("7. Thoát");
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập số lượng sinh viên bạn muốn nhập: ");
                    size = sc.nextInt();
                    if (size > 0) {
                        for (int i = 0; i < size; i++) {
                            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + " :");
                            studentsArray[i] = new Student();
                            studentsArray[i].inputStudent(size);
                        }
                        formStatus = true;
                    } else {
                        System.out.println("Không hợp lệ.");
                    }
                    break;
                case 2:
                    if (formStatus)
                        for (int i = 0; i < size; i++) {
                            studentsArray[i].displayData();
                        }
                    else
                        System.out.println("Chưa có sinh viên nào.");
                    break;
                case 3:
                    Student temp = studentsArray[0];
                    if (formStatus)
                        for (int i = 0; i < size - 1; i++) {
                            for (int j = 1; j < size; j++) {
                                if (studentsArray[i].calAvgMark() > studentsArray[j].calAvgMark()) {
                                    temp = studentsArray[j];
                                    studentsArray[j] = studentsArray[i];
                                    studentsArray[i] = temp;
                                }
                            }
                        }
                    else {
                        System.out.println("Chưa có sinh viên.");
                    }
                    break;
                case 4:
                    if (formStatus) {
                        System.out.println("Nhập vào tên sinh viên bạn muốn tìm: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        for (int i = 0; i < size; i++) {
                            if (studentsArray[i].getStudentName().equalsIgnoreCase(name))
                                studentsArray[i].displayData();
                        }
                    } else {
                        System.out.println("Chưa có sinh viên.");
                    }
                    break;
                case 5:
                    int countMale = 0;
                    int countFemale = 0;
                    if (formStatus) {
                        for (int i = 0; i < size; i++) {
                            if (studentsArray[i].getSex() == 1)
                                countMale++;
                            else
                                countFemale++;
                        }
                        System.out.println("Tổng số sinh viên nam: " + countMale + "\nTổng số sinh viên nữ: " + countFemale);
                    } else {
                        System.out.println("Chưa có sinh viên.");
                    }
                    break;
                case 6:
                    if (formStatus) {
                        System.out.println("\nCác sinh viên xếp loại giỏi:");
                        for (int i = 0; i < size; i++) {
                            if (studentsArray[i].calAvgMark() >= 8 && studentsArray[i].calAvgMark() <9)
                                studentsArray[i].displayData();
                        }
                        System.out.println("\n\nCác sinh viên xếp loại TB: ");
                        for (int i = 0; i < size; i++) {
                            if (studentsArray[i].calAvgMark() >= 5 && studentsArray[i].calAvgMark() < 7)
                                studentsArray[i].displayData();
                        }
                    } else {
                        System.out.println("Chưa có sinh viên.");
                    }
                    break;
                case 7:
                    System.exit(0);
            }
        } while (choice != 7);
    }
}
