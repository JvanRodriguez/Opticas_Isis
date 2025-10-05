package presenter;

import model.*;
import view.View;

public class Presenter {

    private SistemaReservas sistema;
    private View view;

    public Presenter() {
        this.sistema = new SistemaReservas();
        this.view = new View();
    }

    public void inicioMenu() {
        int option = -1;
        int subOption = -1;
        view.ShowMessage("Bienvenidx a Ópticas ISIS");

        while (option != 0) {
            showMenu();
            option = view.inputInteger();

            switch (option) {
                case 1:
                    showCrudOptometras();
                    subOption = view.inputInteger();
                    switch (subOption) {
                        case 11 -> System.out.println(createOptometra());
                        case 12 -> readOptometra();
                        case 13 -> System.out.println(updateOpt());
                        case 14 -> System.out.println(deleteOptometra());
                    }
                    break;

                case 2:
                    showCrudPacientes();
                    subOption = view.inputInteger();
                    switch (subOption) {
                        case 21 -> System.out.println(createPaciente());
                        case 22 -> readPaciente();
                        case 23 -> System.out.println(updatePaciente());
                        case 24 -> System.out.println(deletePaciente());
                    }
                    break;

                case 3:
                    showCrudCitas();
                    subOption = view.inputInteger();
                    switch (subOption) {
                        case 31 -> System.out.println("ID de la cita: " + createCita());
                        case 32 -> readCita();
                        case 33 -> System.out.println(updateCita());
                        case 34 -> System.out.println(deleteCita());
                    }
                    break;

                case 4:
                    showCrudConsultorios();
                    subOption = view.inputInteger();
                    switch (subOption) {
                        case 41 -> System.out.println(createConsultorio());
                        case 42 -> readConsultorio();
                        case 43 -> System.out.println(updateConsultorio());
                        case 44 -> System.out.println(deleteConsultorio());
                    }
                    break;
            }
        }
    }

    // ================================================
    // OPTOMETRAS
    // ================================================
    private boolean createOptometra() {
        view.ShowMessage("Nombre:");
        String nombre = view.inputString();
        view.ShowMessage("Número de identificación:");
        String opt_id = view.inputString();
        view.ShowMessage("Número de celular:");
        String phone = view.inputString();
        view.ShowMessage("Año de nacimiento:");
        int anio = view.inputInteger();
        view.ShowMessage("Mes de nacimiento:");
        int mes = view.inputInteger();
        view.ShowMessage("Día de nacimiento:");
        int dia = view.inputInteger();

        return sistema.crearOptometra(nombre, opt_id, phone, anio, mes, dia);
    }

    private void readOptometra() {
        view.ShowMessage("Número de identificación:");
        String id = view.inputString();
        Optometra opt = sistema.leerOptometra(id);
        if (opt != null) {
            view.ShowMessage("Nombre: " + opt.getNombre());
            view.ShowMessage("Teléfono: " + opt.getNumero_celular());
            view.ShowMessage("Fecha nacimiento: " + opt.getFecha_nacimiento());
        } else {
            view.ShowMessage("No se encontró el optometra.");
        }
    }

    private boolean updateOpt() {
        view.ShowMessage("Número de identificación del optometra a actualizar:");
        String num_Id = view.inputString();
        view.ShowMessage("Nuevo nombre:");
        String nombre = view.inputString();
        view.ShowMessage("Nuevo número de celular:");
        String phone = view.inputString();
        view.ShowMessage("Año de nacimiento:");
        int anio = view.inputInteger();
        view.ShowMessage("Mes de nacimiento:");
        int mes = view.inputInteger();
        view.ShowMessage("Día de nacimiento:");
        int dia = view.inputInteger();

        return sistema.actualizarOptometra(nombre, num_Id, phone, anio, mes, dia);
    }

    private boolean deleteOptometra() {
        view.ShowMessage("Número de identificación del optometra a eliminar:");
        String id = view.inputString();
        return sistema.eliminarOptometra(id);
    }

    // ================================================
    // PACIENTES
    // ================================================
    private boolean createPaciente() {
        view.ShowMessage("Nombre:");
        String nombre = view.inputString();
        view.ShowMessage("Número de identificación:");
        String id = view.inputString();
        view.ShowMessage("Número de celular:");
        String phone = view.inputString();
        view.ShowMessage("Año de nacimiento:");
        int anio = view.inputInteger();
        view.ShowMessage("Mes de nacimiento:");
        int mes = view.inputInteger();
        view.ShowMessage("Día de nacimiento:");
        int dia = view.inputInteger();

        return sistema.crearPaciente(nombre, id, phone, anio, mes, dia);
    }

    private void readPaciente() {
        view.ShowMessage("Número de identificación:");
        String id = view.inputString();
        Paciente p = sistema.leerPaciente(id);
        if (p != null) {
            view.ShowMessage("Nombre: " + p.getNombre());
            view.ShowMessage("Teléfono: " + p.getNumero_celular());
            view.ShowMessage("Fecha nacimiento: " + p.getFecha_nacimiento());
        } else {
            view.ShowMessage("No se encontró el paciente.");
        }
    }

    private boolean updatePaciente() {
        view.ShowMessage("Número de identificación:");
        String id = view.inputString();
        view.ShowMessage("Nuevo nombre:");
        String nombre = view.inputString();
        view.ShowMessage("Nuevo número de celular:");
        String phone = view.inputString();
        view.ShowMessage("Año de nacimiento:");
        int anio = view.inputInteger();
        view.ShowMessage("Mes de nacimiento:");
        int mes = view.inputInteger();
        view.ShowMessage("Día de nacimiento:");
        int dia = view.inputInteger();

        return sistema.actualizarPaciente(nombre, id, phone, anio, mes, dia);
    }

    private boolean deletePaciente() {
        view.ShowMessage("Número de identificación:");
        String id = view.inputString();
        return sistema.eliminarPaciente(id);
    }

    // ========================================
    // CITAS
    // ========================================

    private int createCita() {
        view.ShowMessage("Documento del optometra:");
        String docOptometra = view.inputString();
        view.ShowMessage("Documento del paciente:");
        String docPaciente = view.inputString();
        view.ShowMessage("ID del consultorio:");
        String idConsultorio = view.inputString();
        view.ShowMessage("Año:");
        int anio = view.inputInteger();
        view.ShowMessage("Mes:");
        int mes = view.inputInteger();
        view.ShowMessage("Día:");
        int dia = view.inputInteger();
        view.ShowMessage("Hora:");
        int hora = view.inputInteger();
        view.ShowMessage("Minutos:");
        int minutos = view.inputInteger();
        return sistema.crearCita(docOptometra, docPaciente, idConsultorio, anio, mes, dia, hora, minutos);
    }

    private void readCita() {
        view.ShowMessage("ID de la cita:");
        int id = view.inputInteger();
        Cita c = sistema.leerCita(id);
        if (c != null) {
            view.ShowMessage("ID: " + c.getId());
            view.ShowMessage("Optometra: " + c.getDocumento_optometra());
            view.ShowMessage("Paciente: " + c.getDocumento_paciente());
            view.ShowMessage("Consultorio: " + c.getId_consultorio());
            view.ShowMessage("Fecha: " + c.getFecha());
            view.ShowMessage("Hora: " + c.getHora());
            view.ShowMessage("Estado: " + c.getEstadoCita());
        } else {
            view.ShowMessage("No se encontró la cita.");
        }
    }

    private boolean updateCita() {
        view.ShowMessage("ID de la cita a actualizar:");
        int id = view.inputInteger();
        view.ShowMessage("Nuevo documento del optometra:");
        String docOptometra = view.inputString();
        view.ShowMessage("Nuevo documento del paciente:");
        String docPaciente = view.inputString();
        view.ShowMessage("Nuevo ID del consultorio:");
        String idConsultorio = view.inputString();
        view.ShowMessage("Nuevo año:");
        int anio = view.inputInteger();
        view.ShowMessage("Nuevo mes:");
        int mes = view.inputInteger();
        view.ShowMessage("Nuevo día:");
        int dia = view.inputInteger();
        view.ShowMessage("Nueva hora:");
        int hora = view.inputInteger();
        view.ShowMessage("Nuevos minutos:");
        int minutos = view.inputInteger();

        boolean actualizado = sistema.actualizarCita(id, docOptometra, docPaciente, idConsultorio, anio, mes, dia, hora, minutos);
        if (!actualizado) {
            view.ShowMessage(" No se pudo actualizar la cita (posiblemente la fecha/hora ya pasó).");
        }
        return actualizado;
    }

    private boolean deleteCita() {
        view.ShowMessage("ID de la cita a eliminar:");
        int id = view.inputInteger();
        return sistema.eliminarCita(id);
    }

    // ================================================
    // CONSULTORIOS
    // ================================================
    private boolean createConsultorio() {
        view.ShowMessage("ID del consultorio:");
        String id = view.inputString();
        view.ShowMessage("Dirección:");
        String direccion = view.inputString();
        view.ShowMessage("Ciudad:");
        String ciudad = view.inputString();
        return sistema.crearConsultorio(id, direccion, ciudad);
    }

    private void readConsultorio() {
        view.ShowMessage("ID del consultorio:");
        String id = view.inputString();
        Consultorio c = sistema.leerConsultorio(id);
        if (c != null) {
            view.ShowMessage("ID: " + c.getId());
            view.ShowMessage("Dirección: " + c.getDireccion());
            view.ShowMessage("Ciudad: " + c.getCiudad());
        } else {
            view.ShowMessage("No se encontró el consultorio.");
        }
    }

private boolean updateConsultorio() {
    view.ShowMessage("ID del consultorio a actualizar:");
    String id = view.inputString();
    view.ShowMessage("Nueva dirección:");
    String direccion = view.inputString();
    view.ShowMessage("Nueva ciudad:");
    String ciudad = view.inputString();
    return sistema.actualizarConsultorio(id, direccion, ciudad);
}

private boolean deleteConsultorio() {
    view.ShowMessage("ID del consultorio a eliminar:");
    String id = view.inputString();
    return sistema.eliminarConsultorio(id);
}


    // ================================================
    // MENÚS
    // ================================================
    private void showCrudOptometras() {
        view.ShowMessage("OPTOMETRAS");
        view.ShowMessage("11 - Crear");
        view.ShowMessage("12 - Leer");
        view.ShowMessage("13 - Actualizar");
        view.ShowMessage("14 - Eliminar");
    }

    private void showCrudPacientes() {
        view.ShowMessage("PACIENTES");
        view.ShowMessage("21 - Crear");
        view.ShowMessage("22 - Leer");
        view.ShowMessage("23 - Actualizar");
        view.ShowMessage("24 - Eliminar");
    }

    private void showCrudCitas() {
        view.ShowMessage("CITAS");
        view.ShowMessage("31 - Crear");
        view.ShowMessage("32 - Leer");
        view.ShowMessage("33 - Actualizar");
        view.ShowMessage("34 - Eliminar");
    }

    private void showCrudConsultorios() {
        view.ShowMessage("CONSULTORIOS");
        view.ShowMessage("41 - Crear");
        view.ShowMessage("42 - Leer");
        view.ShowMessage("43 - Actualizar");
        view.ShowMessage("44 - Eliminar");
    }

    private void showMenu() {
        view.ShowMessage(" ");
        view.ShowMessage("OPCIONES");
        view.ShowMessage("1 - CRUD Optometristas");
        view.ShowMessage("2 - CRUD Pacientes");
        view.ShowMessage("3 - CRUD Citas");
        view.ShowMessage("4 - CRUD Consultorios");
        view.ShowMessage("0 - Salir");
    }
}