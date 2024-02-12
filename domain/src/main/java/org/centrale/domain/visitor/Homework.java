package org.centrale.domain.visitor;

public interface Homework {
    public String getTitle();
    public String getStudentName();

    public void accept(TeacherVisitorInterface teacher);
}
