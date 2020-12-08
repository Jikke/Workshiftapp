/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Day;
import domain.Period;
import domain.Person;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jeoleivo
 */
public class UI extends Application {

    private Period currentPeriod;

    private Stage window;
    private Scene mainScene;
    //mainScenen nappulat
    private Button createPeriod, addEmployees, appointShifts, checkPeriod,
            checkShifts, exit;
    //appointShift scenen RadioButtonit
    RadioButton morningChoice;
    RadioButton eveningChoice;
    RadioButton nightChoice;
    RadioButton dayoffChoice;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        //Luodaan Button-oliot
        createPeriod = new Button("Luo uusi jakso");
        addEmployees = new Button("Lisää työntekijöitä");
        appointShifts = new Button("Työntekijöiden lisääminen vuorohoin");

        checkPeriod = new Button("Työjakson tarkastelu");

        checkShifts = new Button("Työntekijän vuoron tarkastus");
        exit = new Button("Poistu");

        //Päävalikon Layout
        VBox menuLayout = new VBox(10);
        Label menuLabel = new Label("Päävalikko");
        menuLayout.getChildren().addAll(menuLabel, createPeriod, addEmployees, appointShifts, checkPeriod,
                checkShifts, exit);
        menuLayout.setAlignment(Pos.CENTER);
        mainScene = new Scene(menuLayout, 300, 250);
        window.setScene(mainScene);
        window.setTitle("WorkShiftApp");
        window.show();

        //"Lisää uusi jakso"-nappulan toiminnallisuus
        createPeriod.setOnAction(e -> {
            Scene createPeriodScene = createCreatePeriodScene();
            window.setScene(createPeriodScene);
            window.show();
        });

        //"Lisää työntekijöitä"-nappulan toiminnallisuus
        addEmployees.setOnAction(e -> {
            if (currentPeriod != null) {
                Scene addEmployeesScene = createAddEmployeesScene();
                window.setScene(addEmployeesScene);
                window.show();
            } else {
                AlertBox.display("Virhe!", "Työjaksoa ei ole vielä luotu.");
            }
        });

        //"Työntekijöiden lisääminen vuorohoin"-nappulan toiminnallisuus
        appointShifts.setOnAction(e -> {
            if (currentPeriod != null) {
                Scene appointShiftsScene = createAppointShiftsScene();
                window.setScene(appointShiftsScene);
                window.show();
            } else {
                AlertBox.display("Virhe!", "Työjaksoa ei ole vielä luotu.");
            }
        });

        //"Työjakson tarkastelu"-nappulan toiminnallisuus
        checkPeriod.setOnAction(e -> {
            if (currentPeriod != null) {
            checkPeriod();
            } else {
                AlertBox.display("Virhe!", "Työjaksoa ei ole vielä luotu.");
            }
        });

        //"Työntekijän vuoron tarkastus"-nappulan toiminnallisuus
        checkShifts.setOnAction(e -> {
            if (currentPeriod != null) {
                Scene checkShiftsScene = createCheckEmployeeScene();
                window.setScene(checkShiftsScene);
                window.show();
            } else {
                AlertBox.display("Virhe!", "Työjaksoa ei ole vielä luotu.");
            }
        });

        //Poistu-nappulan toiminnallisuus
        exit.setOnAction(e -> window.close());

        //Aloitusikkunan asettelu ja avaus
    }

    public void checkPeriod() {
        ArrayList<Day> days = currentPeriod.getDays();
        String wholePeriod = "";
        //looppaa läpi kaikkien päivien
        for (Day currentDay : days) {
            //luo vuoroista omat String-listat jokaisen uuden päivän tarkastelun alussa
            ArrayList<String> morningList = currentDay.getMorning();
            ArrayList<String> eveningList = currentDay.getEvening();
            ArrayList<String> nightList = currentDay.getNight();
            ArrayList<String> dayoffList = currentDay.getDayoff();
            //Luo lopulliseen String-olioon lisättävät String-oliot vuorojen työtenkijöistä
            String morning = "   Aamuvuorossa: ";
            String evening = "   Iltavuorossa: ";
            String night = "   Yövuorossa: ";
            String dayoff = "   Vapaalla:";
            //silmukoi tämän päivän kunkin vuoron listojen läpi ja lisää työntekijöiden nimet vuorojen String-olioihin
            for (int i = 0; i < currentDay.getMorning().size(); i++) {
                morning += (" " + morningList.get(i));
            }
            morning += "\n";
            for (int i = 0; i < currentDay.getEvening().size(); i++) {
                evening += (" " + eveningList.get(i));
            }
            evening += "\n";
            for (int i = 0; i < currentDay.getNight().size(); i++) {
                night += (" " + nightList.get(i));
            }
            night += "\n";
            for (int i = 0; i < currentDay.getDayoff().size(); i++) {
                dayoff += (" " + dayoffList.get(i));
            }
            dayoff += "\n";
            //kokoa lopulliseen String-olioon tämän päivän osalta kerätyt työntekijät        
            wholePeriod += ("\n" + currentDay.getWeekday() + ": \n" + morning + " \n" + evening + " \n" + night + " \n" + dayoff);
        }
        //kirjoittaa edelläkootun String-olion period.txt-tiedostoon ja avaa sen gedit-editorilla
        File periodFile = new File("period.txt");
        try ( PrintWriter writer = new PrintWriter(periodFile, "UTF-8")) {
            writer.write(wholePeriod);
            writer.flush();
            writer.close();
//                java.awt.Desktop.getDesktop().edit(periodFile);
            new ProcessBuilder("gedit", "period.txt").start();
        } catch (Exception e) {
            AlertBox.display("Virhe!", "Työjakson kirjoittaminen epäonnistui!");
        }
    }

    public boolean createPeriod(String userInput) {

        try {
            String[] numbers = userInput.split(",");
            if (numbers.length == 3) {
                int m = Integer.parseInt(numbers[0]);
                int e = Integer.parseInt(numbers[0]);
                int n = Integer.parseInt(numbers[0]);
                this.currentPeriod = new Period(m, e, n);

                return true;
            }

        } catch (Exception e) {

            return false;
        }
        return false;
    }

    //Luo "Lisää uusi jakso"-näkymän 
    public Scene createCreatePeriodScene() {
        GridPane createPeriodGrid = createGridPane();

        Label createPeriodInfo = new Label("Anna aamu-, ilta- ja yövuorojen minimivahvuudet \n"
                + "pilkulla erotettuna:");
        GridPane.setConstraints(createPeriodInfo, 1, 0);

        TextField minValuesInput = new TextField();
        GridPane.setConstraints(minValuesInput, 1, 1);

        Button proceedButton = new Button("Syötä!");
        GridPane.setConstraints(proceedButton, 1, 2);
        
        Button leaveButton = new Button("Poistu");
        GridPane.setConstraints(leaveButton, 1, 3);

        proceedButton.setOnAction(e -> {

            boolean result = createPeriod(minValuesInput.getText());
            if (result == true) {
                AlertBox.display("Jakso luotu", "Jakson luominen onnistui!");
                window.setScene(mainScene);
                window.setTitle("WorkShiftApp");
                window.show();
            } else {
                AlertBox.display("Virhe!", "Virheellinen syöte!\n"
                        + "Anna syöte muodossa 1,2,3");
            }
        }
        );
        
        leaveButton.setOnAction(e -> {
            window.setScene(mainScene);
            window.setTitle("WorkShiftApp");
            window.show();
        }
        );

        createPeriodGrid.getChildren().addAll(createPeriodInfo, minValuesInput, proceedButton, leaveButton);
        Scene createdPeriodScene = new Scene(createPeriodGrid, 325, 200);
        return createdPeriodScene;
    }

    public boolean createEmployees(String employeeName) {
        if (currentPeriod != null) {
            if (currentPeriod.findEmployee(employeeName) == null) {
                Person newEmployee = new Person(employeeName);
                currentPeriod.addEmployee(newEmployee);
                //Asettaa vakiovuoroksi uudelle työntekijälle vapaavuorot
                for (Day day : currentPeriod.getDays()) {
                    currentPeriod.setEmployeeDayoff(day, employeeName);
                }
                return true;
                //Samannimisen työntekijän tarkistus    
            } else {
                AlertBox.display("Virhe!", "Kyseinen työntekijä on jo olemassa");
            }
            //Period-olion olemassaolon tarkistus   
        } else {
            AlertBox.display("Virhe!", "Työjaksoa ei ole vielä luotu!");
        }
        return false;
    }

    //Luo "Lisää työtenkijöitä"-näkymän
    public Scene createAddEmployeesScene() {
        GridPane addEmployeesGrid = createGridPane();

        Label addEmployeesInfo = new Label("Anna työntekijän nimi:");
        GridPane.setConstraints(addEmployeesInfo, 1, 0);

        TextField employeeNameInput = new TextField();
        GridPane.setConstraints(employeeNameInput, 1, 1);

        Button proceedButton = new Button("Lisää!");
        GridPane.setConstraints(proceedButton, 1, 2);

        Button leaveButton = new Button("Poistu");
        GridPane.setConstraints(leaveButton, 1, 3);

        Label succesfullyAdded = new Label("Työntekijän lisääminen onnistui!");
        GridPane.setConstraints(succesfullyAdded, 1, 4);

        addEmployeesGrid.getChildren().addAll(addEmployeesInfo, employeeNameInput, proceedButton, leaveButton);

        proceedButton.setOnAction(e -> {

            boolean result = createEmployees(employeeNameInput.getText());
            if (result == true) {

                GridPane addedEmployeesGrid = createGridPane();

                addedEmployeesGrid.getChildren().addAll(addEmployeesInfo, employeeNameInput, proceedButton, leaveButton, succesfullyAdded);
                Scene addedEmployeesScene = new Scene(addedEmployeesGrid, 300, 200);
                window.setScene(addedEmployeesScene);
                window.show();

            } else {

                GridPane notAddedEmployeesGrid = createGridPane();

                notAddedEmployeesGrid.getChildren().addAll(addEmployeesInfo, employeeNameInput, proceedButton, leaveButton);
                Scene notAddedEmployeesScene = new Scene(notAddedEmployeesGrid, 300, 200);
                window.setScene(notAddedEmployeesScene);
                window.show();
            }
        }
        );

        leaveButton.setOnAction(e -> {
            window.setScene(mainScene);
            window.setTitle("WorkShiftApp");
            window.show();
        }
        );

        Scene createdAddEmployeesScene = new Scene(addEmployeesGrid, 300, 200);

        return createdAddEmployeesScene;
    }

    public Scene createAppointShiftsScene() {

        GridPane appointShiftsGrid = createGridPane();

        Label appointShiftsInfo = new Label("Valitse pudotusvalikosta päivä, klikkaa vuoro \n"
                + "ja kirjoita kenttään vuoroon lisättävän työntekijän nimi.");
        GridPane.setConstraints(appointShiftsInfo, 1, 0);

        //Luodaan päivien pudotusvalikko
        ChoiceBox<Day> dropDownDays = new ChoiceBox<>();
        for (Day currentDay : currentPeriod.getDays()) {
            dropDownDays.getItems().add(currentDay);
        }
        dropDownDays.getSelectionModel().selectFirst();
        GridPane.setConstraints(dropDownDays, 1, 1);

        //Luodaan vuorojen radiobuttonit
        ToggleGroup shiftToggle = new ToggleGroup();

        morningChoice = new RadioButton("Aamu");
        eveningChoice = new RadioButton("Ilta");
        nightChoice = new RadioButton("Yö");
        dayoffChoice = new RadioButton("Vapaa");

        shiftToggle.getToggles().addAll(morningChoice, eveningChoice, nightChoice, dayoffChoice);
        //asetetaan aamuvuoro vakioksi
        morningChoice.setSelected(true);
        
        GridPane.setConstraints(morningChoice, 1, 2);
        GridPane.setConstraints(eveningChoice, 1, 3);
        GridPane.setConstraints(nightChoice, 1, 4);
        GridPane.setConstraints(dayoffChoice, 1, 5);

        //Luodaan työntekijöistä pudotusvalikko
        ChoiceBox<String> dropDownEmployees = new ChoiceBox<>();
        for (Person currentPerson : currentPeriod.getEmployees()) {
            dropDownEmployees.getItems().add(currentPerson.getName());
        }
        dropDownEmployees.getSelectionModel().selectFirst();
        GridPane.setConstraints(dropDownEmployees, 1, 6);

        Button proceedButton = new Button("Lisää!");
        GridPane.setConstraints(proceedButton, 1, 7);

        Button leaveButton = new Button("Poistu");
        GridPane.setConstraints(leaveButton, 1, 8);

        Label infoLabel = new Label("");
        GridPane.setConstraints(infoLabel, 1, 9);

        //"Lisää!"-nappulan toiminnallisuus
        proceedButton.setOnAction(e -> {
            String chosenEmployee = chosenDropDownEmployee(dropDownEmployees);

                int howManyMore = this.setPeriodEmployees(chosenDropDownDay(dropDownDays), chosenShift(), chosenEmployee);
                //vapaa-vuoro, johon lisäys ei vaadi lepoaikojen tarkastamista TAI 
                //minimityöntekijöiden määrä on saavutettu
                if (chosenShift().equals("vapaa") || howManyMore == -2) {
                    GridPane addedEmployeesGrid = createGridPane();
                    infoLabel.setText("Työntekijän lisääminen vuoroon onnistui!");
                    addedEmployeesGrid.getChildren().addAll(appointShiftsInfo, dropDownDays, morningChoice, eveningChoice,
                            nightChoice, dayoffChoice, dropDownEmployees, proceedButton, leaveButton, infoLabel);
                    Scene addedEmployeesScene = new Scene(addedEmployeesGrid, 500, 500);
                    window.setScene(addedEmployeesScene);
                    window.show();

                    //Lepoajat eivät täyty, virhekoodi -10 
                } else if (howManyMore == -10) {
                    AlertBox.display("Virhe!", "Kyseistä työntekijää ei voitu lisätä tähän vuoroon, \n"
                            + "koska lepoajat eivät täyttyisi.");
                    GridPane addedEmployeesGrid = createGridPane();
                    infoLabel.setText("Työntekijää ei lisätty vuoroon.");

                    addedEmployeesGrid.getChildren().addAll(appointShiftsInfo, dropDownDays, morningChoice, eveningChoice,
                            nightChoice, dayoffChoice, dropDownEmployees, proceedButton, leaveButton, infoLabel);
                    Scene addedEmployeesScene = new Scene(addedEmployeesGrid, 500, 500);
                    window.setScene(addedEmployeesScene);
                    window.show();
                } //tilanteet, joissa vuoroon tarvitaan vielä työntekijöitä  
                else {

                    GridPane addedEmployeesGrid = createGridPane();
                    infoLabel.setText("Työntekijän lisääminen vuoroon onnistui!\n"
                            + chosenShift() + "vuoroon tarvitaan vielä " + howManyMore + " työntekijää lisää.");

                    addedEmployeesGrid.getChildren().addAll(appointShiftsInfo, dropDownDays, morningChoice, eveningChoice,
                            nightChoice, dayoffChoice, dropDownEmployees, proceedButton, leaveButton, infoLabel);
                    Scene addedEmployeesScene = new Scene(addedEmployeesGrid, 500, 500);
                    window.setScene(addedEmployeesScene);
                    window.show();
                }
        });

        leaveButton.setOnAction(e -> {
            window.setScene(mainScene);
            window.setTitle("WorkShiftApp");
            window.show();
        });

        //Luodaan appointShiftsScene
        appointShiftsGrid.getChildren().addAll(appointShiftsInfo, dropDownDays, morningChoice, eveningChoice,
                nightChoice, dayoffChoice, dropDownEmployees, proceedButton, leaveButton, infoLabel);
        Scene createdAppointShiftsScene = new Scene(appointShiftsGrid, 400, 400);

        return createdAppointShiftsScene;
    }

    //Palauttaa pudotusvalikosta valitun päivän
    public Day chosenDropDownDay(ChoiceBox<Day> dropDownDays) {
        Day currentDay = dropDownDays.getValue();
        return currentDay;
    }

    //Palauttaa pudotusvalikosta valitun työntekijän
    public String chosenDropDownEmployee(ChoiceBox<String> dropDownEmployees) {
        String currentEmployee = dropDownEmployees.getValue();
        return currentEmployee;
    }

    //Palauttaa vuoron arvon Radiobutton-valinnan mukaan
    public String chosenShift() {
        if (morningChoice.isSelected()) {
            return "aamu";
        } else if (eveningChoice.isSelected()) {
            return "ilta";
        } else if (nightChoice.isSelected()) {
            return "yö";
        } else {
            return "vapaa";
        }
    }

    public int setPeriodEmployees(Day currentDay, String currentShift, String employeeName) {

        String shift = currentShift;
        boolean isFree = true;
        int howManyMore = -2;

        switch (shift) {
            case "aamu":
                isFree = currentPeriod.isEmployeeAvailable(currentPeriod.findEmployee(employeeName), currentDay, "aamu");
                if (isFree == true) {
                    currentPeriod.setEmployeeMorning(currentDay, employeeName);
                    howManyMore = currentDay.howManyMoreToShift("aamu");
                }
                break;
            case "ilta":
                isFree = currentPeriod.isEmployeeAvailable(currentPeriod.findEmployee(employeeName), currentDay, "ilta");
                if (isFree == true) {
                    currentPeriod.setEmployeeEvening(currentDay, employeeName);
                    howManyMore = currentDay.howManyMoreToShift("ilta");
                }
                break;
            case "yö":
                isFree = currentPeriod.isEmployeeAvailable(currentPeriod.findEmployee(employeeName), currentDay, "yö");
                if (isFree == true) {
                    currentPeriod.setEmployeeNight(currentDay, employeeName);
                    howManyMore = currentDay.howManyMoreToShift("yö");
                }
                break;
            case "vapaa":
                currentPeriod.setEmployeeDayoff(currentDay, employeeName);
                break;
        }

        //-10 on virhekoodi lepoaikojen täyttymättömyydelle
        if (isFree == false) {
            return -10;
        }

        return howManyMore;
    }

    public Scene createCheckEmployeeScene() {
        GridPane checkEmployeeGrid = createGridPane();

        Label checkEmployeeInfo = new Label("Valitse työntekijän nimi ja työpäivä pudotusvalikoista:");
        GridPane.setConstraints(checkEmployeeInfo, 1, 0);

        //Luodaan työntekijöistä pudotusvalikko
        ChoiceBox<String> dropDownEmployees = new ChoiceBox<>();
        for (Person currentPerson : currentPeriod.getEmployees()) {
            dropDownEmployees.getItems().add(currentPerson.getName());
        }
        dropDownEmployees.getSelectionModel().selectFirst();
        GridPane.setConstraints(dropDownEmployees, 1, 1);

        //Luodaan päivien pudotusvalikko
        ChoiceBox<Day> dropDownDays = new ChoiceBox<>();
        for (Day currentDay : currentPeriod.getDays()) {
            dropDownDays.getItems().add(currentDay);
        }
        dropDownDays.getSelectionModel().selectFirst();
        GridPane.setConstraints(dropDownDays, 1, 2);

        Button proceedButton = new Button("Hae!");
        GridPane.setConstraints(proceedButton, 1, 3);

        Button leaveButton = new Button("Poistu");
        GridPane.setConstraints(leaveButton, 1, 4);

        proceedButton.setOnAction(e -> {
            String employeeName = chosenDropDownEmployee(dropDownEmployees);
            String dayName = chosenDropDownDay(dropDownDays).getWeekday();

            try {
                String result = currentPeriod.checkEmployee(employeeName, dayName);
                AlertBox.display("Haku onnistui!", "Henkilön " + employeeName + " työvuoro päivänä " + dayName + " on " + result);

            } catch (Exception s) {
                AlertBox.display("Haku epäonnistui!", "Tarkista pudotusvalikoiden valinnat!");
            }
        }
        );

        leaveButton.setOnAction(e -> {
            window.setScene(mainScene);
            window.show();
        });

        checkEmployeeGrid.getChildren().addAll(checkEmployeeInfo, dropDownEmployees, dropDownDays, proceedButton, leaveButton);
        Scene createdPeriodScene = new Scene(checkEmployeeGrid, 400, 300);
        return createdPeriodScene;
    }

    //Luo geneerisen GridPanen
    public GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        return gridPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
