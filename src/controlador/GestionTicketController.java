/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modelo.Departamento;
import modelo.Ticket;
/**
 *
 * @author Karlaa
 */
public class GestionTicketController implements Initializable {
    @FXML
    private TableView<Ticket> tblTickets;
    @FXML
    private TableColumn<Ticket, String> tblTituloColumna;
    @FXML
    private TableColumn<Ticket, String> tblDescripcionColumna;
    @FXML
    private TableColumn<Ticket, String> tblDepartamentoColumna;
    @FXML
    private TableColumn<Ticket, String> tblPrioridadColumna;
    @FXML
    private Button buttonCrearTicket;
    @FXML
    private Button buttonModificarTicket;
    @FXML
    private Button buttonAsignarTicket;
    @FXML
    private Button buttonCerrarTicket;
    @FXML
    private Button buttonMenu;

    private ObservableList<Ticket> listaTickets;

        
     /**
     * Initializes the controller class.
     */

   @Override
    public void initialize(URL url, ResourceBundle rb) {
    listaTickets = FXCollections.observableArrayList();


    tblTituloColumna.setCellValueFactory(new PropertyValueFactory<>("titulo"));
    tblDescripcionColumna.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    tblDepartamentoColumna.setCellValueFactory(new PropertyValueFactory<>("departamento"));

    tblPrioridadColumna.setCellValueFactory(new PropertyValueFactory<>("prioridad"));

    listaTickets.add(new Ticket(0, "Error en Sistema", "Sistema no responde", "TI", "Alta"));
    tblTickets.setItems(listaTickets); // Vincular lista a la tabla
}


    
    
    
    @FXML
    private void handleCrearTicket(ActionEvent event) {
    try {
        // Cargar la vista del formulario de creación/modificación
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GestionTicket2Vista.fxml"));
        Parent root = loader.load();

        // Obtener el controlador del formulario
        GestionTicket2Controller controller = loader.getController();

        // Pasar la lista de tickets al formulario para que pueda actualizarla
        controller.setListaTickets(listaTickets);

        // El formulario estará limpio
        controller.limpiarCampos();

        // Crear un nuevo Stage para la nueva interfaz
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.setTitle("Crear Nuevo Ticket");
        newStage.show();

        // Cerrar la ventana actual
        Stage currentStage = (Stage) buttonCrearTicket.getScene().getWindow();
        currentStage.close();
    } catch (IOException e) {
        // Mostrar un mensaje de error si no se puede cargar la vista
        mostrarMensajeError("Error al abrir el formulario: " + e.getMessage());
        e.printStackTrace(); // Imprimir detalles del error para depuración
    }
}

   


    @FXML
    private void handleModificarTicket(ActionEvent event) {
    try {
        // Seleccionar un ticket de la tabla
        Ticket seleccionado = tblTickets.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarMensajeError("Debe seleccionar un ticket para modificar.");
            return;
        }

        // Cargar la vista del formulario de modificación
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GestionTicket2Vista.fxml"));
        Parent root = loader.load();

        // Obtener el controlador del formulario y configurar el modo modificación
        GestionTicket2Controller controller = loader.getController();
        controller.setListaTickets(listaTickets);
        controller.configurarModoModificar(seleccionado);

        // Crear un nuevo Stage para la nueva interfaz
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.setTitle("Modificar Ticket");
        newStage.show();

        // Cerrar la ventana actual
        Stage currentStage = (Stage) buttonModificarTicket.getScene().getWindow();
        currentStage.close(); // Cierra la ventana actual
    } catch (IOException e) {
        mostrarMensajeError("Error al abrir el formulario: " + e.getMessage());
        e.printStackTrace(); // Depurar el error
    }
}


    
      @FXML
    private void handleAsignarTicket(ActionEvent event) {
        Ticket ticketSeleccionado = tblTickets.getSelectionModel().getSelectedItem();
        if (ticketSeleccionado == null) {
            mostrarMensajeError("Debe seleccionar un ticket para asignar.");
            return;
        }

        try {
            // Cargar la vista para asignar un departamento al ticket seleccionado
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GestionTicket3Vista.fxml"));
            Parent root = loader.load();

            GestionTicket3Controller controller = loader.getController();
            controller.setListaTickets(listaTickets); // Pasar la lista de tickets
            controller.configurarModoModificar(ticketSeleccionado);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Asignar Departamento a Ticket");
            stage.show();
            
               // Cerrar la ventana actual
        Stage currentStage = (Stage) buttonAsignarTicket.getScene().getWindow();
        currentStage.close();
        } catch (IOException e) {
            mostrarMensajeError("Error al abrir la vista de asignación de departamentos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCerrarTicket(ActionEvent event) {
        Ticket seleccionado = tblTickets.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarMensajeError("Debe seleccionar un ticket para cerrar.");
            return;
        }
        listaTickets.remove(seleccionado);
        mostrarMensajeInfo("Ticket cerrado exitosamente.");
    }


    private void mostrarMensajeError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarMensajeInfo(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
   public void setListaTickets(ObservableList<Ticket> listaTickets) {
    if (listaTickets == null || listaTickets.isEmpty()) {
        System.out.println("La lista de tickets está vacía o no inicializada.");
    }
    this.listaTickets = listaTickets;
    tblTickets.setItems(this.listaTickets); // Vincular la lista a la tabla
}

   
    @FXML
    private void handleMenu(ActionEvent event) {
            
         try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MenuVista.fxml"));
             Parent root;
             root = loader.load();
             Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             stage.setScene(new Scene(root));
             stage.show();
             
         } catch (IOException ex) {
             java.util.logging.Logger.getLogger(GestionTicketController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }     
    }

}
    