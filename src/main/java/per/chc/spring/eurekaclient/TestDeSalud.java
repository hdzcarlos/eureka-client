package per.chc.spring.eurekaclient;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Esta configuración nos permite cambiar el estado del microservicio sin necesidad de pararlo .
 */

@Component
public class TestDeSalud implements HealthCheckHandler {
    /**
     * Manejamos la variable counter desde el archivo de propiedades.
     *
     */
    @Value("${application.health.contador}")
    private int counter;

    @Override
    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus currentStatus) {
        //   counter++;
        switch (counter) {
            case 0:
                return InstanceInfo.InstanceStatus.OUT_OF_SERVICE;
            case 1:
                return InstanceInfo.InstanceStatus.DOWN;
            case 2:
                return InstanceInfo.InstanceStatus.STARTING;
            case 3:
                return InstanceInfo.InstanceStatus.UNKNOWN;
            default:
                return InstanceInfo.InstanceStatus.UP;
        }
    }
}
