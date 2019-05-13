package mx.com.aforecoppel.capa.movies.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import mx.com.aforecoppel.capa.movies.beans.Usuario;


@Controller
public class MoviesController {
	
	//private static final Logger logger = Logger.getLogger(MoviesController.class);
	@RequestMapping(value="/getUsuariosClient")
	public List<Usuario> getUsuariosClient() {
		List<Usuario> sRespuesta=new ArrayList<>();
		try {
			// URL donde se encuentra alojado el servicio REST
			String url = "http://10.44.150.211:8080/tallerSpring/getUsuariosRest";

			// Objeto de Spring para consumir servicios REST
			RestTemplate restTemplate = new RestTemplate();

			// Se obtiene el valor que retorna el servicio REST de la URL especificada
			// List.class = el tipo de valor que retorna el servicio REST
			sRespuesta = restTemplate.getForObject(url, List.class);
			
			System.out.println(sRespuesta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//SE REGRESA EL NOMBRE DE LA VISTA Y EL MAP CON LA INFORMACION MOSTRAR
		return sRespuesta;
	}
	
	@RequestMapping(value="/inicio")
	public ModelAndView usuarios(HttpServletRequest request) {
		Map<String,Object> map= new HashMap<>();
		List<Usuario> sRespuesta=new ArrayList<>();
		try {
			// URL donde se encuentra alojado el servicio REST
			String url = "http://10.44.150.211:8080/tallerSpring/getUsuariosRest";

			// Objeto de Spring para consumir servicios REST
			RestTemplate restTemplate = new RestTemplate();

			// Se obtiene el valor que retorna el servicio REST de la URL especificada
			// List.class = el tipo de valor que retorna el servicio REST
			sRespuesta = restTemplate.getForObject(url, List.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//SE GUARDA LA INFORMACION A MANDAR A LA VISTA POR MEDIO DEL MAP
		map.put("listUsuarios",sRespuesta);
		//SE REGRESA EL NOMBRE DE LA VISTA Y EL MAP CON LA INFORMACION MOSTRAR
		return new ModelAndView("home",map);
	}
	@RequestMapping(value="/insertUsuario")
	public ModelAndView insertUsuario(HttpServletRequest request) {
		Map<String,Object> Respuesta=new HashMap<>();
		
		
		String nombre=request.getParameter("nombre");
		String apellido=request.getParameter("apellido");
		String nss=request.getParameter("nss");
		String curp=request.getParameter("curp");

		try {
			// URL donde se encuentra alojado el servicio REST
			
			Usuario usuario= new Usuario();
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setNss(nss);
			usuario.setCurp(curp);
			
			//Se consume el servicio para insertar Usuarios
			String url = "http://localhost:8080/tallerSpring/consumirInsertUsuario";
			
			// Objeto de Spring para consumir servicios REST
			RestTemplate restTemplate = new RestTemplate();
			
		Respuesta = restTemplate.postForObject( url, usuario, Map.class);
			
		System.out.println("Response :: " + Respuesta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("redirect: /movies/inicio");
	}
	@RequestMapping(value="/destroyUsuario/{id}",method = RequestMethod.GET)
	public ModelAndView destroyUsuario(@PathVariable int id) {
		Map<String,Object> Respuesta=new HashMap<>();
		try {
			// URL donde se encuentra alojado el servicio REST
			
			Usuario usuario= new Usuario();
			usuario.setId(id);
			
			//Se consume el servicio para insertar Usuarios
			String url = "http://localhost:8080/tallerSpring/consumirDestroyUsuario";
			
			// Objeto de Spring para consumir servicios REST
			RestTemplate restTemplate = new RestTemplate();
			Respuesta = restTemplate.postForObject(url, usuario.getId(), Map.class);
		//Respuesta = restTemplate.postForObject( url, usuario, Map.class);
			
		System.out.println("Response :: " + Respuesta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("redirect: /movies/inicio"); 
	}
	@RequestMapping(value="/updateUsuario")
	public ModelAndView updateUsuario(HttpServletRequest request) {
		Map<String,Object> Respuesta=new HashMap<>();
		
		
		String id=request.getParameter("idModal");
		String nombre=request.getParameter("nombreModal");
		String apellido=request.getParameter("apellidoModal");
		String nss=request.getParameter("nssModal");
		String curp=request.getParameter("curpModal");

		try {
			// URL donde se encuentra alojado el servicio REST
			
			Usuario usuario= new Usuario();
			usuario.setId(Integer.parseInt(id));
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setNss(nss);
			usuario.setCurp(curp);
			
			//Se consume el servicio para insertar Usuarios
			String url = "http://localhost:8080/tallerSpring/consumirUpdateUsuario";
			
			// Objeto de Spring para consumir servicios REST
			RestTemplate restTemplate = new RestTemplate();
			
		Respuesta = restTemplate.postForObject( url, usuario, Map.class);
			
		System.out.println("Response :: " + Respuesta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("redirect: /movies/inicio");
	}
	
}
