package org.centrale.domain.visitor;

public class BadWork implements Homework{
    private final String title;
    private final String student;

    public BadWork(String title, String studentName) {
        this.title = title;
        this.student = studentName;
    }
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getStudentName() {
        return student;
    }

    @Override
    public void accept(TeacherVisitorInterface teacher) {
        teacher.markBadHomework(this);
    }
}
