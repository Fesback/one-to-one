package com.fescode;

import com.fescode.model.Documento;
import com.fescode.model.Persona;
import com.fescode.model.TipoDocumento;
import com.fescode.service.PersonaService;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;

@Log4j2
public class MainApp {

    public static void main(String[] args) {
        PersonaService personaService = new PersonaService();

        //Creacion de persona
        Persona persona = new Persona("Sebastian Bismarck");

        Documento documento = new Documento(TipoDocumento.DNI, LocalDate.of(2028, 10, 10));
        persona.asignarDocumento(documento);

        personaService.crearPersona(persona);
        log.info("******************* LISTADO DE PERSONAS ******************");







        personaService.obtenerPersonas().forEach(p ->{
            log.info("Persona" + p.getNombre());
            if(p.getDocumento() !=null){
                log.info("Documento Tipo: " + p.getDocumento().getTipoDocumento());
                log.info("Fechas expedicion: " + p.getDocumento().getFechaExpedicion());
            }else{
                log.info("No tiene documento");
            }
        });
        personaService.cerrar();

    }
}
