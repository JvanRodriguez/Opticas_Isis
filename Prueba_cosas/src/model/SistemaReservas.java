package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.HashMap;

public class SistemaReservas {
    private HashMap<String, Optometra> optometras;
    private HashMap<String, Paciente> pacientes;
    private HashMap<Integer, Cita> citas;
    private HashMap<String, Consultorio> consultorios;

    public SistemaReservas() {
        this.optometras = new HashMap<>();
        this.pacientes = new HashMap<>();
        this.citas = new HashMap<>();
        this.consultorios = new HashMap<>();
    }

    // ================================
    // CRUD OPTOMETRAS
    // ================================
    public boolean crearOptometra(String nombre, String numero_documento,
            String numero_celular, int anio, int mes, int dia) {
        if (optometras.containsKey(numero_documento)) return false;
        optometras.put(numero_documento, new Optometra(nombre, numero_documento, numero_celular, anio, mes, dia));
        return true;
    }

    public Optometra leerOptometra(String numero_documento) {
        return optometras.get(numero_documento);
    }

    public boolean actualizarOptometra(String nombre, String numero_documento,
            String numero_celular, int anio, int mes, int dia) {
        LocalDate fecha_nueva = LocalDate.of(anio, mes, dia);
        Period edad = Period.between(fecha_nueva, LocalDate.now());
        if(edad.getYears() < 18) return false;
        Optometra optometra = optometras.get(numero_documento);
        if (optometra != null) {
            optometra.setNombre(nombre);
            optometra.setNumero_celular(numero_celular);
            optometra.setFecha_nacimiento(fecha_nueva);
            return true;
        }
        return false;
    }

    public boolean eliminarOptometra(String numero_documento) {
        return optometras.remove(numero_documento) != null;
    }

    // ================================
    // CRUD PACIENTES
    // ================================
    public boolean crearPaciente(String nombre, String numero_documento,
            String numero_celular, int anio, int mes, int dia) {
        if (pacientes.containsKey(numero_documento)) return false;
        pacientes.put(numero_documento, new Paciente(nombre, numero_documento, numero_celular, anio, mes, dia));
        return true;
    }

    public Paciente leerPaciente(String numero_documento) {
        return pacientes.get(numero_documento);
    }

    public boolean actualizarPaciente(String nombre, String numero_documento,
            String numero_celular, int anio, int mes, int dia) {
        Paciente paciente = pacientes.get(numero_documento);
        if (paciente != null) {
            paciente.setNombre(nombre);
            paciente.setNumero_celular(numero_celular);
            paciente.setFecha_nacimiento(LocalDate.of(anio, mes, dia));
            return true;
        }
        return false;
    }

    public boolean eliminarPaciente(String numero_documento) {
        return pacientes.remove(numero_documento) != null;
    }

    // ========================================
    // CRUD CITAS
    // ========================================
    public int crearCita(String docOptometra, String docPaciente, String idConsultorio, 
                            int anio, int mes, int dia, int hora, int minutos) {
        int id = Cita.getContador();
        if (citas.containsKey(id)) return -1;

        LocalDate fecha_nueva = LocalDate.of(anio, mes, dia);
        LocalTime hora_nueva = LocalTime.of(hora, minutos);
        LocalTime hora_nueva_fin = hora_nueva.plusMinutes(20);
        for (Cita cita : citas.values()){
            if(cita.getFecha().isEqual(fecha_nueva) && 
            cita.getDocumento_optometra().equals(docOptometra) &&
            cita.getId_consultorio().equals(idConsultorio)){
                LocalTime inicio_actual = cita.getHora();
                LocalTime fin_actual = inicio_actual.plusMinutes(20);
                boolean seCruzan = !hora_nueva.isAfter(fin_actual) && !hora_nueva_fin.isBefore(inicio_actual);
                if(seCruzan) return -1;
            }
        }
        Cita nueva = new Cita(docOptometra, docPaciente, idConsultorio, anio, mes, dia, hora, minutos);
        citas.put(nueva.getId(), nueva);
        return id;
    }

    public Cita leerCita(int id) {
        return citas.get(id);
    }

    public boolean actualizarCita(int id, String docOptometra, String docPaciente, String idConsultorio, 
                                int anio, int mes, int dia, int hora, int minutos) {
        Cita c = citas.get(id);
        if (c == null) return false;
        // Validación simple: no permitir actualizar a una fecha pasada
        LocalDate nuevaFecha = LocalDate.of(anio, mes, dia);
        LocalTime nuevaHora = LocalTime.of(hora, minutos);
        if (nuevaFecha.isBefore(LocalDate.now()) || 
        (nuevaFecha.isEqual(LocalDate.now()) && nuevaHora.isBefore(LocalTime.now()))) {
            return false;
        }
        c.setDocumento_optometra(docOptometra);
        c.setDocumento_paciente(docPaciente);
        c.setId_consultorio(idConsultorio);
        c.setFecha(nuevaFecha);
        c.setHora(nuevaHora);
        return true;
    }

    public boolean eliminarCita(int id) {
        return citas.remove(id) != null;
    }

    // ================================
    // CRUD CONSULTORIOS
    // ================================
    public boolean crearConsultorio(String id, String direccion, String ciudad) {
        if (consultorios.containsKey(id)) return false;
        consultorios.put(id, new Consultorio(id, direccion, ciudad));
        return true;
    }

    public Consultorio leerConsultorio(String id) {
        return consultorios.get(id);
    }

    public boolean actualizarConsultorio(String id, String direccion, String ciudad) {
        Consultorio c = consultorios.get(id);
        if (c == null) return false;
        c.setDireccion(direccion);
        c.setCiudad(ciudad);
        return true;
    }

    public boolean eliminarConsultorio(String id) {
        return consultorios.remove(id) != null;
    }

}