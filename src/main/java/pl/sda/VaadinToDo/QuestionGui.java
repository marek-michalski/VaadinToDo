package pl.sda.VaadinToDo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("list")
public class QuestionGui extends VerticalLayout {

    @Autowired
    private QuestionRepo questionRepo;

    private TextField textFieldTitle = new TextField("Co chcesz kupić:");
    private Button buttonAdd = new Button("Dodaj");


    public QuestionGui() {

        Button buttonListAll = new Button("Lista zakupów", new Icon(VaadinIcon.BUTTON));
        buttonListAll.addClickListener(e ->
                buttonListAll.getUI().ifPresent(ui ->
                        ui.navigate("listAll")));

        buttonListAll.addClassName("buttonListAll");

        add(textFieldTitle, buttonAdd, buttonListAll);

        buttonAdd.addClickListener(click -> {
            Notification.show("Dodano do bazy!");
        });

        buttonAdd.addClickListener(clickEvent -> {
            Question question = new Question();
            question.setTitle(textFieldTitle.getValue());
            questionRepo.save(question);
        });
    }

}
