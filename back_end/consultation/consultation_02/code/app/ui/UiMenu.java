package code.app.ui;

import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Scanner;

public class UiMenu {

    private final List<UIAction> uiActions;

    public UiMenu(List<UIAction> uiActions) {
        this.uiActions = uiActions;
    }

    public void startUI(){
        while (true) {
            try {
                System.out.println("Please enter your choice: ");

                for (int i = 0; i < uiActions.size(); i++) {
                    var uiAction = uiActions.get(i);
                    System.out.println(i + ". " + uiAction.getActionName());
                }

                Scanner scanner = new Scanner(System.in);
                int userInput = scanner.nextInt();
                uiActions.get(userInput).execute();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
