package com.spring.app1.springboot_app.controllers;

// import java.util.HashMap;
// import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.spring.app1.springboot_app.models.Empleados;
import com.spring.app1.springboot_app.models.dto.ClaseDTO;

@RestController
@RequestMapping("/api")
public class EjemploRestController {

    @GetMapping("/detalles_info2")
    public ClaseDTO detallesInfo2222() {
        // Empleados empleado = new Empleados("Luis", "Velasco", "Calle Falsa 123", "Desarrollador", 30, 123456789);
        // Map<String, Object> response = new HashMap<>();
        // response.put("Empleado Apellido", empleado.getApellido());
        // response.put("Empleado Nombre", empleado.getNombre());
        // response.put("Empleado Dirección", empleado.getDireccion());
        // response.put("Empleado Puesto", empleado.getPuesto());
        // response.put("Empleado Edad", empleado.getEdad());
        // response.put("Empleado Teléfono", empleado.getTelefono());




        ///CLASE DTO
        ClaseDTO usuario1 = new ClaseDTO();
        usuario1.setTitulo("Desarrollador");
        usuario1.setUsuario("Luis Velasco");
        return usuario1;
    }
}

// "En base a un formulario de HTML, esos datos pasan a una clase que tendrá atributos que son los datos del formulario, y en otra clase, se usa como una inyección de dependencias usando la anotación @ y el tipo de dato, y en ese objeto ya están los datos del form?"

// @PostMapping("/registrar")
// public String registrarUsuario(@ModelAttribute Usuario usuario) {
//     // Aquí el objeto ya viene "relleno" con lo que el usuario escribió
//     System.out.println(usuario.getNombre());
//     System.out.println(usuario.getEmail());
//     return "exito";
// }

