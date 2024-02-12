package org.centrale.domain.visitor;

public class MeanTeacher implements TeacherVisitorInterface{
    @Override
    public void mark(Homework homework) {
        System.out.println("2/20");
    }

    @Override
    public void markBadHomework(BadWork homework) {
        System.out.println(
                homework.getTitle() + " de " + homework.getStudentName() + " aura 0/20. " +
                "Si je pouvais mettre moins un je l'aurai fait...");
    }

    @Override
    public void markExcellentWork(ExcellentWork homework) {
        System.out.println(
                homework.getTitle() + " de " + homework.getStudentName() + " aura 12/20, " +
                        "peut mieux faire.");
    }
}
