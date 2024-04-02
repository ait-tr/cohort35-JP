package code.app.ui;

import code.app.service.FindTaskByIdService;

import java.util.Scanner;

public class ExitUiAction implements UIAction{


    @Override
    public void execute() {
      System.out.println("Bye-bye!");
      System.exit(0);

    }

    @Override
    public String getActionName() {
        return "Exit";
    }


}
