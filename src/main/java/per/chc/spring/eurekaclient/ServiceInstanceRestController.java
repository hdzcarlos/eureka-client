package per.chc.spring.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceInstanceRestController {
    /**
     * Inyectamos las propiedades del objeto discoveryClient para poder recuperar la instancia.
     */
    @Autowired
    public DiscoveryClient discoveryClient;

    /**
     * Recupera y mapea  el property que le hemos dicho que se cargue antes de la aplicacion en el bootstrap.yml
     * Funciona como una ID Name por  donde entramos al servicio.
     * la url de acceso seria http://service-instances/"Lo especificado en el bootstrap.yml"
     * @param applicationName Nombre que recibe por propiedades.
     * @return retornamos una instancia encontrada en eureka, con el nombre del servicio.
     */
    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName){
        return this.discoveryClient.getInstances(applicationName);
        /*
         * Log de como se registra en el ecosistema
         * 2018-07-01 00:30:25.936  INFO 11700 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_O-CLIENT-PERSON/192.168.142.1:o-client-person - registration status: 204
         * 2018-07-01 00:30:55.887  INFO 11700 --- [freshExecutor-0] com.netflix.discovery.DiscoveryClient    : The response status is 200
         */
    }




}
