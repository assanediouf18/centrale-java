package org.centrale.domain.visitor;

public interface TeacherVisitorInterface {
    public void mark(Homework homework);
    public void markBadHomework(BadWork homework);
    public void markExcellentWork(ExcellentWork homework);
}
