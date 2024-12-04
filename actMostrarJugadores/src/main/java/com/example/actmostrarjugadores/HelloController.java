package com.example.actmostrarjugadores;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private TextField posicionTF;
    @FXML
    private TextField nombreTF;
    @FXML
    private TextField anyoTF;
    @FXML
    private TextField equipoTF;
    @FXML
    private TextField idTF;

    private List<Jugador> jugadores = new ArrayList<>();
    private int currentIndex = 0;

    @FXML
    public void initialize() {
        cargarJugadores();
        if (!jugadores.isEmpty()) {
            mostrarJugador(currentIndex);
        }
    }

    @FXML
    public void previoFuncion(ActionEvent actionEvent) {
        if (currentIndex > 0) {
            currentIndex--;
            mostrarJugador(currentIndex);
        }
    }

    @FXML
    public void siguienteFuncion(ActionEvent actionEvent) {
        if (currentIndex < jugadores.size() - 1) {
            currentIndex++;
            mostrarJugador(currentIndex);
        }
    }

    private void cargarJugadores() {
        try {
            File inputFile = new File("C:/Users/alex/Desktop/2 DAM/Acceso a datos/actMostrarJugadores/jugadores.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("jugador");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    int id = Integer.parseInt(element.getAttribute("id"));
                    String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
                    String equipo = element.getElementsByTagName("equipo").item(0).getTextContent();
                    int anyo = Integer.parseInt(element.getElementsByTagName("año").item(0).getTextContent());
                    String posicion = element.getElementsByTagName("posicion").item(0).getTextContent();

                    Jugador jugador = new Jugador(id, nombre, equipo, anyo, posicion);
                    jugadores.add(jugador);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarJugador(int index) {
        Jugador jugador = jugadores.get(index);
        idTF.setText(String.valueOf(jugador.getId()));
        nombreTF.setText(jugador.getNombre());
        equipoTF.setText(jugador.getEquipo());
        anyoTF.setText(String.valueOf(jugador.getAnyo()));
        posicionTF.setText(jugador.getPosicion());
    }
}
