package com.aanorbel.lab6;

import java.util.ArrayList;

/**
 * holds the Courses that a student is enrolled in an arrayList, has a name
 *
 * @author anorbel
 */
public class Student {

    /**
     * name of student
     */
    String name;
    /**
     * students total
     */
    double total;
    /**
     * ArrayList of students courses
     */
    ArrayList<Course> courses;

    /**
     *
     * @param name default constructor
     */
    Student(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    /**
     * Adds a course to the Student’s list of courses.
     *
     * @param courseName
     */
    public void addCourse(Course courseName) {
        this.courses.add(courseName);
    }

    /**
     * Adds the given number of points to the points for a specific course
     *
     * @param newPoints
     */
    public void addPoints(double newPoints) {
        this.total += newPoints;
    }

    /**
     * Returns the total points this student has earned for the course specified
     *
     * @param courseName
     * @return
     */
    public double getPoints(Course courseName) {
        double sum = 0.0;
        for (int i = 0; i < this.courses.size(); i++) {
            if (this.courses.get(i).courseName.equals(courseName)) {
                for (int j = 0; j < this.courses.get(i).students.size(); j++) {
                    if (this.name.equals(courses.get(i).students.get(j).name)) {
                        sum = courses.get(i).studentGrades.get(j);
                    }
                }
            }
        }
        return sum;
    }

    /**
     * Prints the names of the courses the student is taking
     */
    public void getCourses() {
        for (Course course : courses) {
            System.out.printf(course.courseName);
        }
    }

    /**
     * Returns the name of the student
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns a String representation of this Student
     *
     * @return
     */
    @Override
    public String toString() {
        String remark = "Fail";
        String replyToString = " ";
        replyToString = replyToString + this.getName();
        replyToString = replyToString + "\n----------------------------------------------------\n";
        replyToString += "Course \tMark \tRemark \n";
        for (int i = 0; i < this.courses.size(); i++) {
            double average = this.courses.get(i).averageAll();
            for (int j = 0; j < courses.get(i).students.size(); j++) {
                double grade = this.courses.get(i).studentGrades.get(j);
                if (this.courses.get(i).students.get(j).name.equals(getName())) {

                    if (grade >= average) {
                        remark = grade + "   Pass ";
                    } else {
                        remark = grade + "   Fail ";
                    }
                    replyToString += this.courses.get(i).courseName + "   " + remark + "\n";
                }
            }
        }
        return replyToString;
    }
}
