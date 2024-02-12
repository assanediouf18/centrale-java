package org.centrale.domain.visitor;

public class NiceTeacher implements TeacherVisitorInterface {
    @Override
    public void mark(Homework homework) {
        System.out.println("10/20");
    }

    @Override
    public void markBadHomework(BadWork homework) {
        System.out.println(homework.getTitle() + " de " + homework.getStudentName() + " aura 10/20");
    }

    @Override
    public void markExcellentWork(ExcellentWork homework) {
        System.out.println(homework.getTitle() + " de " + homework.getStudentName() + " aura 21/20, c'est un travail exquis !");
    }
}
