package pl.sda.VaadinToDo;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("listaAll")
public class QuestionGridGui extends VerticalLayout {

    public QuestionGridGui(QuestionApi question) {
        Grid<Question> grid = new Grid<>();
        grid.addColumn(Question::getId).setHeader("Id");
        grid.addColumn(Question::getTitle).setHeader("Do kupienia");

        List<Question> questionAll = (List<Question>) question.getAll();
        grid.setItems(questionAll);

        add(grid);
    }

}
