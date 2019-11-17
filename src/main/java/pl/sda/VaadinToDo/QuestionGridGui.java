package pl.sda.VaadinToDo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("listAll")
public class QuestionGridGui extends VerticalLayout {

    public QuestionGridGui(QuestionApi question) {
        Grid<Question> grid = new Grid<>();
        grid.addColumn(Question::getId).setHeader("Id");
        grid.addColumn(Question::getTitle).setHeader("Do kupienia");

        List<Question> questionAll = (List<Question>) question.getAll();
        grid.setItems(questionAll);

        Button buttonList = new Button("Dodaj do listy", new Icon(VaadinIcon.BUTTON));
        buttonList.addClickListener(e ->
                buttonList.getUI().ifPresent(ui ->
                        ui.navigate("list")));

        buttonList.addClassName("buttonList");

        add(grid, buttonList);
    }

}
