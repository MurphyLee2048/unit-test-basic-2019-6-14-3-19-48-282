package ExpenseService;

import ExpenseService.Exception.UnexpectedProjectTypeException;
import ExpenseService.Project.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ExpenseService.Expense.ExpenseType.*;
import static ExpenseService.ExpenseService.getExpenseCodeByProjectTypeAndName;
import static ExpenseService.Project.ProjectType.*;
import static org.junit.jupiter.api.Assertions.assertSame;

class ExpenseServiceTest {
    @Test
    void should_return_internal_expense_type_if_project_is_internal() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(INTERNAL, "project");

        // when
        // then
        assertSame(INTERNAL_PROJECT_EXPENSE, getExpenseCodeByProjectTypeAndName(project));

    }

    @Test
    void should_return_expense_type_A_if_project_is_external_and_name_is_project_A() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(EXTERNAL, "Project A");

        // when
        // then
        assertSame(EXPENSE_TYPE_A, getExpenseCodeByProjectTypeAndName(project));
    }

    @Test
    void should_return_expense_type_B_if_project_is_external_and_name_is_project_B() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(EXTERNAL, "Project B");

        // when
        // then
        assertSame(EXPENSE_TYPE_B, getExpenseCodeByProjectTypeAndName(project));
    }

    @Test
    void should_return_other_expense_type_if_project_is_external_and_has_other_name() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(EXTERNAL, "Project C");

        // when
        // then
        assertSame(OTHER_EXPENSE, getExpenseCodeByProjectTypeAndName(project));
    }

    @Test
    void should_throw_unexpected_project_exception_if_project_is_invalid() {
        // given
        Project project = new Project(UNEXPECTED_PROJECT_TYPE, "invalidProject");

        // when
        // then
        Assertions.assertThrows(UnexpectedProjectTypeException.class, () -> {
            getExpenseCodeByProjectTypeAndName(project);
        });
    }
}